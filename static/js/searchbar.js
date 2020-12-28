const img = document.querySelector(".search-img");
const input = document.querySelector(".search-field");
const check = document.querySelector("#search-check");
const header_items = document.querySelector(".header-items");

img.addEventListener('click',()=>{
	input.className = 'searchbar-transition';
	img.style.animation = 'fade-in 1s linear';
	header_items.style.display = 'none';
});

window.addEventListener('click',(e)=>{
	if(e.target.id == 'simg' || e.target.id == 'search')
		check.checked = true;
	else{
		input.className = 'search-field';
		check.checked = false;
		img.style.animation = 'none';
		header_items.style.display = 'block';
	}
}); 


img.addEventListener('click',()=>{
	if(input.value.length!=0){
		window.location = "booksearch.do?searchBook="+input.value;
	}
});

input.addEventListener('keyup',(event)=>{
	if(input.value.length!=0 && event.which === 13){
		window.location = "booksearch.do?searchBook="+input.value;
	}
});


const profile = document.querySelector("#profile");
const signout = document.querySelector("#signout");
const dropdown = document.querySelector(".user_dropdown");

dropdown.addEventListener('click',()=>{
	if(signout.selected){
		window.location = "signout.do";
	}
	else if(profile.selected){
		window.location = "profile.do";
	}	
});