package com.xupt.bookshop.model.enums;

/**
 * 图书状态, 1有货, 2无货, 3下架
 * 
 * @author yunfeng.yang created on 16-4-19
 * @version 1.0
 */
public enum State {
    OK_TO_ORDER(1, "有货"), OUT_OF_STOCK(2, "无货"), UNDER_CARRIAGE(3, "下架");

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
        if (src.equals(OUT_OF_STOCK.toString())) {
            return OUT_OF_STOCK;
        } else if (src.equals(UNDER_CARRIAGE.toString())) {
            return UNDER_CARRIAGE;
        }else if(src.equals(OK_TO_ORDER.toString())) {
            return OK_TO_ORDER;
        }
        else
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
