var floders=document.getElementsByClassName("flod-body");
			var floded=document.getElementsByClassName("flod-body flod-active");
			for(var i=0;i<floders.length;i++){
				floders[i].addEventListener("click",function(){
					//alert(1);
					if(this.className=="flod-body flod-active"){
						this.classList.remove("flod-active");
					}else{
						this.classList.add("flod-active");
						floded.classList.remove("flod-active");
						floded.style.height="2.6rem";
					}
					
				})
			}