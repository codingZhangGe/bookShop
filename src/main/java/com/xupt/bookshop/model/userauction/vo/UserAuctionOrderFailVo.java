package com.xupt.bookshop.model.userauction.vo;

import com.xupt.bookshop.model.enums.BookState;
import org.joda.time.DateTime;
import qunar.api.pojo.Money;

/**
 *
 * Created by yangsongbao on 16-4-20.
 */
public class UserAuctionOrderFailVo {
    private String itemName;

    private String imgUrl;

    private DateTime auctionTime;

    private Money auctionPrice;

    private String sellerQtalk;

    private BookState bookState;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public DateTime getAuctionTime() {
        return auctionTime;
    }

    public void setAuctionTime(DateTime auctionTime) {
        this.auctionTime = auctionTime;
    }

    public Money getAuctionPrice() {
        return auctionPrice;
    }

    public void setAuctionPrice(Money auctionPrice) {
        this.auctionPrice = auctionPrice;
    }

    public String getSellerQtalk() {
        return sellerQtalk;
    }

    public void setSellerQtalk(String sellerQtalk) {
        this.sellerQtalk = sellerQtalk;
    }

    public BookState getBookState() {
        return bookState;
    }

    public void setBookState(BookState bookState) {
        this.bookState = bookState;
    }
}
