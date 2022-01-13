package com.ecome.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ecome.model.Feedback;

public class feedbackDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public feedbackDao(Connection con) {
		this.con=con;
	}
	
	public boolean insert_Feedback(Feedback model) {
		boolean flag=false;
		try {
			query="insert into feedback(email,feedback_text) values(?,?)";
			pst=this.con.prepareStatement(query);
			pst.setString(1, model.getEmail());
			pst.setString(2, model.getFeedback_text());
			pst.executeUpdate();
			flag=true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}
}
