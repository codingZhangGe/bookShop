package com.qunar.qauction.dao;

import com.qunar.qauction.model.upload.ImgModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by liuyanjiang on 16-4-18.
 */
@Repository
public interface ImgDao {
    public void insertImgs(@Param("imgModel") ImgModel imgModel);// 插入图片

    public List<String> selectImages(@Param("itemId") String itemId);// 查询图片

    public void deleteImg(@Param("pictureId") String pictureId);// 删除

    public void deleteImgByItemId(@Param("itemId") String itemId);// 根据itemId删除图片

    public String selectFirstPicture(@Param("itemId") String itemId);// 查询用户上传的第一张图片
}
