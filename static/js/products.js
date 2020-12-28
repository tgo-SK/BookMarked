const product_list = document.querySelector(".product-list");
const ts = document.querySelector("#ts");

console.log("###############");
const getData = async ()=>{
	const response = await fetch('product.do');
	const data = await response.json();
	console.log(data);
}

getData();

console.log("*****************");