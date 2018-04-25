<%@page import="DrRAJ.DAO.ProductDAO"%>
<%@page import="DrRAJ.Bean.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Products | Dr. Raj Homoeo Pharmacy</title>
<%@include file="UserHeader.jsp"%>
</head>
<body>
	<%
		Gson gson = new Gson();
		ArrayList<ProductBean> mylist = (ArrayList<ProductBean>) new ProductDAO().getList();
		String jsonCartList = gson.toJson(mylist);
	%>
	<div class="rawdata hidden"><%=jsonCartList %></div>
	<section class="bgimage"
		style="background-image: url(https://farm5.staticflickr.com/4758/26597341938_f5594beb73_o_d.jpg);">
	<div class="blackcover opaq2"></div>
	<div class="container posrel" style="z-index: 2;">
		<br>
		<br>
		<br>
		<br>
		<div class="tcenter fgwhite jumbotext text-2"
			style="margin-bottom: 40px;">Products
		</div>
		<br>
		<br>
		<br>
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
				<div class="cs7 nomargin overhidden"
					style="padding-left: 4px; padding-right: 4px;">
					<input type="text" class="textbox posrel searchbox" style="top: 5px;"
						placeholder="Search Products or Remedies" />
				</div>
				<div class="cs3 nomargin"></div>
				<div class="cs1 cx6 nomargin" style="padding-right: 2px;">
					<input type="button" class="button full active atozbutton" value="A to Z" />
				</div>
				<div class="cs1 cx6 nomargin" style="padding-left: 2px;">
					<input type="button" class="button full ztoabutton" value="Z to A" />
				</div>
			</div>
			<br><br>
			<div class="row productContainer">
				<!-- <div class="cs4 product_template">
					<img src="imgs/product_sample.png" class="imgResponsive" style="max-height: 350px;" />
					<span>Calcikid</span>
					<a href="#" class="button responsive">Buy Now</a>
					<a href="#" class="button responsive">Details</a>
				</div> -->
			</div>
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
			<br><br>
		</div>
	</section>
	<%@include file="UserFooter.jsp"%>
	<script type="text/javascript">
		$("title").text($(".remname").text()+ $("title").text());
		var temp = $(".rawdata").text();
		if(temp!=""){
			$(".rawdata").remove();
			var products=$.parseJSON(temp);
			products.sort(function(a,b) {return (a.productName> b.productName) ? 1 : ((b.productName> a.productName) ? -1 : 0);} ); 
			for(var prod of products){
				var prodtemplate="";
				prodtemplate+='<div class="cs4 product_template">';
				prodtemplate+='<img src="'+prod.imageLink+'" class="imgResponsive" style="max-height: 350px;" />';
				prodtemplate+='<span style="margin-bottom:0;">'+prod.productName+'</span>';
				prodtemplate+='<span class="opaq5" style="font-size:0.9em;">'+prod.remediesName+'</span>';
				prodtemplate+='<a href="'+prod.forwardLink+'" class="button responsive">Buy Now</a>&nbsp;';
				prodtemplate+='<a href="'+prod.productURL+'" class="button responsive">Details</a>';
				prodtemplate+='</div>';
				$(".productContainer").append(prodtemplate);
				prod.structure=$(".productContainer").children("div:last-child");
			}
		}
		function searchProduct(){
			var term=$(".searchbox").val();
			$(".productContainer>div").addClass("hidden");
			var count=0;
			for(var prod of products){
				if(prod.productName.toLowerCase().includes(term.toLowerCase())||prod.remediesName.toLowerCase().includes(term.toLowerCase())){
					$(prod.structure).removeClass("hidden");
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
			searchProduct();
		});
		$(".atozbutton").click(function(){
			products.sort(function(a,b) {return (a.productName> b.productName) ? 1 : ((b.productName> a.productName) ? -1 : 0);} );
			for(var prod of products){
				$(".productContainer").append(prod.structure);
			}
			searchProduct();
			$(".atozbutton").addClass("active");
			$(".ztoabutton").removeClass("active");
		});
		$(".ztoabutton").click(function(){
			products.sort(function(a,b) {return (a.productName> b.productName) ? -1 : ((b.productName> a.productName) ? 1 : 0);} );
			for(var prod of products){
				$(".productContainer").append(prod.structure);
			}
			searchProduct();
			$(".atozbutton").removeClass("active");
			$(".ztoabutton").addClass("active");
		});
	</script>
</body>
</html>