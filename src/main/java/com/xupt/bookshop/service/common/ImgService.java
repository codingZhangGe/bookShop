package com.xupt.bookshop.service.common;

import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * Created by liuyanjiang on 16-4-17.
 */
public interface ImgService {

    public String upLoadImg(InputStream inputStream, String itemId, String fileName);

    public String upLoadImg(File file, String itemId, String fileName);

    public List<String> getPictureUrl(String itemId);

    public void deleteImg(String pictureId);

    public String upLoadImg(byte[] bytes, String itemId, String fileName);

    public void deleteImgsByItemId(String itemId);

    public String getFirstPictureUrl(String itemId);
}
