function preview_image(event) {
 var reader = new FileReader();
 reader.onload = function()
 {
  var output = document.getElementById('output_image');
  output.src = reader.result;
 }
 reader.readAsDataURL(event.target.files[0]);
}

const image_box = document.querySelector(".user-image-box");
const upload_box = document.querySelector(".user-image");
const cross1 = document.querySelector(".img1");
const cross2 = document.querySelector(".img2");
const fsubmit = document.getElementById("file-submit");
const uprof = document.getElementById("uprof");
const utext = document.querySelector(".user-text");


image_box.addEventListener("click",()=>{
	upload_box.style.display = 'flex';
});

cross1.addEventListener("click",()=>{
	upload_box.style.display = 'none';
	fsubmit.style.display = 'none';
	var output = document.getElementById('output_image');
    output.src = "";
});

cross2.addEventListener("click",()=>{
	utext.style.display = 'none';
});

function upload(){
	fsubmit.style.display = 'flex';
	if(document.getElementById("ufile").value != ""){
		fsubmit.style.display = 'flex';
	}
}

uprof.addEventListener("click",()=>{
	utext.style.display = 'flex';
});

/*function focusBorder(e){
	console.log(e.target.tagName);
	e.target.className.borderBottom = '2px solid green';
}

function blurBorder(e){
	e.target.style.borderBottom = 'none';
}*/

