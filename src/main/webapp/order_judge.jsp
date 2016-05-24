<%@page import="com.design.dao.Dao_Method_order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	
	String id = request.getParameter("id");
	int flag = Dao_Method_order.getStatue(id);
	out.println(flag);
	out.flush();
%>
