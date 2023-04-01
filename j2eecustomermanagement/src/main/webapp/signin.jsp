<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SIGNIN</title>
</head>
<body style="background-color: lime;">

<form action="CustomerController" method="get">

<input type="hidden" name="action" value="signin">

<%
    if(null!=request.getAttribute("message"))
    {
        out.println(request.getAttribute("message"));
    }
%>

<br><br>

Email<input type="text" name="custemailid"><br>
Password<input type="password" name="custpassword"><br>

<input type="submit" value="SignIn">
</form>

</body>
</html>