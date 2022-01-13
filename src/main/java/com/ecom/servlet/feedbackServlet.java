package com.ecom.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecome.connections.DbCon;
import com.ecome.dao.feedbackDao;
import com.ecome.model.Feedback;

/**
 * Servlet implementation class feedbackServlet
 */
@WebServlet("/feedbackServlet")
public class feedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out=response.getWriter()){
			String email=request.getParameter("f_mail");
			String feed=request.getParameter("f_text");
			
			Feedback fe=new Feedback();
			fe.setEmail(email);
			fe.setFeedback_text(feed);
			
			feedbackDao fdao=new feedbackDao(DbCon.getConnectio());
			boolean res=fdao.insert_Feedback(fe);
			
			if(res) {
				response.sendRedirect("index.jsp");
			}
			else {
				out.println("Oops ! Something wrong happened");
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
