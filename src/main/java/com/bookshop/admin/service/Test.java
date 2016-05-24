package com.bookshop.admin.service;

import java.util.List;



public class Test {
	public static void main(String[] args) {
		String str="sgdvdgc and ddc";
		String st=str.substring(0, str.lastIndexOf(" and "));
		System.out.println(st);//sgdvdgc
		/*int t=5;
		if(t==1 || t==2 || t==3 || t==4 || t==5){
			System.out.println("成功啦");
		}*/
		/*int s=2;
		if(s==1){
			System.out.println("1");
		}else if(s==2){
			System.out.println("2");
		}else if(s==3){
			System.out.println("3");
		}else if(s==4){
			System.out.println("4");
		}else{
			System.out.println("meiyou");
		}*/
		/*String str="123.34";
		String st="2.41q";
		String s="23";
		boolean b1=str.matches("[0-9]+");
		boolean b2=st.matches("[0-9]+");
		boolean b3=s.matches("[0-9]+");
		if(b1){
			System.out.println("b1");
		}
		if(b2){
			System.out.println("b2");
		}
		if(b3){
			System.out.println("b3");
		}*/
		/*String str="wsd=q";
		String[] st=str.split("=");
		System.out.println(st.length);*/
		
		/*boolean author=Dao_Method_book.existAuthor("张潇洒");
		boolean publish=Dao_Method_book.existPublish("西安邮电大学出版社");
		System.out.println("author="+author+";publish="+publish);*/
		//Dao_Method_book.addBook_Dao("name", 45, 24, "discount", "author", "publish", 5, "introduce", 2, "image_s", "image_b", 19);
		//System.out.println(list.size());
	}
}
