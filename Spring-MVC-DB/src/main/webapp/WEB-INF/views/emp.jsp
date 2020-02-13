<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib  uri="http://java.sun.com/jstl/core_rt" prefix="c" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>




<form action="viewEmployee" method="post">

<c:forEach var ="employee"  items="${viewEmployee}">

<table>
	<tr>
	<td>${employee.empId}</td>
	<td>${employee.empName}</td>
	<td>${employee.empName}</td>
	<td>${employee.dob}</td>
</table>
</c:forEach>















</form>
</body>
</html>