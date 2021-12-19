

import java.sql.*;

public class DbCon2 {
	private static Connection connection=null;
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		if(connection==null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_cart","vkk","vkk");
			System.out.println("Connected...");
		}
		return connection;
	}
}
