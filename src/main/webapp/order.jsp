<%@page import="com.ecome.connections.*"%>
<%@page import="com.ecome.model.*"%>
<%@page import="java.util.*"%>
<%@page import="com.ecome.dao.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
/*User auth = (User) request.getSession().getAttribute("auth");
List<Order> orders=null;
if (auth != null) {
	request.setAttribute("auth", auth);
	orders=new orderDao(DbCon.getConnectio()).userOrders(auth.getId());
} else {
	response.sendRedirect("login.jsp");
}*/

User auth = (User) request.getSession().getAttribute("auth");
User adm = (User) request.getSession().getAttribute("adm");
List<Order> orders=null;

if (auth != null) {
	request.setAttribute("auth", auth);
	orders=new orderDao(DbCon.getConnectio()).userOrders(auth.getId());
}
else if (adm != null) {
	request.setAttribute("adm", adm);
	orders=new orderDao(DbCon.getConnectio()).userOrders(adm.getId());
}
else{
	response.sendRedirect("login.jsp");
}

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
	request.setAttribute("cart_list", cart_list);
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
		<div class="card-header my-3">
			All Orders
			<table class="table table-light">
				<thread>
				<tr>
					<th scope="col">Date</th>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">Cancel</th>
				</tr>
				</thread>
				
				<tbody>
				
				<%
				if(orders!=null){
					for(Order o:orders){%>
					<tr>
						<td><%=o.getDate() %></td>
						<td><%=o.getName() %></td>
					    <td><%=o.getCategory() %></td>
						<td><%=o.getQuantity() %></td>
						<td><%=o.getPrice() %></td>
						<td><a class="btn btn-sm btn-danger" href="cancelServlet?id=<%=o.getOrderId() %>">Cancel</a></td>
					</tr>
					<%}
				}
				%>
				
				</tbody>
				
			</table>
		</div>
	</div>

	<%@include file="includes/footer.jsp"%>
</body>
</html>