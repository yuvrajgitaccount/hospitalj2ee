<!DOCTYPE html>
<html>
<head>
<style>
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="componects/all_css.jsp"%>
</head>
<body>
	<%@include file="componects/navbar.jsp"%>






	<div class="container">
	
	<h1 class="text-center text-success">User Register</h1>

	<%
	String succMsg = (String) session.getAttribute("succMsg");

	if (succMsg != null) {
	%>


	<div class="alert alert-success" role="alert">
		<%=succMsg%>UserLogin..<a href="signup.jsp">Clickhere</a>
	</div>

	<%
	session.removeAttribute("succMsg");
	}
	%>



	<%
	String errorMsg = (String) session.getAttribute("errorMsg");

	if (errorMsg != null) {
	%>


	<div class="alert alert-danger" role="alert">
		<%=errorMsg%>Todo..<a href="signup.jsp">Clickhere</a>
	</div>

	<%
	session.removeAttribute("errorMsg");
	}
	%>


	
		<div class="row py-5">
			<div class="col-md-6 offset-md-3">
				<div class="card paint-card">
					<div class="card-body">

						<!-- form boostrap -->

						<form action="UserRegister" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Enter fullName</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="name">

							</div>


							<div class="form-group">
								<label for="exampleInputEmail1">Enter Email</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="email">

							</div>


							<div class="form-group">
								<label for="exampleInputEmail1">Enter Password</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="password">

							</div>



							<div class="container text-center p-3">

								<button type="submit"
									class="btn btn-danger btn-block badge-pill">Register</button>
							</div>


						</form>


					</div>



				</div>




			</div>





		</div>


	</div>






</body>
</html>
