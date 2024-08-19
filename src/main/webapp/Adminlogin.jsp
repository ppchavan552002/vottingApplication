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
	background-color: dimgray; 
}
.adminbox{
margin-top: 10%;
}
</style>
</head>
<body>
<div class="container w-50">
<div class="container-fluid border border-success p-4 adminbox bg-primary p-2 text-light bg-opacity-25">
<h1>Admin LogIn</h1>
	<form action="adminlogin" method="post">
		<label class="form-label">Enter UserName</label><br><br>
		<input type="text" class="form-control" name="aname" required><br><br>
		
		<label>Enter password</label><br><br>
		<input type="password" class="form-control" name="apass" required><br><br>
		
		<button class="btn btn-success">Log in</button>

	</form>
	</div>
</div>
</body>
</html>