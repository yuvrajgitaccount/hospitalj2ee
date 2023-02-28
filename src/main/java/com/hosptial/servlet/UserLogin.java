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


@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet{

	
	
	
	
	 
		private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			String email = request.getParameter("email");
			String password = request.getParameter("password");

			
			
			
			UserDao userDao=new UserDao(DbUtil.getConnection());
	User user;
	try {
		user = userDao.loginUser(email, password);
		HttpSession session = request.getSession();

		if (user!=null) {
			session.setAttribute("userobj", user);
			session.setAttribute(" succmsg", "User login Success");
			response.sendRedirect("index.jsp");//homepage index.jsp

		}

		else {

			session.setAttribute("errormsg", "User login failed");
			response.sendRedirect("user_login.jsp");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
			
			
			
			
			
			
		

		}

}
