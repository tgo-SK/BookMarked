<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
	<head>
		<title>Edit Book</title>
		<link href="https://fonts.googleapis.com/css2?family=Exo:wght@500&family=Signika:wght@400;700&family=Trispace&display=swap" rel="stylesheet"><!-- h1 -->
		<link href="https://fonts.googleapis.com/css2?family=Trispace&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css2?family=Signika:wght@700&family=Trispace&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css2?family=Ropa+Sans&family=Viga&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css2?family=Chivo&family=Ropa+Sans&family=Viga&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="static/css/edit.css">
		<link rel="stylesheet" href="static/css/header.css">
		<link rel="stylesheet" href="static/css/searchbar.css">
		<link rel="stylesheet" href="static/css/full_page_scroll.css"> 
		<link rel="stylesheet" href="static/css/footer2.css">
	</head>
	<body>
		<div class="bd">
			<div class="hd">
				<%@ include file="header.jsp" %>
			</div>
		<div style="display:none;" id="bookidd">${editbook.bookId}</div>
		<div class="admin-container">
			<div class="admin-box">
				<div class="right-input-box">					
						<div class="right-input">					
							<span class="h1">1. New Book</span>	
							<p class="p-label">Book Category:
							<select class="sel" id="category1" name="p_option1">
								<c:forEach var="cat" items="${category}">
								<c:if test="${cat.category != editbook.category.category}">
										<option value="${cat.categoryId}">${cat.category}</option>
								</c:if>

								<c:if test="${cat.category == editbook.category.category}">
										<option value="${cat.categoryId}" selected>${cat.category}</option>
								</c:if>

								</c:forEach>
							</select></p>
							<label for="p_name" class="p-label">Book Name:</label>
							<input type="text" name="p_name1" class="p-input" id="p-name" value="${editbook.title}">

							<label for="p_price" class="p-label">Price:</label>
							<input type="number" name="p_price1" id="p-price" class="p-input" value="${editbook.price}">


							<label for="p_author" class="p-label">Author:</label>
							<input type="text" name="p_author" id="p-author" class="p-input" value="${editbook.author}">
							
							<div class="btn" id="next1">Next</div>
							
						</div>

						<div class="right-input">
							<span class="h1">2. Book Description</span>

							<label for="p-desc1" class="p-label">Please provide Book Description here.</label>
							<textarea name="p_desc1" id="p-desc1" rows="10" cols="100">${editbook.description}</textarea>
							
							<input type="hidden" id="book_id" value="">
							<div class="btn" id="next2">Next</div>
						</div>

						<div class="right-input">
							<span class="h1">3. Book Type</span>

							<span style="display:block">
							<c:if test="${editbook.fileType.fileTypeId == 1}">
								<input type="radio" name="p_type1" id="p_type1" value="e-book" checked>
							</c:if>
							<c:if test="${editbook.fileType.fileTypeId == 2}">
								<input type="radio" name="p_type1" id="p_type1" value="e-book">
							</c:if>
							<label for="p_type1" class="p-label" style="display:inline-block">e-Book</label>
							</span>

							<span style="display:block" >
							<c:if test="${editbook.fileType.fileTypeId == 2}">
								<input type="radio" name="p_type1" id="p_type2" value="Audio Book" checked>
							</c:if>
							<c:if test="${editbook.fileType.fileTypeId == 1}">
								<input type="radio" name="p_type1" id="p_type2" value="Audio Book">
							</c:if>
							<label for="p_type2" class="p-label" style="display:inline-block">Audio Book</label>
							</span>

							

							<div class="btn" id="next3">Next</div>
						</div>

						<div class="right-input">
							<span class="h1">4. Payment Details</span>

						<!-- 
							<input type="checkbox" name="p_payment1" id="p_payment1" value="Paytm">
								<label for="p_payment1" class="p-label" style="display:inline-block">Paytm</label><br>
								<input type="checkbox" name="p_payment1" id="p_payment1" value="Paytm">
								<label for="p_payment1" class="p-label" style="display:inline-block">PayPal</label><br>
								<input type="checkbox" name="p_payment1" id="p_payment1" value="Paytm">
								<label for="p_payment1" class="p-label" style="display:inline-block">Google Pay </label> -->
								
								
								<label for="pay-desc" class="p-label">Please provide Payment Details here.</label>
							    <textarea name="pay_desc" id="p-desc" rows="20" cols="100">${editbook.payment}</textarea>

							<div class="btn" id="next4">Next</div>
						</div>

						<div class="right-input">
							<span class="h1">5. Pointwise Book's Details</span>
							
							<div class="p-table">
								<table id="p_ar_table">
									<thead>
										<tr class="record_header">
											<th class="p-label_">&nbsp;</th>
											<th class="p-label_">Point-Title</th>
											<th class="p-label_">Point-Value</th>
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
							
											</td>
											<td class="block2">
												<!-- <input type="text" name="point_title" class="p-input2 pnt"> -->
											</td>
											<td class="block3">
												<!-- <textarea name="product_point" rows="4" cols="40" class="point_txt1"></textarea> -->
											</td>
										</tr>
									</tbody>
								</table>
							</div>

							<div class="btn" id="next5">Next</div>
						</div>
						
									<form action="bookFilesUdate.do" method="post" enctype="multipart/form-data" id="fileForm">
						<div class="right-input">							
							<span class="h1">6. Book's Pics</span>

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
							
								<input type="file" accept="image/*" onchange="preview_image(event)" id="ufile1" name="p_pic1" class="product-image-text p_images1">
								<label for="ufile1">Choose a file</label>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
								<img src="bookpic.do?bookId=${editbook.bookId}" id="booked" onclick="filepre()">
								<input type="file" accept=".pdf" id="pfile1" name="p_file1" class="product-image-text">
								<label for="pfile1" id="pfile_label1" style="display:none">Choose a .pdf file</label>

								<input type="file" accept=".mp3" id="pfile2" name="p_file1" class="product-image-text">
								<label for="pfile2" id="pfile_label2" style="display:none">Choose a .mp3 file</label>
							<div class="btn" id="next6" onclick="updateTest()">Next</div>
								<!-- <input type="submit" class="btn" id="next6" value="SUBMIT"/> -->
							
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
		<div class="ft">
		<!-- 	<%@ include file="footer.jsp" %> -->
		</div> 
		</div>
		<script>
			row1 = document.querySelectorAll("row1").length + 1;
			row2 = document.querySelectorAll("row2").length + 1;
			var nrow;
			var cell1,cell2,cell3;
			var input_field;
			<c:forEach var="ep" items="${editbookpoints}">
				nrow = product_point_record.insertRow(row1++);

				cell1 = nrow.insertCell(0);
				cell2 = nrow.insertCell(1);
				cell3 = nrow.insertCell(2);

				cell1.innerHTML = `${row1}.`;
				cell1.className = 'block1';

				input_field = document.createElement('input');
				input_field.className = 'p-input2 pnt';
				input_field.setAttribute('name',"point_title");
				input_field.setAttribute('value',"${ep.pointHeader}");
				cell2.append(input_field);
				cell2.className = 'block2';
				
				cell3.innerHTML = '<textarea class="point_txt1" name="product_point" rows="4" cols="40">${ep.pointValue}</textarea>';
				cell3.className = 'block3';		
			</c:forEach>
		
		function filepre(){
			window.location.assign("bookfileshow.do?bookid=${editbook.bookId}&filetype=${editbook.fileType.fileTypeId}");
		
		}

		</script>
		<script src="static/js/edit.js"></script>
	</body>
</html>
