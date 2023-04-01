<%@page import="com.csi.service.CustomerServiceImpl"%>
<%@page import="com.csi.service.CustomerService"%>
<%@page import="com.csi.model.Customer"%>

<%@page import="java.text.SimpleDateFormat"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User</title>
</head>
<body>
<%
	Customer customer = new Customer();
%>
<%
	CustomerService customerServiceImpl = new CustomerServiceImpl();
%>
<form method="GET" action='CustomerController' name="frmEditUser"><input
	type="hidden" name="action" value="edit" /> <%
 	String uid = request.getParameter("custid");
 	if (!((uid) == null)) {
 		int id = Integer.parseInt(uid);
 		customer = customerServiceImpl.getDataById(id);
 		

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dob = simpleDateFormat.format(customer.getCustDOB());
 %>
<table>
	<tr>
		<td>Customer Id</td>
		<td><input type="text" name="custid" readonly="readonly"
			value="<%=customer.getCustId()%>"></td>
	</tr>
	<tr>
		<td>Customer Name</td>
		<td><input type="text" name="custname" value="<%=customer.getCustName()%>"/></td>
	</tr>
	
	<tr>
		<td>Customer Address</td>
		<td><input type="text" name="custaddress" value="<%=customer.getCustAddress()%>"/></td>
	</tr>
	
	<tr>
		<td>Customer Contact Number</td>
		<td><input type="text" name="custcontactnumber" value="<%=customer.getCustContactNumber()%>"/></td>
	</tr>
	
	<tr>
		<td>Customer Age</td>
		<td><input type="text" name="custage" value="<%=customer.getCustAge()%>"/></td>
	</tr>
	
	
	<tr>
		<td>Customer Acc Balance</td>
		<td><input type="text" name="custaccountbalance" value="<%=customer.getCustAccountBalance()%>"/></td>
	</tr>
	
	<tr>
		<td>Customer Gender</td>
		<td><input type="text" name="custgender" value="<%=customer.getCustGender()%>"/></td>
	</tr>
	
	<tr>
		<td> Customer DOB</td>
		<td><input type="text" name="custdob" value="<%=dob%>"/></td>
	</tr>
	
	<tr>
		<td>Customer Email</td>
		<td><input type="text" name="custemailid" value="<%=customer.getCustEmailId()%>"/></td>
	</tr>
	
	<tr>
		<td>Customer Password</td>
		<td><input type="text" name="custpassword" value="<%=customer.getCustPassword()%>"/></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Update" /></td>
	</tr>
</table>
<%
	} else
		out.println("ID Not Found");
%>
</form>
</body>
</html>