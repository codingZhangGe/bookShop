package com.bookshop.admin.vo;

public class Order_type {
	public int OrderID;
	public int UID;// 用户id
	public String Address; //地址
	public String Telephone; //电话
	public String OrderTime; //下单时间
	public String Status;//状态
	
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public int getOrderID() {
		return OrderID;
	}
	
	public void setUID(int uID) {
		UID = uID;
	}
	public int getUID() {
		return UID;
	}
	
	public void setAddress(String address) {
		Address = address;
	}
	public String getAddress() {
		return Address;
	}
	
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	public String getTelephone() {
		return Telephone;
	}
	
	public void setOrderTime(String orderTime) {
		OrderTime = orderTime;
	}
	public String getOrderTime() {
		return OrderTime;
	}
	
	public void setStatus(String status) {
		Status = status;
	}
	public String getStatus() {
		return Status;
	}
}
