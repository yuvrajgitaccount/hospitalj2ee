package com.hosptial.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hosptial.dao.SpecialistDao;
import com.hosptial.dao.UserDao;
import com.hosptial.db.DbUtil;
import com.hosptial.entity.User;



@WebServlet("/SpeciallistServlet")
public class SpeciallistServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String spcailistname = request.getParameter("spcailistname");

		
		
		
		SpecialistDao specialistDao=new SpecialistDao (DbUtil.getConnection());
		
		 try {
		boolean flag=	specialistDao.saveSpcalist(spcailistname);
		
		HttpSession session=request.getSession();
		if (flag) {
			
	
			session.setAttribute("succmsg","Specillist AddedSuccessfuly");
			response.sendRedirect("admin/index.jsp");//admin homepage
			
		}
		else {
			session.setAttribute("errormsg","Server failed");
			response.sendRedirect("admin_login.jsp");
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 

	}
		
		
		
}
