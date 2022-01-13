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
 * Servlet implementation class orderNowServlet
 */
@WebServlet("/orderNowServlet")
public class orderNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();

			User auth = (User) request.getSession().getAttribute("auth");
			User adm = (User) request.getSession().getAttribute("adm");

			if (auth != null || adm != null) {
				String productId = request.getParameter("id");
				int productQuantity = Integer.parseInt(request.getParameter("quantity"));
				if (productQuantity < 0) {
					productQuantity = 1;
				}
				Order ordermodel = new Order();
//				ordermodel.setOrderId(3);
				ordermodel.setId(Integer.parseInt(productId));
				if (auth != null && adm == null) {
					ordermodel.setWid(auth.getId());
				} else if (auth == null && adm != null) {
					ordermodel.setWid(adm.getId());
				}
				ordermodel.setQuantity(productQuantity);
				ordermodel.setDate(formatter.format(date));

				orderDao orderdao = new orderDao(DbCon.getConnectio());
				boolean result = orderdao.insertOrder(ordermodel);

				if (result) {
					ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
					if (cart_list != null) {
						for (Cart c : cart_list) {
							if (c.getId() == Integer.parseInt(productId)) {
								cart_list.remove(cart_list.indexOf(c));
								break;
							}
						}
					}
					response.sendRedirect("ThanksForBuying.jsp");
				} else {
					out.print("<script type=\"text/javascript\">");
					out.println("alert('Order failed');");
					out.println("location='order.jsp';");
					out.println("</script>");
				}
			} else {
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
