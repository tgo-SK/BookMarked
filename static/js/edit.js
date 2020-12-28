var circle1 = document.getElementById('circle1');
var circle2 = document.getElementById('circle2');
var circle3 = document.getElementById('circle3');
var circle4 = document.getElementById('circle4');
var circle5 = document.getElementById('circle5');
var circle6 = document.getElementById('circle6');
var rightInputBox = document.querySelector('.right-input-box');

var next1 = document.getElementById('next1');
var next2 = document.getElementById('next2');
var next3 = document.getElementById('next3');
var next4 = document.getElementById('next4');
var next5 = document.getElementById('next5');
var next6 = document.getElementById('next6');

const add_more_link = document.querySelector('#add_more_link');
const product_point_record = document.querySelector('#product_point_record');
const product_point_record_preview = document.querySelector('#product_point_record_preview');
const bookId = document.getElementById("bookidd").innerHTML;
console.log(bookId);


function preview_image(event) {
 var reader = new FileReader();
 reader.onload = function()
 {
	var output = document.getElementById("output_image_ufile1");
	output.src = reader.result;
 }
 reader.readAsDataURL(event.target.files[0]);
}

/*=====================================================================*/

next1.addEventListener('click',()=>{
	rightInputBox.style.top = '-100%';
	circle1.className = 'completed-circle';
});

next2.addEventListener('click',()=>{
	rightInputBox.style.top = '-200%';
	circle2.className = 'completed-circle';
});

next3.addEventListener('click',()=>{
	rightInputBox.style.top = '-300%';
	circle3.className = 'completed-circle';
});

next4.addEventListener('click',()=>{
	rightInputBox.style.top = '-400%';
	circle4.className = 'completed-circle';
});

next5.addEventListener('click',()=>{
	rightInputBox.style.top = '-500%';
	circle5.className = 'completed-circle';
});

next6.addEventListener('click',()=>{
	circle6.className = 'completed-circle';
});



/*---------------------------------POPUP-------------------------------*/
/*const submit_popup = document.querySelector(".popup");
const cross1 = document.querySelector(".img1");

next6.addEventListener("click",()=>{
	submit_popup.style.display = 'flex';
});

cross1.addEventListener("click",()=>{
	submit_popup.style.display = 'none';
});*/


/*--------------------------------ADD POINTS----------------------------*/

row1 = document.querySelectorAll("row1").length + 1;
row2 = document.querySelectorAll("row2").length + 1;

add_more_link.addEventListener('click',()=>{	

	const nrow = product_point_record.insertRow(row1++);

	const cell1 = nrow.insertCell(0);
	const cell2 = nrow.insertCell(1);
	const cell3 = nrow.insertCell(2);

	cell1.innerHTML = `${row1}.`;
	cell1.className = 'block1';

	const input_field = document.createElement('input');
	input_field.className = 'p-input2 pnt';
	input_field.setAttribute('name',"point_title");
	cell2.append(input_field);
	cell2.className = 'block2';
	
	cell3.innerHTML = '<textarea class="point_txt1" name="product_point" rows="4" cols="40"></textarea>';
	cell3.className = 'block3';
});


/*--------------------------------REMOVE-POINTS-------------------------*/
const remove_link = document.querySelector('#remove_link');

remove_link.addEventListener('click',()=>{
	console.log(row1);
	
	row1--;	
	//row2--;	

	product_point_record.deleteRow(row1);
	//product_point_record_preview.deleteRow(row2);	
});

/*--------------------------------ADD IMAGES----------------------------*/
const add_more_images = document.querySelector('#add_more_img');
const product_point_images1 = document.querySelector('#product_images1');
const product_point_images = document.querySelector('#product_images');
console.log(product_point_images);
var img_row1 = document.querySelectorAll("img_row1").length + 1;
var img_row2 = document.querySelectorAll("img_row2").length + 1;
let i=2;
add_more_images.addEventListener('click',()=>{	

	const nrow = product_point_images1.insertRow(img_row1++);

	const cell1 = nrow.insertCell(0);
	const cell2 = nrow.insertCell(1);

	cell1.innerHTML = `${img_row1}.`;
	cell1.className = 'block1';
	
	const preview_img = document.createElement('img');
	preview_img.id = `output_image_ufile${img_row1}`; 
	preview_img.className = "img_size"; 

	const img_input = document.createElement('input');
	img_input.className = 'product-image-text p_images1';
	img_input.type = "file";
	img_input.name = "p_pic"+i;
	img_input.accept="image/*";
	++i;
	img_input.id = `ufile${img_row1}`;
	

	var img_label = document.createElement("Label");
	img_label.setAttribute("for",img_input.id);
	img_label.innerHTML = "Choose a file";
	

	cell2.append(preview_img);
	cell2.append(img_input);
	cell2.append(img_label);
	cell2.className = 'block2';
	
	img_input.addEventListener("change",(event)=>{
		var reader = new FileReader();
		reader.onload = function(){
			var output = document.getElementById("output_image_"+event.target.id);
			output.src = reader.result;
		}
		reader.readAsDataURL(event.target.files[0]);
	});

	
	/*const mrow = product_point_images.insertRow(img_row2++);

	const cell3 = mrow.insertCell(0);
	const cell4 = mrow.insertCell(1);

	cell3.innerHTML = `${img_row1}.`;
	cell3.className = 'block1';

	const img_input_field = document.createElement('input');
	img_input_field.className = 'p-input2 p_images';
	cell4.append(img_input_field);
	cell4.className = 'block2';*/
});


/*--------------------------------REMOVE IMAGES----------------------------*/
const remove_images = document.querySelector('#remove_img');

