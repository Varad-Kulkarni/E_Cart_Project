package com.ecom.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecome.connections.DbCon;
import com.ecome.dao.orderDao;
import com.ecome.model.Cart;
import com.ecome.model.Order;
import com.ecome.model.User;

/**
 * Servlet implementation class checkoutServlet
 */
@WebServlet("/checkoutServlet")
public class checkoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out=response.getWriter()){
			SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
			Date date=new Date();
			
			ArrayList<Cart> cart_list=(ArrayList<Cart>) request.getSession().getAttribute("cart-list");
			User auth=(User) request.getSession().getAttribute("auth");
			if(cart_list!=null && auth!=null) {
				for(Cart c:cart_list) {
					Order order=new Order();
					order.setId(c.getId());
					order.setWid(auth.getId());
					order.setQuantity(c.getQuantity());
					order.setDate(formatter.format(date));
					
					orderDao odao=new orderDao(DbCon.getConnectio());
					boolean result=odao.insertOrder(order);
					if(!result) {
						break;
					}	
				}
				cart_list.clear();
				response.sendRedirect("order.jsp");
			}
			else {
				if(auth==null) {
					response.sendRedirect("login.jsp");
				}
				response.sendRedirect("cart.jsp");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
