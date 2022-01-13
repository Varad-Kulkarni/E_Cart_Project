<%@page import="java.util.*"%>
<%@page import="com.ecom.servlet.*"%>
<%@page import="com.ecome.connections.*"%>
<%@page import="com.ecome.model.*"%>
<%@page import="com.ecome.dao.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
User auth = (User) request.getSession().getAttribute("auth");
User adm = (User) request.getSession().getAttribute("adm");
if (auth != null) {
	request.setAttribute("auth", auth);
} else if (adm != null) {
	request.setAttribute("adm", adm);
}

productDao pd = new productDao(DbCon.getConnectio());
List<product> prod = pd.getAllProduct();

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
	request.setAttribute("cart_list", cart_list);
}
%>
<!DOCTYPE html>
<html>
<head>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="../css/home.css">
<link rel="stylesheet" href="../css/header.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap"
	rel="stylesheet">
<%@include file="includes/head.jsp"%>

<style>
        /* Modify the background color */
         
        .navbar-custom {
            background-color: lightgreen;
        }
        /* Modify brand and text color */
         
        .navbar-custom .navbar-brand,
        .navbar-custom .navbar-text {
            color: green;
        }
    </style>

</head>
<body>
	<%@include file="includes/navbar.jsp"%>


	<header>
		<!-- Background image -->
		<div class="p-5 text-center bg-image"
			style="background-image: url('images/znitHeaderShop.jpg'); height: 400px;">
			<div class="mask" style="background-color: rgba(0, 0, 0, 0.6);">
				<div class="d-flex justify-content-center align-items-center h-100">
					<div class="text-white">
						<h1 class="mb-3">WELCOME TO SHOPZ-NOW!!!</h1>
						<h4 class="mb-3">Get your latest styles...</h4>
						<a class="btn btn-outline-light btn-lg"
							href="categoryClothing.jsp" role="button">See latest fashion
							trends </a>
					</div>
				</div>
			</div>
		</div>
		<!-- Background image -->
	</header>



	<div class="container">
		<div class="card-header my-3 card text-warning border-info mb-3" style="background-color: #355482;">Todays Collection</div>
		<div class="row">

			<%
			if (!prod.isEmpty()) {
				for (product p : prod) {
			%>
			<div class="col-md-3 my-3" style="margin: 35px;">
				<div class="card text-warning border-dark mb-3" style="width: 18rem; background-color: #192e4d;">
					<img src="images/<%=p.getImage()%>" class="card-img-top"
						alt="card image cap">
					<div class="card-body">
						<h5 class="card-title">
							Name :<%=p.getName()%></h5>
						<h6 class="price">
							Price : Rs.
							<%=p.getPrice()%></h6>
						<h6 class="category">
							Category :
							<%=p.getCategory()%></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a href="cartServlet?id=<%=p.getId()%>"
								class="btn btn-outline-light">Add to cart</a> <a
								href="orderNowServlet?quantity=1&id=<%=p.getId()%>"
								class="btn btn-outline-success">Buy now</a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			}
			%>
		</div>
	</div>

	<%@include file="includes/footer.jsp"%>
</body>
</html>