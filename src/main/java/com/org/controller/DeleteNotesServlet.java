package com.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.NotesDao;
import com.org.dao.UserDao;
import com.org.dto.User;
@WebServlet("/delete")
public class DeleteNotesServlet  extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	
	HttpSession session = req.getSession(false);
	int userid = (int) session.getAttribute("userId");
	UserDao userDao = new UserDao();
	User user = userDao.fetchUserById(userid);
	if(user==null) {
		resp.sendRedirect("login.jsp");
	}else {
		 NotesDao notesDao = new NotesDao();
		 notesDao.deleteNotesById(id);
		session.setAttribute("message", "Delete successfully");
		resp.sendRedirect("home.jsp");
	}
}
}
