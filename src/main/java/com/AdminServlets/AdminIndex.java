package com.AdminServlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PropertyManagementSystem.GetConnection;


public class AdminIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get user and property count
		String UserCount = "";
		String PropertyCount = "";
		Statement statementObj = null;
		// get connection and execute the sql statements and assign them to usercount and propertycount
		try {
			
			statementObj = GetConnection.getConnection();
			String sqlUser = "SELECT COUNT(*) FROM users";
			
			ResultSet resultSetObjUser = statementObj.executeQuery(sqlUser);
			
			while(resultSetObjUser.next()) {
				
				UserCount = resultSetObjUser.getString(1);			
			}
			
		} catch (Exception e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}
		//popertycount
		try {
			
			statementObj = GetConnection.getConnection();
			String sqlProperty = "SELECT COUNT(*) FROM property";
			
			ResultSet resultSetObjProperty = statementObj.executeQuery(sqlProperty);
			
			while(resultSetObjProperty.next()) {
				
				PropertyCount = resultSetObjProperty.getString(1);			
			}
			
		} catch (Exception e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}
		//set user count and property count in the request objects
		request.setAttribute("UserCount", UserCount);
		request.setAttribute("PropertyCount", PropertyCount);
		
		//redirect to admin index jsp
		RequestDispatcher reqDis = request.getRequestDispatcher("adminIndex.jsp");
		reqDis.forward(request, response);
		
		
	}

}
