<%@page import="com.org.dto.User"%>
<%@page import="com.org.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>LogOut Page</title>
    <%@ include file="components/css.jsp"%>
  </head>
  <body class="bg-dark text-white">
  <% int id = (int) session.getAttribute("userId");
	UserDao userDao = new UserDao();
	User user = userDao.fetchUserById(id);
	if(user==null){
		response.sendRedirect("login.jsp");
	}else{
%>
    <%@ include file="components/homenav.jsp"%>

     
      <h3 style="text-align: center"> Are you sure to want logout</h3>
      <p style="text-align: center">
     <a href="logout" class="btn btn-danger decoration-none">Yes,logout </a><br>
     <br>
     <a href="home.jsp" class="btn btn-success decoration-none">No,Go to Home page </a>
     </p>
     
      
      
<%} %> 
      
<%@ include file="components/js.jsp"%>

  </body>
</html>