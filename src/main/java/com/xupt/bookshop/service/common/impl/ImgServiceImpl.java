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
import com.xupt.bookshop.service.upload.impl.SwiftContainer;
import org.javaswift.joss.model.StoredObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * Created by liuyanjiang on 16-4-17. 与图片操作有关的服务
 */
@Service
public class ImgServiceImpl implements ImgService {

    @Resource
    private SwiftContainer swiftContainer;
    @Resource
    private ImgDao imgDao;
    private Logger logger = LoggerFactory.getLogger(ImgServiceImpl.class);

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
    // 根据itemId和上传的文件名生成一个uuid并且记录图片类型，其他服务类似
    public String upLoadImg(InputStream inputStream, String itemId, String fileName) {
        logger.info("upload image to server,item Id={},fileName={}", itemId, fileName);
        String uuId = UUIDGenerator.getUUID();
        String pictureId = FileUtils.getFullName(uuId, fileName);
        StoredObject object = swiftContainer.getContainer().getObject(pictureId);
        object.uploadObject(inputStream);
        ImgModel model = new ImgModel();
        model.setItemId(itemId);
        model.getPictureId().add(pictureId);
        imgDao.insertImgs(model);
        return pictureId;
    }

    @Override
    public String upLoadImg(File file, String itemId, String fileName) {
        logger.info("upload image to server,item Id={},fileName={}", itemId, fileName);
        String uuId = UUIDGenerator.getUUID();
        String pictureId = FileUtils.getFullName(uuId, fileName);
        StoredObject object = swiftContainer.getContainer().getObject(pictureId);
        object.uploadObject(file);
        ImgModel model = new ImgModel();
        model.setItemId(itemId);
        model.getPictureId().add(pictureId);
        imgDao.insertImgs(model);
        return pictureId;
    }

    @Override
    // 通过itemId返回一个对应的图片URL list地址
    public List<String> getPictureUrl(String itemId) {
        logger.info("query image from server,item Id={}", itemId);
        List<String> imgsId = imgDao.selectImages(itemId);
        List<String> pictureUrl = Lists.newArrayList();
        for (String imgId : imgsId) {
            pictureUrl.add(swiftContainer.getContainer().getObject(imgId).getPublicURL());
        }
        return pictureUrl;
    }

    @Override
    public void deleteImg(String pictureId) {
        logger.warn("delete picture pictureId={}", pictureId);
        StoredObject object = swiftContainer.getContainer().getObject(pictureId);
        object.delete();
        imgDao.deleteImg(pictureId);
    }


    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken(){
        return auth.uploadToken(bucketname);
    }




    @Override
    public String upLoadImg(byte[] bytes, String itemId, String fileName) {


//
//        logger.info("upload image to server,item Id={},fileName={}", itemId, fileName);
        //生成图片此次上传的id
        String uuId = UUIDGenerator.getUUID();
        //生成文件名
        String pictureId = FileUtils.getFullName(uuId, fileName);
    //    StoredObject object = swiftContainer.getContainer().getObject(pictureId);

//        object.uploadObject(bytes);

        try {
            FilePaths.add("/home/zhangge/图片/2.jpg");
            FilePaths.add("/home/zhangge/图片/1.jpg");

            //调用put方法上传
            Response res = null;
            for(String str:FilePaths) {
                String key = str;
                res = uploadManager.put(str, key, getUpToken());
            }
            //打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
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
            swiftContainer.getContainer().getObject(pictureId).delete();
        }
        imgDao.deleteImgByItemId(itemId);
    }

    @Override
    public String getFirstPictureUrl(String itemId) {
//        logger.warn("query picture from server itemId={}", itemId);
//        String pictureId = imgDao.selectFirstPicture(itemId);
//        return swiftContainer.getContainer().getObject(pictureId).getPublicURL();
        return "imgUrl";
    }

}
