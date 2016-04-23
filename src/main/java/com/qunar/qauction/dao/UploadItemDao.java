package com.qunar.qauction.dao;

import com.qunar.qauction.model.upload.UploadItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by liuyanjiang on 16-4-19.
 */
@Repository
public interface UploadItemDao {
    public void insertItem(@Param("item") UploadItem itemModel);

    public void selectItem(@Param("item") UploadItem item);
}
