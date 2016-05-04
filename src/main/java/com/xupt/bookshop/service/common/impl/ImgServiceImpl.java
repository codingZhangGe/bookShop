package com.xupt.bookshop.service.common.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.xupt.bookshop.common.utils.FileUtils;
import com.xupt.bookshop.common.utils.UUIDGenerator;
import com.xupt.bookshop.dao.ImgDao;
import com.xupt.bookshop.model.upload.ImgModel;
import com.xupt.bookshop.service.common.ImgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by ge.zhang on 16-4-17. 与图片操作有关的服务
 */
@Service
public class ImgServiceImpl implements ImgService {

    @Resource
    private ImgDao imgDao;
    private Logger logger = LoggerFactory.getLogger(ImgServiceImpl.class);
    private static final String FILEPATH = "/home/zhangge/statics/";

    //设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = "y5o4ohv3iRU6H0ha3BxqGllu-Au7YkzeyV5Z-4Q8";
    String SECRET_KEY = "wGD6J1UGgAqlodPEibUqtrbwPMwzyG9wGrOhTA0K";
    //要上传的空间
    String bucketname = "zhangge";


    //密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    //创建上传对象
    UploadManager uploadManager = new UploadManager();

    @Override
    // 通过itemId返回一个对应的图片URL list地址
    public List<String> getPictureUrl(String itemId) {

        logger.info("query image from server,item Id={}", itemId);
        List<String> imgsId = imgDao.selectImages(itemId);
        String downloadUrl;
        List<String> pictureUrl = Lists.newArrayList();
        for (String imgId : imgsId) {
            downloadUrl="http://7xti7f.com2.z0.glb.clouddn.com/"+imgId;
            pictureUrl.add(downloadUrl);
        }
        return pictureUrl;
    }

    @Override
    public void deleteImg(String pictureId) {
        logger.warn("delete picture pictureId={}", pictureId);

        imgDao.deleteImg(pictureId);
    }


    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken(){
        return auth.uploadToken(bucketname);
    }

    @Override
    public String upLoadImg(CommonsMultipartFile file, String itemId, String fileName) {
        //生成图片上传的id
        String uuId = UUIDGenerator.getUUID();
        //重新定义名字
        String pictureId = FileUtils.getFullName(uuId, fileName);
        String filePath=   FILEPATH+file.getOriginalFilename();
        File transfile = new File(filePath);
       try{
            file.transferTo(transfile);
            //调用put方法上传
            Response res = null;
            //照片路径,图片id
            res = uploadManager.put(filePath, pictureId, getUpToken());
            //打印返回的信息
          logger.info("upload img {} success",pictureId);
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
        logger.error("<QiniuException>   {}",r.toString());
        }
       catch (IOException e) {
           logger.info("img upload fail");
       }
        ImgModel model = new ImgModel();
        model.setItemId(itemId);
        model.getPictureId().add(pictureId);
        imgDao.insertImgs(model);
        return pictureId;
    }

    @Override
    public void deleteImgsByItemId(String itemId) {
        logger.warn("delete item picture itemId={}", itemId);
        List<String> picturesId = imgDao.selectImages(itemId);
        Preconditions.checkNotNull(picturesId);
        for (String pictureId : picturesId) {

        }
        imgDao.deleteImgByItemId(itemId);
    }

    @Override
    public String getFirstPictureUrl(String itemId) {
       logger.warn("query picture from server itemId={}", itemId);
        String pictureId = imgDao.selectFirstPicture(itemId);
        String downloadUrl="http://zhangge//"+pictureId;
        String pictureUrl =auth.privateDownloadUrl(downloadUrl);

        return pictureId;
    }

}
