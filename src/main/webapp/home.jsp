<%@page import="com.org.dao.UserDao"%>
<%@page import="com.org.dao.NotesDao"%>
<%@page import="com.org.dto.Notes"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home Page</title>
    <%@ include file="components/css.jsp"%>
  </head>
  <body class="bg-dark text-white">
  <% 

	User user = UserDao.fetchUserById((int)session.getAttribute("userId"));
	if(user==null){
		response.sendRedirect("login.jsp");
	}else{
%>
    <%@ include file="components/homenav.jsp"%>

      <h3 style="text-align: center; color:white"> Welcome to Home page</h3>

  <% String msg=(String)session.getAttribute("message"); 
    if(msg!=null){%>
		<p class="text-center text-success fs-4"><%= msg%></p>
	 <% 
	 session.removeAttribute("message");
						    }

	List<Notes> list= NotesDao.fetchNotesByUserId((int)session.getAttribute("userId"));

	%>

      <div class="container border">
      
<div class="row">
   <% for(Notes n:list){	 %>
	   
	   <div class="col-md-4 card border border-primary m-4" style="width:15em;" > 
	       <div class="card-body">
	       
	       <div class="d-flex flex-wrap justly-content-evenly">
	       <div>
	         <h2 class="text-success card-title"><%=n.getTitle() %></h2>
	         <a href="viewnote.jsp?id=<%=n.getId()%>" class="btn btn-sm btn-info">view</a>
	         <a href="updatenote.jsp?id=<%=n.getId()%>" class="btn btn-sm btn-info">update</a>
	         <a href="delete?id=<%=n.getId()%>" class="btn btn-sm btn-info">delete</a>
	         </div>
	       </div>
	       
	       </div>
	   </div>
	   <% 
   }
	   %>
   </div>
</div>

    
      <div class="position-absolute bottom-0 end-0 p-3 g-col-12">   
      <a href="addnote.jsp">
      <img src="lib\Add.gif" alt="Logo" width="100" height="100" class=" btn d-inline-block align-text-top ">
       </a> </div>
      
<%} %>

<%@ include file="components/js.jsp"%>

  </body>
</html>