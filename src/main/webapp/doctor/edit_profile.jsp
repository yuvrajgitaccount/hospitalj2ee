




<%@page import="com.hosptial.entity.Specialist"%>
<%@page import="java.util.List"%>
<%@page import="com.hosptial.db.DbUtil"%>
<%@page import="com.hosptial.dao.SpecialistDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}

.backImg {
	background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("../img/hospital.jpg");
	height: 20vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
<%@include file="all_css.jsp"%>
</head>
<body>
	<c:if test="${empty doctorobj }">
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>


	<%@include file="navbar.jsp"%>
	
	<div class="container p-4">
		<div class="row">
			<div class="col-md-4 ">
				<div class="card paint-card">
					<p class="text-center fs-3">Change Password</p>
					<c:if test="${not empty succMsg }">
						<p class="text-center text-success fs-3">${succMsg}</p>
						<c:remove var="succMsg" scope="session" />
					</c:if>

					<c:if test="${not empty errorMsg }">
						<p class="text-center text-danger fs-5">${errorMsg}</p>
						<c:remove var="errorMsg" scope="session" />
					</c:if>
					<div class="card-body">
						<form action="../doctChangePassword" method="post">
							<div class="mb-3">
								<label>Enter New Password</label> <input type="text"
									name="newPassword" class="form-control" required>
							</div>

							<div class="mb-3">
								<label>Enter Old Password</label> <input type="text"
									name="oldPassword" class="form-control" required>
							</div>
							<input type="hidden" value="${doctorobj.id }" name="uid">
							<button class="btn btn-success col-md-12">Change
								Password</button>
						</form>
					</div>
				</div>
			</div>
			
			<div class="col-md-5 offset-2">
				<div class="card paint-card">
					<p class="text-center fs-3">Edit Doctor Deatils</p>
					<c:if test="${not empty succMsgd }">
						<p class="text-center text-success fs-3">${succMsgd}</p>
						<c:remove var="succMsgd" scope="session" />
					</c:if>

					<c:if test="${not empty errorMsgd }">
						<p class="text-center text-danger fs-5">${errorMsgd}</p>
						<c:remove var="errorMsgd" scope="session" />
					</c:if>
					<div class="card-body">
					
					<form method="post" action="../doctorUpdateProfile">



							<div class="form-group mb-3">

								<label>Enter Name</label> <input type="text" name="name" value="${doctorobj.name}"
									class="form-control">
							</div>

							<div class=" mb-3">

								<label>Enter Birthday</label> <input type="date" name="dob" value="${doctorobj.dob}"
									class="form-control">
							</div>

							<div class="form-group mb-3">

								<label>Enter Qualification</label><input type="text"value="${doctorobj.quali}"
									name="quali" class="form-control">
							</div>

							<div class="form-group mb-3">

								<label>Enter Spicaillication</label> <select
									name="spcailistname" class="form-control">

									<option>${doctorobj.spcailistname }</option>



									<%
									SpecialistDao specialistDao = new SpecialistDao(DbUtil.getConnection());
									List<Specialist> list = specialistDao.getAllSpecilist();

									for (Specialist specialist : list) {
									%>

									<option><%=specialist.getSpcailistname()%></option>


									<%
									}
									%>

								</select>
							</div>


							<div class="form-group mb-3">

								<label>Enter Email</label> <input type="text" readonly name="email" value="${doctorobj.email}"
									class="form-control">
							</div>



							<div class="form-group mb-3">

								<label>Enter MobileNo</label> <input type="text" name="mobno" value="${doctorobj.mobno }"
									class="form-control">
							</div>



<input type="hidden" name="id" value="${doctorobj.id}">

							<div class="text-center my-2">

								<button type="submit" class="btn btn-success">Add</button>
							</div>
						</form>

					
			
			
			
			</div>
		</div>
	</div>
	
	</body>
	</html>