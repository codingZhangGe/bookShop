package com.qunar.qauction.web.controller;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.qunar.qauction.common.Constants;
import com.qunar.qauction.common.exceptions.ParameterException;
import com.qunar.qauction.common.utils.CookieUtil;
import com.qunar.qauction.common.utils.FileUtils;
import com.qunar.qauction.common.utils.ParameterCheckUtil;
import com.qunar.qauction.common.utils.UUIDGenerator;
import com.qunar.qauction.model.common.Category;
import com.qunar.qauction.model.upload.ImgModel;
import com.qunar.qauction.model.upload.UploadItem;
import com.qunar.qauction.service.common.ImgService;
import com.qunar.qauction.service.home.HomeService;
import com.qunar.qauction.service.upload.UploadItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import qunar.api.pojo.CodeMessage;
import qunar.api.pojo.json.JsonV2;
import qunar.web.spring.annotation.JsonBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by liuyanjiang on 16-4-18. upLoadImg 图片上传,上传后会生成唯一的uuid,将此uuid存入数据库里面 上传过程会检测图片数量,是否为合法图片
 */
@Controller
@RequestMapping("/item")
public class ItemUploadController {
    private Logger logger = LoggerFactory.getLogger(ItemUploadController.class);
    @Resource
    private ImgService imgService;
    @Resource
    private UploadItemService uploadItemService;
    @Resource
    private HomeService homeService;
    @RequestMapping(value = "/imageUpload",method= RequestMethod.POST)
    @JsonBody
    public Object uploadImg(@RequestParam(value = "file", required = true) CommonsMultipartFile[] files,
            HttpServletRequest request) throws Exception {
        String itemId = UUIDGenerator.getUUID();
        logger.info("上传图片,图片数量={},用户id={}", files.length, CookieUtil.getCookieValue(request, "login_id"));
        Preconditions.checkNotNull(files);
        if (files.length > Constants.DEFAULT_SIZE) {
            logger.error("图片上传失败,数量太大,数量:{},用户:{}", files.length, CookieUtil.getCookieValue(request, "login_id"));
            return new JsonV2<>(CodeMessage.SYSTEM_ERROR, "图片上传数量超过五张", files.length);
        }
        if (!FileUtils.isPictures(files)) {
            logger.warn("上传的并非图片,用户:{}", CookieUtil.getCookieValue(request, "login_id"));
            return new JsonV2<>(CodeMessage.SYSTEM_ERROR, "不合法的图片名,文件要以图片名结尾", "");
        }
        List<String> list = Lists.newArrayList();
        for (CommonsMultipartFile file : files) {
            list.add(imgService.upLoadImg(file.getBytes(), itemId, file.getFileItem().getName()));
        }
        if (list.size() != files.length) {

            logger.warn("部分图片上传失败，成功数量:{},用户:{}", CookieUtil.getCookieValue(request, "login_id"));
            return new JsonV2<>(CodeMessage.SYSTEM_ERROR, "部分图片上传失败,系统错误", files.length - list.size());
        }
        logger.info("图片上传成功，数量:{},生成的itemId:{}", files.length, itemId);
        return new JsonV2<>(CodeMessage.OK, "上传成功", new ImgModel(itemId, list));
    }

    @RequestMapping(value = "/itemUpload",method = RequestMethod.POST)
    @JsonBody
    public Object uploadItem(@RequestBody UploadItem uploadItem,HttpServletRequest request) throws ParameterException{
        Preconditions.checkNotNull(uploadItem);
        uploadItem.setSellerQtalk(CookieUtil.getCookieValue(request,"login_id"));
        JsonV2 jsonV2 = ParameterCheckUtil.checkUploadItem(uploadItem);
        if (jsonV2.status < 0) {
            logger.warn("用户参数校验失败,用户id:{},message:{},data:{}", uploadItem.getSellerQtalk(), jsonV2.message,
                    jsonV2.data);
            return jsonV2;
        }
        logger.info("上传商品信息id:{},用户id:{}", uploadItem.getItemId(), uploadItem.getSellerQtalk());
        List<String> picturesUrl = imgService.getPictureUrl(uploadItem.getItemId());
        if (picturesUrl == null || picturesUrl.size() <= 0) {
            logger.warn("该拍卖物品图片并未上传，拍卖信息上传失败:itemId={}", uploadItem.getItemId());
            return new JsonV2<>(CodeMessage.SYSTEM_ERROR, "该拍卖品图片并没有成功上传", uploadItem.getItemId());
        }
        List<Category>categories=homeService.queryAllCategory();
        boolean flag=false;
        for(Category category:categories){
            if(category.getId()==uploadItem.getCategoryId()){
                flag=true;
            }
        }
        if(!flag){
            logger.warn("没有该物品类别id:categoryId={}", uploadItem.getCategoryId());
            return new JsonV2<>(CodeMessage.OK, "成功上传该拍物品","");
        }
        uploadItemService.uploadItem(uploadItem);
        logger.info("拍卖信息上传成功:用户id={},itemId={}", uploadItem.getSellerQtalk(), uploadItem.getItemId());
        return new JsonV2<>(CodeMessage.OK, "成功上传该拍物品","");
    }
}
