package com.bookshop.admin.dao;

import com.bookshop.admin.jdbc.CreatDB;
import com.bookshop.admin.vo.Order_type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;



public class Dao_Method_order {
	public static List allOrder_Dao() {
		List<Order_type> list = new ArrayList<Order_type>();
		
		try {
			Connection conn = CreatDB.getConnection_ZH();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery("select * from orders");
			
			while(rs.next()){
				Order_type ot = new Order_type();
				ot.setOrderID(rs.getInt("OrderID"));
				ot.setUID(rs.getInt("UID"));
				ot.setAddress(rs.getString("Address"));
				ot.setTelephone(rs.getString("Telephone"));
				Timestamp data = rs.getTimestamp("OrderTime");
				ot.setOrderTime(data.toString());
				if(rs.getInt("Status")==1){
					ot.setStatus("未支付");
				}else if(rs.getInt("Status")==2){
					ot.setStatus("支付");
				}else if(rs.getInt("Status")==3){
					ot.setStatus("已取消");
				}else if(rs.getInt("Status")==4){
					ot.setStatus("过期");
				}
				list.add(ot);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<Order_type> addOrders_Dao(String[] values, String time, int statue) {
		List<Order_type> list = new ArrayList<Order_type>();
		
		try {
			Connection conn = CreatDB.getConnection_ZH();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO orders(UID, Address, Telephone, OrderTime, Status) values(?,?,?,?,?)");
			ps.setInt(1, Integer.parseInt(values[0]));
			ps.setString(2, values[1]);
			ps.setString(3, values[2]);
			ps.setString(4, time);
			ps.setInt(5, statue);
			ps.execute();
			
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		list = allOrder_Dao();
		return list;
	}
	
	public static void deleteOrders_Dao(int id) {
		try {
			Connection conn=CreatDB.getConnection_ZH();

			PreparedStatement ps=conn.prepareStatement("DELETE FROM orders WHERE OrderID=?");
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Order_type> modifyOrders_Dao(Map<String, String> map) {
		List<Order_type> list = new ArrayList<Order_type>();
		
		String sql="UPDATE orders SET ";
		Set<Entry<String, String>> set=map.entrySet();
		Iterator<Entry<String, String>> it=set.iterator();
		while(it.hasNext()){
			Entry en=it.next();
			if("Telephone".equals(en.getKey())){
				sql += en.getKey()+"='"+en.getValue()+"',";
			}else if("Status".equals(en.getKey())){
				sql += en.getKey()+"="+Integer.parseInt((String)en.getValue())+",";
			}else if("UID".equals(en.getKey())){
				sql += en.getKey()+"="+Integer.parseInt((String)en.getValue())+",";
			}else if("Address".equals(en.getKey())){
				sql += en.getKey()+"='"+en.getValue()+"',";
			}
		}
		sql=sql.substring(0,sql.lastIndexOf(","))+" WHERE OrderID=?";
		
		try {
			Connection conn=CreatDB.getConnection_ZH();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(map.get("OrderID")));
			ps.executeUpdate();
			ps.close();
			conn.close();
			list = idSelect(map.get("OrderID"), "modify");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static List<Order_type> idSelect(String strId, String flag) {
		List<Order_type> list = new ArrayList<Order_type>();
		
		Connection conn = CreatDB.getConnection_ZH();
		ResultSet rs = null;
		
		try {
			if("modify".equals(flag)){
				Statement sta = conn.createStatement();
				rs = sta.executeQuery("SELECT * FROM orders WHERE OrderID="+Integer.parseInt(strId)); 
			}else if("".equals(flag)){
				
			}
			while(rs.next()){
				Order_type ot = new Order_type();
				ot.setOrderID(rs.getInt("OrderID"));
				ot.setUID(rs.getInt("UID"));
				ot.setAddress(rs.getString("Address"));
				ot.setTelephone(rs.getString("Telephone"));
				Timestamp data = rs.getTimestamp("OrderTime");
				ot.setOrderTime(data.toString());
				if(rs.getInt("Status")==1){
					ot.setStatus("未支付");
				}else if(rs.getInt("Status")==2){
					ot.setStatus("支付");
				}else if(rs.getInt("Status")==3){
					ot.setStatus("已取消");
				}else if(rs.getInt("Status")==4){
					ot.setStatus("过期");
				}
				list.add(ot);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static List<Order_type> selectOrders_Dao(Map<String, String> map) {
		List<Order_type> list = new ArrayList<Order_type>();
		String sql = "SELECT * FROM orders";
		String where = " WHERE";
		boolean flag = false;
		
		Set<Entry<String, String>> set=map.entrySet();
		Iterator<Entry<String, String>> it=set.iterator();
		while(it.hasNext()){
			Entry en=it.next();
			if("UID".equals(en.getKey()) && ((String)en.getValue()).length()!=0){
				where += " UID LIKE '%"+Integer.parseInt((String)en.getValue())+ "%' and";
				flag = true;
			}else if("Address".equals(en.getKey()) && ((String)en.getValue()).length()!=0){
				where += " Address LIKE '%"+en.getValue()+"%' and";
				flag = true;
			}else if("Telephone".equals(en.getKey()) && ((String)en.getValue()).length()!=0){
				where += " Telephone LIKE '%"+en.getValue()+"%' and";
				flag = true;
			}else if("OrderTime".equals(en.getKey()) && ((String)en.getValue()).length()!=0){
				where += " OrderTime LIKE '%"+en.getValue()+ "%' and";
				flag = true;
			}else if("Status".equals(en.getKey()) && Integer.parseInt(((String)en.getValue()))!=0){
				where += " Status LIKE '%"+Integer.parseInt((String)en.getValue())+ "%' and";
				flag = true;
			}
		}
		
		if(flag){
			sql += where.substring(0,where.lastIndexOf(" and"));
		}
		/*System.out.println(sql);*/
		
		try {
			Connection conn = CreatDB.getConnection_ZH();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()){
				Order_type ot = new Order_type();
				ot.setOrderID(rs.getInt("OrderID"));
				ot.setUID(rs.getInt("UID"));
				ot.setAddress(rs.getString("Address"));
				ot.setTelephone(rs.getString("Telephone"));
				Timestamp data = rs.getTimestamp("OrderTime");
				ot.setOrderTime(data.toString());
				if(rs.getInt("Status")==1){
					ot.setStatus("未支付");
				}else if(rs.getInt("Status")==2){
					ot.setStatus("支付");
				}else if(rs.getInt("Status")==3){
					ot.setStatus("已取消");
				}else if(rs.getInt("Status")==4){
					ot.setStatus("过期");
				}
				list.add(ot);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static int getStatue(String id) {
		int flag = -1;
		
		try {
			Connection conn = CreatDB.getConnection_ZH();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery("SELECT Status FROM orders WHERE OrderID="+Integer.parseInt(id));
			while(rs.next()){
				flag = rs.getInt("Status");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return flag;
	}
}