<!DOCTYPE html>
<html>
<head>
	<title>Profile</title>
	<link href="https://fonts.googleapis.com/css2?family=Exo:wght@500&family=Signika:wght@400;700&family=Trispace&display=swap" rel="stylesheet"><!-- h1 -->
	<link href="https://fonts.googleapis.com/css2?family=Trispace&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Signika:wght@700&family=Trispace&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Ropa+Sans&family=Viga&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Chivo&family=Ropa+Sans&family=Viga&display=swap" rel="stylesheet">
	<!-- <link rel="stylesheet" type="text/css" href="static/css/profile1.css"> -->
	<link rel="stylesheet" href="static/css/header.css">
	<link rel="stylesheet" href="static/css/searchbar.css">
	<!-- <link rel="stylesheet" href="static/css/full_page_scroll.css"> -->
	<link rel="stylesheet" href="static/css/footer2.css">
	<link rel="stylesheet" type="text/css" href="static/css/profile.css">
	<script src="https://kit.fontawesome.com/65f7cfda7c.js" crossorigin="anonymous"></script>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="container" id="blur">
				

		<div class="leftbox">
			
			<nav>
				
				<a class="tab pic">
					<img src="showprofpic.do" class="propic" onclick="toggle()">
				</a>



				<a onclick="tabs(0)" class="tab active">
					<i class="fas fa-user-circle"></i>
				</a>
				<!-- 
				<a onclick="tabs(1)" class="tab">
					<i class="fas fa-map-marked-alt"></i>	
				</a> -->
				
				<a onclick="tabs(1)" class="tab">
					<i class="fas fa-crown"></i>
				</a>
				<!-- <a onclick="tabs(2)" class="tab">
					<i class="fas fa-book-reader"></i>
				</a> -->
				
			</nav>

		</div>

		<div class="rightbox">
			
			<div class="profile tabshow">
				<span class='h1'>Personal Info</span>
				<form id="profileF" action="profile.do" method="POST">
					<h2>First Name</h2>
					<input type="text" class="input" name="firstName" value="${user.firstName}" required>
				
					<h2>Middle Name</h2>
					<input type="text" class="input" name="middleName" value="${user.middleName}" required>
					
					<h2>Last Name</h2>
					<input type="text" class="input" name="lastName" value="${user.lastName}" required>

					<h2>Date Of Birth</h2>
					<input type="date" class="input"  name="dob" value="${user.dob}" required>

					<h2>Mobile Number</h2>
					<input id="mobile" type="Number" class="input"  name="mobile" value="${user.mobile}" required>

					<input type="hidden" name="otp" id="otp1">

					<input type="submit" class="btn" value="Update">
				</form>
			</div>

			<div class="subscription tabshow">
				<span class='h1'>Subscription Info</span>
				
				
				<c:if test="${mempurchase != null}">


					<img src="static/images/profile/member/${mempurchase.membership.membershipId}.png" height="190px" style="margin-bottom: 20px ">

					<h2>Purchase Date</h2>
					<p>${mempurchase.purchaseDate}</p>

					<h2>Expire Date</h2>
					<p>${mempurchase.expireDate}</p>
				
					<h2>Charge</h2>
					<p>${mempurchase.membership.price}<span>includes tax.</span></p>
					
					<h2>CEDITS left</h2>
					<p>${mempurchase.credits}</p>
				</c:if>
				

				<c:if test="${mempurchase == null}">
				
					<img src="static/images/profile/sad.gif" height="190px" style="margin-bottom: 20px ">

					<h2>No Membership Yet</h2>
				</c:if>				

			</div>
			
		</div>

		
	</div>
	<div class="footer">
		<%@ include file="footer.jsp" %>
	</div>
	<div id="popup">
		<p style="margin-bottom: 30px">Click on Picture</p>
		<form action="profilepic.do" method="post" enctype="multipart/form-data">
			<input onchange="previewImg(event)" class="inppic" type="file"  accept="image/*" name="ufile">
			<input type="submit" class="btn sub" name="asd">
		</form>
		<br>
		 <img src="static/images/profile/close.png" class="close" onclick="toggle()">
	</div>

	<div id="popup1">
		<p style="margin-bottom: 30px" id="popotp">OTP Verification</p>
			<input type="number" id="otp2" name="otp" style="width: 130px" class="input" placeholder="Enter OTP" maxlength="6" minlength="6" required>
			<input type="submit" value="SUBMIT" style="margin:20px auto;" class="btn" onclick="OTP()">	
		
		<br>
		 <img src="static/images/profile/close.png" class="close1" onclick="poggle()">
	</div>

	<script>
		const tabBtn = document.querySelectorAll('.tab');
		const tab = document.querySelectorAll('.tabshow');	
		const inppic = document.querySelector('.inppic');
		const picbtn = document.querySelector('.sub');
		const piclose = document.querySelector('.close');
		const profileForm = document.getElementById("profileF");
		const mobile = document.getElementById('mobile').value;
		var respotp;

		function tabs(panelIndex){
				tab.forEach((node)=>{node.style.display="none";});
				tabBtn.forEach((node)=>{node.classList.remove('active');});
				tab[panelIndex].style.display = "block";
				tabBtn[panelIndex + 1].classList.add('active');
			}	
			tabs(0);
		
		function previewImg(event) {
			 if(inppic.files[0].size > 500000){
		       alert("File is too big!");
		       this.value = "";
    		}else{
    			 var reader = new FileReader();
				 reader.onload = function()
				 {
				  inppic.style.backgroundImage = 'url('+reader.result+')';
				 }
				 reader.readAsDataURL(event.target.files[0]);
				 picbtn.style.display = "block";
				 piclose.style.top = "-400px";
    		}
		}

		function toggle(){
			var blur= document.getElementById('blur');
			blur.classList.toggle('active');
			var popup=document.getElementById('popup');
		    popup.classList.toggle('active');
		}

		function poggle(){
			var blur= document.getElementById('blur');
			blur.classList.toggle('active');
			var popup1=document.getElementById('popup1');
		    popup1.classList.toggle('active');
		}


		const sendOTP = async () => {
			const response = await fetch('sendotp.do?mobile='+mobile);
			const data = await response.json();
			return data;
		};


		profileF.addEventListener('submit',(e)=>{
			e.preventDefault();
			sendOTP().then((data)=>{console.log(data);
													 respotp = data;})
										.catch((err)=>{console.log(err)});
			var blur= document.getElementById('blur');
			blur.classList.toggle('active');
			var popup1=document.getElementById('popup1');
		    popup1.classList.toggle('active');	
		});

		function OTP() {
			const otp1 = document.getElementById("otp1");
			const otp2 = document.getElementById("otp2");
			if(otp2.value.length == 6){
				console.log(respotp+"&&&&&&"+otp2.value);
				if(respotp == otp2.value){
					otp1.value = otp2.value;
					profileF.submit();	
				}else
					popotp.innerHTML = 'Wrong OTP';
			}else{
				otp2.value = "";
				popotp.innerHTML = 'Wrong OTP 1';
			}
		}
	</script>
</body>
</html>