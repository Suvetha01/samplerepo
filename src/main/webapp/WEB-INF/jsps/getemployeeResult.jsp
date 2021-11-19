<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightpink">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<div align="center">

<h1>Employee Detail</h1>

<h1>${resultEmp }</h1>

<c:set var="emp" value="${resultEmp }" />
	
	<c:if test="${emp eq null  }">
	
		<h1>Record does not exist</h1>
	
	</c:if>
	
	<c:if test="${emp ne null }">
	 
		<h3>Id: <c:out value="${emp.id }" /> </h3>
	 	<h3>Name: <c:out value="${emp.name }" /> </h3>
	 	<h3>Salary: <c:out value="${emp.marks }" /> </h3>
	 
	</c:if>

	
<form action="getemployee.jsp" method="post">
	<input type="submit" value="Employee Fetch"> <br><br>


</form>
</div>
</body>
</html>