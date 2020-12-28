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
const submit_popup = document.querySelector(".popup");
const cross1 = document.querySelector(".img1");

next6.addEventListener("click",()=>{
	submit_popup.style.display = 'flex';
});

cross1.addEventListener("click",()=>{
	submit_popup.style.display = 'none';
});


/*--------------------------------ADD POINTS----------------------------*/
const add_more_link = document.querySelector('#add_more_link');
const product_point_record = document.querySelector('#product_point_record');
const product_point_record_preview = document.querySelector('#product_point_record_preview');

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
	cell2.append(input_field);
	cell2.className = 'block2';
	
	cell3.innerHTML = '<textarea class="point_txt1" rows="4" cols="40"></textarea>';
	cell3.className = 'block3';

	
	const mrow = product_point_record_preview.insertRow(row2++);

	const cell4 = mrow.insertCell(0);
	const cell5 = mrow.insertCell(1);
	const cell6 = mrow.insertCell(2);

	cell4.className = 'block1';
	cell4.innerHTML = `${row2}.`;

	const input_field_ = document.createElement('input');
	input_field_.className = 'p-input2 point_ttl';
	input_field_.setAttribute("name","point_title");
	cell5.append(input_field_);
	cell5.className = 'block2';	
	
	cell6.innerHTML = '<textarea name="product_point" class="point_txt2" rows="3" cols="40"></textarea>';
	cell6.className = 'block3';
});


/*--------------------------------REMOVE-POINTS-------------------------*/
const remove_link = document.querySelector('#remove_link');

remove_link.addEventListener('click',()=>{
	row1--;	
	row2--;	

	product_point_record.deleteRow(row1);
	product_point_record_preview.deleteRow(row2);	
});

/*--------------------------------ADD IMAGES----------------------------*/
const add_more_images = document.querySelector('#add_more_img');
const product_point_images = document.querySelector('#product_images1');
const product_point_images_preview = document.querySelector('#product_images');

let img_button_array = null;
let img_file_array = null;

var img_row1 = document.querySelectorAll("img_row1").length + 1;
var img_row2 = document.querySelectorAll("img_row2").length + 1;

add_more_images.addEventListener('click',()=>{	

	const nrow = product_point_images.insertRow(img_row1++);

	const cell1 = nrow.insertCell(0);
	const cell2 = nrow.insertCell(1);

	cell1.className = 'block1_';
	cell1.innerHTML = `${img_row1}.`;
	
	const preview_img = document.createElement('img');
	preview_img.id = `output_image_ufile${img_row1}`; 
	preview_img.className = "img_size"; 

	const img_input = document.createElement('button');
	img_input.className = 'product-image-text';
	img_input.id = `ubutton${img_row1}`;
	

	var img_label = document.createElement("Label");
	img_label.setAttribute("for",img_input.id);
	img_label.innerHTML = "Choose a file";
	img_label.className = "p-images-buttons";
	img_label.id = `uf-button${img_row1}`;
	img_label.onclick = img_click;
	

	cell2.append(preview_img);
	cell2.append(img_input);
	cell2.append(img_label);
	cell2.className = 'block2';

	
	const mrow = product_point_images_preview.insertRow(img_row2++);

	const cell3 = mrow.insertCell(0);
	const cell4 = mrow.insertCell(1);

	cell3.innerHTML = `${img_row1}.`;
	cell3.className = 'block1';

	const img_input_field = document.createElement('input');
	img_input_field.className = 'product-image-text12 p_images';
	img_input_field.setAttribute("name","p_pic");
	img_input_field.type = 'file';
	img_input_field.accept = 'image/*';
	img_input_field.id = `ufile${img_row2}`;

	img_input_field.addEventListener("change",(event)=>{
	var reader = new FileReader();
	reader.onload = function(){
		var output = document.getElementById("output_image_"+event.target.id);
		output.src = reader.result;
	}
	reader.readAsDataURL(event.target.files[0]);
	});

	var img_label1 = document.createElement("Label");
	img_label1.setAttribute("for",img_input_field.id);
	img_label1.id = `ulabel${img_row1}`;

	cell4.append(img_input_field);
	cell4.append(img_label1);
	cell4.className = 'block2';

	img_button_array = Array.from(document.querySelectorAll(".p-images-buttons"));
    img_file_array = Array.from(document.querySelectorAll(".p_images"));
});


/*--------------------------------REMOVE IMAGES----------------------------*/
const remove_images = document.querySelector('#remove_img');

