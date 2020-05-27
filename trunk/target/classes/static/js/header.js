var ts=document.getElementsByClassName("go-back");
for (var i=0;i<ts.length;i++){
    ts[i].addEventListener("click",function (evt) {
        window.history.back();
    })
}