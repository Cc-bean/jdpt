function showmask(){
	for (var i=0;i<arguments.length;i++) {
		arguments[0].style.display="block";
	}
}
function hiden(it){
	it.style.display="none";
}

var dycards=document.getElementsByClassName("dycard");
for(var i=0;i<dycards.length;i++){
		dycards[i].addEventListener("click",function(e){
		e.stopPropagation();
	})
}
var dangyuans=document.getElementsByClassName("dangyuan");
for(var i=0;i<dangyuans.length;i++){
		dangyuans[i].addEventListener("click",function(e){
		e.stopPropagation();
	})
}
