<%@page import="java.util.*"%>
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
}
else if (auth != null) {
	request.setAttribute("adm", adm);
}

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
List<Cart> cartProduct = null;
if (cart_list != null) {
	productDao pDao = new productDao(DbCon.getConnectio());
	cartProduct = pDao.getCartProducts(cart_list);
	int total = pDao.getTotal(cart_list);
	request.setAttribute("cart_list", cart_list);
	request.setAttribute("total", total);
}
%>
<!DOCTYPE html>
<html>
<head>

<%@include file="includes/head.jsp"%>

</head>
<body>
	<%@include file="includes/navbar.jsp"%>

	<div class="container my-3 mt-5" style="min-height : 73vh">
		<div class="d-flex py-3">
			<h3>Total price=Rs. ${(total>0)?total:0 }</h3>
			<a class="mx-3 btn btn-primary" href="checkoutServlet">Check out</a>
		</div>
		<table class="table table-light">
			<thread>
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Category</th>
				<th scope="col">Price</th>
				<th scope="col">Buy now</th>
				<th scope="col">Cancel</th>
			</tr>
			</thread>
			<tbody>
				<%
				if (cart_list != null) {
					for (Cart c : cartProduct) {
				%>

				<tr>
					<td><%=c.getName()%></td>
					<td><%=c.getCategory()%></td>
					<td>$<%=c.getPrice()%></td>
					<td>
						<form action="orderNowServlet" method="post" class="form-inline">
							<input type="hidden" name="id" value="<%=c.getId() %>" class="form-input">
							<div class="form-group d-flex justify-content-between">
								<a class="btn btn-sm btn-incre" href="IncDecServlet?action=inc&id=<%=c.getId()%>"><i
									class="fas fa-plus-square"></i></a> <input type="text"
									name="quantity" class="form-cantrol" value="<%=c.getQuantity() %>" readonly>
								<a class="btn btn-sm btn-decre" href="IncDecServlet?action=dec&id=<%=c.getId()%>"><i
									class="fas fa-minus-square"></i></a>
							</div>
							<button type="submit" class="btn btn-primary btn-sm">Buy</button>
						</form>
					</td>
					<td><a class="btn btn-danger" href="removeServlet?id=<%=c.getId()%>">Remove</a></td>
				</tr>

				<%
				}
				}
				%>
			</tbody>
		</table>
	</div>

	<%@include file="includes/footer.jsp"%>
</body>
</html>