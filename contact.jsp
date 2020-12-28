<!doctype html>
<html>
<head>
<meta name="viewport" content="width=device-width, intial-scale=1.0">
<title>Contact Us</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
  <link rel="stylesheet" href="static/css/contact.css">
  <link rel="stylesheet" href="static/css/header.css">
  <link rel="stylesheet" href="static/css/searchbar.css">
  <link rel="stylesheet" href="static/css/footer2.css">
  <link rel="stylesheet" href="static/css/full_page_scroll.css">
</head>
<body>
	<div class="container">
		<%@ include file="header.jsp" %>
		<div class="section">			
			<section class ="contact1">
				<div class="content1">
					<h2>Contact Us</h2>
					<P> Hello! Welcome To The BookMarked ,We Would Love To Respond To Your Queries And Help You Succeed.Feel Free To Get In Touch With Us.</p>
				</div>
				<div class="container1">
					<div class="contactinfo">
						<div class="box">
							<div class="icon"><i class="fa fa-map-marker" aria-hidden="true"></i></div>
							<div  class="text">
							<h3> Address</h3> 
							<p>4671 MR4 road ,<br>Jabalpur,Madhya Pradesh,<br>482004</p>
							</div>
						</div>

						<div class="box">
							<div class="icon"><i class="fa fa-phone" aria-hidden="true"></i></div>
							<div  class="text">
							<h3>Phone</h3> 
							<p>0761 24444432, 45333321</p>
							</div>
						</div>

						<div class="box">
							<div class="icon"><i class="fa fa-envelope" aria-hidden="true"></i></div>
							<div  class="text">
							<h3> Email</h3> 
							<p>Incompatibletypeags@gmail.com</p>
							</div>
						</div>
					</div>
					<div class="contactform">
						<form action="contact.do" method ="post">
							<h2>Send Message</h2>
							<div class="inputBox">
									<input type="text" name="name" required="required">
									<span> Full Name</span>
							</div>
							<div class="inputBox">
									<input type="email" name="email" required="required">
									<span>Email</span>
							</div>
							<div class="inputBox">
								   <textarea required="required" name="message"></textarea>
									<span>Type Your Message...</span>
							</div>

							<div class="inputBox" >
							<input type="submit" value="Send">
							</div>
						</form>
					</div>

				</div>
			</section>
		</div>
		<%@ include file="footer.jsp" %>
	</div>
	<script src="static/js/searchbar.js"></script>
</body>
</html>