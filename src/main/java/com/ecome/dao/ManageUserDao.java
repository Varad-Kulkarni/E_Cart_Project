package com.ecome.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.ecome.model.Order;
import com.ecome.model.User;
import com.ecome.model.product;

public class ManageUserDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ManageUserDao(Connection con) {
		this.con=con;
	}

	public List<User> userManage(int id){
		List<User> list=new ArrayList<>();
		try {
			query="select * from users where id=?";
			pst=this.con.prepareStatement(query);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				User us=new User();
				int idu=rs.getInt("id");
				String nameu=rs.getString("name");
				String emailu=rs.getString("email");
				String passwordu=rs.getString("password");
				list.add(us);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}
	
	public boolean deleteUser(int ide) {
		boolean flag=false;
		try {
			query="delete from users where id='"+ide+"'";
			pst=this.con.prepareStatement(query);
			pst.execute();
			flag=true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return flag;
	}
}
