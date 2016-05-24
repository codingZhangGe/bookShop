package com.bookshop.admin.servlet;

import com.alibaba.fastjson.JSON;
import com.bookshop.admin.action.Action_Method_order;
import com.bookshop.admin.vo.Order_type;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Order_add extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
		//String valuesArray=new String(req.getParameter("valuesArray").getBytes("iso8859-1"),"UTF-8");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String[] values = new String[3];
		values[0] = req.getParameter("UID");
		
		values[1] = new String(req.getParameter("Address").getBytes("iso8859-1"),"UTF-8");
		values[2] = new String(req.getParameter("Telephone").getBytes("iso8859-1"),"UTF-8");
		System.out.println(req.getParameter("Address"));
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		
		List<Order_type> list = Action_Method_order.addOrders_Action(values, time, 1);
		
		resp.setContentType("text/html;charset=utf-8");
		String json = JSON.toJSONString(list);
		resp.getWriter().println(json);
	}
}
