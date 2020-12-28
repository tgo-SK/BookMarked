<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Book Description</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="static/css/ProductDescription.css">
	<link rel="stylesheet" href="static/css/full_page_scroll.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
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
	<div class="bd" id="blur">
		<div class="hd">
			<%@ include file="header.jsp" %>
		</div>
		
		<div class = "card-wrapper">
			<div id="bookid" style="display:none;">${bookdesc.bookId}</div>	
			<div class = "card">
				<!-- card left -->			
				<div class = "img-display">
					<div class = "img-showcase">
					<img id="big-image" class="bookimg" src="bookpic.do?bookId=${bookdesc.bookId}" alt="">
					</div>
				</div>

				<!-- card right -->
				<div class = "product-content">
					<h2 class = "product-title">${bookdesc.title}</h2>
					<h2 class = "product-title1">BY:${bookdesc.author}</h2>
			  
			 
					<div class = "product-rating"></div>

					<div class = "product-price">
						<p class = "new-price">New Price:&nbsp; &nbsp;Rs &nbsp;<span id="newp">${bookdesc.price}</span></p>
						<p class = "last-price">Old Price:&nbsp;	&nbsp;Rs&nbsp;&nbsp;<span id="oldp">1800</span></p>				
					</div>
			  
			  
					<div class = "purchase-info">			  
						<button type="button" class="btn" id="buy-button" onclick="buyNow(${bookdesc.bookId})">
						  BUY NOW
						</button>
						<c:if test="${mempurchase != null}">
							<button type="button" class="btn" id="mem-button" onclick="buycredits(${bookdesc.bookId})">
							  USE CREDITS
							</button>
						</c:if>
					</div>

					<div class = "product-detail">				
						<ul id="bookpoints">
						<!-- <li>Shipping Fee: <span>Free</span></li> -->
						</ul>				
						<h2>about this item: </h2>
						<p>${bookdesc.description}</p>
					</div>

				</div>
			</div>
		</div>
	</div>

	<div id="popup">
		<p style="margin-bottom: 30px" id="popupText"></p>
		<img src="static/images/profile/close.png" class="close" onclick="toggle()">
	</div>

	<script src="static/js/productDescription.js"></script>
  </body>
</html>