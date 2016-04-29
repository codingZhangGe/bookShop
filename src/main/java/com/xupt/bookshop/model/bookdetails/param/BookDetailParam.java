package com.xupt.bookshop.model.bookdetails.param;

import com.xupt.bookshop.model.bookdetails.param.validation.ItemIdValidator;
import org.hibernate.validator.constraints.Range;



/**
 * @author yunfeng.yang created on 16-4-24
 * @version 1.0
 */
public class BookDetailParam {
    /**
     * 竞拍物品的itemId
     */
    @ItemIdValidator(message = "竞拍物品的itemId不满足要求")
    private String bookId;

    /**
     * 竞拍物品的状态state
     */
    @Range(min = 1, max = 4, message = "竞拍物品状态取值只能是1, 2, 3, 4")
    private Integer state;

    public String getItemId() {
        return bookId;
    }

    public void setItemId(String itemId) {
        this.bookId = itemId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
