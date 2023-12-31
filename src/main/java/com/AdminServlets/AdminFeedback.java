package com.AdminServlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PropertyManagementSystem.*;

public class AdminFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//creating a list of feedback objects
		List<FeedbackDetails> feedbackList = new ArrayList<FeedbackDetails>();
		Statement statementObj = null;
		
		// getting connection and execute the sql and adding feedback objects to the list
		try {
			
			statementObj = GetConnection.getConnection();
			String sql = "SELECT * FROM feedbackunreg";
			
			ResultSet resultSetObj = statementObj.executeQuery(sql);
			
			while(resultSetObj.next()) {
				
				String Fname = resultSetObj.getString(2);
				String Lname = resultSetObj.getString(3);
				String Email = resultSetObj.getString(4);
				String Message = resultSetObj.getString(5);
				
				FeedbackDetails feedbackObj = new FeedbackDetails(Fname,Lname,Email,Message);
				feedbackList.add(feedbackObj);
			}
			
			
			
		} catch (Exception e) {
			
			System.out.println("Something wrong with loading driver " + e.toString());
			
		}
		
		//setting the list of feedback in the request object
		request.setAttribute("FeedbackList", feedbackList);
		
		// redirect to feedback jsp page
		RequestDispatcher reqDis = request.getRequestDispatcher("adminFeedback.jsp");
		reqDis.forward(request, response);
		
	}

}
