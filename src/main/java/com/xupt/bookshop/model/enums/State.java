package com.xupt.bookshop.model.enums;

/**
 * 拍卖物品状态, 1-未开始, 2-竞拍中, 3-竞拍成功, 4-竞拍失败
 * 
 * @author yunfeng.yang created on 16-4-19
 * @version 1.0
 */
public enum State {
    UN_START_AUCTION(1, "未开始"), DURING_AUCTION(2, "竞拍中"), SUCCESS_AUCTION(3, "竞拍成功"), FAILURE_AUCTION(4, "竞拍失败");

    private int code;
    private String description;

    State(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int code() {
        return getCode();
    }

    public static State codeOf(int code) {
        State[] values = values();
        for (State value : values) {
            if (value.getCode() == code) {
                return value;
            }
        }
        return null;
    }


    public static State byString(String src) {
        if (src.equals(UN_START_AUCTION.toString())) {
            return UN_START_AUCTION;
        } else if (src.equals(DURING_AUCTION.toString())) {
            return DURING_AUCTION;
        } else if (src.equals(SUCCESS_AUCTION.toString())) {
            return SUCCESS_AUCTION;
        } else if (src.equals(FAILURE_AUCTION.toString())) {
            return FAILURE_AUCTION;
        }  else
            return null;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
