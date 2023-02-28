
<%@page import="com.hosptial.db.DbUtil"%>
<%@page import="com.hosptial.dao.DoctorDao"%>
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
<%@include file="all_css.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>


	<c:if test="${empty adminobj }">
		<c:redirect url="../admin_login.jsp"></c:redirect>
	</c:if>

	<div class="container p-5">

		<h1 class="text-center text-danger fs-3">Admin DashBoard</h1>


		<c:if test="${not empty succmsg }">

			<p class="text-center text-primary fs-3">${succmsg }</p>
			<c:remove var="sucmsg" scope="session"></c:remove>
		</c:if>


		<c:if test="${not empty errormsg }">
			<p class="text-center text-danger fs-3">${errormsg }</p>
			<c:remove var="errormsg" scope="session"></c:remove>
		</c:if>



<%

 DoctorDao doctorDao=new DoctorDao(DbUtil.getConnection());

                 


%>

		<div class="row">

			<div class="col-md-4">
				<div class="card paint-card">

					<div class="card-body text-center text-success">

						<i class="fa fa-user-md fa-3x"></i><br>
						<p class="fs-4 text-center">
							Doctor<br>
							<%=doctorDao.countDoctor()%>
					</div>

				</div>


			</div>


			<div class="col-md-4">
				<div class="card paint-card">

					<div class="card-body text-center text-success">

						<i class="fa fa-user-circle fa-3x"></i><br>
						<p class="fs-4 text-center">
							User<br>
							<%=doctorDao.countUSer() %>
							
					</div>

				</div>


			</div>



			<div class="col-md-4">
				<div class="card paint-card">

					<div class="card-body text-center text-success">

						<i class="fa fa-calendar fa-3x"></i><br>
						<p class="fs-4 text-center">
							Total Appoinetment<br>
							
							<%=doctorDao.countAppointment() %>
					</div>

				</div>


			</div>

			<div class="col-md-4 mt-2">
				<div class="card paint-card " data-toggle="modal"
					data-target="#exampleModal">

					<div class="card-body text-center text-success">

						<i class="fa fa-user-md fa-3x"></i><br>
						<p class="fs-4 text-center">
							SpecialList<br>
							
							<%=doctorDao.countSpecialist() %>
					</div>

				</div>


			</div>


		</div>

	</div>




	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">


					<form method="post" action="SpeciallistServlet">



						<div class="form-group">

							<label>Enter Specailication</label> <input type="text"
								name="spcailistname" class="form-control">
						</div>
						<div class="text-center my-2">

							<button type="submit" class="btn btn-success">Add</button>
						</div>


					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>

				</div>
			</div>
		</div>
	</div>

</body>

</html>

