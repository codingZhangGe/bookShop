package com.bookshop.admin.servlet;

import com.alibaba.fastjson.JSON;
import com.bookshop.admin.action.Action_Method_admin;
import com.bookshop.admin.vo.User_Type;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Admin_select extends HttpServlet {
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
		String name="";
		String valueList=new String(req.getParameter("valueList").getBytes("iso8859-1"),"UTF-8");
		String[] valueStr=valueList.split(";");
		//System.out.println("这是数组的长度："+valueStr.length);
		for(int i=0;i<valueStr.length;i++){
			if(i==0){
				if(valueStr[0].length()!=0 && !valueStr[0].equals("")){
					id=Integer.parseInt(valueStr[0]);
					//System.out.println("这是id");
				}
			}
			if(i==1){
				if(valueStr[1].length()!=0 && !valueStr[1].equals(" ")){
					name=valueStr[1];
					/*name="'"+name+"'";*/
					//System.out.println("这是name");
				}
			}
			if(i==2){
				if(valueStr[2].length()!=0 && !valueStr[2].equals(" ")){
					state=Integer.parseInt(valueStr[2]);
					//System.out.println("这是state");
				}
			}
			
			//System.out.println("第"+i+"个的值是："+valueStr[i]+"它的长度是："+valueStr[i].length());
		}
		
		List<User_Type> list= Action_Method_admin.selectAdmin_Action(id, name, state);
		
		resp.setContentType("text/html;charset=utf-8");
		String json= JSON.toJSONString(list);
		resp.getWriter().println(json);
	}
}
