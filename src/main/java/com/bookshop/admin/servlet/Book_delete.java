package com.bookshop.admin.servlet;

import com.bookshop.admin.action.Action_Method_book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Book_delete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String valueList=req.getParameter("idList");
		String[] valueStr=valueList.split(";");
		for(int i=0;i<valueStr.length;i++){
			Action_Method_book.deleteBook_Action(Integer.parseInt(valueStr[i]));
		}
	}
}
