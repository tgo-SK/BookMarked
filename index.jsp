<!DOCTYPE html>
<html>
	<head>
		<title>Landing Page</title>
		<link rel="stylesheet" href="static/css/landing-css/top.css">
		<link rel="stylesheet" href="static/css/landing-css/middle.css">
		<link rel="stylesheet" href="static/css/landing-css/clouds.css">
		<link rel="stylesheet" href="static/css/landing-css/scrollbar.css">
		<link rel="stylesheet" href="static/css/landing-css/full-page-scroll.css">
		<link rel="stylesheet" href="static/css/footer.css">
		<link href="https://fonts.googleapis.com/css2?family=Londrina+Solid:wght@300&family=Noto+Sans+TC:wght@700&family=Oleo+Script:wght@400;700&family=Open+Sans&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css2?family=Londrina+Solid:wght@300&family=Noto+Sans+TC:wght@700&family=Open+Sans&display=swap" rel="stylesheet">
    </head>
	<body>
		<div class="container">
			<div class="section">
				<div id="top">
				<img src="static/images/p.png" class="bottom-clouds">
				</div>

				<div id="landing" class="banner">

					<div class="slideshow-container">
						<div class="mySlides fade">
							<img src="static/images/landing-images/face1.png" height="700px" width="90%">
						</div>
						<div class="mySlides fade">
							<img src="static/images/landing-images/face2.png" height="700px" width="75%">
						</div>
						<div class="mySlides fade">
							<img src="static/images/landing-images/face3.png" height="700px" width="70%">
						</div>
					</div>
					
					<div id="clouds">
						<img src="static/images/landing-images/cloud1.png" style="--i:1">
						<img src="static/images/landing-images/cloud2.png" style="--i:2;">
						<img src="static/images/landing-images/cloud3.png" style="--i:3;">
						<img src="static/images/landing-images/cloud4.png" style="--i:4;">
						<img src="static/images/landing-images/cloud5.png" style="--i:5;">
						<img src="static/images/landing-images/cloud1.png" style="--i:6">
						<img src="static/images/landing-images/cloud2.png" style="--i:7;">
						<img src="static/images/landing-images/cloud3.png" style="--i:8;">
						<img src="static/images/landing-images/cloud4.png" style="--i:9;">
						<img src="static/images/landing-images/cloud5.png" style="--i:10;">
					</div>

					<div class="title">
						<h1>BookMarked</h1><br>
						<q>Good friends, good books, and a sleepy conscience: this is the ideal life.</q><br>
						<h2>Mark Twain</h2><br><br>
						<a href="login.do" class="btn">Log In</a>
						<a href="signup.do" class="btn">Sign Up</a>
					</div>

				</div>
			</div>
			
			<div class="section">
				<div id="middle" class="background">
					
					<div id="ob1" class="ob">
						<img src="static/images/landing-images/i1.png" id="b1">
						<div id="arrowAnim">
						  <div class="arrowSliding">
							<div class="arrow"></div>
						  </div>
						  <div class="arrowSliding delay1">
							<div class="arrow"></div>
						  </div>
						  <div class="arrowSliding delay2">
							<div class="arrow"></div>
						  </div>
						  <div class="arrowSliding delay3">
							<div class="arrow"></div>
						  </div>
						</div>
						<p>Click the Image to View E-Books</p>
					</div>
					<div id="ob2" class="ob">
						<p>Click the Image to View Audio-Books</p>
						<div id="arrowAnim1">
						  <div class="arrowSliding1">
							<div class="arrow1"></div>
						  </div>
						  <div class="arrowSliding1 delay11">
							<div class="arrow1"></div>
						  </div>
						  <div class="arrowSliding1 delay21">
							<div class="arrow1"></div>
						  </div>
						  <div class="arrowSliding1 delay31">
							<div class="arrow1"></div>
						  </div>
						</div>
						<img src="static/images/landing-images/i2.png" id="b2">
					</div>

					<h1 id="overview">OVERVIEW</h1>

					<div id="ob3" class="ob">
						<img src="static/images/landing-images/i3.png" id="b3">
						<p>Memberships</p>
					</div>
					<div id="ob4" class="ob">
						<img src="static/images/landing-images/i4.png" id="b4">
						<p>Categories</p>
					</div>		
					<div id="ob5" class="ob">
						<img src="static/images/landing-images/i5.png" id="b5">
						<p>Profile</p>
					</div>
				</div> 
			</div>

			<div class="section">
				<%@ include file="footer.jsp" %>
			</div>
		</div>
		<div id="progressbar"></div>

		<script src="static/js/moving_images.js"></script>
		<script src="static/js/scrollbar.js"></script>
	</body>
</html>
