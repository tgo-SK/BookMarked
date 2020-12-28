const wrapper = document.querySelector(".wrapper_bk");

const allBooks = async ()=>{
	const response = await fetch("allbooks.do");
	const data = await response.json();

	return data;
}; 


allBooks().then((data)=>{
				showbooks(data);
			})
			.catch((err)=>{
				console.log(err);
			});
  
const showbooks = (books)=>{
	if(books.length>0){
		books.forEach((book)=>{
		wrapper.innerHTML += `<div class="card animate">
	                <h2 class="animate">${book.title}</h2>
	               	<span>By:- ${book.author} &nbsp; Rs ${book.price}/-</span>
					<div class="cta_container animate">
                        <a href="bookDescription.do?bookid=${book.bookId}"  class="cta">View Book Description</a>
					</div>
					<div >
						<img class="bookimg" src="bookpic.do?bookId=${book.bookId}">
					</div>
				</div>`;		

		});
	}else{
		console.log("no books");
	}
};