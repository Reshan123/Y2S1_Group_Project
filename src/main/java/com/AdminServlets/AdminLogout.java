package com.AdminServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// getting session object
		HttpSession session = request.getSession();
		//making all sessions invalid
		session.invalidate();
		//redirect to adminlogin jsp
		response.sendRedirect("adminLogin.jsp");
		return;
		
	}

}
