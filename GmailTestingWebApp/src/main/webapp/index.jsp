<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style=" text-align: center;">GmailTesting logs</h1>
	<table class="table table-inverse">
		<thead>
			<tr>
				<th>#</th>
				<th>Thread name</th>	
				<th>Date</th>
				<th>Level</th>
				<th>Class name</th>
				<th>Line number</th>
				<th>Method name</th>
				<th>Message</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="lineNumber" value="1" scope="page" />
			<c:forEach items="${myList }" var="account" varStatus="count">
				<tr>					
					<td>${count.count }</td>
					<td>${account.threadName }</td>

					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${account.date }" /></td>

					<td>${account.level }</td>
					<td>${account.className }</td>
					<td>${account.lineNumber }</td>
					<td>${account.methodName }</td>	
					<td>${account.message }</td>							
				</tr>
			</c:forEach>
			<tr class="table-active">
			</tr>
			<tr class="table-success">
			</tr>
		</tbody>
	</table>
</body>
</html>