package com.ecom.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecome.model.Cart;

/**
 * Servlet implementation class cartServlet
 */
@WebServlet("/cartServlet")
public class cartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out=response.getWriter()) {
			ArrayList<Cart> cartList=new ArrayList<>();
			
			int id=Integer.parseInt(request.getParameter("id"));
			Cart cm=new Cart();
			cm.setId(id);
			cm.setQuantity(1);
			
			HttpSession session=request.getSession();
			session.getAttribute("cart-list");
			ArrayList<Cart> cart_list=(ArrayList<Cart>) session.getAttribute("cart-list");
			
			if(cart_list==null) {
				cartList.add(cm);
				session.setAttribute("cart-list", cartList);
//				out.println("Session created and added to the list");
				response.sendRedirect("index.jsp");
			}
			else {
				cartList=cart_list;
				boolean exists=false;
				for(Cart c:cartList) {
					if(c.getId()==id) {
						exists=true;
						out.print("<script type=\"text/javascript\">");
						out.println("alert('Product already exists in cart');");
						out.println("location='index.jsp';");
						out.println("</script>");
					}
				}
				if(!exists) {
					cartList.add(cm);
					response.sendRedirect("index.jsp");
				}
			}
			for(Cart c:cart_list) {
				out.println(c.getId());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
