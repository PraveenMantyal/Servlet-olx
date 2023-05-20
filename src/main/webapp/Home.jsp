<%@page import="dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<h1 align="center" >Welcome to buy_Sell</h1>
<div align="center" style="border: 5px solid red" >

<%
Customer customer=(Customer)session.getAttribute("customer");
if(customer==null)
{
%>
<a href="Login.html" ><button>Login</button></a><br><br>
<a href="Signup.html"><button>Signup</button></a><br><br>
<%} %>

<a href="buy"><button>Buy</button></a><br><br>
<a href="sell"><button>Sell</button></a><br><br>
<%
Customer customer1=(Customer)session.getAttribute("customer");
if(customer1!=null)
{
%>
<a href="logout"><button>Logout</button></a><br><br>
<%} %>
</div>
</body>
</html>