<%@page import="com.org.dto.User"%>
<%@page import="com.org.dao.UserDao"%>
<%@page import="com.org.dto.Notes"%>
<%@page import="com.org.dao.NotesDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add Note</title>
    <%@ include file="components/css.jsp"%>
  </head>
  <body class="bg-dark text-white">
  <%  int id = (int) session.getAttribute("userId");
	UserDao userDao = new UserDao();

	User user = userDao.fetchUserById(id);
	if(user==null){
		response.sendRedirect("login.jsp");
	}else{
%>
    <%@ include file="components/homenav.jsp"%>

       <% int noteid=Integer.parseInt(request.getParameter("id"));
       NotesDao notesDao= new NotesDao();
   Notes notes= notesDao.fetchNoteById(noteid);
       System.out.println(notes.getDescription());
  %>
      <div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center"><%=user.getName() %> Note</p>
						
						<form  >
						<div class="mb-3">
								<label class="form-label">Title</label> <input
									name="title" type="text" readonly="readonly" class="form-control" value="<%=notes.getTitle()%>"required>
							</div>
													<div class="mb-3">
								<label class="form-label">Description</label>
							<textarea rows="10" cols="46" readonly="readonly" name="description"><%=notes.getDescription()%></textarea>
							</div>
					<a href="home.jsp" class="btn bg-primary text-white col-md-12">Back</a>
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