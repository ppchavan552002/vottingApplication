<%@page import="com.Model.Candidate"%>
<%@page import="java.util.List"%>
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
<% 
String check=(String)request.getAttribute("una");
if(check!=null){
%>
<div class="container w-50">
<div class="container-fluid border border-success p-4 votebox bg-primary p-2 text-light bg-opacity-25">
<h2>Select the Candidate you want to vote</h2>
	<form action="uservote" method="post">
	<%
	List<Candidate> cl=(List<Candidate>)request.getAttribute("cl");
	
	if(cl!=null){
		for(Candidate c:cl){
	%>
		<input type="radio" class="vote form-check-input" name="entervote" value="<%=c.getName() %>">
		<label class="form-check-label"><%=c.getName() %></label><br><br>
	<%		
		}
	}
	%>
	<input type="hidden" name="uname" value="<%=check%>">
	<br>
	<button class="btn btn-success">submit</button>
	</form>
	</div>
</div>
<%}else {
	response.sendRedirect("userlogin.jsp");
}
%>
	<script type="text/javascript">
    // Example: Validate if a radio button is selected
    document.querySelector("form").onsubmit = function(event) {
        var radios = document.querySelectorAll('input[name="entervote"]');
        var selected = Array.from(radios).some(radio => radio.checked);
        if (!selected) {
            alert("Please select an option before submitting.");
            event.preventDefault();
        }
    };
</script>


</body>
</html>