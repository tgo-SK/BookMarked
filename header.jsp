<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
	<head>
		<title>Document</title>
		<link rel="stylesheet" href="static/css/header.css">
		<link rel="stylesheet" href="static/css/searchbar.css">
	</head>
	<body>
		<div class="header">
			<div class="logo">
				<img src="static/images/header-images/BookMarked.png" height="80px" width="220px">
			</div>

			<div class="header-items">
				<ul>
					<c:if test="${user.userType.userTypeId == 2}">
						<a href="adminhome.do"><li>Admin</li></a>
						<a href="newprod.do"><li>Add New Book</li></a>
						<a href="allBooks.jsp"><li>View All Books</li></a>
						<a href="modify.do"><li>Edit Books</li></a>
					</c:if>
					<c:if test="${user.userType.userTypeId != 2}">
						<a href="home.do"><li>Home</li></a>
						<a href="allBooks.jsp" id="ts"><li>All Books</li></a>
						<a href="Aboutus.jsp"><li>About Us</li></a>	
						<a href="contact.do"><li>Contact Us</li></a>	
						<a href="recentbook.do"><li>Recent Books</li></a>	
					</c:if>
				</ul>
			</div>

			<div class="searchbar">
				<input type="text" name="searchBook" id="search" class="search-field" placeholder="Search">
				<input type="checkbox" id="search-check" style="display:none">
				<div class="search-img">
					<img src="static/images/header-images/search.png" height="40px" width="40px" id="simg">
				</div>
			</div>
			<c:if test="${user.userType.userTypeId == 1}">
				<div class="my-account">
					<select class="user_dropdown">
						<option style="display:none">${user.userName}</option>
						<option id="profile">My Profile</option>
						<option id="signout">SignOut</option>
					</select>
				</div>
			</c:if>
			<c:if test="${user.userType.userTypeId == 2}">
				<div class="my-account">					
					<select class="user_dropdown">
						<option style="display:none">${user.userName}</option>						
						<option id="signout">SignOut</option>
					</select>
				</div>
			</c:if>
		</div>
		<script src="static/js/searchbar.js"></script>
	</body>
</html>