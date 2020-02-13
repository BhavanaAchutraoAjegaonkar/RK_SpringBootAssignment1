<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form modelAttribute="prodModel" action="handleForm">
	
		Product Name: <form:select path="prodName">
	    <form:options items="${listProds }" />
	</form:select> <br>
	
	Select Product:
	<form:checkboxes items="${listProds }"  path="prodName"/> <br>
	
	Select One Product:
	<form:radiobuttons path="prodName" items="${listProds }"/> <br>
	
	Date: <form:input path="date"/> <br>
	
	<button type="submit">Submit</button>

	

</form:form>
  


</body>
</html>