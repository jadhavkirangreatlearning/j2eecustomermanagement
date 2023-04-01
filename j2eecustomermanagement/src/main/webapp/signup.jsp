<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SIGNUP</title>
</head>
<body style="background-color: orange">
<form action="CustomerController" method="get" style="text-align: center;">

<input type="hidden" name="action" value="signup">

Id<input type="text" name="custid"><br>
Name<input type="text" name="custname"><br>
Address<input type="text" name="custaddress"><br>
Contact Number<input type="text" name="custcontactnumber"><br>
Age<input type="text" name="custage"><br>
Account Balance<input type="text" name="custaccountbalance"><br>
Gender<br>
Male<input type="radio" name="custgender" value="Male"><br>
Female<input type="radio" name="custgender" value="Female"><br>
DOB<input type="text" name="custdob"><br>
Email<input type="text" name="custemailid"><br>
Password<input type="password" name="custpassword"><br>
<input type="submit" value="Signup" >
</form>
</body>
</html>