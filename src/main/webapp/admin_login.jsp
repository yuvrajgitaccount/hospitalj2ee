
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<style>
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
<title></title>
<%@include file="componects/all_css.jsp"%>
</head>
<body>
	<%@include file="componects/navbar.jsp"%>




	<div class="container py-5">

		<div class="row">

			<div class="col-md-6   offset-md-3">

				<div class="card paint-card">



					<div class="card-body">

						<h1 class="text-center">Admin Login</h1>


						<c:if test="${not empty succmsg }">

							<p class="text-center text-success fs-3">${succmsg }</p>
							<c:remove var="sucmsg" scope="session"></c:remove>
						</c:if>


						<c:if test="${not empty errormsg }">
							<p class="text-center text-danger fs-3">${errormsg }</p>
							<c:remove var="errormsg" scope="session"></c:remove>
						</c:if>


						<form method="post" action="AdminLogin">



							<div class="form-group">

								<label>Enter Email</label> <input type="text" name="email"
									class="form-control">
							</div>



							<div class="form-group">

								<label>Enter password</label> <input type="text" name="password"
									class="form-control">
							</div>




							<div class="text-center py-3">
								<button class="btn btn-success ">Login</button>
							</div>


						</form>
					</div>
				</div>

			</div>
		</div>
	</div>






</body>
</html>