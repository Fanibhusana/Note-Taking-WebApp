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
@WebServlet("/change")
public class ChangePwdServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession();
	int id = (int) session.getAttribute("userId");
	User user = UserDao.fetchUserById(id);	
	String currentpwd = req.getParameter("currentpwd");
	String newpwd = req.getParameter("newpwd");
	String confompwd = req.getParameter("confompwd");
	if(currentpwd.equals(user.getPassword())) {
		 if(newpwd.equals(confompwd)) {
			 user.setPassword(confompwd);
			 user.setNotes(user.getNotes());
			 new Notes().setUser(user);
			  UserDao.saveAndUpdateUser(user);
			 
			 session.setAttribute("message", "Password is changed");
				resp.sendRedirect("changepwd.jsp");

		 }else {
			 session.setAttribute("message", "new & conform password is not matched");
				resp.sendRedirect("changepwd.jsp");
		 }
	}else {
		session.setAttribute("message", "Invalid password");
		resp.sendRedirect("changepwd.jsp");
	}
}
}
