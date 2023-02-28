<%@page import="com.hosptial.entity.Doctor"%>
<%@page import="com.hosptial.dao.DoctorDao"%>
<%@page import="com.hosptial.entity.Specialist"%>
<%@page import="java.util.List"%>
<%@page import="com.hosptial.db.DbUtil"%>
<%@page import="com.hosptial.dao.SpecialistDao"%>
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


	<h1>Doctor Dashboard</h1>

	<div class="container p-5">


		<div class="row">

			<div class="col-md-8 offset-md-2">


				<div class="card paint-card">

					<div class="card-body">

						<p class="text-center fs-5 text-danger">Doctor DashBoard</p>


						<c:if test="${not empty succmsg }">

							<p class="text-center text-primary fs-3">${succmsg }</p>
							<c:remove var="sucmsg" scope="session"></c:remove>
						</c:if>


						<c:if test="${not empty errormsg }">
							<p class="text-center text-danger fs-3">${errormsg }</p>
							<c:remove var="errormsg" scope="session"></c:remove>
						</c:if>



						<%
						int id = Integer.parseInt(request.getParameter("id"));
						DoctorDao doctorDao = new DoctorDao(DbUtil.getConnection());
						Doctor doctor = doctorDao.getByDoctoriD(id);
						%>



						<form method="post" action="../DoctorUpdate">



							<div class="mb-3">

								<label>Enter Name</label> <input type="text" name="name" value="<%=doctor.getName()%>"
									class="form-control">
							</div>

							<div class="mb-3">

								<label>Enter Birthday</label> <input type="date" name="dob" value="<%=doctor.getDob()%>"
									class="form-control">
							</div>

							<div class="mb-3">

								<label>Enter Qualification</label><input type="text"
									name="quali" value="<%=doctor.getQuali()%>" class="form-control">
							</div>

							<div class="mb-3">

								<label>Enter Spicaillication</label> <select
									name="spcailistname" class="form-control">

									<option><%=doctor.getSpcailistname()%></option>



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


							<div class="mb-3">

								<label>Enter Email</label> <input type="text" name="email" value="<%=doctor.getEmail()%>"
									class="form-control">
							</div>



							<div class="mb-3">

								<label>Enter MobileNo</label> <input type="text" name="mobno" value="<%=doctor.getMobno()%>"
									class="form-control">
							</div>




							<div class="mb-3">

								<label>Enter Password</label> <input type="text" name="password" value="<%=doctor.getPassword()%>"
									class="form-control">
							</div>
							
							<input type="hidden" name="id" value="<%=doctor.getId() %>">


							<div class="text-center my-2">

								<button type="submit" class="btn btn-success">Update</button>
							</div>
						</form>



					</div>

				</div>

			</div>

		</div>
	</div>


</body>
</html>
