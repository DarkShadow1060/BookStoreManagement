<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script type="text/javascript">
	function changeFunc() {
		document.getElementById("error").style.display = "none";
	}
</script>
</head>
<body>
	<section class="vh-100" style="background-color: #508bfc;">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-12 col-md-8 col-lg-6 col-xl-5">
					<div class="card shadow-2-strong" style="border-radius: 1rem;">
						<form action="bookinfo">
							<div class="card-body p-5 text-center">
								<%
							//========================================================================
							PrintWriter dis = response.getWriter();

							if (session.getAttribute("UserName") == null) {
								response.sendRedirect("login.jsp");
							} else {
								dis.print(" Hello " + " " + session.getAttribute("UserName"));
							}
							//========================================================================
							%>
								<h3 class="mb-5">Add Book Details</h3>
								<p id="error" class="text-danger">${error}</p>
								<div class="form-outline mb-4">
									<input type="number" id="bookcode"
										class="form-control form-control-lg" placeholder="Book Code"
										name="bookCode" required onclick="changeFunc();"
										onkeypress="changeFunc();" />
								</div>

								<div class="form-outline mb-4">
									<input type="text" id="bookname"
										class="form-control form-control-lg" placeholder="Book Name"
										name="bookName" required onclick="changeFunc();"
										onkeypress="changeFunc();" />
								</div>
								
								<div class="form-outline mb-4">
									<input type="date" id="date"
										class="form-control form-control-lg" 
										name="currDate" />
								</div>
								
								<div class="form-outline mb-4">
									<input type="text" id="author"
										class="form-control form-control-lg" placeholder="Author"
										name="authorName" />
								</div>

								<button class="btn btn-primary btn-lg btn-block" type="submit">Add
								</button>
								<a href="redirectsession"> <button class="btn btn-danger btn-lg btn-block" type="button">Cancel</button> </a>
								<hr class="my-4">
							</div>
						</form>
						
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>