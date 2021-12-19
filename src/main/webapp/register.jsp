<%@page import="java.util.*" %>
<%@page import="com.ecom.servlet.*"%>
<%@page import="com.ecome.connections.*"%>
<%@page import="com.ecome.model.*"%>
<%@page import="com.ecome.dao.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
	User auth=(User)request.getSession().getAttribute("auth");
	if(auth!=null){
		request.setAttribute("auth",auth);
	}
	%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel ="stylesheet" href="css/login.css">
<%@include file="includes/head.jsp"%>
<title>register</title>
</head>
<body>
<%@include file="includes/navbar.jsp"%>


	
	
	<div class="container">
            <div class="screen">
                <div class="screen__content">
                    <form action="registerServlet" method="get">
                        <div class="login__field">
                            <i class="login__icon fas fa-lock"></i>
                            <input type="text" name="register-id" class="login__input" placeholder="Enter your mobile number">
                        </div>
                        <div class="login__field">
                            <i class="login__icon fas fa-lock"></i>
                            <input type="text" name="register-name" class="login__input" placeholder="Enter your name">
                        </div>
                        <div class="login__field">
                            <i class="login__icon fas fa-user"></i>
                            <input type="text" name="register-email" class="login__input" placeholder="Enter your email">
                        </div>
                        <div class="login__field">
                            <i class="login__icon fas fa-lock"></i>
                            <input type="text" name="register-password" class="login__input" placeholder="Enter your password">
                        </div>
                        <button type="submit" class="button login__submit">
                           <span class="button__text">Register</span>
                           
                            <i class="button__icon fas fa-chevron-right"></i>
                        </button>				
                    </form><br>
                    
                    
                    <div class="social-login">
                        <h3>log in via</h3>
                        <div class="social-icons">
                            <a href="#" class="social-login__icon fab fa-instagram"></a>
                            <a href="#" class="social-login__icon fab fa-facebook"></a>
                            <a href="#" class="social-login__icon fab fa-twitter"></a>
                        </div>
                    </div>
                </div>
                <div class="screen__background">
                    <span class="screen__background__shape screen__background__shape4"></span>
                    <span class="screen__background__shape screen__background__shape3"></span>		
                    <span class="screen__background__shape screen__background__shape2"></span>
                    <span class="screen__background__shape screen__background__shape1"></span>
                </div>		
            </div>
        </div>

<%@include file="includes/footer.jsp"%>
</body>
</html>