<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<div class="row justify-content-center">
			<div class="col-10">
				<a href="/addSong">Add Song</a>
				<a href="/topSongs">Top Songs</a>
				<form action="/getArtist" method="POST">
					<input type="text" name="searchedArtist" id="searchedArtist">
					<label for="searchedArtist">Search Artist</label>
				</form>
				
			</div> 
		</div>
		
		<div class="row justify-content-center">
			<div class="col-10">
				<table class="table">
			        <thead>
			            <tr>
			                <th scope="col">Name</th>
			                <th scope="col">Artist</th>
			                <th scope="col">Rating</th>
			                <th scope="col">Actions</th>
			            </tr>
			        </thead>
			        <tbody>
			        	<c:forEach items="${songs}" var="song">
			            <tr>
			                <td>
			                	<a href="/show/${song.id}">
			                		<c:out value="${song.title}"></c:out>
			                	</a>
			                </td>
			                <td><c:out value="${song.artist}"></c:out></td>
			                <td><c:out value="${song.rating}"></c:out></td>
			                <td><a href="/update/<c:out value="${song.id}"></c:out>">Update</a><a href="/delete/<c:out value="${song.id}"></c:out>">Delete</a> </td>
			            </tr>
			            </c:forEach> 
			        </tbody>
			    </table>
		    </div>
		</div>
</div>
</body>
</html>