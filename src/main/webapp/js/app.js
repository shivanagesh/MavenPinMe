function setLimit(){
var selected = document.querySelector("#settinglimit").value;
if(selected === "yes"){
$("#limit").css("display","block");
}else{
	$("#limit").css("display","none");
}
}