
// Control img
const ARRAY_MAX= 4;
img_arr= new Array(ARRAY_MAX);
img_arr[0]= "image/1_spring.jpg";
img_arr[1]= "image/2_summer.jpg";
img_arr[2]= "image/3_fall.jpg";
img_arr[3]= "image/4_winter.jpg";

let index= 0;
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


// Control yy mm
// Create Date Obj
let today= new Date();
let lastDate= "";

let month=0;
function curentTime()
{
	let date= new Date();
	let year= date.getFullYear();
	month= date.getMonth()+1;

	document.getElementById("year").innerText= `${year}년 ${month}월`;
}
curentTime();
id= setInterval("curentTime();", 10000);

console.log(month);
if (1<=month<=3) {document.getElementById("header_img").src= img_arr[0];}
else if (4<=month<=6) {document.getElementById("header_img").src= img_arr[1];}
else if (7<=month<=9) {document.getElementById("header_img").src= img_arr[2];}
else if (10<=month<=12) {document.getElementById("header_img").src= img_arr[3];}
// 0,1,2
// 3,4,5
// 6,7,8
// 9,10,11

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
addRow();