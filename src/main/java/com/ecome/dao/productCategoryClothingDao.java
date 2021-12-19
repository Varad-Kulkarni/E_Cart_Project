package com.ecome.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ecome.model.Cart;
import com.ecome.model.product;

public class productCategoryClothingDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	public productCategoryClothingDao(Connection con) {
		this.con = con;
	}
	
	public List<product> getAllProduct(){
		List<product> prodcts=new ArrayList<product>();
		try {
			query="select * from digital";
			pst=this.con.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next()) {
				product row=new product();
				row.setId(rs.getInt("id"));
				row.setName(rs.getString("name"));
				row.setCategory(rs.getString("category"));
				row.setPrice(rs.getString("price"));
				row.setImage(rs.getString("image"));
				
				prodcts.add(row);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return prodcts;
	}
}
