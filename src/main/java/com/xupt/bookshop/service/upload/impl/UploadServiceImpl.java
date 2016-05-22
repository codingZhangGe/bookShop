package com.xupt.bookshop.service.upload.impl;

import javax.annotation.Resource;

import com.xupt.bookshop.dao.UploadItemDao;
import com.xupt.bookshop.model.Category.Category;
import com.xupt.bookshop.model.upload.UploadItemParam;
import com.xupt.bookshop.service.upload.UploadItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;


/**
 * Created by ge.zhang on 16-4-19.
 */
@Service
public class UploadServiceImpl implements UploadItemService {
    private static Logger logger = LoggerFactory.getLogger(UploadServiceImpl.class);
    @Resource
    private UploadItemDao uploadItemDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void uploadItem(UploadItemParam item){
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getBookId());
        logger.info("upload item,item id={},itemName={", item.getBookId(), item.getBookId());
        item.setCurrentPrice(item.getPrice(),item.getDiscount());
        uploadItemDao.insertItem(item);
        logger.info("update dynamic item list,itemId:{}",item.getBookId());
        uploadItemDao.insertBookDynamicItem(item);
    }

    @Override
    public void uploadCategory(String name,String parentName) {
        Category category=new Category();
        category.setCategoryName(name);
        if(parentName==""){
            category.setParentId(0);
        }
        category.setCategoryId(uploadItemDao.selectParentCategoryId(parentName));
        uploadItemDao.insertCategory(category);
    }
}
