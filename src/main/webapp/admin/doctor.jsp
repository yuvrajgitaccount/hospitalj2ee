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


	
	<div class="container-fluid p-5">


		<div class="row">

			<div class="col-md-4">


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


						<form method="post" action="../DoctorRegister">



							<div class="form-group mb-3">

								<label>Enter Name</label> <input type="text" name="name"
									class="form-control">
							</div>

							<div class=" mb-3">

								<label>Enter Birthday</label> <input type="date" name="dob"
									class="form-control">
							</div>

							<div class="form-group mb-3">

								<label>Enter Qualification</label><input type="text"
									name="quali" class="form-control">
							</div>

							<div class="form-group mb-3">

								<label>Enter Spicaillication</label> <select
									name="spcailistname" class="form-control">

									<option>--select--</option>



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

								<label>Enter Email</label> <input type="text" name="email"
									class="form-control">
							</div>



							<div class="form-group mb-3">

								<label>Enter MobileNo</label> <input type="text" name="mobno"
									class="form-control">
							</div>




							<div class="form-group mb-3">

								<label>Enter Password</label> <input type="text" name="password"
									class="form-control">
							</div>


							<div class="text-center my-2">

								<button type="submit" class="btn btn-success">Add</button>
							</div>
						</form>



					</div>

				</div>

			</div>



			<div class="col-md-8">

				<div class="card paint-card">

					<div class="card-body">

						<p class="text-center fs-5">Doctor Details</p>



						<table class="table">
							<thead>

								<tr>

									<th scope="col">FullName</th>
									<th scope="col">DOB</th>
									<th scope="col">QUALIFICATION</th>
									<th scope="col">SPECIALIZATION</th>
									<th scope="col">EMAIL</th>
									<th scope="col">MOBILNO</th>
									<th scope="col">ACTION</th>
								</tr>

							</thead>
							<tbody>

								<%
								DoctorDao doctorDao = new DoctorDao(DbUtil.getConnection());

								List<Doctor> list2 = doctorDao.getAllDoctor();

								for (Doctor doctor : list2) {
								%>


								<tr>
									<td><%=doctor.getName()%></td>
									<td><%=doctor.getDob()%></td>
									<td><%=doctor.getQuali()%></td>
									<td><%=doctor.getSpcailistname()%></td>
									<td><%=doctor.getEmail()%></td>
									<td><%=doctor.getMobno()%></td>

									<td><a href="editdoctor.jsp?id=<%=doctor.getId()%>"
										class="btn btn-sm btn-success">Edit</a> <a
										href="../DoctorDelete?id=<%=doctor.getId()%>"
										class="btn btn-sm btn-danger">Delete</a></td>

								</tr>


								<%
								}
								%>

							</tbody>


						</table>
					</div>

				</div>



			</div>


		</div>


	</div>
</body>

</html>