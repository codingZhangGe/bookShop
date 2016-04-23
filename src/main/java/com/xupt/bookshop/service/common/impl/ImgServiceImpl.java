package com.xupt.bookshop.service.common.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
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

    @Override
    public String upLoadImg(byte[] bytes, String itemId, String fileName) {
        logger.info("upload image to server,item Id={},fileName={}", itemId, fileName);
        String uuId = UUIDGenerator.getUUID();
        String pictureId = FileUtils.getFullName(uuId, fileName);
        StoredObject object = swiftContainer.getContainer().getObject(pictureId);
        object.uploadObject(bytes);
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
