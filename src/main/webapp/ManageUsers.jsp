<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.ecom.servlet.*"%>
<%@page import="com.ecome.connections.*"%>
<%@page import="com.ecome.model.*"%>
<%@page import="com.ecome.dao.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
/*User auth = (User) request.getSession().getAttribute("auth");
List<User> usr = null;
if (auth != null) {
	request.setAttribute("auth", auth);
	usr = new ManageUserDao(DbCon.getConnectio()).userManage(auth.getId());
} else {
	response.sendRedirect("login.jsp");
}*/

User auth = (User) request.getSession().getAttribute("auth");
User adm = (User) request.getSession().getAttribute("adm");
List<User> usr=null;
if (auth != null) {
	request.setAttribute("auth", auth);
	usr=new ManageUserDao(DbCon.getConnectio()).userManage(auth.getId());
}
else if (adm != null) {
	request.setAttribute("adm", adm);
	usr=new ManageUserDao(DbCon.getConnectio()).userManage(adm.getId());
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
<meta charset="ISO-8859-1">
<title>Manage users</title>
<%@include file="includes/head.jsp"%>
</head>
<body>
	<%@include file="includes/navbar.jsp"%>
	
	<%
	Connection c=DbCon.getConnectio();
	PreparedStatement ps=c.prepareStatement("select * from users");
	ResultSet rs=ps.executeQuery();
	List<User> ls=new ArrayList<>();
	int cnt=0;
	while(rs.next()){
		int id=Integer.parseInt(rs.getString(1));
		String namu=rs.getString(2);
		String emlu=rs.getString(3);
		String pasu=rs.getString(4);
		User us=new User();
		us.setId(id);
		us.setName(namu);
		us.setEmail(emlu);
		us.setPassword(pasu);
		ls.add(us);
		cnt++;
	}
	%>

	<div class="container my-3 mt-5" style="min-height: 73vh">
		<div class="card-header my-3">
			All Users
			<table class="table table-light">
				<thread>
				<tr>
					<th scope="col">Mobile number</th>
					<th scope="col">Username</th>
					<th scope="col">Email</th>
					<th scope="col">Password</th>
					<th scope="col">Remove User</th>
				</tr>
				</thread>

				<tbody>

					<%
					// while(rs.next()){
						// String id=rs.getString(1);
					for(User u:ls){	
					%>
					<tr>
						<td><%=u.getId()%></td>
						<td><%=u.getName()%></td>
						<td><%=u.getEmail()%></td>
						<td><%=u.getPassword()%></td>
						<td><a class="btn btn-sm btn-danger" href="ManageUserServlet?id=<%=u.getId()%>">Cancel</a></td>
					</tr>
					<%
					}
					%>

				</tbody>

			</table>
		</div>
	</div>

	<%@include file="includes/footer.jsp"%>
</body>
</html>