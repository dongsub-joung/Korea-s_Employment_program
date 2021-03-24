function changeImg() {
	// let opt= document.getElementById("demo").src;
	const TIGER= "images/tiger.gif";
	const BIRD= "images/bird.gif";
	if (opt == TIGER) {
		opt= BIRD;
	} else {
		opt= TIGER;
	}
}

function checkLogin() {
	id= document.getElementById("user_id").value;
	pw= document.getElementById("user_pw").value;
	// console.log(id+","+pw);
	if (id == "java") {
		if (pw == "1234") {
			console.log("PASS");
		} else {
			console.log("Incorrect PW");
		}
	} else {
		console.log("Incorrect ID");
	}
}


var p_tag= document.createElement("span");
const CODE= createRandomCode();
p_tag.innerText= CODE;
var praent_tag= document.getElementById("code");
praent_tag.appendChild(p_tag);

function createRandomCode() {
	// 1. i=10; j=26; chars= [[0,2,3...],[a,b,c...],[A,B,C..]];
	// 2. chars= '0'~'9'; chars= 'A'~'Z; chars= 'a'~'z;
	chars= "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	const MAX= 36; let code= "";
	for (i = 0; i<5; i++) 
	{
		j= Math.floor(Math.random()*36);
		code+= chars.charAt(j);	
	}
	// 2. chars.substring(i,i+1);
	return code;
}

function checkCode() {
	const INPUT= document.getElementById("code_input").value;
	if (CODE == INPUT) { alert("PASS"); }
	else { alert("NOT"); }
}

let id_input= document.getElementById("ID02").value;
let id_check_input= document.getElementById("email").value;
let pw_input= document.getElementById("PW02").value;
let pw_check_input= document.getElementById("check_pw").value;
if (id_input=="" || id_check_input=="" || pw_input=="" || pw_check_input==""){
	alert("Please enter blink.")
}

function join () {
	if (pw_input == pw_check_input) {console.log("PASS");}
	else { alert("Please check PW"); }
}
