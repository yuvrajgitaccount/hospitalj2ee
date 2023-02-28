package com.hosptial.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hosptial.dao.UserDao;
import com.hosptial.db.DbUtil;

@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserDao userDao = new UserDao(DbUtil.getConnection());

		try {
			boolean flag =userDao.saveUser(name, email, password);

			HttpSession httpSession = request.getSession();
			if (flag) {
				
				httpSession.setAttribute("succMsg", "Successfully Datat Saved");
				response.sendRedirect("signup.jsp");

			}
			else {
				httpSession.setAttribute("errorMsg","error get the data saved");
				response.sendRedirect("user_login.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
