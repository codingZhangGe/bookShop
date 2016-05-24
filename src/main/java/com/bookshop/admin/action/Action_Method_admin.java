package com.bookshop.admin.action;

import com.bookshop.admin.dao.Dao_Method_admin;
import com.bookshop.admin.vo.User_Type;

import java.util.List;



public class Action_Method_admin {
	
	public static int getType_Action(String name, String password,int state) {
		int flag= Dao_Method_admin.getLogin_Dao(name, password, state);
		return flag;
	}
	
	public static List<User_Type> allAdmin_Action() {
		List<User_Type> list=Dao_Method_admin.allAdmin_Dao();
		return list;
	}
	
	public static List addAdmin_Action(String name,String password,int state) {
		List<User_Type> list=Dao_Method_admin.addAdmin_Dao(name, password, state);
		return list;
	}
	
	public static void deleteAdmin_Action(int id,String name,int state) {
		Dao_Method_admin.deleteAdmin_Dao(id, name, state);
		//return list;
	}
	
	public static List selectAdmin_Action(int id,String name,int state) {
		List<User_Type> list=Dao_Method_admin.selectAdmin_Dao(id, name, state);
		return list;
	}
	
	public static List modifyAdmin_Action(int id,String name,String password,int state) {
		List<User_Type> list=Dao_Method_admin.modifyAdmin_Dao(id, name, password, state);
		return list;
	}
}
