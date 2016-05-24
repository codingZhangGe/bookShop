package com.bookshop.admin.vo;

public class Book_type {
	public int id;
	public String name;
	public int price;//原价
	public int currentprice;//现价
	public String discount;//折扣
	public String author;//作者
	public String Publish;//出版社
	public int cid;//类型id
	public String introduce;//介绍
	public int shopid;//店铺ID
	public int commentID;//评论ID
	public String image_s;//小图
	public String image_b;//大图
	public int status;//图书状态，售出，预定，没有售出
	public int count;
	public int sale;
	public String version;
	
	public void setVersion(String version) {
		this.version = version;
	}
	public String getVersion() {
		return version;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	
	public void setCurrentprice(int currentprice) {
		this.currentprice = currentprice;
	}
	public int getCurrentprice() {
		return currentprice;
	}
	
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getDiscount() {
		return discount;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor() {
		return author;
	}
	
	public void setPublish(String publish) {
		Publish = publish;
	}
	public String getPublish() {
		return Publish;
	}
	
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getCid() {
		return cid;
	}
	
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getIntroduce() {
		return introduce;
	}
	
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public int getShopid() {
		return shopid;
	}
	
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	public int getCommentID() {
		return commentID;
	}
	
	public void setImage_b(String image_b) {
		this.image_b = image_b;
	}
	public String getImage_b() {
		return image_b;
	}
	
	public void setImage_s(String image_s) {
		this.image_s = image_s;
	}
	public String getImage_s() {
		return image_s;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	public int getStatus() {
		return status;
	}

}
