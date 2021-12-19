package com.ecom.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecome.connections.DbCon;
import com.ecome.dao.orderDao;

/**
 * Servlet implementation class cancelServlet
 */
@WebServlet("/cancelServlet")
public class cancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out=response.getWriter()){
			String id=request.getParameter("id");
			if(id!=null) {
				orderDao orderdao=new orderDao(DbCon.getConnectio());
				orderdao.cancelOrder(Integer.parseInt(id));
			}
			response.sendRedirect("order.jsp");
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
