<%@page import="com.ecome.connections.*" %>
<%@page import="com.ecome.model.*" %>
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
    <link rel="stylesheet" href="css/login.scss    ">
<title>Login to e-cart</title>
<link rel ="stylesheet" href="css/login.css">

<%@include file="includes/head.jsp"%>

</head>
<body>



<%@include file="includes/navbar.jsp"%>

   <div class="container">
            <div class="screen">
                <div class="screen__content">
                    <form action="loginServlet" method="post">
                        <div class="login__field">
                            <i class="login__icon fas fa-user"></i>
                            <input type="text" name="login-email" class="login__input" placeholder="User name / Email">
                        </div>
                        <div class="login__field">
                            <i class="login__icon fas fa-lock"></i>
                            <input type="password" name="login-password" class="login__input" placeholder="Password">
                        </div>
                        <button type="submit" class="button login__submit">
                           <span class="button__text">Login</span>
                           
                            <i class="button__icon fas fa-chevron-right"></i>
                        </button>				
                    </form><br>
                    
                    <form></form>
                    Not have an account!
        <br><center><a href="register.jsp"> <button id="register"  class="mt-3 btn btn-transperent" type="button">register here</button></a></center>
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
<br>        
        

	<%@include file="includes/footer.jsp"%>
</body>
</html>