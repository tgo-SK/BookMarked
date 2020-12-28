<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Sign-In</title>
		<link rel="stylesheet" href="static/css/signin.css"/>
		<script src="https://www.google.com/recaptcha/api.js" async defer></script>
	</head>

	<body>
		<div class="backg">
			<img class="bckimg" src="static/images/signin-images/back2.jpg">
			<div class="container-background"></div>
			<!--container---------------------->
			<div class="container">
				<!--sign-up-box-container--->
				<div class="sign-up">
					<!--heading-->
					<h1 class="heading">Hello!!!</h1>
					<!--name-box-->
					<form action="login.do" id="form" method="post">
						<div class="text">
							<img src="static/images/signin-images/user.png" height="20px"/>
							<input type="text" name="unm_email" id="name" placeholder="UserName or Email"  maxlength="30" minlength="5" />
						</div>

						<div class="text">
							<img src="static/images/signin-images/password.png" height="20px"/>
							<input type="password" name="password" id="pass" placeholder="Password" minlength="6" maxlength="12" />
						</div>

						<div align='center' class="g-recaptcha" data-sitekey="6Le0w9QZAAAAAISl5pKEdFobekKqH6pmPcH-9bzC">
						</div>
						<!--button-->
						<button class="_submit">SIGN IN</button>
					</form>
					<!--sign-in-->
					<p class="conditions">Don't have an account <a href="signup.do">Sign Up</a></p>
				</div>
				<!--text-container-->
				<div class="text-container">
						<h1 style="font-family:arial; color:#2d2c2c; line-height:20px;">Nice to see you Again</h1>
					<p style="font-size:17px">Please SignIn</p>
					<p id="err">${errmsg}</p>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="static/js/signin.js">
		</script>
		<script>
			var str = document.getElementById("err").innerHTML;
			setTimeout(()=>{if(str != '')
			alert(str);}, 1000);
		</script>
	</body>
</html>
