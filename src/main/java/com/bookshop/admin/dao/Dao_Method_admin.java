package com.bookshop.admin.dao;

import com.bookshop.admin.jdbc.CreatDB;
import com.bookshop.admin.vo.User_Type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class Dao_Method_admin {
	
	public static int getLogin_Dao(String name, String password,int state) {
		int flag=0;//Whether the user exist
		try {
			Connection conn= CreatDB.getConnection_ZH();
			Statement sta=conn.createStatement();
			
			ResultSet rs=sta.executeQuery("SELECT *FROM admin WHERE AName='"+name+"'");
			//System.out.println("这是Dao的值： "+name+"\t"+password+"\t"+state+"\t"+flag);
			while(rs.next()){
				if(rs.getString("APassword").equals(password)){
					flag=2;
					if(rs.getInt("state")==state){
						flag=3;	//类型也正确
						continue;
					}
				}else{
					flag=1;//密码不正确
					continue;
				}
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static List<User_Type> allAdmin_Dao() {
		List<User_Type> list=new ArrayList<User_Type>();
		try {
			Connection conn=CreatDB.getConnection_ZH();
			Statement sta=conn.createStatement();
			
			ResultSet rs=sta.executeQuery("SELECT *FROM admin");
			while(rs.next()){
				User_Type us=new User_Type();
				us.setId(rs.getInt("AdminID"));
				us.setName(rs.getString("AName"));
				us.setPassword(rs.getString("APassword"));
				us.setState(rs.getInt("state"));
				list.add(us);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List addAdmin_Dao(String name,String password,int state) {
		List<User_Type> list=new ArrayList<User_Type>();
		try {
			Connection conn=CreatDB.getConnection_ZH();
			PreparedStatement ps=conn.prepareStatement("INSERT INTO admin(Aname,Apassword,state) values(?,?,?)");
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setInt(3, state);
			ps.execute();
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		list=allAdmin_Dao();
		return list;
	}
	
	public static void deleteAdmin_Dao(int id,String name,int state) {
		try {
			Connection conn=CreatDB.getConnection_ZH();

			PreparedStatement ps=conn.prepareStatement("DELETE FROM admin WHERE AdminID=?");
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<User_Type> selectAdmin_Dao(int id,String name,int state) {
		List<User_Type> list=new ArrayList<User_Type>();
		if(id<0 && name.length()==0 && state!=1 && state!=2 ){
			list=allAdmin_Dao();
		}else{
			try {
				Connection conn=CreatDB.getConnection_ZH();
				String sql="SELECT * FROM admin ";
				if(id<1){//id没有输入
					if(name==null || name.equals("")){//name没有输入
						sql=sql+"WHERE state LIKE '%"+state+"%' and";//id和name没有输入  state一定会输入
					}else{//name输入
						sql=sql+"WHERE AName LIKE '%"+name+"%' and";
						if(state==1 || state==2){
							sql=sql+" state LIKE '%"+state+"%' and";
						}//否则不做操作
					}
				}else{//id输入
					sql=sql+"WHERE AdminID LIKE '%"+id+"%' and";
					if(name==null || name.equals("")){//name没有输入
						if(state==1 || state==2){//state输入
							sql=sql+" state LIKE '%"+state+"%' and";
						}//state没有输入
					}else{//name输入
						sql=sql+" AName LIKE '%"+name+"%' and";
						if(state==1 || state==2){//state输入了
							sql=sql+" state LIKE '%"+state+"%' and";
						}//否则不做任何操作
					}
				}
				sql = sql.substring(0,sql.lastIndexOf(" and"));
				
				/*System.out.println(sql);	*/
				
				Statement sta=conn.createStatement();
				ResultSet rs=sta.executeQuery(sql);
				/*System.out.println("Dao层的数据:ID="+id+"NAME="+name+"STATE="+state);
				if(id<1){//id没有输入
					if(name==null || name.equals("")){//name没有输入
						sql=sql+"WHERE state=?";//id和name没有输入  state一定会输入
					}else{//name输入
						sql=sql+"WHERE AName=?";
						if(state==1 || state==2){
							sql=sql+",state=?";
						}//否则不做操作
					}
				}else{//id输入
					sql=sql+"WHERE AdminID=?";
					if(name==null || name.equals("")){//name没有输入
						if(state==1 || state==2){//state输入
							sql=sql+",state=?";
						}//state没有输入
					}else{//name输入
						sql=sql+",AName=?";
						if(state==1 || state==2){//state输入了
							sql=sql+",state=?";
						}//否则不做任何操作
					}
				}
				System.out.println(sql);	
				PreparedStatement ps=conn.prepareStatement(sql);
				
				String test="";
				if(id<1){//id没有输入
					if(name==null || name.equals("")){//name没有输入
						ps.setInt(1, state);//id和name没有输入  state一定会输入
						test+="ps.setInt(1, state);";
					}else{//name输入
						ps.setString(1, name);
						test+="ps.setString(1, name);";
						if(state==1 || state==2){
							ps.setInt(2, state);
							test+="ps.setInt(2, state);";
						}//否则不做操作
					}
				}else{//id输入
					ps.setInt(1, id);
					test+="ps.setInt(1, id);";
					if(name==null || name.equals("")){//name没有输入
						if(state==1 || state==2){//state输入
							ps.setInt(2, state);
							test+="ps.setInt(2, state);";
						}//state没有输入
					}else{//name输入
						ps.setString(2, name);
						test+="ps.setString(2, name);";
						if(state==1 || state==2){//state输入了
							ps.setInt(3, state);
							test+="ps.setInt(3, state);";
						}//否则不做任何操作
					}
				}
				System.out.println(test);
				ResultSet rs=ps.executeQuery();*/
				while(rs.next()){
					//System.out.println("有结果了");
					User_Type ut=new User_Type();
					ut.setId(rs.getInt("AdminID"));
					ut.setName(rs.getString("AName"));
					ut.setPassword(rs.getString("APassword"));
					ut.setState(rs.getInt("state"));
					list.add(ut);
				}
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public static List modifyAdmin_Dao(int id,String name,String password,int state) {
		List<User_Type> list=new ArrayList<User_Type>();
		name="'"+name+"'";
		password="'"+password+"'";
		String sql="UPDATE admin SET AName="+name+",APassword="+password+",state="+state+" WHERE AdminID="+id; 
		/*System.out.println(sql);*/
		try {
			Connection conn=CreatDB.getConnection_ZH();
			//PreparedStatement ps=conn.prepareStatement(sql);
			//ResultSet rs=ps.executeQuery();
			//ps.execute();
			Statement sta=conn.createStatement();
			sta.executeUpdate(sql);
			list=allAdmin_Dao();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		return list;
	}
}
