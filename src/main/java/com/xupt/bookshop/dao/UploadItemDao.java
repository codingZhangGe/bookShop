package com.xupt.bookshop.dao;

import com.xupt.bookshop.model.Category.Category;
import com.xupt.bookshop.model.upload.UploadItemParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;



/**
 *
 * Created by ge.zhang on 16-4-19.
 */
@Repository
public interface UploadItemDao {
    public void insertItem(@Param("item") UploadItemParam itemModel);

    public void selectItem(@Param("item") UploadItemParam item);
    public int selectParentCategoryId(@Param("parentName") String parentName);
    public void insertBookDynamicItem(@Param("item") UploadItemParam item);
    public void insertCategory(@Param("category") Category item);
}
