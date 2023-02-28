package com.hosptial.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hosptial.dao.DoctorDao;
import com.hosptial.dao.UserDao;
import com.hosptial.db.DbUtil;



@WebServlet("/userChangePassword")
public class UserChangePassword extends HttpServlet {

	
	
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			int uid = Integer.parseInt(req.getParameter("uid"));
			String oldPassword = req.getParameter("oldPassword");
			String newPassword = req.getParameter("newPassword");

			UserDao dao = new 	UserDao (DbUtil.getConnection());
			HttpSession session = req.getSession();

			if (dao.checkOldPassword(uid, oldPassword)) {

				if (dao.changePassword(uid, newPassword)) {
					session.setAttribute("succMsg", "Password Change Sucessfully");
					resp.sendRedirect("user_login.jsp");

				} else {
					session.setAttribute("errorMsg", "Something wrong on server");
					resp.sendRedirect("Changepassword.jsp");
				}

			} else {
				session.setAttribute("errorMsg", "Old Password Incorrect");
				resp.sendRedirect("Changepassword.jsp");
			}

		}

}
