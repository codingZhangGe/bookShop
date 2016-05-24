package com.bookshop.admin.servlet;

import com.bookshop.admin.action.Action_Method_admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class Admin_delete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String idList=req.getParameter("idList");
		
		if(idList!=null && idList.length()!=0){
			String[] idString=idList.split(";");
			for(int i=0;i<idString.length;i++){
				Action_Method_admin.deleteAdmin_Action(Integer.parseInt(idString[i]), null, -1);
			}
		}
				
		
		/*int id=Integer.parseInt(req.getParameter("na_id"));
		String name=req.getParameter("na_name");
		int state=Integer.parseInt(req.getParameter("na_type"));
		String str="";
		
		List<User_Type> list=new ArrayList<User_Type>();
		list=Action_Method.deleteAdmin_Action(id, name, state);
		
		String json = JSON.toJSONString(list);
		resp.getWriter().println(json);
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("user.jsp").forward(req, resp);*/
		
	}
}
