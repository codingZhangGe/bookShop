package com.bookshop.admin.servlet;

import com.bookshop.admin.action.Action_Method_admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Login extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String userName=req.getParameter("na_user");
		String password=req.getParameter("na_password");
		int state=Integer.parseInt(req.getParameter("na_type"));
		
		int flag= Action_Method_admin.getType_Action(userName, password, state);
		//System.out.println("这是Servlet的值： "+userName+"\t"+password+"\t"+state+"\t"+flag);
		if(flag==3){//查到用户
			if(state==2){//这是客户
				req.getRequestDispatcher("clientTable.jsp").forward(req, resp);
			}else{
				req.getRequestDispatcher("adminTable.jsp").forward(req, resp);
			}
		}else{//没有这个用户
			if(flag==2){
				System.out.println("用户类型不正确");
			}else if(flag==1){
				System.out.println("密码不存在");
			}else if(flag==0){
				System.out.println("用户不存在");
			}else{
				System.out.println("既没有（查出来），又没有（查不出来）！   o(╯□╰)o 出错啦！");
			}
			
			req.getRequestDispatcher("login.jsp?flag="+flag).forward(req, resp);
		}
	}
}
