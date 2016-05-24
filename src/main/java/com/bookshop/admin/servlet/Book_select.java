package com.bookshop.admin.servlet;

import com.alibaba.fastjson.JSON;
import com.bookshop.admin.action.Action_Method_book;
import com.bookshop.admin.vo.Book_type;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Book_select extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String valueList=new String(req.getParameter("valueList").getBytes("iso8859-1"),"UTF-8");
		
		String[] valueStr=valueList.split(";");
		
		Map<String, String> map=new HashMap<String, String>();
		for(int i=0;i<valueStr.length;i++){
			String[] st=valueStr[i].split("=");
			if(st.length==2){
				map.put(st[0], st[1]);
			}
		}
		List<Book_type> list= Action_Method_book.selectBook_Action(map);
		
		resp.setContentType("text/html;charset=utf-8");
		String json= JSON.toJSONString(list);
		resp.getWriter().println(json);
	}
}
