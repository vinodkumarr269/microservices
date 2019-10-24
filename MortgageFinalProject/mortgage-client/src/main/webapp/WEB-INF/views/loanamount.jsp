<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form action="/approveloan" method = "post">
	<table border="2" id = "customers">
		<tr>
			<th>Available Loan Amount For Your Property</th>
			<td><input type = "text" name = "loanamount" readonly="readonly" value = "${loanamount}" /></td>
		</tr>
		<tr>
			<th>Enter Required Amount</th>
			<td><input type = "text" name = "requiredamount" placeholder="Enter Amount"/></td>
		</tr>
		<tr>
			<td><input type = "submit" value = "Confirm" /></td>
			<td><input type = "button" value = "Deny" id = "Deny" onclick="deny()"/></td>
		</tr>
	</table>
</form>
</div>
</body>
</html>
