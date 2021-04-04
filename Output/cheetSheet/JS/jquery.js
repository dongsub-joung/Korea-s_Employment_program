
/* 
	BTN option using move Up and Down element array 
*/
// 1. class 
index= 0; 
len= $("p").length;
$("#btnUP").click(()=>{
	$("p").eq(index).removeClass("indexSet");
	index++;
	if (index>=len) { index= 0; }
});	
$("#btnDown").click(()=>{
	$("p").eq(index).removeClass("indexSet");
	index--;
	if (index<0) {index=len-1;}
});	

// 2. Move image btn pre/next
let index= 0;
// Save images in img_arr (init)
img_arr= new Array(ARRAY_MAX);
function next() {
	index++;
	if (index>ARRAY_MAX-1) {
		index= 0;
		document.getElementById("header_img").src= img_arr[index];
	} else {
		document.getElementById("header_img").src= img_arr[index];
	}
}
function pre() {
	index--;
	if (index<0) {
		index= ARRAY_MAX-1;
		document.getElementById("header_img").src= img_arr[index];
	} else {
		document.getElementById("header_img").src= img_arr[index];
	}
}



/* 
	Exit Main - Sub Select-Option 
	If user Selecte Main option, display Sub option value.
*/
function selectMain() 
{
	mainval= $("#mainCate > option:selected").val();
	initdat= "<option value=''> 전체 </option>";
	switch(mainval) 
	{
		case '1':
			curdate= initdat;
			break;
		case '2':
			curdate= initdat;
			curdate+= "<option value= 'STH1'> STH </option>";
			curdate+= "<option value= 'STH2'> STH </option>";
			$("select#subCate").html(curdate);
			break;
		case '3':
			curdate= initdat;
			curdate+= "<option value= 'STH1'> STH </option>";
			curdate+= "<option value= 'STH2'> STH </option>";
			$("select#subCate").html(curdate);
			break;
		default:
			break;	
	}
}
setInterval(selectMain, 500);



/* 
	Set Date()
	Get Year, Month, Day
	Get Hour, Min, Sec
*/
function currentTime()
{
	// Date instance
	let date= new Date();

	// Get value
	let year = date.getFullYear();
	let month = date.getMonth()+1;	// 달은 0부터 시작됨
	let day = date.getDate();
	var hour = date.getHours();		// 1~24시
	var min = date.getMinutes();
	var sec = date.getSeconds();

	// Change HTML text
	hour = updateTime(hour);
	min = updateTime(min);
	sec = updateTime(sec);
}
function updateTime(k) 
{
	if(k<10) { k="0"+k; }
	else	 { k = k; }
	return k;
}
id = setInterval("currentTime()",1000);

/* 
	Set table row 
*/
function addRow() 
{
	//현재 달의 처음날짜계산 마지막 날짜 전체계산
	var lastDate = new Date(today.getFullYear(), today.getMonth()+1, 0);
	var startDate = new Date(today.getFullYear(), today.getMonth(), 1);
	
	//현재 달의 처음일, 마지막일
	var startDay = startDate.getDate();
	var lastDay = lastDate.getDate(); 
	//요일
	var weekStartDay = startDate.getDay();
	var weekLastDay = lastDate.getDay(); 
	
	var tbl = document.getElementById("calendar");
	
	//1개의 행을 추가
	var newRow = tbl.insertRow();
	
	var cnt = 0;
	var newCell = null;
	for(n=0; n<weekStartDay; n++) {
		newCell = newRow.insertCell();
		cnt++;
	}
	
	for(d=1; d<=lastDay+3; d++) {
		 
		newCell = newRow.insertCell();
		if (d>lastDay) {
			newCell.innerHTML = "";
		}
		else if(d<=lastDay) {
			newCell.innerHTML = d;
		}
		cnt++;
		
		if(cnt%7==0) {
			if (d>lastDay) {
				newCell.innerHTML = "";
			}
			else {
				// 7개 열 추가 후 다음 행 추가
				newRow = tbl.insertRow();
				newCell.innerHTML = "<span class='sat'>"+d+"<span>";
			}
		}
		if(cnt%7==1) {
			if (d>lastDay) {
				newCell.innerHTML = "";
			}
			else {
				newCell.innerHTML = "<span class='sun'>"+d+"<span>";
			}
		}
	}
}