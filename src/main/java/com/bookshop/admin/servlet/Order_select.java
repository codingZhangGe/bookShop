package com.bookshop.admin.servlet;

import com.alibaba.fastjson.JSON;
import com.bookshop.admin.action.Action_Method_order;
import com.bookshop.admin.vo.Order_type;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Order_select extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		Map<String, String> map = new HashMap<String, String>();
		map.put("UID", req.getParameter("UID"));
		map.put("Address", new String(req.getParameter("Address").getBytes("iso8859-1"),"UTF-8"));
		map.put("Telephone", new String(req.getParameter("Telephone").getBytes("iso8859-1"),"UTF-8"));
		if("NaN-NaN-NaN".equals(req.getParameter("OrderTime"))){
			map.put("OrderTime", "");
		}else{
			map.put("OrderTime", req.getParameter("OrderTime"));
		}
		
		map.put("Status", req.getParameter("Status"));
		
		List<Order_type> list = Action_Method_order.selectOrders_Action(map);
		for(int i=0; i<list.size(); i++){
			System.out.println("select "+list.get(i).getAddress());
		}
		
		resp.setContentType("text/html;charset=utf-8");
		String json= JSON.toJSONString(list);
		resp.getWriter().println(json);
	}
}
