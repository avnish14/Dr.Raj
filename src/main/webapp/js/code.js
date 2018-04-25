$("a[href='#']").click(function(e){
	e.preventDefault();
});
$(".hover-dropdown").mouseenter(function(){
	$(this).children(".hover-dropdown-menu").addClass("open");
}).mouseleave(function(){
	$(this).children(".hover-dropdown-menu").removeClass("open");
});
$(".menubutton").click(function(){
	$(".mobilemenu").addClass("open");
	$("body").css("overflow","hidden");
});
$(".mobilemenu .closebutton").click(function(){
	$(".mobilemenu").removeClass("open");
	$("body").css("overflow","auto");
});
$(".dropdown-button").mouseenter(function(){
	target=$($(this).attr("target"));
	target.addClass("open");
	/*target.css("display","block");
	setTimeout(function(){
		target.css("opacity","1");
	},50);*/
}).mouseleave(function(){
	target=$($(this).attr("target"));
	target.removeClass("open");
			/*if(!target.hasClass("in")){
			target.css("opacity","0");
			setTimeout(function(){
				target.css("display","none");
			},250);
		}*/
});
$("body").on("mouseenter",".container-dropdown-menu",function(){
	/*target=$(this);
	target.addClass("in");
	target.css("display","block");
	setTimeout(function(){
		target.css("opacity","1");
	},50);*/
}).on("mouseleave",".container-dropdown-menu",function(){
	/*target=$(this);
	target.removeClass("in");
	setTimeout(function(){
		target.css("opacity","0");
		setTimeout(function(){
			target.css("display","none");
		},350);
	},300);*/
})
$(".ratingBlock.input .item").mouseenter(function(){
	var ind=$(this).index()+1;
	$(this).parent().children(".item:nth-child(1)").children("img").attr("src","imgs/stare.svg");
	$(this).parent().children(".item:nth-child(2)").children("img").attr("src","imgs/stare.svg");
	$(this).parent().children(".item:nth-child(3)").children("img").attr("src","imgs/stare.svg");
	$(this).parent().children(".item:nth-child(4)").children("img").attr("src","imgs/stare.svg");
	$(this).parent().children(".item:nth-child(5)").children("img").attr("src","imgs/stare.svg");
	$(this).children("img").attr("src","imgs/starf.svg");
	if(ind==2){
		$(this).parent().children(".item:nth-child(1)").children("img").attr("src","imgs/starf.svg");
	}
	if(ind==3){
		$(this).parent().children(".item:nth-child(1)").children("img").attr("src","imgs/starf.svg");
		$(this).parent().children(".item:nth-child(2)").children("img").attr("src","imgs/starf.svg");
	}
	if(ind==4){
		$(this).parent().children(".item:nth-child(1)").children("img").attr("src","imgs/starf.svg");
		$(this).parent().children(".item:nth-child(2)").children("img").attr("src","imgs/starf.svg");
		$(this).parent().children(".item:nth-child(3)").children("img").attr("src","imgs/starf.svg");
	}
	if(ind==5){
		$(this).parent().children(".item:nth-child(1)").children("img").attr("src","imgs/starf.svg");
		$(this).parent().children(".item:nth-child(2)").children("img").attr("src","imgs/starf.svg");
		$(this).parent().children(".item:nth-child(3)").children("img").attr("src","imgs/starf.svg");
		$(this).parent().children(".item:nth-child(4)").children("img").attr("src","imgs/starf.svg");
	}
}).mouseleave(function(){
	if($(this).siblings("input").val()=="0"||$(this).siblings("input").val()==""){
		$(this).parent().children(".item:nth-child(1)").children("img").attr("src","imgs/stare.svg");
		$(this).parent().children(".item:nth-child(2)").children("img").attr("src","imgs/stare.svg");
		$(this).parent().children(".item:nth-child(3)").children("img").attr("src","imgs/stare.svg");
		$(this).parent().children(".item:nth-child(4)").children("img").attr("src","imgs/stare.svg");
		$(this).parent().children(".item:nth-child(5)").children("img").attr("src","imgs/stare.svg");
	}
	else{
		var val=$(this).siblings("input").val();
		if(val==1){
			$(this).parent().children(".item:nth-child(1)").children("img").attr("src","imgs/starf.svg");
			$(this).parent().children(".item:nth-child(2)").children("img").attr("src","imgs/stare.svg");
			$(this).parent().children(".item:nth-child(3)").children("img").attr("src","imgs/stare.svg");
			$(this).parent().children(".item:nth-child(4)").children("img").attr("src","imgs/stare.svg");
			$(this).parent().children(".item:nth-child(5)").children("img").attr("src","imgs/stare.svg");		
		}
		if(val==2){
			$(this).parent().children(".item:nth-child(1)").children("img").attr("src","imgs/starf.svg");
			$(this).parent().children(".item:nth-child(2)").children("img").attr("src","imgs/starf.svg");
			$(this).parent().children(".item:nth-child(3)").children("img").attr("src","imgs/stare.svg");
			$(this).parent().children(".item:nth-child(4)").children("img").attr("src","imgs/stare.svg");
			$(this).parent().children(".item:nth-child(5)").children("img").attr("src","imgs/stare.svg");		
		}
		if(val==3){
			$(this).parent().children(".item:nth-child(1)").children("img").attr("src","imgs/starf.svg");
			$(this).parent().children(".item:nth-child(2)").children("img").attr("src","imgs/starf.svg");
			$(this).parent().children(".item:nth-child(3)").children("img").attr("src","imgs/starf.svg");
			$(this).parent().children(".item:nth-child(4)").children("img").attr("src","imgs/stare.svg");
			$(this).parent().children(".item:nth-child(5)").children("img").attr("src","imgs/stare.svg");		
		}
		if(val==4){
			$(this).parent().children(".item:nth-child(1)").children("img").attr("src","imgs/starf.svg");
			$(this).parent().children(".item:nth-child(2)").children("img").attr("src","imgs/starf.svg");
			$(this).parent().children(".item:nth-child(3)").children("img").attr("src","imgs/starf.svg");
			$(this).parent().children(".item:nth-child(4)").children("img").attr("src","imgs/starf.svg");
			$(this).parent().children(".item:nth-child(5)").children("img").attr("src","imgs/stare.svg");		
		}
		if(val==5){
			$(this).parent().children(".item:nth-child(1)").children("img").attr("src","imgs/starf.svg");
			$(this).parent().children(".item:nth-child(2)").children("img").attr("src","imgs/starf.svg");
			$(this).parent().children(".item:nth-child(3)").children("img").attr("src","imgs/starf.svg");
			$(this).parent().children(".item:nth-child(4)").children("img").attr("src","imgs/starf.svg");
			$(this).parent().children(".item:nth-child(5)").children("img").attr("src","imgs/starf.svg");		
		}
	}
}).click(function(){
	var ind=$(this).index()+1;
	$(this).siblings("input").val(ind);
});
if($(".ratingBlock")[0]){
	$(".ratingBlock").each(function(){
		if(!$(this).hasClass("input")){
			var value=$(this).attr("value");
			for(var i=0;i<value;i++){
				$(this).append("<span class='item'><img src='imgs/starf.svg'/></span>");
			}
			for(var i=value;i<5;i++){
				$(this).append("<span class='item'><img src='imgs/stare.svg'/></span>");
			}
		}
	});
}
function callAjax(url, executor) {
    $.ajax({
        url: url,
        success: function (data) {
            executor(data);
        }
    });
}
function titleCaseSentence(str) {
    var capflag = true;
    var final = "";
    if (str.length > 0) {
        for (i = 0; i < str.length; i++) {
            if (capflag) {
                final += str[i].toUpperCase();
                capflag = false;
            }
            else final += str[i].toLowerCase();
            if (str[i] == ' ' || str[i] == '.') capflag = true;
        }
    }
    return final;
}
$("body").on("click",".modelButton",function(){
	var target=$($(this).attr("target"));
	openModel(target);
});
function openModel(target){
	$("body").css({"padding-right":$(window).outerWidth()-$("body").outerWidth(),"overflow":"hidden"});
	target.css("display","block");
	target.addClass("open");
	setTimeout(function(){
		target.css("opacity","1");
	},50);
}
function closeModel(){
	target=$(".model.open");
	target.css("opacity","0");
	setTimeout(function(){
		target.css("display","none");
		$("body").css({"overflow":"auto","padding-right":"0"});
	},350);
	target.removeClass("open");
}
$(".model .body").click(function(){
	return false;
});
$(".model .bodyParent,.modelCloser").click(function(){
	closeModel();
});
$("body").keydown(function(e){
	if(e.keyCode==27){
		closeModel();
	}
});
$("body").on("click",".owl-carousel-wrapper .left-arrow",function(){
	var target=$($(this).parent().data("target"));
	target.trigger("prev.owl.carousel");
});
$("body").on("click",".owl-carousel-wrapper .right-arrow",function(){
	var target=$($(this).parent().data("target"));
	target.trigger("next.owl.carousel");
});