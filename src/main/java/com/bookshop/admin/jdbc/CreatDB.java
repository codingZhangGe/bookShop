package com.bookshop.admin.jdbc;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class CreatDB {
	private static String driver;
	private static String url;
	private static String password;
	private static String username;
	
	static{
		try {
			
			String path = CreatDB.class.getResource("/").toString();//   file:/F:/ls/apache-tomcat-6.0.44/webapps/Graduation_design/WEB-INF/classes/
			path=path.substring(path.indexOf(":")+2);
			
			SAXReader reader = new SAXReader();
			Document doc = reader.read(path+"JDBC_ZH.xml");//也可以是 JDBC_MY.xml
	
			Element root = doc.getRootElement();
			List<Element> cLi = root.elements();
			for (Element e1 : cLi) {
				if(e1.getName().equals("driver")){
					driver = e1.getTextTrim();
				}else if(e1.getName().equals("url")){
					url = e1.getTextTrim();
				}else if(e1.getName().equals("password")){
					password = e1.getTextTrim();
				}else if(e1.getName().equals("root")){
					username = e1.getTextTrim();
				}
			}
			//System.out.println(driver+"  &&  "+url+"  &&  "+password+"  &&  "+username);
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection_ZH(){
		Connection conn=null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
