<!doctype html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
	<head>
		<title>Add New Book</title>
		<link rel="stylesheet" href="static/css/add_new_book.css">
		<link rel="stylesheet" href="static/css/header.css">
		<link rel="stylesheet" href="static/css/searchbar.css">
	 <link rel="stylesheet" href="static/css/full_page_scroll.css">
	</head>
	<body>
	<div class="bd">
	<div class="hd">
				<%@ include file="header.jsp" %>
			</div>
        <div class="admin-container">
	        <div class="popup">
			<div class="img1 img"  style="display:inline-block"><img src="static/images/remove.png" height="45px" width="45px"></div>
			<div class="popup-center">
				<div class="p-submit-div">
					<form method="post" name="product_details">
					    <h1 class="heading"> Book Details
						
						</h1>
								
						<span><h2>Book Category: </h2><input class="p-input1" type="text" name="p_option"></span>
						<span><h2>Book  Name: </h2><input class="p-input1" type="text" name="p_name"></span>
						<span><h2>Price: </h2><input class="p-input1" type="text" name="p_price"></span>
						<span><h2>Author: </h2><input class="p-input1" type="text" name="p_author"></span>
						<span><h2>Description: </h2><input type="text" class="p-input1" name="p_desc"></span>

						<span><h2>Payment: </h2><input class="p-input1" type="text" name="p_payment"></span>
						
						<span><h2>Book Points: </h2>
							 <table>
								<tbody id="product_point_record_preview">
									<tr id="row2">
										<td class="block1_">
											1.
										</td>
										<td class="block2_">
											<input type="text" name="point_title" class="p-input2 point_ttl">
										</td>
										<td class="block3_">
											<textarea name="product_point" rows="3" cols="40" class="point_txt2"></textarea>
										</td>
									</tr>
								</tbody>
							</table>
						</span>

						<span><h2>Book Type: </h2><input class="p-input1" type="text" name="p_type"></span>

					</form>


					<form action="productfile.do" name="product_details_" method="post" enctype="multipart/form-data">
						<span><h2>Book File: </h2>
							<input id="p_file__" type="file" name="p_file" class="product-image-text12">
							<label id="preview_file_" for="p_file__"></label>
						</span>

						<span><h2>Book Pics: </h2>
							 <table>
								<tbody id="product_images">
									<tr id="img_row2">
										<td class="block1_">
											1.
										</td>
										<td class="block2_">
											<input type="file" id="ufile1" accept="image/*" name="p_pic" class="product-image-text12 p_images" onchange="preview_image(event)">
											<label id="ulabel1" for="ufile1"></label>
										</td>
									</tr>
								</tbody>
							</table>
						</span>	
					</form> 

					<div class="product-submit" id="edit">Edit</div>		
					<button id="forms-submit1" class="product-submit">Submit Normal Fields</button>
					<button id="forms-submit2" class="product-submit" style="display:none">Submit Pics & File</button> 

				</div>
			</div>			
		</div>

			<div class="admin-box">
				<div class="right-input-box">
					<form name="product_details1">						
						<div class="right-input">					
							<span class="h1">1. New Book </span>
								
							<p class="p-label">Book Category:
							<select class="sel" name="p_option1">
								<option>Select</option>
								<c:forEach var="category" items="${category}">
									<option value="${category.categoryId}">${category.category}</option>
								</c:forEach>
							</select></p>

							<label for="p-name" class="p-label">Book Name:</label>
							<input type="text" name="p_name1" class="p-input" id="p-name">

							<label for="p-price" class="p-label">Price:</label>
							<input type="text" name="p_price1" id="p-price" class="p-input">

							<label for="p-author" class="p-label">Author:</label>
							<input type="text" name="p_author1" id="p-author" class="p-input">
							
							<div class="btn" id="next1">Next</div>
							
						</div>

						<div class="right-input">
							<span class="h1">2.Book Description</span>

							<label for="p-desc1" class="p-label">Please provide Book Description here.</label>
							<textarea name="p_desc1" id="p-desc1" rows="20" cols="100"></textarea>

							<div class="btn" id="next2">Next</div>
						</div>

						<div class="right-input">
							<span class="h1">3. Book type </span>

							<span style="display:block" onclick="file_tab()"><input type="radio" name="p_type1" id="p_type1" value="e-book">
							<label for="p_type1" class="p-label" style="display:inline-block">e-Book</label>
							</span>

							<span style="display:block" onclick="file_tab()"><input type="radio" name="p_type1" id="p_type2" value="Audio Book">
							<label for="p_type2" class="p-label" style="display:inline-block">Audio Book</label>
							</span>



							<button id="pfile_label1" class="btn1" style="display:none">Choose a .pdf file</button>
							<button id="pfile_label2" class="btn1" style="display:none">Choose a .mp3 file</button>


							<div class="btn" id="next3">Next</div>
						</div>

						<div class="right-input">
							<span class="h1">4. Payment Details</span>

						
								<input type="checkbox" name="p_payment1" id="p_payment1" value="Paytm">
								<label for="p_payment1" class="p-label" style="display:inline-block">Paytm</label><br>
								
								<!-- <input type="checkbox" name="p_payment1" id="p_payment2" value="PayPal">	
								<label for="p_payment2" class="p-label" style="display:inline-block">PayPal</label><br>
								
								<input type="checkbox" name="p_payment1" id="p_payment3" value="Google Pay">
								<label for="p_payment3" class="p-label" style="display:inline-block">Google Pay </label> -->

							<div class="btn" id="next4">Next</div>
						</div>

						<div class="right-input">
							<span class="h1">5. Pointwise Book Details</span>
							
							<div class="p-table">
								<table id="p_ar_table">
									<thead>
										<tr class="record_header">
											<th class="p-label_">&nbsp;</th>
											<th class="p-label_">Point-Title</th>
											<th class="p-label_">Point-Description</th>
										</tr>
									</thead>

									<tfoot>
										<tr>
											<td>&nbsp</td>
											<td>&nbsp</td>											
											<td align="right">
												
												<span id="add_more_link">
													<img src="static/images/add.png" id="add_ico" height="30px" width="30px">
													<span id="add_more" class="add-rem-tag">Add More</span>
												</span>

												<span id="remove_link">
													<img src="static/images/remove.png" id="add_ico" height="30px" width="30px">
													<span id="remove" class="add-rem-tag">Remove</span>
												</span>
											</td>
										</tr>						
									</tfoot>
									
									<tbody id="product_point_record">
										<tr id="row1">
											<td class="block1">
												1.
											</td>
											<td class="block2">
												<input type="text" name="point_title1" class="p-input2 pnt">
											</td>
											<td class="block3">
												<textarea name="product_point1" rows="4" cols="40" class="point_txt1"></textarea>
											</td>
										</tr>
									</tbody>
								</table>
							</div>

							<div class="btn" id="next5">Next</div>
						</div>

						<div class="right-input">							
							<span class="h1">6. Book Pics</span>

							<div class="p-table">
								<table id="p_ar_table">
									<tfoot>
										<tr>
											<td>&nbsp</td>										
											<td align="right">
												
												<span id="add_more_img">
													<img src="static/images/add.png" id="add_ico" height="30px" width="30px">
													<span id="add_more" class="add-rem-tag">Add More</span>
												</span>

												<span id="remove_img">
													<img src="static/images/remove.png" id="add_ico" height="30px" width="30px">
													<span id="remove" class="add-rem-tag">Remove</span>
												</span>
											</td>
										</tr>						
									</tfoot>
									
									<tbody id="product_images1">
										<tr id="img_row1">
											<td class="block1">
												1.
											</td>
											<td class="block2">
												<img id="output_image_ufile1" class="img_size">

												<button id="ubutton1" class="product-image-text "></button>
												<label id="uf-button1" for="ubutton1" class="p-images-buttons" onclick="img_click(event)">Choose a file</label>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
							
							<div class="btn" id="next6" onclick="preview_product()">Next</div>			
						</div>

					</form>
				</div>
			</div>		
			
			<div class="admin">
				<span>A</span>
				<span>D</span>
				<span>M</span>
				<span>I</span>
				<span>N</span>
			</div>

			<div class="admin-strip">
				<div class="circle" id="circle1"><h3>1</h3></div>
				<div class="circle" id="circle2"><h3>2</h3></div>
				<div class="circle" id="circle3"><h3>3</h3></div>
				<div class="circle" id="circle4"><h3>4</h3></div>
				<div class="circle" id="circle5"><h3>5</h3></div>
				<div class="circle" id="circle6"><h3>6</h3></div>
			</div>
		</div>
        </div>
		<script src="static/js/add_new_book.js"></script>
		<script src="static/js/searchbar.js"></script>
		
	</body>
</html>
