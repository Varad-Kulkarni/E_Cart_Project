package com.ecom.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecome.connections.DbCon;
import com.ecome.dao.registerDao;
import com.ecome.model.User;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out=response.getWriter()) {
			int id=Integer.parseInt(request.getParameter("register-id"));
			String name=request.getParameter("register-name");
			String mail=request.getParameter("register-email");
			String pass=request.getParameter("register-password");
			
//			User u=new User();
			
//			u.setName(name);
//			u.setEmail(mail);
//			u.setPassword(pass);
			
//			registerDao r=new registerDao(DbCon.getConnectio());
//			boolean result=r.insertUser(u);
			
			Connection con=DbCon.getConnectio();
			PreparedStatement pst=con.prepareStatement("insert into users values(?,?,?,?)");
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3, mail);
			pst.setString(4, pass);
			int i=pst.executeUpdate();
			
			if(i>0) {
//				out.println("information saved successfully");
				response.sendRedirect("ThankYouRegister.jsp");
			}
			else {
				out.print("<script type=\"text/javascript\">");
				out.println("alert('Information processing failed');");
				out.println("location='register.jsp';");
				out.println("</script>");
			}
		}
		catch(Exception e) {
			e.printStackTrace();;
		}
	}
}
