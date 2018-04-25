<!DOCTYPE html>
<%@page import="java.util.HashMap"%>
<%@page import="DrRAJ.Controller.ProductListServlet"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="DrRAJ.Bean.ReviewBean"%>
<%@page import="DrRAJ.Bean.IngredientBean"%>
<%@page import="DrRAJ.Bean.ProductDosageBean"%>
<%@page import="DrRAJ.Bean.PriceBean"%>
<%@page import="DrRAJ.Bean.ProductCompositionBean"%>
<%@page import="DrRAJ.DAO.ProductDAO"%>
<%@page import="DrRAJ.Bean.ProductIndicationBean"%>
<%@page import="DrRAJ.Bean.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%
	ProductBean bean = (ProductBean) request.getAttribute("bean");
	System.out.println(bean.getRate() + " Rate");
	if (bean != null) {
%>
<%
	ArrayList<ReviewBean> reviewList = (ArrayList<ReviewBean>) new ProductDAO()
				.getReview(bean.getProductId());
%>
<title><%=bean.getProductName()%> | Dr. Raj Homoeo Pharmacy</title>
<%@include file="UserHeader.jsp"%>
<section class="bgimage maincover regular"
	style="background-image: url(<%=bean.getRemediesImageLink()%>);">
	<div class="blackcover"></div>
	<div class="container">
		<h3><%=bean.getRemediesName()%></h3>
		<div class="jumbotext"><%=bean.getProductName()%></div>
	</div>
	<div class="posab">
		<img src="imgs/bottomwhitecircle.svg" />
	</div>
</section>
<section>
	<div class="container thousand">
		<div class="row">
			<div class="cm6 tcenter">
				<img src="<%=bean.getImageLink()%>" class="imgResponsive"
					style="max-height: 400px;">
			</div>
			<div class="cm6">
				<h2 style="margin-bottom: 5px;"><%=bean.getProductName()%></h2>
				<p class="paragraph" style="margin-top: 0;"><%=bean.getDescription()%></p>
				<span class="size12 line15 fgblue">Indication</span>
				<%
					HashMap<String, ArrayList<ProductIndicationBean>> indicationMap = (HashMap<String, ArrayList<ProductIndicationBean>>) request
								.getServletContext().getAttribute("productIndicationMap");
						System.out.println("Hello ");
						if (indicationMap.size() == 0 || indicationMap.get(bean.getProductId()) == null) {
				%>
				<div>No Indication</div>
				<%
					} else {
							ArrayList<ProductIndicationBean> indicationList = indicationMap.get(bean.getProductId());
							for (int i = 0; i < indicationList.size(); i++) {
				%>
				<p class="paragraph customBullet">
					<img src="imgs/done.svg" /> <span><%=indicationList.get(i).getIndication()%></span>
				</p>
				<%
					}
						}
				%>
				<br>
				<h3 class="bold">
					₹
					<%=bean.getMinPrice()%>.00
				</h3>
				<br> <a href="<%=bean.getForwardLink()%>"
					class="button responsive blue bordered" target="_blank">Buy Now</a>
				<a class="inblock link bold" style="padding: 20px;"
					href="#reviewSection">
					<div class="ratingBlock small"
						style="margin-bottom: 10px; top: 4px;">
						<%
							int rate = 0;
								if (bean.getRate() != null) {
									rate = Integer.parseInt(bean.getRate().substring(0, 1));
								}
								for (int i = 0; i < rate; i++) {
						%>
						<span class="item"><img src="imgs/starf.svg" /></span>
						<%
							}
								for (int i = rate; i < 5; i++) {
						%>
						<span class="item"><img src="imgs/stare.svg" /></span>
						<%
							}
						%>
					</div> <span><%=reviewList.size()%> Review(s)</span>
				</a> <br> <img src="imgs/productICO1.png"
					style="height: 45px; display: inline-block; margin: 10px;" /><img
					src="imgs/productICO2.png"
					style="height: 45px; display: inline-block; margin: 10px;" /><img
					src="imgs/productICO3.png"
					style="height: 45px; display: inline-block; margin: 10px;" /><img
					src="imgs/productICO4.png"
					style="height: 45px; display: inline-block; margin: 10px;" />
			</div>
		</div>
		<div class="row">
			<div class="cs6 nomargin">
				<span class="line15 size12 fgblue">Composition</span><br>
				<table class="paragraph" cellspacing="0" cellpadding="0"
					style="margin-bottom: 15px; width: 100%;">
					<%
						HashMap<String, ArrayList<ProductCompositionBean>> compositionMap = (HashMap<String, ArrayList<ProductCompositionBean>>) request
									.getServletContext().getAttribute("productCompositionMap");
							ArrayList<ProductCompositionBean> compositionList = compositionMap.get(bean.getProductId());
							if (compositionMap == null || compositionMap.size() == 0) {
					%>
					<tr>
						<td>No Comopsition</td>
					</tr>
					<%
						}

							else if (compositionList == null) {
					%>
					<tr>
						<td>No Composition</td>
					</tr>
					<%
						} else {
								for (int i = 0; i < compositionList.size(); i++) {
					%>
					<tr>
						<td><%=compositionList.get(i).getIngredientsName()%></td>
						<%
							String[] temp = compositionList.get(i).getCompositionContent().split(" ");
										for (int j = 0; j < temp.length; j++) {
						%>
						<td><%=temp[j]%></td>
						<%
							}
						%>
					</tr>
					<%
						}
							}
					%>

				</table>
			</div>
			<div class="cs6 nomargin">
				<span class="size12 line15 fgblue">Packaging</span>
				<table class="paragraph" cellspacing="0" cellpadding="0"
					style="margin-bottom: 15px;">
					<%
						HashMap<String, ArrayList<PriceBean>> priceMap = (HashMap<String, ArrayList<PriceBean>>) request
									.getServletContext().getAttribute("priceMap");

							if (priceMap.size() == 0 || priceMap.get(bean.getProductId()) == null) {
					%>
					<tr>
						<td>No Packaging</td>
					</tr>
					<%
						} else {
								ArrayList<PriceBean> priceList = priceMap.get(bean.getProductId());
								for (int i = 0; i < priceList.size(); i++) {
					%>
					<tr>
						<td><%=priceList.get(i).getPackageSize()%></td>
						<td><span class="tab"></span></td>
						<td>₹ <%=priceList.get(i).getPrice()%>.00
						</td>
					</tr>
					<%
						}
							}
					%>
				</table>
				<span class="size12 line15 fgblue">Dosage</span>
				<p class="paragraph" style="margin-top: 5px;">
					<%
						HashMap<String, ArrayList<ProductDosageBean>> dosageMap = (HashMap<String, ArrayList<ProductDosageBean>>) request
									.getServletContext().getAttribute("productDosageMap");
							if (dosageMap.size() == 0 || dosageMap.get(bean.getProductId()) == null) {
					%>
				
				<div>No Dosage</div>
				<%
					} else {
							ArrayList<ProductDosageBean> dosageList = dosageMap.get(bean.getProductId());

							for (int i = 0; i < dosageList.size(); i++) {
				%>
				<%=dosageList.get(i).getContent()%><br>
				<%
					}
						}
				%>
				</p>
				<span class="size12 line15 fgblue">Interaction</span>
				<p class="paragraph" style="margin-top: 5px;"><%=bean.getInteraction()%></p>
				<span class="size12 line15 fgblue">Side Effects</span>
				<p class="paragraph" style="margin-top: 5px;"><%=bean.getSideEffect()%></p>
				<span class="size12 line15 fgblue">Contra-indication</span>
				<p class="paragraph" style="margin-top: 5px;"><%=bean.getContraIndication()%></p>
			</div>
		</div>
	</div>
</section>
<section class="bottom-rounded-title">
	<h2 class="title">Know Your Medicine</h2>
	<div class="posab">
		<img src="imgs/bottomwhitecircle.svg" />
	</div>
	<div class="container thousand">
		<div class="owl-carousel-wrapper" data-target=".knowYourMedicines">
			<div class="owl-carousel owl-theme knowYourMedicines">

				<%
					HashMap<String, ArrayList<IngredientBean>> ingredientMap = (HashMap<String, ArrayList<IngredientBean>>) request
								.getServletContext().getAttribute("ingredientMap");
						ArrayList<IngredientBean> ingredientList = ingredientMap.get(bean.getProductId());

						if (ingredientList == null || indicationMap == null) {
				%>
				<tr>
					<td>No Ingredient</td>
				</tr>
				<%
					} else {
							for (int i = 0; i < ingredientList.size(); i++) {
				%>
				<div class="item tcenter">
					<div class="knowYourMedicine modelButton medicineNode kym<%=i%>"
						target=".medicineModel"
						data-img="<%=ingredientList.get(i).getPhotoLink()%>"
						data-title="<%=ingredientList.get(i).getTitle()%>"
						data-desc="<%=ingredientList.get(i).getDescription()%>"
						data-index="<%=i%>">
						<img src="<%=ingredientList.get(i).getPhotoLink()%>" />
						<div class="bold"><%=ingredientList.get(i).getTitle()%></div>
						<span class="fgblue" style="font-size: 14px;">Know More</span>
					</div>
				</div>
				<%
					}
						}
				%>
			</div>
			<img src="imgs/left.svg" class="left-arrow" /> <img
				src="imgs/right.svg" class="right-arrow" />
		</div>
	</div>
</section>
<section class="bottom-rounded-title">
	<h2 class="title">Related Products</h2>
	<div class="posab">
		<img src="imgs/bottomwhitecircle.svg" />
	</div>
	<div class="container thousand">
		<div class="relatedProductStage owl-carousel-wrapper" data-target=".relatedProducts">
		<img src="imgs/left.svg" class="left-arrow" /> <img
				src="imgs/right.svg" class="right-arrow" />
		</div>
	</div>
</section>


<%
	Gson gson = new Gson();
		ArrayList<ProductBean> relatedProduct = (ArrayList<ProductBean>) new ProductDAO()
				.getAllRelatedProducts(bean.getRemediesId());
		String temp = gson.toJson(relatedProduct);
%>
<div class="relatedProductsList hidden"><%=temp%></div>
<div class="idOfMe hidden"><%=bean.getProductId()%></div>
<section id="reviewSection">
	<div class="container thousand">
		<h2 class="title bold" style="margin-bottom: 30px;">Reviews</h2>
		<div class="row">
			<div class="cs6 tleft responsive marginB10">
				<h3 style="top: 5px;" class="posrel"><%=reviewList.size()%>
					Review(s)
				</h3>
			</div>
			<div class="cs6 tright marginB10">
				<button type="button" class="button responsive reviewbutton blue">Write
					a Review</button>
			</div>
		</div>
		<div class="tcenter successmsg hidden">
			<br> <br> <br> <br>
			<h2>Thank You</h2>
			<div style="font-size: 2em;">Your review has been saved.</div>
			<br> <br> <br> <br>
		</div>
		<div class="tcenter failmsg hidden">
			<br> <br> <br> <br>
			<h2>Sorry</h2>
			<div style="font-size: 2em;">Your review has not been saved.</div>
			<br> <br> <br> <br>
		</div>
		<div class="reviewForm hidden"
			style="padding: 30px 0; max-width: 900px; margin: 0 auto;">
			<h3 class="tcenter marginB20">Write a Review</h3>
			<label class="label">Name</label> <input type="text"
				class="textbox reviewNameBox" name="txtCustomerName" /> <label
				class="label">Ratings</label>
			<div class="ratingBlock input marginB10">
				<span class="item"><img src="imgs/stare.svg" /></span><span
					class="item"><img src="imgs/stare.svg" /></span><span class="item"><img
					src="imgs/stare.svg" /></span><span class="item"><img
					src="imgs/stare.svg" /></span><span class="item"><img
					src="imgs/stare.svg" /></span> <input type="text" value="0"
					name="txtRating" class="reviewRateBox">
			</div>
			<label class="label">Title of Review</label> <input type="text"
				class="textbox reviewTitleBox" name="txtTitle" /> <label
				class="label">Body of Review</label>
			<textarea type="text" class="textbox reviewDescBox" rows="4"
				name="txtDescription"></textarea>
			<input type="hidden" name="txtProductId"
				value=<%=bean.getProductId()%> class="reviewProductId">
			<div class="tcenter">
				<span class="error bold hidden" style="color: crimson;">Please
					fill all mandatory fields<br> <br> </b>
				</span>
				<button type="button"
					class="button responsive uppercase sendbutton blue bordered">Submit
					Review</button>
			</div>
		</div>
		<%
			if (reviewList.size() == 0) {
		%>
		<span>No Review</span>

		<%
			} else {
					for (int i = 0; i < reviewList.size(); i++) {
		%>
		<div class="commentBlock">
			<div class="ratingBlock" value="<%=reviewList.get(i).getRating()%>"></div>
			&nbsp;<span class="name"><%=reviewList.get(i).getCustomerName()%></span>
			<br>
			<div class="title"><%=reviewList.get(i).getTitle()%></div>
			<p class="description"><%=reviewList.get(i).getDescription()%></p>
		</div>
		<%
			}
				}
		%>
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
	var temp = $(".relatedProductsList").text();
	var myflag=false;
	var curmodelindex;
	var medicineCount=<%=ingredientList.size()%>;
	var inflag=<%if (ingredientList.size() > 3) {%>true;<%} else {%>false;<%}%>
	if(temp!=""){
		$(".relatedProductsList").remove();
		var products=$.parseJSON(temp);
		products.sort(function(a,b) {return (a.productName> b.productName) ? 1 : ((b.productName> a.productName) ? -1 : 0);} );
		var idOfMe=$(".idOfMe").html();
		var prodtemplate="";
		prodtemplate+='<div class="owl-carousel owl-theme relatedProducts">';
		for(var prod of products){
			if(prod.productId==idOfMe)continue;
			prod.mp=parseInt(prod.minPrice);
			prod.mp=parseInt(prod.minPrice);
			prodtemplate+='<div class="item tcenter">';
			prodtemplate+='<div class="product_template">';
			prodtemplate+='<a href="'+prod.productURL+'"><img src="'+prod.imageLink+'" class="imgResponsive productAnimate" /></a>';
			prodtemplate+='<span>'+prod.productName+'</span>';
			prodtemplate+='<div class="description">'+prod.description+'</div>';
			prodtemplate+='<div class="price">₹ '+prod.minPrice+'.00</div>';
			prodtemplate+='<a href="'+prod.forwardLink+'" target="_blank" class="button responsive blue bordered">Buy Now</a>';
			prodtemplate+='</div>';
			prodtemplate+='</div>'; 
		}
		prodtemplate+='</div>';
		$(".relatedProductStage").append(prodtemplate);
		if(products.length>3)myflag=true;
	}
	$(".medicineNode").click(function(){
		curmodelindex=$(this).attr("data-index");
		loadModelData($(this));
	});
	function loadModelData(target){
		$(".modelImage").attr("src",target.attr("data-img"));
		$(".modelTitle").text(target.attr("data-title"));
		$(".modelDesc").text(target.attr("data-desc"));
	}
	$(".modelNextButton").click(function(){
		curmodelindex++;
		if(curmodelindex>medicineCount-1)curmodelindex=0;
		loadModelData($(".kym"+curmodelindex));
	});
	$(".modelPrevButton").click(function(){
		curmodelindex--;
		if(curmodelindex<0)curmodelindex=medicineCount-1;
		loadModelData($(".kym"+curmodelindex));
	});
	$("body").keydown(function(e){
		if(e.keyCode==37)$(".modelPrevButton").click();
		if(e.keyCode==39)$(".modelNextButton").click();
	});
	$('.knowYourMedicines').owlCarousel({
		loop : inflag,
		margin : 20,
		nav:false,
		dots:false,
		pagination : false,
		responsive : {
			0 : {
				items : 1
			},
			600 : {
				items : 2
			},
			1000 : {
				items : 3
			}
		},
		autoplay : true,
		autoplayTimeout : 5000,
		autoplayHoverPause : true,
		autoHeight : true
	});
	$('.relatedProducts').owlCarousel({
		loop : myflag,
		margin : 20,
		nav:false,
		dots:false,
		pagination : false,
		responsive : {
			0 : {
				items : 1
			},
			600 : {
				items : 2
			},
			1000 : {
				items : 3
			}
		},
		autoplay : true,
		autoplayTimeout : 5000,
		autoplayHoverPause : true,
		autoHeight : true
	});
	$(".reviewbutton").click(function() {
		$(".reviewForm").toggleClass("hidden");
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
	var sendflag = false;
	$(".sendbutton").click(
			function() {
				if (!sendflag) {
					var title = $(".reviewTitleBox").val();
					var rate = $(".reviewRateBox").val();
					var desc = $(".reviewDescBox").val();
					var name = $(".reviewNameBox").val();
					var id= $(".reviewProductId").val();
					if (title== "" || rate== "" || desc== ""
							|| name == "") {
						$(".error").removeClass("hidden");
					} else {
						sendflag = true;
						$(".sendbutton").val("Submitting...");
						$(".error").addClass("hidden");
						callAjax("AJAXServlet?method=reviewInsert&customerName="+name+"&rating="+rate+"&title="+title+"&description="+desc+"&productId="+id, function(data) {
							$(".reviewForm").remove();
							if (data == "true") {
								$(".successmsg").removeClass("hidden");
							} else {
								$(".failmsg").removeClass("hidden");
							}
						});
					}
				}
			});
	$(".reviewTitleBox,.reviewDescBox,.reviewNameBox").keyup(function() {
		$(".error").addClass("hidden");
	});
	$(".reviewRateBox").change(function() {
		$(".error").addClass("hidden");
	});
</script>
<%
	} else {
%>
<h3>Error Page</h3>
<%
	}
%>

</html>