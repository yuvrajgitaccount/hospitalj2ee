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
import com.hosptial.db.DbUtil;

@WebServlet("/DoctorRegister")
public class DoctorRegister extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");

		String dob = request.getParameter("dob");

		String quali = request.getParameter("quali");

		String spcailistname = request.getParameter("spcailistname");
		String email = request.getParameter("email");
		String mobno = request.getParameter("mobno");
		String password = request.getParameter("password");

		DoctorDao doctorDao = new DoctorDao(DbUtil.getConnection());

		try {
			boolean flag = doctorDao.saveDoctor(name, dob, quali, spcailistname, email, mobno, password);

			HttpSession httpSession = request.getSession();
			
			if (flag) {
				httpSession.setAttribute("succmsg", "Successfuly Doctor saved");
				response.sendRedirect("admin/doctor.jsp");
				
			}
			
			else {
				httpSession.setAttribute("errormsg", "Failed to saved data");
				response.sendRedirect("admin/doctor.jsp");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
