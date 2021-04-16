
// var line01_arr= document.querySelector(".sub_m1").querySelectorAll("a");

function showMain(){
	document.getElementById("content").innerHTML= `<object type= "text/html" data= "ROOT_content.html"></object>`;
}

window.addEventListener('load', (event) => {
  showMain();
}, { once : true});


/*
	Main contents URL
*/

// Main01 - Sub01
// $ /Sub01 > 01, 02, 03
const URL_Sub_menuA_01= `<object type= "text/html" data= "/Sub01/Sub01_01.html"></object>`;
const URL_Sub_menuA_02= `<object type= "text/html" data= "/Sub01/Sub01_02.html"></object>`;
const URL_Sub_menuA_03= `<object type= "text/html" data= "/Sub01/Sub01_02.html"></object>`;

// Main01 - Sub02
// $ /Sub02 > 01, 02, 03
const URL_Sub_menuB_01= `<object type= "text/html" data= "/Sub02/Sub02_01.html"></object>`;
const URL_Sub_menuB_02= `<object type= "text/html" data= "/Sub02/Sub02_02.html"></object>`;
const URL_Sub_menuB_03= `<object type= "text/html" data= "/Sub02/Sub02_03.html"></object>`;

function setConten(URL){
	delete showMain.innerHTML;
	document.getElementById("content").innerHTML= `${URL}`;
}

$(()=>{


/*
	$("각각의 class들 속 a") 선택 후 클릭 이벤트 -> index 받아서 해당 인덱스면 url 이동
	| sub_m1 | sub_m2 |
	<!-- html 속 html 넣기 -->
	<!-- https://soft91.tistory.com/27 -->
*/

// Main logo Event
	$("#home_dir").click(function(){
		showMain();
	});

/*
	Main menu 01
	$(".sub_m1 a") => objec Array a tag 0,1,2 
*/
// Sub menu 01
	const Sub_menuA_01= 0;
	$(".sub_m1 a").eq(Sub_menuA_01).click(function(){ setConten(URL_PL_main_bc); });

// Sub menu 02
	const Sub_menuA_02= 1;
	$(".sub_m1 a").eq(Sub_menuA_02).click(function(){ setConten(URL_PL_map_intro); });

// Sub menu 03
	const Sub_menuA_03= 2;
	$(".sub_m1 a").eq(Sub_menuA_03).click(function(){ setConten(URL_PL_CP_car_park); });


/*
	Main menu 02
	$(".sub_m2 a") => objec Array a tag 0,1,2
*/
// Sub menu 01
	const Sub_menuB_01= 0;
	$(".sub_m2 a").eq(Sub_menuB_01).click(function(){ setConten(URL_PLC_mu); });

// Sub menu 02
	const Sub_menuB_02= 1;
	$(".sub_m2 a").eq(Sub_menuB_02).click(function(){ setConten(URL_PLC_Contents_01); });

// Sub menu 03
	const Sub_menuB_03= 2;
	$(".sub_m2 a").eq(Sub_menuB_03).click(function(){ setConten(URL_PLC_festival_01); });
