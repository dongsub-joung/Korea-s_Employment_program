$(()=>{
	$("body").css("width", "1200px");
	$("*").css("width", "inherit");
	$(".e01").css("border", "2px solid black");
	$(".e01").css("font-size", "2.0em");
	
	$("#hi").css("background-color", "blue");
	$(".chars").css("width", "100%");
	$(".chars").css("height", "50px");

	$("#a").css("background-color", "green");
	$("#b").css("background-color", "yellow");
	$("#c").css("background-color", "black");
	$("div[my-data=`1234`]").css("background-color", "red");
	$("div[my-data=`1234`]").css("width", "100%");

	$(".login_wrrap").css("width", "500px");
	$(".login_wrrap").css("height", "100px");
	$(".login_wrrap").css("background-color", "lightgreen");
	$(".login_wrrap").css("text-align", "center");
	$("input").css("width", "200px");
	$("input").css("margin", "20px");
	$("button").css("width", "100px");
	$(".login_btn").click(()=>{
		// $(".login_btn").textContent("Join");
		$(".login_btn").css("background-color", "black");
		$(".login_btn").css("color", "white");
	});
});