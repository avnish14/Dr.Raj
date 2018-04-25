<%@page import="DrRAJ.Bean.ProductBean"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DrRAJ.DAO.ProductCategoryDAO"%>
<%@page import="DrRAJ.Bean.ProductCategoryBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	ArrayList<ProductBean> categoryList = (ArrayList<ProductBean>) request.getAttribute("categoryBean");
	Gson gson = new Gson();
	String temp = gson.toJson(categoryList);
	System.out.println(" Temp " + temp);
	if (temp.equals("[]")) {
		response.sendRedirect("not-found");
%>

<%
	} else {
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=categoryList.get(0).getProductCategoryName()%> | Dr.
	Raj Homoeo Pharmacy</title>
<%@include file="UserHeader.jsp"%>
</head>
<body>
	<div class="rawdata hidden"><%=temp%></div>
	<section class="bgimage maincover regular"
		style="background-image: url(https://farm5.staticflickr.com/4758/26597341938_f5594beb73_o_d.jpg);">
	<div class="blackcover"></div>
	<div class="container">
		<h3>Products</h3>
		<div class="jumbotext">
			<%=categoryList.get(0).getProductCategoryName()%>
		</div>
	</div>
	<div class="posab">
		<img src="imgs/bottomwhitecircle.svg"/>
	</div>
	</section>
	<section>
	<div class="container">
		<div class="row">
			<div class="cs1 nomargin"></div>
			<div class="cs4 nomargin remedies-searchbox">
				<div class="iconTextBox left full">
					<input type="text" class="textbox posrel searchbox" placeholder="Search Products" /> <img
						src="imgs/search.svg" />
				</div>
			</div>
			<div class="cs3 nomargin"></div>
			<div class="cs3">
				<select class="textbox sortbox">
					<option value="0" selected>Sort By Default</option>
					<option value="1">Price Low to High</option>
					<option value="2">Price High to Low</option>
					<option value="3">Popularity</option>
				</select>
			</div>
			<div class="cs1 nomargin"></div>
		</div>
		<div class="row productContainer">
		</div>
	</div>
	<div class="nothingFound hidden">
		<h2>
			Nothing found for "<span class="sterm"></span>"
		</h2>
	</div>
	</section>
	<%@include file="UserFooter.jsp"%>
	<script type="text/javascript">
		var temp = $(".rawdata").text();
		if(temp!=""){
			$(".rawdata").remove();
			var products=$.parseJSON(temp);
			products.sort(function(a,b) {return (a.productName> b.productName) ? 1 : ((b.productName> a.productName) ? -1 : 0);} );
			for(var prod of products){
				var prodtemplate="";
				prod.mp=parseInt(prod.minPrice);
				if(prod.rate==undefined)prod.rate=0;
				else prod.rate=parseInt(prod.rate);
				prodtemplate+='<div class="cs4 product_template">';
				prodtemplate+='<a href="'+prod.productURL+'"><img src="'+prod.imageLink+'" class="imgResponsive productAnimate" /></a>';
				prodtemplate+='<span>'+prod.productName+'</span>';
				prodtemplate+='<div class="description">'+prod.description+'</div>';
				prodtemplate+='<div class="price">₹ '+prod.minPrice+'.00</div>';
				prodtemplate+='<a href="'+prod.forwardLink+'" target="_blank" class="button responsive blue bordered">Buy Now</a>';
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
				if(prod.productName.toLowerCase().includes(term.toLowerCase())){
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
		$(".sortbox").change(function(){
			if($(this).val()=="0"){
				products.sort(function(a,b) {return (a.productName > b.productName) ? 1 : ((b.productName> a.productName) ? -1 : 0);} );
			}else if($(this).val()=="1"){
				products.sort(function(a,b) {return a.mp- b.mp;} );	
			}else if($(this).val()=="2"){
				products.sort(function(a,b) {return b.mp- a.mp;} );
			}else if($(this).val()=="3"){
				products.sort(function(a,b) {return b.rate- a.rate;} );
			}
			for(var prod of products){
				$(".productContainer").append(prod.structure);
			}
			searchProduct();
		});
		$(".productAnimate").mouseenter(function(){
			animateProduct($(this));
		});
		function animateProduct(target){
			target.css({"transform-origin":"bottom","transition":"transform 0.3s ease"});
			target.css("transform","rotate(-5deg)");
			setTimeout(function(){
				target.css("transform","rotate(5deg)");
				setTimeout(function(){
					target.css("transform","rotate(-5deg)");
					setTimeout(function(){
						target.css("transform","rotate(5deg)");
						setTimeout(function(){
							target.css("transform","rotate(0deg)");				
						},300);
					},300);
				},300);
			},300);
		}
	</script>
</body>
<%
	}
%>
</html>