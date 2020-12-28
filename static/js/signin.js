const form = document.getElementById('form');
const userName = document.getElementById('name');
const password = document.getElementById('pass');

userName.addEventListener('focus',()=>{
	userName.className = 'focus';
});

password.addEventListener('focus',()=>{
	password.className = 'focus';
});

const arr_er = new Array();
let flag = true;
var i=0;

userName.addEventListener('blur',(e)=>{
	const unregex = /^[a-zA-Z][a-zA-Z0-9]{4,29}$/;
	if(!unregex.test(userName.value)){
		const emlregex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
		if(!emlregex.test(userName.value)){
			userName.className  = 'error';
		}
	}
});


form.addEventListener('submit',(e)=>{
	e.preventDefault();
	
	const unregex = /^[a-zA-Z][a-zA-Z0-9]{4,29}$/;
	if(!unregex.test(userName.value)){
		const emlregex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
		if(!emlregex.test(userName.value)){
			flag= false;
			userName.className = 'error';
			console.log('userName regex');
			if(userName.value=="")
				arr_er[i++]= 'User Name field cannot be empty';
			else
				arr_er[i++]= 'Not a valid Name or Email';
		}	
	}


	if (password.value==''){
		flag = false;
		console.log('re != pass');
		password.className = 'error';
		arr_er[i++]= 'Password field is Empty';
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
