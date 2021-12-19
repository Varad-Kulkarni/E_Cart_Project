package com.ecome.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ecome.model.Cart;
import com.ecome.model.product;

public class productDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	public productDao(Connection con) {
		this.con = con;
	}
	
	public List<product> getAllProduct(){
		List<product> prodcts=new ArrayList<product>();
		try {
			query="select * from products where id%3=0";
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
	
	public List<product> getAllProductDigital(){
		List<product> prodcts=new ArrayList<product>();
		try {
			String dig="digital";
			query="select * from products where category = '"+dig+"'";
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
	
	public List<product> getAllProductClothing(){
		List<product> prodcts=new ArrayList<product>();
		try {
			String clo="clothing";
			query="select * from products where category = '"+clo+"'";
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
	
	public List<product> getAllProductDecoration(){
		List<product> prodcts=new ArrayList<product>();
		try {
			String deco="decoration";
			query="select * from products where category = '"+deco+"'";
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
	
	public List<Cart> getCartProducts(ArrayList<Cart> cartList){
		List<Cart> products=new ArrayList<Cart>();
		
		try {
			if(cartList.size()>0) {
				for(Cart item : cartList) {
					query="select * from products where id=?";
					pst=this.con.prepareStatement(query);
					pst.setInt(1, item.getId());
					rs=pst.executeQuery();
					while(rs.next()) {
						Cart row=new Cart();
						row.setId(rs.getInt("id"));
						row.setName(rs.getString("name"));
						row.setCategory(rs.getString("category"));
						int temp=Integer.parseInt(rs.getString("price"))*item.getQuantity();
						String temp1=temp+"";
						row.setPrice(temp1);
						row.setQuantity(item.getQuantity());
						products.add(row);
					}
				}
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());		
		}
		return products;
	}
	
	public product getSingleProduct(int id) {
		product row=null;
		try {
			query="select * from products where id=?";
			pst=this.con.prepareStatement(query);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				row=new product();
				row.setId(rs.getInt("id"));
				row.setName(rs.getString("name"));
				row.setCategory(rs.getString("category"));
				row.setPrice(rs.getString("price"));
				row.setImage(rs.getString("image"));
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return row;
	}
	
	public int getTotal(ArrayList<Cart> cartList) {
		int sum=0;
		try {
			if(cartList.size()>0) {
				for(Cart item:cartList) {
					query="select * from products where id=?";
					pst=this.con.prepareStatement(query);
					pst.setInt(1, item.getId());
					rs=pst.executeQuery();
					while(rs.next()) {
						sum+=Integer.parseInt(rs.getString("price"))*item.getQuantity();
					}
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return sum;
	}
}
