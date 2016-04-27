package com.xupt.bookshop.service.upload.impl;

import javax.annotation.Resource;

import com.xupt.bookshop.dao.UploadItemDao;
import com.xupt.bookshop.model.upload.UploadItem;
import com.xupt.bookshop.service.upload.UploadItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;


/**
 * Created by liuyanjiang on 16-4-19.
 */
@Service
public class UploadServiceImpl implements UploadItemService {
    private static Logger logger = LoggerFactory.getLogger(UploadServiceImpl.class);
    @Resource
    private UploadItemDao uploadItemDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void uploadItem(UploadItem item){
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getItemId());
        logger.info("upload item,item id={},itemName={", item.getItemId(), item.getItemName());
        uploadItemDao.insertItem(item);
        logger.info("update unfinished item list,itemId:{}",item.getItemId());
        uploadItemDao.insertUnfinishedItem(item);
    }
}
