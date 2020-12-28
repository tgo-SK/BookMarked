<!doctype html>
<html lang="en">
	<head>
		<title>Home</title>
		<link rel="stylesheet" href="static/css/sliding_images.css">
		<link rel="stylesheet" href="static/css/category.css">
		<link rel="stylesheet" href="static/css/full_page_scroll.css">
		<link rel="stylesheet" href="static/css/footer2.css">
		<style>
			#popup
			{
			font-size: 23px;
			position: fixed;
			top: 40%;
			left: 50%;
			transform: translate(-50%,-50%);
			width: 400px;
			padding: 50px;
			box-shadow: 0 5px 30px rgba(0,0,0,.30);
			background: #fff;
			visibility: hidden;
			opacity: 0;
			transition: 0.5s;
			}
			#popup.active{
			border-radius: 5px;
			top: 50%;
			height: 150px;
			visibility: visible;
			opacity: 1;
			transition: 0.5s;
			}

			#blur.active{
			filter: blur(20px);
			pointer-events: none;
			user-select: none;
			}

			.close{
				position: relative;
				width: 30px;
				height: 30px;
			    top: -137px;
			    right: -313px;
			}
			.close:hover{
				cursor: pointer;
			}		
		</style>
	</head>
	<body>	
		<div class="container" id="blur">
		
			<%@ include file="header.jsp" %>

			<div class="section">
				<%@ include file="sliding_images.jsp" %>
			</div>

			<div class="section">
				<%@ include file="membership.jsp" %>				
			</div>

			<div class="section">
				<%@ include file="category1.jsp" %>				
			</div>
			
			<%@ include file="footer.jsp" %>
		</div>
		<c:if test="${popup != null}">
			<div id="popup">
				<p style="margin-bottom: 30px">${popup}</p>
				 <img src="static/images/profile/close.png" class="close" onclick="toggle()">
			</div>
		</c:if>

		<script>
			function toggle(){
				var blur= document.getElementById('blur');
				blur.classList.toggle('active');
				var popup=document.getElementById('popup');
				popup.classList.toggle('active');				
			}

			<c:if test="${popup != null}">
				toggle();
			</c:if>
		</script>
		<script src="static/js/sliding_images.js"></script>
	</body>
</html>
