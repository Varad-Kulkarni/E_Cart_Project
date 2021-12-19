package com.ecome.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ecome.model.User;

public class registerDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public registerDao(Connection con) {
		this.con=con;
	}
	
	public boolean insertUser(User u) {
		boolean flag=false;
		
		try {
			query="insert into users(name,email,password) values(?,?,?)";
			pst=this.con.prepareStatement(query);
			pst.setString(1, u.getName());
			pst.setString(2, u.getEmail());
			pst.setString(3, u.getPassword());
			pst.execute();
			flag=true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}
}
