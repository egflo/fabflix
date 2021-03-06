package com.fabflix.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fabflix.Management.User;

/**
 * Servlet implementation class LogoutServlet
 */
public class EmployeeLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLogoutServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); 
		
		User user = (User) session.getAttribute("User");
      
        String message = "You have been logged out. " ;
        if(user != null)
        {
        	message += "Last Employee: " + user.getlast_name();
        }
   	 	request.setAttribute("message", message);
   	 	session.invalidate();  
        RequestDispatcher view = request.getRequestDispatcher("/_dashboard/employeeLogin.jsp");
        view.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
