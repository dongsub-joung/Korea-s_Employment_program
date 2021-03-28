// Date()

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