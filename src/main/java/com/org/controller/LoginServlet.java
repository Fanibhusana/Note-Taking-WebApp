package com.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.User;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	UserDao userDao = new UserDao();
	User user = userDao.fetchUserByEmailAndPassword(req.getParameter("email"),req.getParameter("password"));
	HttpSession session = req.getSession();
	if(user!=null) {
		
		session.setAttribute("userId",user.getId());
		resp.sendRedirect("home.jsp");
	}
	else {
		session.setAttribute("message", "Invalid credential");
		resp.sendRedirect("login.jsp");
	}
}
}
