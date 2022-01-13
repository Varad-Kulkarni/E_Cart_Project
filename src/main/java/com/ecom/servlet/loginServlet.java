package com.ecom.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecome.model.User;
import com.ecome.dao.userDao;
import com.ecome.connections.DbCon;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String email = request.getParameter("login-email");
			String password = request.getParameter("login-password");
			int len = email.length();
			String eq = "cart.com";
			String last8 = email.substring(len - 8);
			try {
				userDao userdao = new userDao(DbCon.getConnectio());
				User user = userdao.userLogin(email, password);

				if (user != null) {
					if (last8.equals(eq)) {
						request.getSession().setAttribute("adm", user);
						response.sendRedirect("index.jsp");
					} else {
						out.print("user login");
						request.getSession().setAttribute("auth", user);
						response.sendRedirect("index.jsp");
					}
				} else {
					out.print("<script type=\"text/javascript\">");
					out.println("alert('Incorrect Email or Password');");
					out.println("location='login.jsp';");
					out.println("</script>");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
