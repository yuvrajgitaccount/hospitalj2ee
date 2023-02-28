<%@page import="com.hosptial.entity.Doctor"%>
<%@page import="com.hosptial.entity.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.hosptial.dao.DoctorDao"%>
<%@page import="com.hosptial.db.DbUtil"%>
<%@page import="com.hosptial.dao.AppointmentDao"%>
<%@page import="com.hosptial.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%@include file="all_css.jsp"%>
<style>
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}

.backImg {
	background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("img/doctor1.jpg");
	height: 20vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
</head>
<body>
<c:if test="${empty adminobj }">
		<c:redirect url="../admin_login.jsp"></c:redirect>
	</c:if>

	
	<%@include file="navbar.jsp"%>

	<div class="container-fulid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>
	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 fw-bold text-center text-success">Appointment
							List</p>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Gender</th>
									<th scope="col">Age</th>
									<th scope="col">Appoint Date</th>
										<th scope="col">Email</th>
									<th scope="col">Diseases</th>
									<th scope="col">Doctor Name</th>
										<th scope="col">Adress</th>
									<th scope="col">Status</th>

								</tr>
							</thead>
							<tbody>
								<%
								
								AppointmentDao dao = new AppointmentDao(DbUtil.getConnection());
								DoctorDao dao2 = new DoctorDao(DbUtil.getConnection());
								List<Appointment> list = dao.getAllAppointment();
								for (Appointment ap : list) {
									Doctor d = dao2.getByDoctoriD(ap.getDoctorid());
								%>
								<tr>
									<th><%=ap.getFullname()%></th>
									<td><%=ap.getGender()%></td>
									<td><%=ap.getAge()%></td>
									<td><%=ap.getAppoindate()%></td>
									<td><%=ap.getEmail() %>
									<td><%=ap.getDiseases()%></td>
									<td><%=d.getName()%></td>
										<td><%=ap.getAddress() %></td>
										<td><%=ap.getStatus() %>
										
											
									<td>
	
									</td>
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