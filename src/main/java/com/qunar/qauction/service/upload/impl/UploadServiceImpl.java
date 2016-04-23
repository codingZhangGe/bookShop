package com.qunar.qauction.service.upload.impl;

import com.qunar.qauction.dao.UploadItemDao;
import com.qunar.qauction.model.upload.UploadItem;
import com.qunar.qauction.service.upload.UploadItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by liuyanjiang on 16-4-19.
 */
@Service
public class UploadServiceImpl implements UploadItemService {
    private static Logger logger = LoggerFactory.getLogger(UploadServiceImpl.class);
    @Resource
    private UploadItemDao uploadItemDao;

    @Override
    public void uploadItem(UploadItem item) {
        logger.info("upload item,item id={},itemName={", item.getItemId(), item.getItemName());
        uploadItemDao.insertItem(item);
    }
}
