const form = document.getElementById('form');
const userName = document.getElementById('name');
const email = document.getElementById('email');
const password = document.getElementById('pass');
const repassword = document.getElementById('repass');
const tick1 = document.getElementById('uimg');
const tick2 = document.getElementById('eimg');
const tick3 = document.getElementById('pimg');
const tick4 = document.getElementById('rpimg');


const emlregex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
const unregex = /^[a-zA-Z][a-zA-Z0-9]{4,29}$/;
userName.onblur = checkUniqueKey;
email.onblur = checkUniqueKey;
let thisfld;
let request; 
function checkUniqueKey(){
	
	if(this.value.length != 0){
		thisfld = this;
		request = new XMLHttpRequest();
		request.open('GET','check.gg?key='+this.value,true);
		request.onreadystatechange = checkUniqueKeyResult;
		request.send();
	}else
		this.className = 'error';
}

function checkUniqueKeyResult(){
	if(request.readyState==4 && request.status==200){
		const response = request.responseText;
		if(response == 'false'){
			thisfld.className = 'error';
			alert("This "+thisfld.id+" is already taken");
		}else{
			console.log(thisfld.id);
			if(thisfld.id == 'name'){
				if(!unregex.test(userName.value)){
					userName.className  = 'error';		
				}else
					tick1.style.display = 'block';
			}
			else{
				if(!emlregex.test(email.value)){
					email.className = 'error';
				}else
					tick2.style.display = 'block';
			}
		}
	}
}

///////////////////////////////////////////////////////////////////////////////////////

userName.addEventListener('focus',()=>{
	userName.className = 'focus';
	tick1.style.display = 'none';
});

email.addEventListener('focus',()=>{
	email.className = 'focus';
	tick2.style.display = 'none';
});

password.addEventListener('focus',()=>{
	password.className = 'focus';
	tick3.style.display = 'none';
});

password.addEventListener('keyup',()=>{
	if(repassword.value == password.value){
		repassword.className = 'focus';
		tick4.style.display = 'none';
	}
});

repassword.addEventListener('focus',()=>{
	repassword.className = 'focus';
});

repassword.addEventListener('keyup',()=>{
	repassword.className = 'focus';
});

const arr_er = new Array();
let flag = true;
var i=0;

repassword.addEventListener('keyup', (e)=>{
	if(password.value != repassword.value){
		repassword.className = 'error';
	}
	else{
		tick4.style.display = 'block';
		tick3.style.display = 'block';
	}
});


password.addEventListener('keyup', (e)=>{
	if((repassword.value != "") && (password.value != repassword.value)){
		repassword.className = 'error';
	}
});


form.addEventListener('submit',(e)=>{
	e.preventDefault();
	const unregex = /^[a-zA-Z][a-zA-Z0-9]{4,29}$/;
	if(!unregex.test(userName.value)){
		flag= false;
		userName.className = 'error';
		console.log('userName regex');
		if(userName.value=="")
			arr_er[i++]= 'User Name field cannot be empty';
		else
			arr_er[i++]= 'Not a valid User Name';
	}

	const emlregex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
	if(!emlregex.test(email.value)){
		flag= false;
		email.className = 'error';
		console.log('emlregex');
		if(email.value=="")
			arr_er[i++] = 'email field cannot be empty';
		else
			arr_er[i++] = 'please enter a valid email';
	}

	if(password.value==""){
		flag= false;
		console.log('pass == 0');
		password.className = 'error';
		arr_er[i++]= 'Password field can not be empty';
	}

	if(repassword.value==""){
		flag= false;
		console.log('re == 0');
		repassword.className = 'error';
		arr_er[i++]= 'Confirmation Password field can not be empty';
	}

	if (repassword.value != password.value){
		flag = false;
		console.log('re != pass');
		repassword.className = 'error';
		arr_er[i++]= 'Confirmation Password does not match';
	}

	if(flag){
		form.submit();
		console.log('1');
	}
	else{
		console.log('0');
		arr_er.forEach((emsg)=>{
			alert(emsg);
		});

		flag = true;
		i = 0;
		arr_er.length = 0;
	}
});
