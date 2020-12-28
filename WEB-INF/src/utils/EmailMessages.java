package utils;

public class EmailMessages{
	public static String getAccountActivationMail(String userName, String activationCode){
		String accountActivationMessage = 
					 "<!doctype html>"+
						"<html lang='en'>"+
						 "<head>"+
						  "<meta charset='UTF-8'>"+
					  "<style>"+
			       			"#container{"+
							"background-color:#663300;"+
							"height: 500px;"+
							"padding-top: 50px;"+
							"font-family: 'Trispace', sans-serif;"+
						"}"+
						"#header{"+
							"background-color: white;"+
							"padding-top: 5px;"+
							"padding-bottom: 5px;"+
							"text-align: center;"+
						"}"+
						"#logo{"+
							"height: 100px;"+
							"width: 280px;"+
						"}"+
						"#msg{"+
						    "text-align: center;"+
							"font-family:Arial;"+
							"font-size: 30px;"+
							"padding: 20px 50px;"+
							"color: white;"+
						"}"+
						"#link{"+
						"border: 2px solid white;"+
						"height: 60px;"+
					    "width: 350px;"+
						"cursor:pointer;"+
						"border-radius: 25px;"+
						"}"+
						"#link a{"+
						"font-size:30px;"+
						"text-decoration: none;"+
						"font-family: arial;"+
						"color:#663300;"+
						"}"+
						"</style>"+
					"<title>Document</title>"+
					 "</head>"+
					 "<body>"+
					 " <div id='container'>"+
						"<div id='header'>"+
							"<img src='https://1.bp.blogspot.com/-XYxu5h-ZLKA/X5lfmDFisfI/AAAAAAAAFUk/cn1x8ssFxH4GV1Uk1d_Z4d83IFIjbrGVACLcBGAsYHQ/s320/BookMarked.png?fit=956%2C326&ssl=1' id='logo'>"+
						"</div>"+
						"<div id='msg'>"+
							"<h3><p>Welcome "+userName+" To BookMarked</p></h3>"+

							"<h3><p>Your Registration is successful...</p></h3>"+
							
							"<p>Click over the activation link to Activate your account:</p>"+
							"<button id='link'>"+
							"<a href='http://localhost:8080/BookMarked1/activate.do?ukey="+userName+"&actCode="+activationCode+"'>Activate Account</a>"+
							"</button>"+
						"</div>"+
					  "</div>"+
					"</body>"+
				"</html>";

		return accountActivationMessage;
	}	
}