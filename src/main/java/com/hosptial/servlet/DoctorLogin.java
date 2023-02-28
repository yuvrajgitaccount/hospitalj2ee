package com.hosptial.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hosptial.dao.DoctorDao;
import com.hosptial.dao.UserDao;
import com.hosptial.db.DbUtil;
import com.hosptial.entity.Doctor;
import com.hosptial.entity.User;


	
	

@WebServlet("/DoctorLogin")
public class DoctorLogin extends HttpServlet{

	
	
	
	
	 
		private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			String email = request.getParameter("email");
			String password = request.getParameter("password");

			
			
			
			DoctorDao userDao=new DoctorDao(DbUtil.getConnection());
	Doctor  doctor;
	try {
		doctor = userDao.loginUser(email, password);
		HttpSession session = request.getSession();

		if (doctor!=null) {
			session.setAttribute("doctorobj", doctor);
			session.setAttribute(" succmsg", "Doctor login Success");
			response.sendRedirect("doctor/index.jsp");//Doctor homepage index.jsp

		}

		else {

			session.setAttribute("errormsg", "Doctor login failed");
			response.sendRedirect("doctor_login.jsp");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
			
			
			
			
			
			
		

		}

}
