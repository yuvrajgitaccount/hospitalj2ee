package com.hosptial.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hosptial.dao.AppointmentDao;
import com.hosptial.db.DbUtil;


	
	

@WebServlet("/UpdateStatus")
public class UpdateStatus extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int id = Integer.parseInt(req.getParameter("id"));
			int did = Integer.parseInt(req.getParameter("did"));
			String comm = req.getParameter("comm");

			AppointmentDao dao = new AppointmentDao(DbUtil.getConnection());

			HttpSession session = req.getSession();

			if (dao.updateCommentStatus(id, did, comm)) {
				session.setAttribute("succMsg", "Comment Updated");
				resp.sendRedirect("doctor/patient.jsp");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
				resp.sendRedirect("doctor/patient.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}


