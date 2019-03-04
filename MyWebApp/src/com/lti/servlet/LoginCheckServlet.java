package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.service.DatabaseLoginService;

/**
 * Servlet implementation class LoginUser
 */
@WebServlet("/login.check")
public class LoginCheckServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		DatabaseLoginService loginService = new DatabaseLoginService();
		boolean isValid = loginService.isValidUser(username, password);
		HttpSession session = request.getSession();
		if (isValid) {
			String fullname = loginService.getFullName(username);
			session.setAttribute("userFullName", fullname);

			response.sendRedirect("Welcome.jsp");
		} else
		{
			session.setAttribute("message","InvalidUsername/Password");

			response.sendRedirect("Login.jsp");

		/*
		 * if (username.equals("sid") && password.equals("123"))
		 * response.sendRedirect("Welcome.html"); else
		 * response.sendRedirect("Login.html");
		 */
	}

}
}
