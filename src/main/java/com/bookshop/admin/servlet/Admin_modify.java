package com.bookshop.admin.servlet;

import com.alibaba.fastjson.JSON;
import com.bookshop.admin.action.Action_Method_admin;
import com.bookshop.admin.vo.User_Type;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Admin_modify extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		int id=-1,state=-1;
		String name="",password="";
		String valueList=new String(req.getParameter("valueList").getBytes("iso8859-1"),"UTF-8");
		String[] valueStr=valueList.split(";");
		
		id=Integer.parseInt(valueStr[0]);
		name=valueStr[1];
		password=valueStr[2];
		state=Integer.parseInt(valueStr[3]);
		
		List<User_Type> list= Action_Method_admin.modifyAdmin_Action(id, name, password, state);
		
		resp.setContentType("text/html;charset=utf-8");
		String json= JSON.toJSONString(list);
		resp.getWriter().println(json);
	}
}
