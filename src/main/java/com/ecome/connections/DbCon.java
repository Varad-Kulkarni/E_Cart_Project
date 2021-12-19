package com.ecome.connections;

import java.sql.*;

public class DbCon {
	private static Connection connection=null;
	public static Connection getConnectio() throws ClassNotFoundException, SQLException{
		if(connection==null) {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_cart","vkk","vkk");
			System.out.println("Connected...");
		}
		return connection;
	}
}
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
//
//public class DbCon {
//	public Connection c;
//	public Statement s;
//	
//	public DbCon() {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			c=DriverManager.getConnection("jdbc:mysql:///e_cart","vkk","vkk");
//			s=c.createStatement();
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//}