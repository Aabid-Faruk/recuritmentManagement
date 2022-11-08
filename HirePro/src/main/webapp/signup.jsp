<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Page</title>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</head>
<body
	style="background: url(img/pexels-hasan-albari-1229861.jpg); background-size: cover; background-attachment: fixed;">
	<div class="container">
		<div class="row">
			<div class="col m6 offset-m3">
				<div class="card">

					<div class=card-content>
						<h3 style="margin-top: 10px;" class="center-align">Register
							here!!</h3>

						<div class="form center-align">
							<!--creating form here  -->
							<form action="signup" method="post">
								<input type="text" name="name" placeholder="Name"> <input
									type="text" name="email" placeholder="Email"> <input
									type="text" name="number" placeholder="Mobile"> <input
									type="date" name="dob">
									
								Degree: <label> <input name="degree" type="radio" value="BTECH" /> <span>Btech</span> </label> 
										<label> <input name="degree" type="radio" value="MTECH" /> <span>Mtech</span> </label>
										<label> <input name="degree" type="radio" value="BSC" /> <span>Bsc</span> </label>
										<label> <input name="degree" type="radio" value="MSC" /> <span>Msc</span> </label>
										<label> <input name="degree" type="radio" value="BCA" /> <span>BCA</span> </label>
										<label> <input name="degree" type="radio" value="MCA" /> <span>MCA</span> </label>

								Gender: <label> <input name="gender" type="radio" value="MALE" /> <span>Male</span> </label>
										<label> <input name="gender" type="radio" value="FEMALE" /> <span>Female</span></label>
									<br>
								
								
								<input type="number" name="experience" min="0" max="34"	placeholder="Experience"> 
								
								<button type="submit" class="btn">Submit</button>

							</form>

						</div>

						<div class="loader center-align"
							style="margin-top: 10px;">
							<div class="preloader-wrapper active">
								<div class="spinner-layer spinner-red-only">
									<div class="circle-clipper left">
										<div class="circle"></div>
									</div>
									<div class="gap-patch">
										<div class="circle"></div>
									</div>
									<div class="circle-clipper right">
										<div class="circle"></div>
									</div>
								</div>
							</div>
							<h5>Please wait...</h5>
						</div>
					</div>
				</div>
			</div>

		</div>

	</div>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"
		integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
		crossorigin="anonymous"></script>
		
	<script>
		$(document).ready(function() {
			console.log("page is ready...")
			
		})
	</script>

</body>
</html>