package com.hosptial.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hosptial.dao.DoctorDao;
import com.hosptial.db.DbUtil;


@WebServlet("/DoctorDelete")
public class DeleteDoctor extends HttpServlet{

	
	
	
	
	private static final long serialVersionUID = 1L;
	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		DoctorDao dao= new DoctorDao(DbUtil.getConnection());
		
boolean flag=dao.DeleteById(id);

HttpSession session=request.getSession();
//if it is true
if (flag) {
	 
	session.setAttribute("succMsg", "SucessfullyDelte");
	response.sendRedirect("admin/doctor.jsp");
	 
	 
	
}
else {
	session.setAttribute("errorMsg","error get the data detleted");
	response.sendRedirect("admin/doctor.jsp");
}
          
	
}
		
}
