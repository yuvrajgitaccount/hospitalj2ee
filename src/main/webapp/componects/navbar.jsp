


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-danger">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"><i class="fa fa-clinic-medical"></i>MEDI_Home</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
       
        
        
        <c:if test="${ empty userobj }">
        
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="admin_login.jsp"><i class="fa fa-sign-in "></i>ADMIN</a>
        </li>
      
      
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="doctor_login.jsp"><i class="fa fa-eye"></i>DOCTOR</a>
        </li>
        
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="user_appointment.jsp"><i class="fa fa-eye"></i>APPOINTMENT</a>
        </li>
        
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="user_login.jsp"><i class="fa fa-eye"></i>USER</a>
        </li>
       

</c:if>


    
        <c:if test="${not empty userobj }">
        
        
      
      
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="user_appointment.jsp"><i class="fa fa-eye"></i>APPOINMENT</a>
        </li>
        
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="user_viewappointment.jsp"><i class="fa fa-eye"></i>VIEWAPPOINTMENT</a>
        </li>
        
          <div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
  	<i class="fa fa-user-md "></i><br>  ${userobj.name }
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="Changepassword.jsp">ChangePassword</a>
     <a class="dropdown-item" href="UserLogout">Logout</a>
   
  </div>
</div>
       

</c:if>
        
       
      </ul>
    
  </div>
</nav>