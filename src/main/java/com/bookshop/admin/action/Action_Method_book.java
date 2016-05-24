package com.bookshop.admin.action;

import com.bookshop.admin.dao.Dao_Method_book;
import com.bookshop.admin.vo.Book_type;

import java.util.List;
import java.util.Map;


public class Action_Method_book {
	public static List addBook_Action(String name,int price,int currentprice,String discount,String author,String publish,int cid,String introduce,int shopid,String image_s,String image_b,int count, String version) {
		List<Book_type> list=Dao_Method_book.addBook_Dao(name,price,currentprice,discount,author,publish,cid,introduce,shopid,image_s,image_b,count,version);
		return list;
	}
	
	public static void deleteBook_Action(int id) {
		Dao_Method_book.deleteBook_Dao(id);
	}
	
	public static List modifyBook_Action(Map<String, String> map) {
		List<Book_type> list=Dao_Method_book.modifyBook_Dao(map);
		return list;
	}
	
	public static List selectBook_Action(Map<String, String> map) {
		List<Book_type> list=Dao_Method_book.selectBook_Dao(map);
		return list;
	}
}