remove_images.addEventListener('click',()=>{	
	img_row1--;	
	img_row2--;	

	product_point_images.deleteRow(img_row1);
	product_point_images_preview.deleteRow(img_row2);	

	img_button_array = Array.from(document.querySelectorAll(".p-images-buttons"));
    img_file_array = Array.from(document.querySelectorAll(".p_images"));
});

/*--------------------------------FORM PREVIEW----------------------------*/	
const edit = document.querySelector("#edit");

edit.addEventListener("click",()=>{
	rightInputBox.style.top = '0%';
	submit_popup.style.display = 'none';
	circle1.className = 'circle';
	circle2.className = 'circle';
	circle3.className = 'circle';
	circle4.className = 'circle';
	circle5.className = 'circle';
	circle6.className = 'circle';
});

function preview_product(){
	document.product_details.p_option.value = document.product_details1.p_option1.value;
	document.product_details.p_name.value = document.product_details1.p_name1.value;
	document.product_details.p_price.value = document.product_details1.p_price1.value;
	document.product_details.p_desc.value = document.product_details1.p_desc1.value;
	document.product_details.p_type.value = document.product_details1.p_type1.value;
	if(document.product_details1.p_payment1.checked == true){
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

	document.product_details.p_author.value = document.product_details1.p_author1.value;
}

/*--------------------------------FORM SUBMIT----------------------------*/	
const saveProductNextStep = async (request) => {	
	const response = await fetch(request,{method:'post'});
	const data = await response.json();
	console.log(data);
	return data;
};

const submit1 = document.getElementById("forms-submit1");
const submit2 = document.getElementById("forms-submit2");
const form = document.forms;

submit1.addEventListener('click',()=>{
	const url = "newprod.do?";
	let query = `p_option=${form[0].p_option.value}&p_name=${encodeURIComponent(form[0].p_name.value)}&p_price=${form[0].p_price.value}&p_author=${form[0].p_author.value}&p_desc=${form[0].p_desc.value}&p_payment=${form[0].p_payment.value}&p_type=${form[0].p_type.value}`;

	let p_title = Array.from(document.querySelectorAll('.pnt'));
	var p_value = Array.from(document.querySelectorAll('.point_txt1'));

	p_title.forEach((point_tl)=>{
		query += `&point_title=${encodeURIComponent(point_tl.value)}`;
	});

	p_value.forEach((point_txt)=>{
		query += `&product_point=${encodeURIComponent(point_txt.value)}`;
	});

	saveProductNextStep(url+query)
		.then((data)=>{
		if(data.resp==1){
			submit1.style.display = "none";
			submit2.style.display = "inline-block";
		}
	}).catch((err)=>{
		console.log(err);
	});

});

submit2.addEventListener('click',()=>{
	form[1].submit();
});

/*--------------------------------FILE----------------------------*/	
const e_book = document.getElementById("p_type1");
const audio_book = document.getElementById("p_type2");
const plabel1 = document.getElementById("pfile_label1");
const plabel2 = document.getElementById("pfile_label2");
const preview_file = document.product_details_.p_file;

function file_tab(){
	if(e_book.checked){
		plabel1.style.display = "inline-block";
		plabel2.style.display = "none";
		preview_file.accept = ".pdf"; 
	}
	else if(audio_book.checked){
		plabel1.style.display = "none";
		plabel2.style.display = "inline-block";
		preview_file.accept = ".mp3"; 
	}
}

plabel1.addEventListener('click',(e)=>{
	e.preventDefault();
	preview_file.click();
});

plabel2.addEventListener('click',(e)=>{
	e.preventDefault();
	preview_file.click();
});

preview_file.addEventListener('change',()=>{
	var path_name = preview_file.value.split('\\').pop();
	plabel1.innerHTML = path_name;
	plabel2.innerHTML = path_name;
	document.getElementById('preview_file_').innerHTML = path_name;
});

/*--------------------------------IMAGES----------------------------*/	
function img_click(e){
	const num = e.target.id.substring(9);

	img_button = document.getElementById("uf-button"+num);
	img_file = document.getElementById("ufile"+num);
	img_label = document.getElementById("ulabel"+num);

	e.preventDefault();
	img_file.click();

	img_file.addEventListener('change',()=>{
		var path_name = img_file.value.split('\\').pop();
		img_button.innerHTML = path_name;
		img_label.innerHTML = path_name;
	});
}
	