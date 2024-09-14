package com.org.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.Notes;
import com.org.dto.User;
@WebServlet("/update")
public class UpdateNotesServlet extends HttpServlet{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 Notes note=new Notes();
		note.setId(Integer.parseInt(req.getParameter("id")));
		note.setTitle(req.getParameter("title"));
		note.setDescription(req.getParameter("description"));
		
		HttpSession session = req.getSession();
		int id = (int) session.getAttribute("userId");
		UserDao userDao = new UserDao();
		User user = userDao.fetchUserById(id);
		List<Notes> list=new ArrayList<Notes>();
		list.add(note);		
		user.setNotes(list);
		note.setUser(user);
		
		userDao.saveAndUpdateUser(user);
		
		session.setAttribute("message", "Update Notes Successful");
		resp.sendRedirect("home.jsp");
}
}
