<%@page import="com.Model.Candidate"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<title>Insert title here</title>
<style type="text/css">
body {
	text-align: center;
	background-color: cadetblue;
}
td{
color: black;
}
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>

<%
String check=(String)request.getAttribute("check");
if(check!=null)
{
%>
<div class="container w-50 mt-1">
<div class="container-fluid border border-black p-4 bg-primary p-2 text-light bg-opacity-25">
<h2>Candidate information</h2>
<form action="candidateinfo" class="w-30">
	<label class="form-label">Enter candidate Name</label><br>
	<input type="text" class="form-control" name="cname"><br>
	
	<label class="form-label">Enter age</label><br>
	<input type="text" class="form-control" name="cage"><br><
	
	<label class="form-label">Enter city</label><br>
	<input type="text" class="form-control" name="ccity"><br>
	
	<input type="hidden" name="votes" value="0">
	
	<button class="btn btn-success">submit</button>
</form>

<%
}else{
	response.sendRedirect("Adminlogin.jsp");
}
%>
</div>
</div>
<br>

<div class="container w-50">
<div class="container-fluid bg-primary p-2 text-light bg-opacity-25">
<table class="">
  <tr>
    <th>candidate name</th>
    <th>age</th>
    <th>City</th>
    <th>votes</th>
  </tr>
<%
List<Candidate> cl=(List<Candidate>)request.getAttribute("cl");
if(cl!=null){
	for(Candidate c:cl){
%>
	<tr>
	    <td><%=c.getName() %></td>
	    <td><%=c.getAge() %></td>
	    <td><%=c.getCity() %></td>
	    <td><%=c.getVotes() %></td>
  </tr>
<%		
	}
}
%>
</table>
</div>
</div>
</body>
</html>