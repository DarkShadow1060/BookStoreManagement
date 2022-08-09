<%@page import="org.hibernate.Transaction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="java.util.List"%>
<%@page import="com.nagarro.bookmanagementsystem.entities.BookEntity"%>
<%@page import="javax.servlet.jsp.jstl.*"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

response.setHeader("Expires", "0");
%>
<!DOCTYPE html>
<%
//============================================================================================================
PrintWriter dis = response.getWriter();

if (session.getAttribute("UserName") == null) {
	response.sendRedirect("login.jsp");
} else {
	dis.print(" Hello " + " " + session.getAttribute("UserName"));
}
//===============================================================================================================
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<style type="text/css">
tr {
	border: 1px;
	order-style: double;
}

td {
	border: 1px;
	border-style: double;
	text-align: center;
}
</style>

</head>
<body>
	<div class="Header">
	
		<form  class="p-5 " action="logout" method="POST">
			<h1 class="w-75 d-inline-block" >Book Listing </h1>  <input  class="btn btn-danger btn-lg btn-block d-inline-block" type="submit" value="Logout"> 	
		</form>
		<form class="d-inline-block pl-4" action="addbookinfo" method="POST">
			<input class="btn btn-primary btn-lg btn-block" type="submit" value="Add a Book" >
		</form>
		</div>
	<hr>

	<hr>
	<div class="p-3 " id="booksTable">
		
		<table class="text-center" style="width: 90%; border: 1px solid black;">
			<thead style="border: 1px solid black"> 
				<tr>
					<th style="width: 15%">Book Code</th>
					<th style="width: 20%">Book Name</th>
					<th style="width: 20%">Author</th>
					<th style="width: 20%">Date Added</th>
					<th style="width: 25%">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${book}" var="p">
				<tr>
					<td style="width: 15%">
					<c:out value="${p.getBookCode()}" />
					</td>
					<td style="width: 20%">
						<c:out value="${p.getBookName()}" />
					</td>
					<td style="width: 20%">
						<c:out value="${p.getAuthorName()}" />
					</td>
					<td style="width: 20%">
						<c:out value="${p.getCurrDate()}" />
					</td>
					
					<td style="width: 25%">
						<a href="update?product_id=${p.getBookCode()}" ><button class="btn btn-primary btn-lg btn-block d-inline-block" >Update</button></a>
						<a href="delete?product_id=${p.getBookCode()}"> <button class="btn btn-danger btn-lg btn-block">Remove</button></a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</body>
</html>