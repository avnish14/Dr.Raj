<%@page import="DrRAJ.DAO.RemediesDAO"%>
<%@page import="DrRAJ.Bean.RemediesBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remedies | Dr. Raj Homoeo Pharmacy</title>
<%@include file="UserHeader.jsp"%>
<%
	Gson gson = new Gson();
	ArrayList<RemediesBean> arrayList = (ArrayList<RemediesBean>) new RemediesDAO().getList();
	String remediesList = gson.toJson(arrayList);
%>
<div class="rawdata hidden"><%=remediesList%></div>
<section class="bgimage"
	style="background-image: url(https://farm5.staticflickr.com/4758/26597341938_f5594beb73_o_d.jpg);">
<div class="blackcover opaq2"></div>
<div class="container posrel" style="z-index: 2;">
	<br> <br> <br> <br>
	<div class="tcenter fgwhite jumbotext text-2"
		style="margin-bottom: 40px;">Remedies</div>
	<br> <br> <br>
</div>
<div class="posab overhidden"
	style="z-index: 3; width: 100%; bottom: -7px;">
	<img src="imgs/bottomwhitecircle.svg" class="posrel"
		style="width: 120%; left: -10%" />
</div>
</section>
<section>
<div class="container">
	<div class="row">
		<div class="cs5 nomargin overhidden"
			style="padding-left: 4px; padding-right: 4px;">
			<div class="iconTextBox left" style="width:100%;">
				<input type="text" class="textbox posrel searchbox" style="top: 5px;"
				placeholder="Search Remedies" />
				<img src="imgs/search.svg"/>
			</div>
		</div>
		<div class="cs5 nomargin"></div>
		<div class="cs1 cx6 nomargin" style="padding-right: 2px;">
			<input type="button" class="button full active atozbutton" value="A to Z" />
		</div>
		<div class="cs1 cx6 nomargin" style="padding-left: 2px;">
			<input type="button" class="button full ztoabutton" value="Z to A" />
		</div>
	</div>
	<br> <br>
	<div class="row remediesContainer">
		<!-- <div class="cs4 cx6 remedies">
			<a href="#" class="bgimage"
				style="background-image: url(https://farm5.staticflickr.com/4606/40468139451_ae8bdbf2fd_o_d.jpg);">
				<div class="blackback"></div>
				<h3>Child Care</h3>
			</a>
		</div> -->
	</div>
	<div class="nothingFound tcenter opaq5 hidden">
		<br>
		<br>
		<br>
		<br>
		<h2>
			Nothing found for "<span class="sterm"></span>"
		</h2>
		<br>
		<br>
		<br>
		<br>
	</div>
</div>
</section>
<%@include file="UserFooter.jsp"%>
<script type="text/javascript">
	var temp=$(".rawdata").text();
	if(temp!=""){
		$(".rawdata").remove();
		var remedies=$.parseJSON(temp);
		remedies.sort(function(a,b) {return (a.name> b.name) ? 1 : ((b.name> a.name) ? -1 : 0);} ); 
		for(var rem of remedies){
			var remtemplate="";
			remtemplate+='<div class="cs4 remedies">';
			remtemplate+='<a href="'+rem.forwardLink+'" class="bgimage"';
			remtemplate+='style="background-image: url('+rem.photolink+');">';
			remtemplate+='<div class="blackback"></div>';
			remtemplate+='<h3>'+rem.name+'</h3>';
			remtemplate+='</a>';
			remtemplate+='</div>';
			$(".remediesContainer").append(remtemplate);
			rem.structure=$(".remediesContainer").children("div:last-child");
		}
	}
	function searchRemedies(){
		var term=$(".searchbox").val();
		$(".remediesContainer>div").addClass("hidden");
		var count=0;
		for(var rem of remedies){
			if(rem.name.toLowerCase().includes(term.toLowerCase())){
				$(rem.structure).removeClass("hidden");
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
	}
	$(".searchbox").keyup(function(){
		searchRemedies();
	});
	$(".atozbutton").click(function(){
		remedies.sort(function(a,b) {return (a.name> b.name) ? 1 : ((b.name> a.name) ? -1 : 0);} );
		for(var rem of remedies){
			$(".remediesContainer").append(rem.structure);
		}
		searchRemedies();
		$(".atozbutton").addClass("active");
		$(".ztoabutton").removeClass("active");
	});
	$(".ztoabutton").click(function(){
		remedies.sort(function(a,b) {return (a.name> b.name) ? -1 : ((b.name> a.name) ? 1 : 0);} );
		for(var rem of remedies){
			$(".remediesContainer").append(rem.structure);
		}
		searchRemedies();
		$(".atozbutton").removeClass("active");
		$(".ztoabutton").addClass("active");
	});
</script>
</html>