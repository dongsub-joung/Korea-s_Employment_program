let sc= new Array(); let sum= 0;
function ex01() {
	let i= 0; 
	while(true)
	{
		input= prompt("Please enter score(EXIT: 0", "");
		if (input == '0') { break; }
		else
		{
			sc[i]= element = parseInt(input);
			// console.log(sc[i]);
			sum+= element;
			i++;
		}
	}
	cnt= sc.lenght;
	for(j=0; j<sc.length; j++) { 
		document.write("Score " + sc[j]); 
		document.write("<br>");
	}
	document.write("SUM "+ sum + ", AVG " + (sum/sc.length) );
}

function ex02() {
	const RANGE= 9;
	var arr_value01= new Array(RANGE);
	var arr_value02= new Array(RANGE);
	for(let i=1; i<=RANGE; i++)
	{
		arr_value01[i]= i;
		for(let j=1; j<=RANGE; j++)
		{
			arr_value02[j]= j;
			result= arr_value01[i]*arr_value02[j]
			console.log(i+"*"+j+"="+result);
		}
	}
}

let dice= new Array(5);
let result= new Array(5);
function ex03() {
	for (var i = 1; i <= 6; i++) {
		dice[i]= `../img_dice_22/D${i}.png`;
	}
	for(let j=0; j<=5; j++)
	{
		result[j]= Math.floor(Math.random()*6)+1;
	}
}
let index= 0;
function setDice() {
	ex03();
	set();
	setInterval(set, 3000);
}
function set() {
	document.getElementById("ex03_array").innerText= result;
	document.getElementById("ex03_img").src= dice[result[index]];
	index++;
	if (index>5) {index=0;}
}

let mat1= new Array(25);
let mat2= Array.from(Array(5), () => new Array(5));
// const arr1 = Array.from(Array(5), () => new Array(2)

function ex04() {
	// mat1 -> mat2
	for(i=0; i<25; i++) {
		mat1[i]= i+1;
	}

	const N= 6; let x= 0; let y=6;
	for(j=0; j<5; j++) 
	{
		mat2[j]= mat1.slice(x,y);
		x+=6; y+=6;
	}

	console.log(mat1);
	console.log(mat2);
	document.getElementById("arr1").innerText= mat1;
	document.getElementById("arr2").innerText= mat2;
}