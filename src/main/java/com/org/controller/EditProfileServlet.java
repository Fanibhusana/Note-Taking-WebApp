package com.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.Notes;
import com.org.dto.User;
@WebServlet("/edit")
public class EditProfileServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession();
	int id = (int) session.getAttribute("userId");
	UserDao userDao = new UserDao();
	User user = userDao.fetchUserById(id);	
	user.setName(req.getParameter("name"));
	user.setEmail(req.getParameter("email"));
	user.setAge(Integer.parseInt(req.getParameter("age")));
	user.setMobile(Long.parseLong(req.getParameter("mobile")));
	user.setNotes(user.getNotes());
	Notes notes=new Notes();
	notes.setUser(user);
	userDao.saveAndUpdateUser(user);
	session.setAttribute("message", "Profile Edit Successfully");
	resp.sendRedirect("editprofile.jsp");
}
}
