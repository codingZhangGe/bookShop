package com.xupt.bookshop.model.enums;

/**
 * @author yunfeng.yang created on 16-4-18
 * @version 1.0
 */
public enum OrderState {
    ORDER_NO_PAY(1, "未支付"), ORDER_PAY_SUCCESS(2, "支付成功"),HAS_REMOVED (3, "已取消"), OUT_OF_DATE(4,"已过期");

    /**
     * 新旧程度的code
     */
    private int code;

    /**
     * 新旧程度的描述
     */
    private String descriptions;

    OrderState(int code, String descriptions) {
        this.code = code;
        this.descriptions = descriptions;
    }

    public int code() {
        return getCode();
    }

    public static OrderState codeOf(int code) {
        OrderState[] values = values();
        for (OrderState value : values) {
            if (value.getCode() == code) {
                return value;
            }
        }
        return null;
    }

    public static OrderState byString(String src) {
        if (src.equals(ORDER_NO_PAY.toString())) {
            return ORDER_NO_PAY;
        } else if (src.equals(ORDER_PAY_SUCCESS.toString())) {
            return ORDER_PAY_SUCCESS;
        } else if (src.equals(HAS_REMOVED.toString())) {
            return HAS_REMOVED;
        } else
            return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
}
