<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>Create Account</title>

<script type="text/javascript">
	function changeFunc() {
		document.getElementById("error").style.display = "none";
	}
</script>

</head>
<body>
	<form action="newuser" method="POST">



		<section class="vh-100" style="background-color: #508bfc;">
			<div class="container py-5 h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-8 col-lg-6 col-xl-5">
						<div class="card shadow-2-strong" style="border-radius: 1rem;">
							<div class="card-body p-5 text-center">
								<p id="error" class="text-danger">${error}</p>
								<h3 class="mb-5">Sign Up</h3>

								<div class="form-outline mb-4">
									<input type="text" id="typePasswordX-2"
										class="form-control form-control-lg" placeholder="Full Name"
										name="name" required onclick="changeFunc();"
										onkeypress="changeFunc();" />
								</div>

								<div class="form-outline mb-4">
									<input type="text" id="typeEmailX-2"
										class="form-control form-control-lg" placeholder="Username"
										name="userName" required onclick="changeFunc();"
										onkeypress="changeFunc();" />
								</div>

								<div class="form-outline mb-4">
									<input type="email" id="typePasswordX-2"
										class="form-control form-control-lg"
										placeholder="Email : example@xyz.com" name="emailID" required onclick="changeFunc();"
										onkeypress="changeFunc();"/>
								</div>

								<div class="form-outline mb-4">
									<input type="password" id="typePasswordX-2"
										class="form-control form-control-lg" placeholder="Password"
										name="passWord" required onclick="changeFunc();"
										onkeypress="changeFunc();" />
								</div>

								<button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>

								<hr class="my-4">
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</form>
</body>
</html>