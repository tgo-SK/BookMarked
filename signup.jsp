<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Sign-Up</title>
		<link rel="stylesheet" href="static/css/signup.css"/>
		
	</head>

	<body>
		<div class="backg">
			<img class="bckimg" src="static/images/signup-images/back2.jpg">
			<div class="container-background"></div>
			<!--container---------------------->
			<div class="container">
				<!--sign-up-box-container--->
				<div class="sign-up">
					<!--heading-->
					<h1 class="heading">SignUp</h1>
					<!--name-box-->
					<form action="signup.do" id="form" method="post">
						<div class="text">
							<img src="static/images/signup-images/user.png" height="20px"/>
							<input type="text" name="name" id="name" placeholder="Name"/>
							<img src="static/images/signup-images/green_tick.png" height="20px" id="uimg">
						</div>
						
						<!--Email-box-->
						<div class="text">
							<img src="static/images/signup-images/email.png" height="12px"/>
							<input type="email" name="email" id="email" placeholder="Example@gmail.com"/>
							<img src="static/images/signup-images/green_tick.png" height="20px" id="eimg">
						</div>
						<!--Password-box-->
						<div class="text">
							<img src="static/images/signup-images/password.png" height="20px"/>
							<input type="password" name="password" id="pass" placeholder="Password"/>
							<img src="static/images/signup-images/green_tick.png" height="20px" id="pimg">
						</div>
						<!--rePassword-box-->
						<div class="text">
							<img src="static/images/signup-images/password.png" height="20px"/>
							<input type="password" name="repassword" id="repass" placeholder="Confirmation Password"/>
							<img src="static/images/signup-images/green_tick.png" height="20px" id="rpimg">
						</div>
						<!--trems-->
							<!-- <div class="trems">
							<input type="checkbox">
							<p class="conditions">I read and agree to <a href="#">Trems & Conditions</a></p>
							</div> -->
						<div align='center' class="g-recaptcha" data-sitekey="6Le0w9QZAAAAAISl5pKEdFobekKqH6pmPcH-9bzC">
						</div>
						<!--button-->
						<button class="_submit">CREATE ACCOUNT</button>
					</form>
					<!--sign-in-->
					<p class="conditions">Already have an account <a href="login.do">Sign in</a></p>
				</div>
				<!--text-container-->
				<div class="text-container">
					<h1 style="font-family:arial; color:#2d2c2c; line-height:20px;">Glad to see you</h1>
					<p>Welcome,Please Fill in the blanks for sign up</p>
					<p id="err">${errmsg}</p>
			</div>
		</div>
		<script type="text/javascript" src="static/js/signup.js"></script>
		<script src="https://www.google.com/recaptcha/api.js" async defer></script>
		<script>
			var str = document.getElementById("err").innerHTML;
			setTimeout(()=>{
				if(str != '')
				alert(str);}, 1000);
		</script>
	</body>
</html>
