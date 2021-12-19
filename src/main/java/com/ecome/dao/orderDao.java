package com.ecome.dao;

import java.sql.*;
import java.util.*;

import com.ecome.model.*;
import com.ecome.dao.*;

public class orderDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public orderDao(Connection con) {
		this.con=con;
	}
	public boolean insertOrder(Order model) {
		boolean result=false;
		try {
			query="insert into orders_new(p_id,u_id,o_quantity,o_date) values(?,?,?,?)";
			pst=this.con.prepareStatement(query);
//			pst.setInt(1, 1);
			pst.setInt(1, model.getId());
			pst.setInt(2, model.getWid());
			pst.setInt(3, model.getQuantity());
			pst.setString(4, model.getDate()+"");
			pst.executeUpdate();
			result=true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Order> userOrders(int id){
		List<Order> list=new ArrayList<>();
		try {
			query="select * from orders_new where u_id=? order by orders_new.o_id desc";
			pst=this.con.prepareStatement(query);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				Order order=new Order();
				productDao productdao=new productDao(this.con);
				int pid=rs.getInt("p_id");
				product prod=productdao.getSingleProduct(pid);
				order.setOrderId(rs.getInt("o_id"));
				order.setId(pid);
				order.setName(prod.getName());
				order.setCategory(prod.getCategory());
				order.setPrice(Integer.parseInt(prod.getPrice())*rs.getInt("o_quantity")+"");
				order.setQuantity(rs.getInt("o_quantity"));
				order.setDate(rs.getString("o_date"));
				list.add(order);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}
	
	public void cancelOrder(int id) {
		try {
			query="delete from orders_new where o_id=?";
			pst=this.con.prepareStatement(query);
			pst.setInt(1, id);
			pst.execute();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