remove_images.addEventListener('click',()=>{	
	img_row1--;	
	//img_row2--;	

	product_point_images1.deleteRow(img_row1);
	//product_point_images_preview.deleteRow(img_row2);	
});

/*--------------------------------FORM PREVIEW--------------------------*/	
const edit = document.querySelector("#edit");

/*edit.addEventListener("click",()=>{
	rightInputBox.style.top = '0%';
	submit_popup.style.display = 'none';
	circle1.className = 'circle';
	circle2.className = 'circle';
	circle3.className = 'circle';
	circle4.className = 'circle';
	circle5.className = 'circle';
	circle6.className = 'circle';
});*/
/*
function preview_product(){
	//document.product_details.p_option1.value = document.product_details1.p_option1.value;
	document.product_details.p_name.value = document.product_details1.p_name1.value;
	document.product_details.p_price.value = document.product_details1.p_price1.value;
	document.product_details.p_desc.value = document.product_details1.p_desc1.value;
	document.product_details.p_type.value = document.product_details1.p_type1.value;
	if(document.product_details1.p_payment1.checked == true){
		console.log("------------------");
		document.product_details.p_payment.value = document.product_details1.p_payment1.value;
	}
	else{
		document.product_details.p_payment.value = "";
	}

	var pnt1 = Array.from(document.querySelectorAll('.pnt'));
	var pnt2 = Array.from(document.querySelectorAll('.point_ttl'));

	for(let i=0;i<pnt1.length;i++){
		pnt2[i].value = pnt1[i].value;
	}

	var ttl1 = Array.from(document.querySelectorAll('.point_txt1'));
	var ttl2 = Array.from(document.querySelectorAll('.point_txt2'));

	for(let i=0;i<ttl1.length;i++){
		ttl2[i].value = ttl1[i].value;
	}

	var imgs1 = Array.from(document.querySelectorAll('.p_images1'));
	var imgs2 = Array.from(document.querySelectorAll('.p_images'));

	console.log(imgs1);

	for(let i=0;i<imgs1.length;i++){
		imgs2[i].value = imgs1[i].value;
	}
}
*/
/*--------------------------------FILE----------------------------*/	
const e_book = document.getElementById("p_type1");
const audio_book = document.getElementById("p_type2");
const plabel1 = document.getElementById("pfile_label1");
const plabel2 = document.getElementById("pfile_label2");

function file_tab(){
	if(e_book.checked){
		plabel1.style.display = "inline-block";
		plabel2.style.display = "none";
	}
	else if(audio_book.checked){
		plabel1.style.display = "none";
		plabel2.style.display = "inline-block";
	}
}

/*-------------------SaveProductsDetails-------------------------*/
let url;
let query;
const saveProductDetails = async (request) => {	

	const response = await fetch(request,{method:'post'});
	const data = await response.json();

	return data;
};

//----------------------------1.New Book--------------------------
const category1 = document.getElementById("category1");
const bookName = document.getElementById("p-name");
const price = document.getElementById("p-price");
const author = document.getElementById("p-author");

next1.addEventListener('click',(e)=>{
	url ="updateook.do?"; 
	query = `p_option1=${category1.value}&p_name1=${bookName.value}&p_price1=${price.value}&p_author=${author.value}&bookid=${bookId}`;
	console.log(query);
	saveProductDetails(url+query)
		.then((data)=>{
			if(data.bookId){
				bookId.value = data.bookId;
				console.log(bookId);
			}
			if(data.resp==0){
				window.location = 'signin.do';				
			}
	}).catch((err)=>{
			console.log(err);
		});
});

//------------------------BookDescription----------------------------------------
const desp = document.getElementById("p-desc1");

next2.addEventListener('click',(e)=>{
url = "updatedescription.do?";
query = `desp=${desp.value}&bookid=${bookId}`;
saveProductDetails(url+query)
		.then((data)=>{
			if(data.resp==-1){
				window.location = 'signin.do';				
			}
	}).catch((err)=>{
			console.log(err);
		});
});


//------------------------FileType + PaymentDetails-----------------------------------

const ebook = document.getElementById("p_type1");
const abook = document.getElementById("p_type2");
const pay = document.getElementById("p-desc");

next4.addEventListener('click',(e)=>{
url = "updatebookpay.do?";
if(ebook.checked)
	query = `pay=${pay.value}&fileType=1`;
else
	query = `pay=${pay.value}&fileType=2`;

saveProductDetails(url+query)
		.then((data)=>{
			if(data.resp==-1){
				window.location = 'signin.do';				
			}
	}).catch((err)=>{
			console.log(err);
		});
});

//------------------------BookPoints-------------------------------------

next5.addEventListener('click',(e)=>{
	file_tab();
	const pnames = Array.from(document.querySelectorAll('.p-input2'));
	const pvalues = Array.from(document.querySelectorAll('.point_txt1'));
	
	url = 'updatebookpoints.do?';
	query = '';
	let i=0;
	pnames.forEach((pname)=>{
		if(i==0)
			query += `pname=${encodeURIComponent(pname.value)}`;
		else
			query += `&pname=${encodeURIComponent(pname.value)}`;
		i++;
	
	});

	pvalues.forEach((pvalue)=>{
		query += `&pvalue=${encodeURIComponent(pvalue.value)}`;
	});

	
	saveProductDetails(url+query)
		.then((data)=>{
			if(data.resp==-1){
				window.location = 'signin.do';				
			}
		}).catch((err)=>{
			console.log(err);
		});
});


const fileForm = document.getElementById("fileForm");
const picfileup = document.getElementById("ufile1");

function updateTest(){
	if(picfileup.value != "")
		fileForm.submit();
	else
		window.location.assign("modify.do");
}