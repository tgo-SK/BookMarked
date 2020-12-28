var slideIndex=0;
showSlides();

function showSlides(){
	var slides = document.getElementsByClassName("mySlides");

	for(var i=0;i<slides.length;i++){
		slides[i].style.display = "none";
	}

	slideIndex++;
    if (slideIndex > slides.length){
		slideIndex = 1;
	}
	slides[slideIndex-1].style.display = "block";  
	setTimeout(showSlides,5000);
}


const eBook = document.querySelector("#b1");
const audioBook = document.querySelector("#b2");

eBook.addEventListener('click',()=>{
	window.location = "ebook.do";
});

audioBook.addEventListener('click',()=>{
	window.location = "audiobook.do";
});