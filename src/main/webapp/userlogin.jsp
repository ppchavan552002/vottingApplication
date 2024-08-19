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
margin-top: 20%;
}

</style>
</head>
<body>
<div class="container w-50">
<div class="container-fluid border border-success p-4 votebox bg-primary p-2 text-light bg-opacity-25">
<%
String check=(String)request.getAttribute("vote");
if(check==null){check="No";}
if(check.equals("Yes")){
%>
<p class="text-center text-danger">Already voted</p>
<%}else if(check.equals("failed")){ %>
<p class="text-center text-danger">User Does't Exist First sign Up</p>
<% }%>

<h1 class="text-center">User LogIn</h1>
	<div class="container w-50">
	<form action="userlogin" method="post">
		<label class="form-label">Enter UserName</label><br><br>
		<input type="text" class="form-control" name="uname" required><br><br>
		
		<label class="form-label">Enter password</label><br><br>
		<input type="password" class="form-control" name="upass" required><br><br>
		<button class="btn btn-success">Log in</button>
		<a href="signup.jsp" class="btn btn-danger ms-5">Sign up</a>
	</form>
	</div>
</div>
</div>
</body>
</html>