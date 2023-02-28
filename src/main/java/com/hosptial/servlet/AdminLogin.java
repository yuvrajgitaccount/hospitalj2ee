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
import com.hosptial.entity.User;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();

		if ("admin@gmail.com".equals(email) && "admin".equals(password)) {
			User user = new User();
			session.setAttribute("adminobj", user);
			session.setAttribute(" succmsg", "login Success");
			response.sendRedirect("admin/index.jsp");

		}

		else {

			session.setAttribute("errormsg", "login failed");
			response.sendRedirect("admin_login.jsp");
		}

	}

}
