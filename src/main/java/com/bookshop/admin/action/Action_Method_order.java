package com.bookshop.admin.action;

import com.bookshop.admin.dao.Dao_Method_order;
import com.bookshop.admin.vo.Order_type;

import java.util.List;
import java.util.Map;


public class Action_Method_order {
	public static List addOrders_Action(String[] values, String time, int statue) {
		List<Order_type> list = Dao_Method_order.addOrders_Dao(values, time, statue);
		return list;
	}
	
	public static void deleteOrders_Action(int id) {
		Dao_Method_order.deleteOrders_Dao(id);
	}
	
	public static List modifyOrders_Action(Map<String, String> map) {
		List<Order_type> list = Dao_Method_order.modifyOrders_Dao(map);
		return list;
	}
	
	public static List selectOrders_Action(Map<String, String> map) {
		List<Order_type> list = Dao_Method_order.selectOrders_Dao(map);
		return list;
	}
}
