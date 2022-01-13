<nav
	class="navbar navbar-expand-lg font-weight-bold" style="background-color: #355482;">
	<a class="navbar-brand" href="#"> </a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse justify-content-center"
		id="navbarNav">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link text-light fa fa-shopping-cart">Shopz-now
					<span class="sr-only">(current)</span>
			</a></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-warning" href="#" id="navbarDropdown"
				role="button" data-bs-toggle="dropdown" aria-expanded="false">
					Products </a>
				<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
					<li><a class="dropdown-item" href="categoryDigital.jsp" style="color: #355482;">Digital</a></li>
					<li><hr class="dropdown-divider"></li>
					<li><a class="dropdown-item" href="categoryClothing.jsp" style="color: #355482;">Clothing</a></li>
					<li><hr class="dropdown-divider"></li>
					<li><a class="dropdown-item" href="categoryDecoration.jsp" style="color: #355482;">Decoration</a></li>
				</ul>
			</li>

			<li class="nav-item"><a class="nav-link text-warning" href="index.jsp">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link text-warning" href="cart.jsp">Cart<span
					class="badge badge-danger">${ cart_list.size() } </span></a></li>

			<li class="nav-item"><a class="nav-link text-warning" href="feedback.jsp">Feedback</a>
			</li>

			<%
			if (auth != null || adm!=null) {
				if(auth!=null){
			%>
			<li class="nav-item"><a class="nav-link text-warning" href="order.jsp">Orders</a>
			</li>
			<li class="nav-item"><a class="nav-link text-warning" href="ManageUsers.jsp">Manage Users</a>
			</li>
			<%}%>
			<li class="nav-item"><a class="nav-link text-warning" href="logoutServlet">logout</a>
			</li>
			<%
			} else {
			%>
			<li class="nav-item"><a class="nav-link text-warning" href="login.jsp">Login</a></li>
			<%
			}
			%>





		</ul>
	</div>
</nav>