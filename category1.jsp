      <div id="main">
        
        <div class="circle-box">
          <div class="over">
          <svg class="_svg" height='602' width='602'>
            <circle r='300' cx='301' cy='301' stroke-width='1px' stroke='gray' fill='none'/>
          </svg>
          <svg class="_svg" height='602' width='602'>
            <circle id="svgCircle" r='300' cx='301' cy='301' stroke-width='1px' stroke='white' fill='none'/>
          </svg>
          
          <div>
            <span class='_span' id="step1"> <img class="cimg" src="static/images/SapnaOnline/software_.png">
            </span>

            <span class='_span' id="step2"> <img class="cimg" src="static/images/SapnaOnline/medical_.png">
            </span>

            <span class='_span' id="step3"> <img class="cimg" src="static/images/SapnaOnline/management_.png">
            </span>

            <span class='_span' id="step4"> <img class="cimg" src="static/images/SapnaOnline/law_.png">
            </span>

            <span class='_span' id="step5"> <img class="cimg" src="static/images/SapnaOnline/engineering.png">	
            </span>

          </div>

          <div class='user-box' id="userBox">

          	<div class="user"><img class='mid-img' src="static/images\SapnaOnline\imgf\engg.png">
          	<div class='cat-head'>Engineering</div>
          	<p>hello this is engineering field for more books please click on the button for more awesome books and for more category click on more options </p><br><br>
          	<a href="showallbooks.do?caterory=1" class="btn">Read More</a>
          	</div>

          	<div class="user"><img class='mid-img' src="static/images\SapnaOnline\imgf\software.png">
          	<div class='cat-head'>Civil Services</div>
          	<p>hello this is engineering field for more books please click on the button for more awesome books and for more category click on more options </p><br><br>
          	<a href="showallbooks.do?caterory=5" class="btn">Read More</a>
          	</div>

          	<div class="user"><img class='mid-img' src="static/images\SapnaOnline\imgf\med.png">
          	<div class='cat-head'>Medical</div>
          	<p>hello this is engineering field for more books please click on the button for more awesome books and for more category click on more options </p><br><br>
          	<a href="showallbooks.do?caterory=2" class="btn">Read More</a>
          	</div>

          	<div class="user"><img class='mid-img' src="static/images\SapnaOnline\imgf\manag.png">
          	<div class='cat-head'>Management</div>
          	<p>hello this is engineering field for more books please click on the button for more awesome books and for more category click on more options </p><br><br>
          	<a href="showallbooks.do?caterory=3" class="btn">Read More</a>
          	</div>

          	<div class="user"><img class='mid-img' src="static/images\SapnaOnline\imgf\law.png">
          	<div class='cat-head'>Law</div>
          	<p>hello this is engineering field for more books please click on the button for more awesome books and for more category click on more options </p><br><br>
          	<a href="showallbooks.do?caterory=4" class="btn">Read More</a>
          	</div>


          </div>
          </div>
        </div>
      </div>
      <script>
        var svgCircle = document.getElementById('svgCircle');
        var step1 = document.getElementById('step1');
        var step2 = document.getElementById('step2');
        var step3 = document.getElementById('step3');
        var step4 = document.getElementById('step4');
        var step5 = document.getElementById('step5');
        var main = document.getElementById('main');
        var userBox = document.getElementById('userBox');


        main.style.backgroundImage = "url('static/images/back.jpg')";

        step1.addEventListener('click',()=>{
          svgCircle.style.strokeDashoffset = '1508';
         /* main.style.backgroundImage = "url('static/images/back.jpg')";*/
          userBox.style.top = "-550px";
        });

        step2.addEventListener('click',()=>{
          svgCircle.style.strokeDashoffset = '1131';
          /*main.style.backgroundImage = "url('static/images/img-2.jpg')";*/
          userBox.style.top = "-1260px";
        });

        step3.addEventListener('click',()=>{
          svgCircle.style.strokeDashoffset = '754';
          /*main.style.backgroundImage = "url('static/images/img-3.jpg')";*/
          userBox.style.top = "-1970px";
        });

        step4.addEventListener('click',()=>{
          svgCircle.style.strokeDashoffset = '377';
          /*main.style.backgroundImage = "url('static/images/img-4.jpg')";*/
          userBox.style.top = "-2680px";
        });

        step5.addEventListener('click',()=>{
          svgCircle.style.strokeDashoffset = '0';
/*main.style.backgroundImage = "url('static/images/img-5.jpg')";*/
          userBox.style.top = "150px";
        });
</script>

