package com.Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static String url = "jdbc:mysql://localhost:3306/propertymanagementsystem";
	static String DBusername = "root";
	static String DBpassword = "";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("fName");
		String lastName = request.getParameter("lName");
		String Email = request.getParameter("Email");
		String message = request.getParameter("message");
		Integer UID = null;
		if (request.getParameter("UID") != null) {
			UID = Integer.parseInt(request.getParameter("UID"));
		}
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conObj = DriverManager.getConnection(url,DBusername,DBpassword);
			
			Statement statementObj = conObj.createStatement();
			if (UID == null) {
				String sql = "INSERT INTO feedbackunreg (Fname , Lname , Email , Message ) VALUES ('"+firstName+"','"+lastName+"','"+Email+"', \" "+message+" \" )";
				statementObj.execute(sql);
			} else {
				String sql = "INSERT INTO feedbackreg (Fname , Lname , Email , Message , UID ) VALUES ('"+firstName+"','"+lastName+"','"+Email+"', \" "+message+" \" , "+ UID +" )";
				statementObj.execute(sql);
			}
			
			
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Something wrong with loading driver " + e.toString());
			
		} catch (SQLException e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}
		
		response.sendRedirect("Contact");
		
	}

}
