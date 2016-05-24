package com.bookshop.admin.servlet;

import com.bookshop.admin.action.Action_Method_admin;
import com.bookshop.admin.vo.User_Type;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Admin_All extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		List<User_Type> list= Action_Method_admin.allAdmin_Action();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("user.jsp").forward(req, resp);
	}
}
