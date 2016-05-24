package com.bookshop.admin.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Test_JDBC {
	public static void main(String[] args) {
		int state=1;
		int id=4;
		int cid=4;
		
		Connection conn= CreatDB.getConnection_ZH();
		
		try {
			String sql = "asd";
			/*PreparedStatement ps = conn.prepareStatement("SELECT * FROM orders WHERE Address LIKE ?");
			ps.setString(1, "'%"+"asd"+"%'");
			ResultSet rs = ps.executeQuery();*/
			
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery("SELECT * FROM orders WHERE Address LIKE '%asd%' and Telephone LIKE '%233%'");
			//ResultSet rs = sta.executeQuery("SELECT * FROM orders WHERE Status LIKE '%1%'");
			
			while(rs.next()){
				System.out.println("test # "+rs.getString("Address"));
			}
			
			/*PreparedStatement ps = conn.prepareStatement("UPDATE orders SET Address=? WHERE OrderID=?");
			ps.setInt(1, 9);
			ps.setString(2, "户县");
			
			ps.executeUpdate();
			
			List<Order_type> list = Dao_Method_order.idSelect("9", "modify");
			for(int i=0; i<list.size(); i++){
				System.out.println("测试  address="+list.get(i).getAddress());
			}*/
			/*String sql="SELECT * FROM book WHERE BookID=? and CID=? and Status=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, cid);
			ps.setInt(3, state);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getString("BName"));
			}*/
			/*String sql="SELECT * FROM admin WHERE AName=? and APassword=? and state=?";
			PreparedStatement ps=conn.prepareStatement(sql);	
			ps.setString(1, name);
			ps.setString(2, pass);
			ps.setInt(3, state);
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("AdminID"));
			}*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
