package com.xupt.bookshop.service.upload;


import com.xupt.bookshop.model.upload.UploadItemParam;

/**
 * Created by ge.zhang on 16-4-19.
 */
public interface UploadItemService {
    public void uploadItem(UploadItemParam item);
    public void uploadCategory(String name);

}
