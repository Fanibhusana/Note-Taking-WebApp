<%@page import="com.org.dto.User"%>
<%@page import="com.org.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ChangePassword</title>
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

     
      
<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Password Change</p>
						<% String msg=(String)session.getAttribute("message"); 
						   if(msg!=null){ %>
							   <p class="text-center text-success fs-4"><%=msg%></p>
						 <%  
						 session.removeAttribute("message");
						   }
						%>
						
						<form action="change" method="post">
						<div class="mb-3">
								<label class="form-label">Current password</label> <input
									name="currentpwd" type="password" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">New password</label> <input
									name="newpwd" type="password" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Conform password</label> <input
									name="confompwd" type="password" class="form-control" required>
							</div>
							
							<button type="submit" class="btn bg-primary text-white col-md-12">change</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
      
<%} %> 
      
<%@ include file="components/js.jsp"%>

  </body>
</html>