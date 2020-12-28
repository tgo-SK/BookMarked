const lastprice = document.querySelector("#oldp");
const newprice = document.querySelector("#newp");
const bookid = document.querySelector("#bookid");
const bookp = document.querySelector("#bookpoints");
const productRating = document.querySelector(".product-rating");
const buy_button = document.querySelector("#buy-button");
const popupText = document.querySelector("#popupText");

lastprice.innerHTML = parseInt(newprice.innerHTML) + 0.2*parseInt(newprice.innerHTML); 

const bookpoints = async ()=>{

	const response = await fetch("bookpoints.do?bookid="+bookid.innerHTML);
	const data = await response.json();

	return data;
}; 


bookpoints().then((data)=>{
				showbookpoints(data);
			})
			.catch((err)=>{
				console.log(err);
			});

const showbookpoints = (points)=>{
							if(points.length>0){
								points.forEach((point)=>{
									bookp.innerHTML +=`<li>${point.pointHeader}: <span>&nbsp;&nbsp;&nbsp;${point.pointValue}</span></li>`;				
								});
							}else{
								console.log("no points");
							}
						}


const bookrating = async ()=>{

	const response = await fetch("bookrating.do?bookid="+bookid.innerHTML);
	const data = await response.json();

	return data;
};

bookrating().then((data)=>{
				showrating(data);
			}).catch((err)=>{

			});

const showrating = (rating)=>{
	let intRating = Math.trunc(rating);
	let emptyStar = 5 - intRating;
	let decimalRating = rating % 1;

	if(decimalRating!=0){
		emptyStar--;
	}
	
	for(var i=0;i<intRating;i++){
		productRating.innerHTML += `<i class = "fas fa-star"></i>`;
	}

	if(decimalRating!=0){
		productRating.innerHTML += `<i class = "fas fa-star-half-alt"></i>`;
	}

	for(var i=0;i<emptyStar;i++){
		productRating.innerHTML += `<i class="fa fa-star-o" aria-hidden="true"></i>`;
	}
	var rating1 = Math.round(rating*10)/10;
	productRating.innerHTML += `<span>&nbsp;${rating1}</span>`;
}


function buyNow(id){
	buy(id).then((data)=>{
		if(data.resp==0){
			window.location = "login.do";	
		}else{
			console.log(data);
			popupText.innerHTML = data;
			toggle();
		}
	}).catch();
}

const buy = async (id)=>{

	const response = await fetch("buynow.do?bookId="+id,{method:'post'});
	const data = await response.json();

	return data;
}; 

function buycredits(id){
	credits(id).then((data)=>{		
		console.log(data);
		popupText.innerHTML = data;
		toggle();		
	}).catch();
}

const credits = async (id)=>{
	const response = await fetch("credits.purchase?bookid="+id,{method:'post'});
	const data = await response.json();

	return data;
};

function toggle(){
	var blur= document.getElementById('blur');
	blur.classList.toggle('active');
	var popup=document.getElementById('popup');
	popup.classList.toggle('active');				
}