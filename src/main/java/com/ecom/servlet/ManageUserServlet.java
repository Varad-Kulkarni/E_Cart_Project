package com.ecom.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

import com.ecome.connections.DbCon;
import com.ecome.dao.ManageUserDao;

/**
 * Servlet implementation class ManageUserServlet
 */
@WebServlet("/ManageUserServlet")
public class ManageUserServlet extends HttpServlet {
//	public boolean deleteUser(int ide) {
//		boolean flag=false;
//		try {
//			Connection con=DbCon.getConnectio();
//			String query="delete from users where id='"+ide+"'";
//			PreparedStatement pst=con.prepareStatement(query);
//			pst.execute();
//			flag=true;
//		}
//		catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//		return flag;
//	}
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out=response.getWriter()) {
			String userId=request.getParameter("id");
			
			int uid=Integer.parseInt(userId);
			ManageUserDao mud=new ManageUserDao(DbCon.getConnectio());
			mud.deleteUser(uid);
			boolean usflag=mud.deleteUser(uid);
			if(usflag) {
				out.print("<script type=\"text/javascript\">");
				out.println("alert('User deleted successfully');");
				out.println("location='index.jsp';");
				out.println("</script>");
				response.sendRedirect("index.jsp");
			}
			else {
				out.print("<script type=\"text/javascript\">");
				out.println("alert('Oops!! Some error occured');");
				out.println("location='ManageUsers.jsp';");
				out.println("</script>");
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
