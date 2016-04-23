package com.xupt.bookshop.model.enums;

/**
 * @author yunfeng.yang created on 16-4-18
 * @version 1.0
 */
public enum OldDegree {
    ONE_OLD_DEGREE(1, "1成新"), TWO_OLD_DEGREE(2, "2成新"), THREE_OLD_DEGREE(3, "3成新"), FOUR_OLD_DEGREE(4,
            "4成新"), FIVE_OLD_DEGREE(5, "5成新"), SIX_OLD_DEGREE(6, "6成新"), SEVEN_OLD_DEGREE(7, "7成新"), EIGHT_OLD_DEGREE(8,
                    "8成新"), NINE_OLD_DEGREE(9, "9成新"), TEN_OLD_DEGREE(10, "10成新");

    /**
     * 新旧程度的code
     */
    private int code;

    /**
     * 新旧程度的描述
     */
    private String descriptions;

    OldDegree(int code, String descriptions) {
        this.code = code;
        this.descriptions = descriptions;
    }

    public int code() {
        return getCode();
    }

    public static OldDegree codeOf(int code) {
        OldDegree[] values = values();
        for (OldDegree value : values) {
            if (value.getCode() == code) {
                return value;
            }
        }
        return null;
    }

    public static OldDegree byString(String src) {
        if (src.equals(ONE_OLD_DEGREE.toString())) {
            return ONE_OLD_DEGREE;
        } else if (src.equals(TWO_OLD_DEGREE.toString())) {
            return TWO_OLD_DEGREE;
        } else if (src.equals(THREE_OLD_DEGREE.toString())) {
            return THREE_OLD_DEGREE;
        } else if (src.equals(FOUR_OLD_DEGREE.toString())) {
            return FOUR_OLD_DEGREE;
        } else if (src.equals(FIVE_OLD_DEGREE.toString())) {
            return FIVE_OLD_DEGREE;
        } else if (src.equals(SIX_OLD_DEGREE.toString())) {
            return SIX_OLD_DEGREE;
        } else if (src.equals(SEVEN_OLD_DEGREE.toString())) {
            return SEVEN_OLD_DEGREE;
        } else if (src.equals(EIGHT_OLD_DEGREE.toString())) {
            return EIGHT_OLD_DEGREE;
        } else if (src.equals(NINE_OLD_DEGREE.toString())) {
            return NINE_OLD_DEGREE;
        } else if (src.equals(TEN_OLD_DEGREE.toString())) {
            return TEN_OLD_DEGREE;
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
