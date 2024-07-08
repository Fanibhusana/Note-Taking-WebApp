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
@WebServlet("/addnote")
public class AddNoteServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Notes notes=new Notes();
		notes.setTitle(req.getParameter("title"));
		notes.setDescription(req.getParameter("description"));
		
		HttpSession session = req.getSession();
		//User user = (User) session.getAttribute("userObj");
		int id = (int) session.getAttribute("userId");
		User user = UserDao.fetchUserById(id);
		List<Notes> list=new ArrayList<Notes>();
		list.add(notes);
		user.setNotes(list);
		notes.setUser(user);
		UserDao.saveAndUpdateUser(user);
		session.setAttribute("message", "Notes added successfully");
		session.setAttribute("userId",user.getId());
		resp.sendRedirect("home.jsp");
	}
}
