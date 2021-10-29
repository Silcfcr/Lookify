<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="row justify-content-center">
			<div class="col-5">
				<h1> Add a new song!</h1>
				<form:form class="form" action="/newSong" method="POST" modelAttribute="song">
			    	<div>
						<c:out value="${errorMessage}"></c:out>
					</div>
			        <div class="form-group">
			            <form:label path="title">Name:</form:label>
			            <form:errors path="title"/>
			            <form:input class="form-control" type="text" path="title"/>
			            
			        </div>
			        <div class="form-group">
			            <form:label path="artist">Artist:</form:label>
			            <form:input class="form-control" path="artist" type="artist"/>
			            <form:errors path="artist"/>
			        </div>
			        <div class="form-group">
			            <form:label path="rating">Rating:</form:label>
			            <form:input class="form-control" path="rating" type="text"/>
			            <form:errors path="rating"/>
			        </div>
			        <div>
			            <button class="btn btn-dark" type="submit">Add new song</button>
			        </div>
    			</form:form>
				
		    </div>
		</div>

</body>
</html>