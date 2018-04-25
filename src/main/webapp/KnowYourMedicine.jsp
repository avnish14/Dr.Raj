<%@page import="DrRAJ.DAO.IngredientDAO"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Know Your Medicine | Dr. Raj Homoeo Pharmacy</title>
<%@include file="UserHeader.jsp"%>
<%
	Gson gson = new Gson();
	String temp = gson.toJson(new IngredientDAO().select());
%>
<div class="rawdata hidden"><%=temp%></div>
<section class="bgimage maincover regular"
	style="background-image: url(https://farm5.staticflickr.com/4744/26597342428_be0c40a818_o_d.jpg);">
<div class="blackcover"></div>
<div class="container">
	<h3>Health and Homoeopathy</h3>
	<div class="jumbotext">Know Your Medicine</div>
</div>
<div class="posab">
	<img src="imgs/bottomwhitecircle.svg" />
</div>
</section>
<section>
<div class="container thousand">
	<div class="row marginB20">
		<div class="cs4 nomargin know-your-medicine-search">
			<div class="iconTextBox left full">
				<input type="text" class="textbox searchbox"
					placeholder="Search Medicine"> <img src="imgs/search.svg" />
			</div>
		</div>
		<div class="cs1 nomargin"></div>
		<div class="cs7 sortChars">
			<span class="sortChar active">All</span>
		</div>
	</div>
	<div class="row medicineTarget"></div>
	<div class="nothingFound hidden">
		<h2>
			Nothing found for "<span class="sterm"></span>"
		</h2>
	</div>
	<div class="model medicineModel">
		<div class="backblack"></div>
		<div class="bodyParent">
			<div class="body">
				<div class="header">
					<img src="imgs/closeBlack.svg" class="modelCloser" />
				</div>
				<div class="knowYourMedicineModal">
					<div class="imageBlock">
						<img class="modelImage" /> <img class="modelPrevButton"
							src="imgs/left.svg" /> <img class="modelNextButton"
							src="imgs/right.svg" />
					</div>
					<span class="modelTitle"></span>
					<p class="modelDesc"></p>
				</div>
			</div>
		</div>
	</div>
</section>
<%@include file="UserFooter.jsp"%>
<script type="text/javascript">
	var medicines=$.parseJSON($(".rawdata").text());
	$(".rawdata").remove();
	var uniqueChars=new Array();
	var index=0;
	var curmodelindex;
	for(var m of medicines){
		var template="";
		m.initChar=m.title.substr(0,1);
		if(!isUniqueCharExists(m.initChar))uniqueChars.push(m.initChar);
		template+='<div class="cs3 medicineNode modelButton" target=".medicineModel" data-index="'+index+'">';
		template+='<div class="knowYourMedicine">';
		template+='<img src="'+m.photoLink+'"/>';
		template+='<span class="title">'+m.title+'</span>';
		template+='<span class="readmoreText">Read More</span>';
		template+='</div>';
		template+='</div>';
		$(".medicineTarget").append(template);
		m.structure=$(".medicineTarget div:last-child");
		index++;
	}
	$(".medicineNode").click(function(){
		curmodelindex=$(this).attr("data-index");
		loadModelData();
	});
	function loadModelData(){
		$(".modelImage").attr("src",medicines[curmodelindex].photoLink);
		$(".modelTitle").text(medicines[curmodelindex].title);
		$(".modelDesc").text(medicines[curmodelindex].description);
	}
	$(".modelNextButton").click(function(){
		curmodelindex++;
		if(curmodelindex>medicines.length-1)curmodelindex=0;
		loadModelData();
	});
	$(".modelPrevButton").click(function(){
		curmodelindex--;
		if(curmodelindex<0)curmodelindex=medicines.length-1;
		loadModelData();
	});
	$("body").keydown(function(e){
		if(e.keyCode==37)$(".modelPrevButton").click();
		if(e.keyCode==39)$(".modelNextButton").click();
	});
	for(var c of uniqueChars){
		$(".sortChars").append("<span class='sortChar'>"+c+"</span>");
	}
	$(".sortChar").click(function(){
		$(this).siblings().removeClass("active");
		$(this).addClass("active");
		var target=$(this).text();
		$(".searchbox").val("");
		if(target=="All"){
			$(".medicineNode").removeClass("hidden");
		}
		else{
			$(".medicineNode").addClass("hidden");
			for(var m of medicines){
				if(m.initChar==target)$(m.structure).removeClass("hidden");
			}
		}
	});
	function isUniqueCharExists(term){
		for(var c of uniqueChars){
			if(c==term)return true;
		}
		return false;
	}
	$(".searchbox").keyup(function(){
		$(".medicineNode").addClass("hidden");
		var term=$(this).val()
		$(".sortChar").removeClass("active");
		$(".sortChar:first-child").addClass("active");
		var count=0;
		for(var m of medicines){
			var flag=false;			
			if(m.title.toLowerCase().includes(term))
				flag=true;
			if(m.description.toLowerCase().includes(term))
				flag=true;
			if(flag){
				$(m.structure).removeClass("hidden");
				count++;
			}
		}
		if(count==0){
			$(".nothingFound").removeClass("hidden");
			$(".sterm").text(term);
		}
		else{
			$(".nothingFound").addClass("hidden");
		}
	});
</script>
</body>
</html>