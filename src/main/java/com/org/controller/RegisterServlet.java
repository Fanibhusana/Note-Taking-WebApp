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
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	User user =new User();
	user.setName(req.getParameter("name"));
	user.setAge(Integer.parseInt(req.getParameter("age")));
	user.setEmail(req.getParameter("email"));
	user.setMobile(Long.parseLong(req.getParameter("mobile")));
	user.setPassword(req.getParameter("password"));
	UserDao userDao = new UserDao();
	userDao.saveAndUpdateUser(user);
	HttpSession session = req.getSession();
	session.setAttribute("message", "Registration successfull");
	resp.sendRedirect("register.jsp");

}
}
