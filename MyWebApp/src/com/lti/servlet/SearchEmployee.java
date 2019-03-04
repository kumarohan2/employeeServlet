package com.lti.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.service.Employee;
import com.lti.service.EmployeeService;

@WebServlet("/employee.check")
public class SearchEmployee extends HttpServlet {
	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId=Integer.parseInt(request.getParameter("empid"));
		EmployeeService employeeService = new EmployeeService();
		Employee emp = employeeService.getEmployeeDetails(empId);
		
		HttpSession session = request.getSession();
		session.setAttribute("employeeData", emp);
		response.sendRedirect("searchEmpResult.jsp");
	}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
