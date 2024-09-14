<%@page import="com.org.dto.User"%>
<%@page import="com.org.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Profile</title>
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

     <% 
     User u= userDao.fetchUserById(id);
%>
          <div class="container-fluid p-3">
        <div class="row">
          <div class="col-md-12">
            <div class="card paint-card">
              <div class="card-body">
                <p class="fs-3 text-center">User Details</p>
                <a href="editprofile.jsp" class="text-decoration-none btn btn-primary">Edit User Profile</a>
              </div>
            </div>
          </div>
    
    
     <h3 style="text-align: center;color:white"><br>
  <p class="change">User name: <%=u.getName() %></p><br>
   <p class="change">User age:  <%=u.getAge() %></p><br>
    <p class="change">User mobile: <%=u.getMobile() %></p><br>
   <p class="change">User email: <%=u.getEmail() %></p><br>
    </h3>
      
<%} %> 
      
<%@ include file="components/js.jsp"%>

  </body>
</html>