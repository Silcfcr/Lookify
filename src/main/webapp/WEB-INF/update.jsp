<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="flex-container">
		<div>
			<a href="/delete/${language.id}">Delete</a>
			<a href="/languages">Dashboard</a>
		</div>
		<div>
			<form:form action="/update/${song.id}" method="POST" modelAttribute="song">
				<div>
					<c:out value="${errorMessage}"></c:out>
				</div>
			        <div class="form-group">
			            <form:label path="title">Name:</form:label>
			            <form:errors path="title"/>
			            <form:input class="form-control" type="text" path="title"/>
			            
			        </div>
			        <div class="form-group">
			            <form:label path="artist">Creator:</form:label>
			            <form:input class="form-control" path="artist" type="artist"/>
			            <form:errors path="artist"/>
			        </div>
			        <div class="form-group">
			            <form:label path="rating">Version:</form:label>
			            <form:input class="form-control" path="rating" type="text"/>
			            <form:errors path="rating"/>
			        </div>
			        <div>
			            <button class="btn btn-dark" type="submit">Add new song</button>
			        </div>
    			</form:form>Ï
		</div>
	    
	    
	</div>
</body>
</html>