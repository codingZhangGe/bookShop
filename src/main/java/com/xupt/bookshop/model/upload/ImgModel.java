package com.xupt.bookshop.model.upload;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * Created by liuyanjiang on 16-4-18.
 */
public class ImgModel {
    private List<String> pictureId = Lists.newArrayList();
    private String itemId;

    public ImgModel() {

    }

    public ImgModel(String itemId, List pictureId) {
        this.itemId = itemId;
        this.pictureId = pictureId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public List<String> getPictureId() {
        return pictureId;
    }

    public void setPictureId(List<String> pictureId) {
        this.pictureId = pictureId;
    }
}
