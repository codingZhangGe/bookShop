package com.bookshop.admin.servlet;

import com.bookshop.admin.action.Action_Method_order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Order_delete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String values = req.getParameter("idList");
		String[] ids = values.split(";");
		for(int i=0; i<ids.length; i++){
			Action_Method_order.deleteOrders_Action(Integer.parseInt(ids[i]));
		}
	}
}
