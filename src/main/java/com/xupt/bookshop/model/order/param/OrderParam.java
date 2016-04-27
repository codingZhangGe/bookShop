package com.xupt.bookshop.model.order.param;

import javax.validation.constraints.NotNull;

/**下单传递参数
 * Created by zhangge on 16-4-27.
 */
public class OrderParam {

    @NotNull
    String linkman;
    @NotNull
    String address;
    @Tel
    String telphone;

    public String getLinkman() {
        return linkman;
    }

    public String getAddress() {
        return address;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }
}
