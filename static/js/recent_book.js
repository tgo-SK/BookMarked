const wrapper = document.querySelector(".wrapper_bk");

const allBooks = async ()=>{
	const response = await fetch("allbooks.do");
	const data = await response.json();

	return data;
}; 


allBooks().then((data)=>{
				recentbooks(data);
			})
			.catch((err)=>{
				console.log(err);
			});
  
const recentbooks = (books)=>{
	if(books.length>0){
		let j=0,z=0;
		books.forEach((book)=>{
			single_rating(book.bookId).then((rating)=>{
				var ttl;
				if(rating==null){
					if(book.fileType.fileTypeId==1){
						ttl = "Read";
					}else{
						ttl = "Listen";
					}


					wrapper.innerHTML += `<div class="card animate">
						<h2 class="animate bktitle" title=${ttl} onclick="bookFileShow(${book.bookId},${book.fileType.fileTypeId})">${book.title}</h2>
						<span>By:- ${book.author} &nbsp; Rs ${book.price}/-</span>
						<div class="cta_container animate" id="stre"+z>
							Rate This Book
							<i class="far fa-star" id="estar1" onmouseover="full_star(event)" onmouseout="empty_star(event)" onclick="rating_submit(1,${book.bookId})"><\/i>
							<i class="far fa-star" id="estar2" onmouseover="full_star(event)" onmouseout="empty_star(event)" onclick="rating_submit(2,${book.bookId})"><\/i>
							<i class="far fa-star" id="estar3" onmouseover="full_star(event)" onmouseout="empty_star(event)" onclick="rating_submit(3,${book.bookId})"><\/i>
							<i class="far fa-star" id="estar4" onmouseover="full_star(event)" onmouseout="empty_star(event)" onclick="rating_submit(4,${book.bookId})"><\/i>
							<i class="far fa-star" id="estar5" onmouseover="full_star(event)" onmouseout="empty_star(event)" onclick="rating_submit(5,${book.bookId})"><\/i>
						   
						</div>
						<div >
							<img class="bookimg bktitle" title=${ttl} src="bookpic.do?bookId=${book.bookId}" onclick="bookFileShow(${book.bookId},${book.fileType.fileTypeId})">
						</div>
					</div>`;	
				}
				else{
					let emptyStar = 5-rating;

					if(book.fileType.fileTypeId==1){
						ttl = "Read";
					}else{
						ttl = "Listen";
					}

					wrapper.innerHTML += `<div class="card animate">
						<h2 class="animate bktitle" title=${ttl} onclick="bookFileShow(${book.bookId},${book.fileType.fileTypeId})">${book.title}</h2>
						<span>By:- ${book.author} &nbsp; Rs ${book.price}/-</span>
						<div class="cta_container animate" id="star`+j+`">
							
						</div>
						<div>
							<img class="bookimg bktitle" title=${ttl} src="bookpic.do?bookId=${book.bookId}" onclick="bookFileShow(${book.bookId},${book.fileType.fileTypeId})">
						</div>
					</div>`;

					let str_cont = document.querySelector("#star"+j);
					
					for(var i=0;i<rating;i++){
						str_cont.innerHTML += `<i class="fas fa-star"></i>`
					}	
					
					for(var i=0;i<emptyStar;i++){
						str_cont.innerHTML += `<i class="far fa-star"></i>`
					}
					
					j++;
				}
					
			}).catch((err)=>{});
		});
	}else{
		console.log("no books");
	}
};


const single_rating = async (id)=>{
	const response = await fetch("singlerating.do?bookId="+id,{method:'post'});
	const data = await response.json();

	return data;
}; 


const bk_rating = async (rat,e)=>{
	const response = await fetch("bookrating.do?rating="+rat+"&bookId="+e,{method:'post'});
	const data = await response.json();
}; 

function rating_submit(rat,e){
	bk_rating(rat,e).then(()=>{
		location.reload();
	}).catch();
}



function full_star(e){
	var len = e.target.id.match(/(\d+)/)[0];
	for(var k=1;k<=len;k++){
		var es = document.querySelector("#estar"+k);
		es.className = "fas fa-star";
	}
}

function empty_star(e){
	var len = e.target.id.match(/(\d+)/)[0];
	for(var k=1;k<=len;k++){
		var es = document.querySelector("#estar"+k);
		es.className = "far fa-star";
	}
}

function bookFileShow(id,fileType){
	window.location = "bookfileshow.do?bookid="+id+"&filetype="+fileType;
}