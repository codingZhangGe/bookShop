package com.xupt.bookshop.dao;

import com.xupt.bookshop.model.upload.UploadItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;



/**
 * Created by ge.zhang on 16-4-19.
 */
@Repository
public interface UploadItemDao {
    public void insertItem(@Param("item") UploadItem itemModel);

    public void selectItem(@Param("item") UploadItem item);

    public void insertUnfinishedItem(@Param("item") UploadItem item);
}
