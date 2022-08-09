<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>Home Page</title>
</head>
<body>
	<form action="loginpage" method="POST">
	
		<section class="vh-100" style="background-color: #508bfc;">
			<div class="container py-5 h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-8 col-lg-6 col-xl-5">
						<div class="card shadow-2-strong" style="border-radius: 1rem;">
							<div class="card-body p-5 text-center">
								<p id="error" class="text-danger">${error}</p>
								<h3 class="mb-5">User Type</h3>

								<div class="form-outline mb-4">
									<label>Existing User</label> <input type="radio" name="UsrType"
										value="Existing User" checked="checked">
								</div>

								<div class="form-outline mb-4">
									<label>New User</label> <input type="radio" name="UsrType"
										value="New User">
								</div>

								<button class="btn btn-primary btn-lg btn-block" type="submit">Proceed</button>

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