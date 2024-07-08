<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login Page</title>
    <%@ include file="components/css.jsp"%>
  </head>
  <body class="bg-dark text-white">

    <%@ include file="components/navbar.jsp"%>

     
      
<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">User Login</p>
						<% String msg=(String)session.getAttribute("message"); 
						   if(msg!=null){ %>
							   <p class="text-center text-success fs-4"><%=msg%></p>
						 <%  
						 session.removeAttribute("message");
						   }
						%>
						
						<form action="login" method="post">
						<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" type="email" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									name="password" type="password" class="form-control" required>
							</div>
							<button type="submit" class="btn bg-primary text-white col-md-12">Login</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
            
<%@ include file="components/js.jsp"%>

  </body>
</html>