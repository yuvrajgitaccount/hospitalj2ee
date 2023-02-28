package com.hosptial.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/AdminLogout")
public class AdminLogout extends HttpServlet {

	
	
	
	   
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			try {
				
				HttpSession session=request.getSession();
				session.removeAttribute("adminobj");
				
				session.setAttribute("succmsg", "Logout succfuly");
				response.sendRedirect("admin_login.jsp");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
		}


}
