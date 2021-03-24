const IMG_RANGE= 3;
let img_arr= new Array(IMG_RANGE);

for(let i=1; i<=IMG_RANGE; i++) {
	img_arr[i-1]= `img22/web22_${i}.jpg`;
}
	
let j= 0;
function pre() {
	j--;
	if (j < 0) {j= IMG_RANGE-1}
	document.getElementById("img2").src= img_arr[j];;
}

function next() {
	j++;
	if (j == IMG_RANGE) { j=0 }
	document.getElementById("img2").src= img_arr[j];
}

function autoSlide() {
	next();
}

id= setInterval("autoSlide()", 3000);

function currentSlide(n) {
	document.getElementById("img2").src= img_arr[n];;
}

// onmouseover
function changeImg() {
	document.getElementById("demo").src= "images/tiger.gif";
}