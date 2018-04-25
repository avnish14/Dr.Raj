<%@page import="DrRAJ.DAO.StateDAO"%>
<%@page import="DrRAJ.Bean.StateBean"%>
<%@page import="DrRAJ.DAO.StoreDetailsDAO"%>
<%@page import="DrRAJ.Bean.StoreDetailsBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find a Store or Practitioner | Dr. Raj Homoeo Pharmacy</title>
<%@include file="UserHeader.jsp"%>
</head>
<body>
	<%
		Gson gson = new Gson();
		ArrayList<StoreDetailsBean> mylist = new StoreDetailsDAO().getList();
		String temp = gson.toJson(mylist);
		ArrayList<StateBean> states = new StateDAO().getList();
	%>
	<div class="rawdata hidden"><%=temp%></div>
	<section class="bgimage maincover regular"
		style="background-image: url(https://farm5.staticflickr.com/4758/26597341938_f5594beb73_o_d.jpg);">
	<div class="blackcover"></div>
	<div class="container">
		<div class="jumbotext">Find a Store or Practitioner</div>
	</div>
	<div class="posab">
		<img src="imgs/bottomwhitecircle.svg" />
	</div>
	</section>
	<section>
	<div class="container">
		<div class="row marginB20">
			<div class="cs3 nomargin overhidden"
				style="padding-left: 4px; padding-right: 4px;">
				<select class="textbox statebox"
					style="position: relative; top: 4px;">
					<option value="0" selected>All States</option>
					<%
						for (int i = 0; i < states.size(); i++) {
					%>
					<option value="<%=states.get(i).getStateName()%>"><%=states.get(i).getStateName()%></option>
					<%
						}
					%>
				</select>
			</div>
			<div class="cs3 nomargin overhidden"
				style="padding-left: 4px; padding-right: 4px;">
				<div class="iconTextBox left" style="width: 100%;">
					<input type="text" class="textbox posrel searchbox"
						style="top: 5px;" placeholder="Search by City" /> <img
						src="imgs/search.svg" />
				</div>
			</div>
			<div class="cs6 nomargin"></div>
		</div>
		<div class="row storeContainer"></div>
	</div>
	<div class="nothingFound hidden">
		<h2 class="marginB10">No Dealers found at this location, try buying online</h2>
		<a class="button" href="https://www.homeomart.com/seo_key_word?&amp;filter_name=dr.%20raj&amp;filter=ATTRIBU=Dr+Raj+Homoeo+Pharmacy=2=Manufacturer" target="_blank">Buy Online</a>
	</div>
	</section>
	<%@include file="UserFooter.jsp"%>
	<script type="text/javascript">
		var temp = $(".rawdata").text();
		if(temp!=""){
			$(".rawdata").remove();
			var stores=$.parseJSON(temp);
			var states=new Array();
			function stateExists(state){
				for(var s of states){
					if(s==state)return true;
				}
				return false;
			}
			for(var store of stores){
				if(store.contact2!="")store.contact=store.contact1+", "+store.contact2;
				else store.contact=store.contact1;
				if(!stateExists(store.statename))states.push(store.statename);
			}
			states.sort();
			for(var s of states){
				//$(".statebox").append("<option value='"+s+"'>"+s+"</option>");
			}
			stores.sort(function(a,b) {return (a.title> b.title) ? 1 : ((b.title> a.title) ? -1 : 0);} ); 
			for(var store of stores){
				var storetemplate="";
				storetemplate+='<div class="cs3 storeNode" >';
				storetemplate+='<div class="store_template">';
				storetemplate+='<span class="name">'+store.name+'</span>';
				storetemplate+='<span>'+store.address+',</span>';
				storetemplate+='<span>'+store.cityname+',</span>';
				storetemplate+='<span>'+store.statename+'</span>';
				storetemplate+='<span>'+store.contact+'</span>';
				storetemplate+='</div>';
				storetemplate+='</div>';
				$(".storeContainer").append(storetemplate);
				store.structure=$(".storeContainer").children("div:last-child");
			}
		}
		function searchStore(){
			var term=$(".searchbox").val();
			$(".storeContainer>div").addClass("hidden");
			var count=0;
			for(var store of stores){
				if(store.cityname.toLowerCase().includes(term.toLowerCase())){
					$(store.structure).removeClass("hidden");
					count++;
				}
			}
			if(count==0){
				$(".nothingFound").removeClass("hidden");
			}
			else{
				$(".nothingFound").addClass("hidden");
			}
		}
		$(".statebox").change(function(){
			$(".searchbox").val("");
			var value=$(this).val();
			if(value=="0")$(".storeContainer>div").removeClass("hidden");
			else{
				$(".storeContainer>div").addClass("hidden");
				var count=0;
				for(var store of stores){
					if(store.statename.toLowerCase().includes(value.toLowerCase())){
						$(store.structure).removeClass("hidden");
						count++;
					}
				}
				console.log(count);
				if(count==0){
					$(".nothingFound").removeClass("hidden");
				}
				else{
					$(".nothingFound").addClass("hidden");
				}
			}
		});
		$(".searchbox").keyup(function(){
			$(".statebox").val("0");
			searchStore();
		});
	</script>
</body>
</html>