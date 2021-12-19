<%@page import="java.util.*" %>
<%@page import="com.ecom.servlet.*"%>
<%@page import="com.ecome.connections.*"%>
<%@page import="com.ecome.model.*"%>
<%@page import="com.ecome.dao.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
}

productDao pd=new productDao(DbCon.getConnectio());
List<product> prod=pd.getAllProductDecoration();

ArrayList<Cart> cart_list=(ArrayList<Cart>) session.getAttribute("cart-list");
if(cart_list!=null){
	request.setAttribute("cart_list",cart_list);
}

%>
<!DOCTYPE html>
<html>
<head>

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/home.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>

<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
<%@include file="includes/head.jsp"%>

</head>
<body>
	<%@include file="includes/navbar.jsp"%>

	<div class="container">
		<div class="card-header my-3">Decoration</div>
		<div class="row">
		
		<%if(!prod.isEmpty()){
			for(product p:prod){ %>
				<div class="col-md-3 my-3">
				<div class="card" style="width: 18rem;">
					<img src="images/<%=p.getImage() %>" class="card-img-top" alt="card image cap">
					<div class="card-body">
						<h5 class="card-title">Name :<%=p.getName() %></h5>
						<h6 class="price">Price : Rs. <%=p.getPrice()%></h6>
						
						<div class="mt-3 d-flex justify-content-between">
						<a href="cartServlet?id=<%=p.getId() %>" class="btn btn-outline-info">Add to cart</a>
						<a href="orderNowServlet?quantity=1&id=<%=p.getId() %>" class="btn btn-outline-success">Buy now</a>
						</div>
					</div>
				</div>
			</div>
			<% }
		}
		
		%>
		</div>
	</div>

	<%@include file="includes/footer.jsp"%>
</body>
</html>