package com.bookshop.admin.dao;

import com.bookshop.admin.jdbc.CreatDB;
import com.bookshop.admin.vo.Book_type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;



public class Dao_Method_book {
	//出版社
	public static void existPublish(String name) {
		int count=0;
		//boolean b=true;
		try {
			Connection conn= CreatDB.getConnection_ZH();
			PreparedStatement ps=conn.prepareStatement("SELECT PName FROM publish WHERE PName=?");
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				count++;
			}
			
			if(count==0){
				PreparedStatement publish=conn.prepareStatement("INSERT INTO publish(PName) values(?)");
				publish.setString(1, name);
				publish.execute();
				publish.close();
				//System.out.println("publish_Dao="+b); 添加成功之后返回来的值是false，
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//作者
	public static void existAuthor(String name) {
		//boolean b=true;
		int count=0;
		try {
			Connection conn=CreatDB.getConnection_ZH();
			PreparedStatement ps=conn.prepareStatement("SELECT AName FROM author WHERE AName=?");
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				count++;
			}
			if(count==0){
				PreparedStatement author=conn.prepareStatement("INSERT INTO author(AName) values(?)");
				author.setString(1, name);
				author.execute();
				author.close();
				//System.out.println("book_Dao="+b);
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return b;
	}
	
	public static List allBook_Dao() {
		List<Book_type> list=new ArrayList<Book_type>();
		try {
			Connection conn=CreatDB.getConnection_ZH();
			Statement sta=conn.createStatement();
			ResultSet rs=sta.executeQuery("select * from book");
			while(rs.next()){
				Book_type bt=new Book_type();
				bt.setId(rs.getInt("BookID"));
				bt.setName(rs.getString("BName"));
				bt.setPrice(rs.getInt("Price"));
				bt.setCurrentprice(rs.getInt("Currentprice"));
				bt.setDiscount(rs.getString("Discount"));
				bt.setAuthor(rs.getString("Author")); //作者  Author
				bt.setPublish(rs.getString("Publish")); //出版社  Publish
				bt.setCid(rs.getInt("CID"));
				bt.setIntroduce(rs.getString("Introduce"));
				bt.setShopid(rs.getInt("ShopID"));
				bt.setCommentID(rs.getInt("CommentID"));
				bt.setImage_s(rs.getString("Image_s"));
				bt.setImage_b(rs.getString("Image_b"));
				bt.setStatus(rs.getInt("Status"));
				bt.setCount(rs.getInt("BCount"));
				bt.setSale(rs.getInt("Bsale"));
				bt.setVersion(rs.getString("Version"));
				list.add(bt);
			}
			
			sta.close();
			conn.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List addBook_Dao(String name,int price,int currentprice,String discount,String author,String publish,int cid,String introduce,int shopid,String image_s,String image_b,int count,String version) {
		//name,"price",currentprice,discount,author,publish,cid,"introduce",shopid,image_s,image_b,count
		existAuthor(author);
		existPublish(publish);
		List<Book_type> list=new ArrayList<Book_type>();
		String sql="INSERT INTO book(";
		String book="BName";
		String values=" values(?,";
		if(price!=-1){
			book+=",Price,Currentprice,Discount,Author,Publish,CID";
			values+="?,?,?,?,?,?,";
		}else{
			book+=",Currentprice,Discount,Author,Publish,CID";
			values+="?,?,?,?,?,";
		}
		if(!introduce.isEmpty()){
			book+=",Introduce,ShopID,Image_s,Image_b,BCount,Status,Version) ";
			values+="?,?,?,?,?,?,?)";
		}else{
			book+=",ShopID,Image_s,Image_b,BCount,Status,Version) ";
			values+="?,?,?,?,?,?)";
		}
		sql+=book+values;
		//System.out.println(sql);
				
		try {
			Connection conn=CreatDB.getConnection_ZH();
			PreparedStatement ps=conn.prepareStatement(sql);

			ps.setString(1, name);
			if(price!=-1){
				ps.setInt(2, price);
				ps.setInt(3, currentprice);
				ps.setString(4, discount);
				ps.setString(5, author);
				ps.setString(6, publish);
				ps.setInt(7, cid);
				if(!introduce.isEmpty()){
					ps.setString(8, introduce);
					ps.setInt(9, shopid);
					ps.setString(10, image_s);
					ps.setString(11, image_b);
					ps.setInt(12, count);
					ps.setInt(13, 1);
					ps.setString(14, version);
				}else{
					ps.setInt(8, shopid);
					ps.setString(9, image_s);
					ps.setString(10, image_b);
					ps.setInt(11, count);
					ps.setInt(12, 1);
					ps.setString(13, version);
				}
			}
			//name,"price",currentprice,discount,author,publish,cid,"introduce",shopid,image_s,image_b,count
			else{
				ps.setInt(2, currentprice);
				ps.setString(3, discount);
				ps.setString(4, author);
				ps.setString(5, publish);
				ps.setInt(6, cid);
				if(!introduce.isEmpty()){
					ps.setString(7, introduce);
					ps.setInt(8, shopid);
					ps.setString(9, image_s);
					ps.setString(10, image_b);
					ps.setInt(11, count);
					ps.setInt(12, 1);
					ps.setString(13, version);
				}else{
					ps.setInt(7, shopid);
					ps.setString(8, image_s);
					ps.setString(9, image_b);
					ps.setInt(10, count);
					ps.setInt(11, 1);
					ps.setString(12, version);
				}
			}
			//list=allBook_Dao();
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		list=allBook_Dao();
		return list;
	}
	
	public static List selectBook_Dao(Map<String, String> map) {
		List<Book_type> list=new ArrayList<Book_type>();
		String sql="SELECT * FROM book";
		String values=" WHERE";
		boolean flag = false;
	
		Set<Entry<String, String>> set=map.entrySet();
		Iterator<Entry<String, String>> it=set.iterator();
		while(it.hasNext()){
			Entry en=it.next();
			if("BookID".equals(en.getKey())){
				if(Integer.parseInt((String)en.getValue())>-1){
					values += " BookID LIKE '%"+Integer.parseInt((String)en.getValue())+"%' and";
				}
			}else if("Price".equals(en.getKey())){
				if(Integer.parseInt((String)en.getValue())>-1){
					values += " Price LIKE '%"+Integer.parseInt((String)en.getValue())+"%' and";
				}
			}else if("Currentprice".equals(en.getKey())){
				if(Integer.parseInt((String)en.getValue())>-1){
					values += " Currentprice LIKE '%"+Integer.parseInt((String)en.getValue())+"%' and ";
				}
			}else if("CID".equals(en.getKey())){
				if(Integer.parseInt((String)en.getValue())>-1){
					values += " CID LIKE '%"+Integer.parseInt((String)en.getValue())+"%' and ";
				}
			}else if("ShopID".equals(en.getKey())){
				if(Integer.parseInt((String)en.getValue())>-1){
					values += " ShopID LIKE '%"+Integer.parseInt((String)en.getValue())+"%' and ";
				}
			}else if("Status".equals(en.getKey())){
				if(Integer.parseInt((String)en.getValue())>-1){
					values += " Status LIKE '%"+Integer.parseInt((String)en.getValue())+"%' and ";
				}
			}else if("BCount".equals(en.getKey())){
				if(Integer.parseInt((String)en.getValue())>-1){
					values += " BCount LIKE '%"+Integer.parseInt((String)en.getValue())+"%' and ";
				}
			}else if("Bsale".equals(en.getKey())){
				if(Integer.parseInt((String)en.getValue())>-1){
					values += " Bsale LIKE '%"+Integer.parseInt((String)en.getValue())+"%' and ";
				}
			}else{
				values += " "+en.getKey()+" LIKE '%"+en.getValue()+"%' and";
			}
			flag = true;
		}
		
		if(flag){
			values=values.substring(0,values.lastIndexOf(" and"));
			sql+=values;
		}
		//System.out.println(sql);
		try {
			Connection conn=CreatDB.getConnection_ZH();
			Statement sta=conn.createStatement();
			ResultSet rs=sta.executeQuery(sql);
			while(rs.next()){
				Book_type bt=new Book_type();
				bt.setId(rs.getInt("BookID"));
				bt.setName(rs.getString("BName"));
				bt.setPrice(rs.getInt("Price"));
				bt.setCurrentprice(rs.getInt("Currentprice"));
				bt.setDiscount(rs.getString("Discount"));
				bt.setAuthor(rs.getString("Author")); //作者  Author
				bt.setPublish(rs.getString("Publish")); //出版社  Publish
				bt.setCid(rs.getInt("CID"));
				bt.setIntroduce(rs.getString("Introduce"));
				bt.setShopid(rs.getInt("ShopID"));
				bt.setCommentID(rs.getInt("CommentID"));
				bt.setImage_s(rs.getString("Image_s"));
				bt.setImage_b(rs.getString("Image_b"));
				bt.setStatus(rs.getInt("Status"));
				bt.setVersion(rs.getString("Version"));
				list.add(bt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<Book_type> idSelect(String id) {
		List<Book_type> list=new ArrayList<Book_type>();
		
		try {
			Connection conn = CreatDB.getConnection_ZH();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery("SELECT * FROM book WHERE BookID="+Integer.parseInt(id));
			
			while(rs.next()){
				Book_type bt=new Book_type();
				bt.setId(rs.getInt("BookID"));
				bt.setName(rs.getString("BName"));
				bt.setPrice(rs.getInt("Price"));
				bt.setCurrentprice(rs.getInt("Currentprice"));
				bt.setDiscount(rs.getString("Discount"));
				bt.setAuthor(rs.getString("Author")); //作者  Author
				bt.setPublish(rs.getString("Publish")); //出版社  Publish
				bt.setCid(rs.getInt("CID"));
				bt.setIntroduce(rs.getString("Introduce"));
				bt.setShopid(rs.getInt("ShopID"));
				bt.setCommentID(rs.getInt("CommentID"));
				bt.setImage_s(rs.getString("Image_s"));
				bt.setImage_b(rs.getString("Image_b"));
				bt.setStatus(rs.getInt("Status"));
				bt.setCount(rs.getInt("BCount"));
				bt.setSale(rs.getInt("Bsale"));
				bt.setVersion(rs.getString("Version"));
				list.add(bt);
			}
			
			sta.close();
			conn.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static List modifyBook_Dao(Map<String, String> map) {
		List<Book_type> list=new ArrayList<Book_type>();
		
		String sql="UPDATE book SET";
		Set<Entry<String, String>> set=map.entrySet();
		Iterator<Entry<String, String>> it=set.iterator();
		while(it.hasNext()){
			Entry en=it.next();
			if(!en.getKey().equals("BookID")){
				if("Price".equals(en.getKey())){
					if(Integer.parseInt((String)en.getValue())>-1){
						sql += " Price="+Integer.parseInt((String)en.getValue())+",";
					}
				}else if("Currentprice".equals(en.getKey())){
					if(Integer.parseInt((String)en.getValue())>-1){
						sql += " Currentprice="+Integer.parseInt((String)en.getValue())+",";
					}
				}else if("CID".equals(en.getKey())){
					if(Integer.parseInt((String)en.getValue())>-1){
						sql += " CID="+Integer.parseInt((String)en.getValue())+",";
					}
				}else if("ShopID".equals(en.getKey())){
					if(Integer.parseInt((String)en.getValue())>-1){
						sql += " ShopID="+Integer.parseInt((String)en.getValue())+",";
					}
				}else if("Status".equals(en.getKey())){
					if(Integer.parseInt((String)en.getValue())>-1){
						sql += " Status="+Integer.parseInt((String)en.getValue())+",";
					}
				}else if("BCount".equals(en.getKey())){
					if(Integer.parseInt((String)en.getValue())>-1){
						sql += " BCount="+Integer.parseInt((String)en.getValue())+",";
					}
				}else if("Bsale".equals(en.getKey())){
					if(Integer.parseInt((String)en.getValue())>-1){
						sql += " Bsale="+Integer.parseInt((String)en.getValue())+",";
					}
				}else{
					sql += " "+en.getKey()+"='"+en.getValue()+"',";
				}
			}
		}
		sql = sql.substring(0,sql.lastIndexOf(","))+" WHERE BookID=?";
		
		try {
			Connection conn = CreatDB.getConnection_ZH();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(map.get("BookID")));
			ps.executeUpdate();
			ps.close();
			conn.close();
			list = idSelect(map.get("BookID"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/*public static List modifyBook_Dao(Map<String, String> map) {
		List<Book_type> list=new ArrayList<Book_type>();
		String sql="UPDATE book SET ";
		
		Set<Entry<String, String>> set=map.entrySet();
		Iterator<Entry<String, String>> it=set.iterator();
		while(it.hasNext()){
			Entry en=it.next();
			sql+=en.getKey()+"=? and ";
		}
		sql=sql.substring(0,sql.lastIndexOf(" and "));
		
		try {
			Connection conn=CreatDB.getConnection_ZH();
			PreparedStatement ps= conn.prepareStatement(sql);
			int c=1;
			while(it.hasNext()){
				Entry en=it.next();
				if("BookID".equals(en.getKey()) && Integer.parseInt((String)en.getValue())>-1){
					ps.setInt(c++, Integer.parseInt((String)en.getValue()));
				}else if("Price".equals(en.getKey()) && Integer.parseInt((String)en.getValue())>-1){
					ps.setInt(c++, Integer.parseInt((String)en.getValue()));
				}else if("Currentprice".equals(en.getKey()) && Integer.parseInt((String)en.getValue())>-1){
					ps.setInt(c++, Integer.parseInt((String)en.getValue()));
				}else if("CID".equals(en.getKey()) && Integer.parseInt((String)en.getValue())>-1){
					ps.setInt(c++, Integer.parseInt((String)en.getValue()));
				}else if("ShopID".equals(en.getKey()) && Integer.parseInt((String)en.getValue())>-1){
					ps.setInt(c++, Integer.parseInt((String)en.getValue()));
				}else if("Status".equals(en.getKey()) && Integer.parseInt((String)en.getValue())>-1){
					ps.setInt(c++, Integer.parseInt((String)en.getValue()));
				}else if("BCount".equals(en.getKey()) && Integer.parseInt((String)en.getValue())>-1){
					ps.setInt(c++, Integer.parseInt((String)en.getValue()));
				}else if("Bsale".equals(en.getKey()) && Integer.parseInt((String)en.getValue())>-1){
					ps.setInt(c++, Integer.parseInt((String)en.getValue()));
				}else{
					ps.setString(c++, (String)en.getValue());
				}
			}
			ps.executeUpdate();
			PreparedStatement ps2=conn.prepareStatement("select * from book where BookID="+map.get("BookID"));
			ResultSet rs=ps2.executeQuery();
			while(rs.next()){
				Book_type bt=new Book_type();
				bt.setId(rs.getInt("BookID"));
				bt.setName(rs.getString("BName"));
				bt.setPrice(rs.getInt("Price"));
				bt.setCurrentprice(rs.getInt("Currentprice"));
				bt.setDiscount(rs.getString("Discount"));
				bt.setAuthor(rs.getString("Author")); //作者  Author
				bt.setPublish(rs.getString("Publish")); //出版社  Publish
				bt.setCid(rs.getInt("CID"));
				bt.setIntroduce(rs.getString("Introduce"));
				bt.setShopid(rs.getInt("ShopID"));
				bt.setCommentID(rs.getInt("CommentID"));
				bt.setImage_s(rs.getString("Image_s"));
				bt.setImage_b(rs.getString("Image_b"));
				bt.setStatus(rs.getInt("Status"));
				bt.setCount(rs.getInt("BCount"));
				bt.setSale(rs.getInt("Bsale"));
				list.add(bt);
			}
			ps.close();
			rs.close();
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	*/
	public static void deleteBook_Dao(int id) {
		List<Book_type> list=new ArrayList<Book_type>();
		try {
			Connection conn=CreatDB.getConnection_ZH();
			PreparedStatement ps=conn.prepareStatement("DELETE FROM book WHERE BookID=?");
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
