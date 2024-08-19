<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style type="text/css">
body {
	text-align: center;
	background-color: darkslateblue;
}
.votebox{
margin-top: 10%;
}

</style>
</head>
<body>
<%
request.setAttribute("check", "No");
%>
	<div class="container w-50">
<div class="container-fluid border border-success p-4 votebox bg-primary p-2 text-light bg-opacity-25">
	
	<h1 class="text-center">User SignIn</h1>
	<div class="container w-50">
	<form action="userSignUp" method="post">
		<label class="form-label">Enter UserName</label><br>
		<input type="text" class="form-control" name="uname" required><br><br>
		
		<label class="form-label">Enter Email</label><br>
		<input type="email" class="form-control" name="uemail" required><br><br>
		
		<label class="form-label">Enter password</label><br>
		<input type="password" class="form-control" name="upass" required><br><br>
		
		<input type="hidden" name="vote" value="No">
		
		<button class="btn btn-success">Sign up</button>
		<a href="userlogin.jsp" class="btn btn-danger ms-5">log in</a>
	</form>
	</div>
	</div>
</div>
</body>
</html>