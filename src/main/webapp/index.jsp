<!DOCTYPE html>
<%@page import="DrRAJ.DAO.IngredientDAO"%>
<%@page import="DrRAJ.Bean.IngredientBean"%>
<%@page import="DrRAJ.DAO.TestimonialDAO"%>
<%@page import="DrRAJ.Bean.TestimonialBean"%>
<html>
<head>
<title>Dr. Raj Homoeo Pharmacy | Nature to Safe & Sure Care</title>
<%@include file="UserHeader.jsp"%>
<section class="maincover homepage">
	<div class="blackcover"></div>
	<div class="container">
		<div class="jumbotext">
			Inspiring the quality of life for<br>healthier you
		</div>
	</div>
	<div class="owl-carousel main-banner-carousel">
		<div class="item bgimage" style="background-image: url(imgs/homebanner1.jpg);"></div>
		<div class="item bgimage" style="background-image: url(imgs/homebanner2.jpg);"></div>
	</div>
	<div class="posab">
		<img src="imgs/bottomwhitecircle.svg" />
	</div>
	<div class="homeRemediesCarousel">
		<div class="container">
			<div class="owl-carousel-wrapper" data-target=".remedies">
				<div class="owl-carousel owl-theme remedies">
					<%
						for (int i = 0; i < list.size(); i++) {
					%>
					<div class="item">
						<a href="<%=list.get(i).getForwardLink()%>" class="homeRemedies"
							style="background-image:url(http://www.shailmewada.ml/temp/?image=<%=list.get(i).getPhotolink()%>&h=300&w=300);"">
							<div class="bgblack"></div> <span><%=list.get(i).getName()%></span>
						</a>
					</div>
					<%
						}
					%>
				</div>
				<img src="imgs/left.svg" class="left-arrow" /> <img
					src="imgs/right.svg" class="right-arrow" />
			</div>
		</div>
	</div>
</section>
<div class="tcenter" style="margin-top: 95px;">
	<a href="remedies" class="button big">All Remedies</a>
</div>
<section class="know-your-medicine-home">
	<img src="imgs/know_your_medicine_home_banner.png"
			class="background-image" />
	<h2 class="title">Know Your Medicine</h2>
	<div class="container noowldots tcenter">
		<div class="owl-carousel-wrapper" data-target=".knowYourMedicines">
			<div class="owl-carousel owl-theme knowYourMedicines">

				<%
					ArrayList<IngredientBean> ingredientBeans = new IngredientDAO().getRandom();
					if (ingredientBeans.size() == 0) {
				%>
				<span>No ingredients</span>

				<%
					} else {

						for (int i = 0; i < ingredientBeans.size(); i++) {
				%>

				<div class="item">
					<div
						class="knowYourMedicine medicine<%=i%> medicineNode modelButton"
						target=".medicineModel"
						data-img="<%=ingredientBeans.get(i).getPhotoLink()%>"
						data-index="<%=i%>"
						data-title="<%=ingredientBeans.get(i).getTitle()%>"
						data-desc="<%=ingredientBeans.get(i).getDescription()%>">
						<img src="<%=ingredientBeans.get(i).getPhotoLink()%>" />
						<div class="bold"><%=ingredientBeans.get(i).getTitle()%></div>
						<p class="hidden"><%=ingredientBeans.get(i).getDescription()%></p>
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
		<a href="know-your-medicine" class="button big">Know More</a>
	</div>
</section>
<section class="bgimage aboutus-banner"
	style="background-image: url(https://farm5.staticflickr.com/4602/26597359718_7d7334de7d_o_d.jpg); background-attachment: inherit;">
	<div class="container">
		<div class="row">
			<div class="cm6 nomargin"></div>
			<div class="cm6 nomargin">
				<h2>We're Providing Quality Health Care With Finest Medicine
					You Trust</h2>
				<p>
					We're on a mission to bring quality of life to<br>children and
					families.
				</p>
				<br> <a href="company-info" class="button big blue">More
					About Us</a>
			</div>
		</div>
	</div>
</section>
<section class="quality-section">
	<div class="container">
		<h2>Medicines You Can Trust</h2>
		<h4>We believe in medicine safety and it's efficasy</h4>
		<div class="row">
			<div class="cs4">
				<img src="imgs/effective.svg" /> <span>Effective</span>
				<p>Our medicines are based on clinical trials done by R&D head
					to prove its efficacy & safety</p>
			</div>
			<div class="cs4">
				<img src="imgs/safe.svg" /> <span>Safe</span>
				<p>We use only the raw materials which are ascertained and
					standardized referring homoeopathic pharmacopeia of India</p>
			</div>
			<div class="cs4">
				<img src="imgs/high_quality.svg" /> <span>High Quality</span>
				<p>Our manufacturing steps follows stringent quality control
					procedure under CAMP guideline and process control management
					system based on ISO 9001 2015</p>
			</div>
		</div>
		<a href="manufacturing-practices" class="link">Learn more about
			our healthier medicines</a>
	</div>
</section>
<section class="charity-section bgimage"
	style="background-image: url(https://farm5.staticflickr.com/4722/26597357478_42d05be7c1_o_d.jpg); background-attachment: inherit;">
	<div class="container">
		<div class="row">
			<div class="cm6 nomargin">
				<h2>Serve to Wellness</h2>
				<p>
					We donate to charitable trust and NGO's focused on helping underprivileged in need of essential health services
				</p>
			</div>
			<div class="cm6 nomargin"></div>
		</div>
	</div>
</section>
<section class="bottom-rounded-title">
	<h2 class="title">Testimonials</h2>
	<div class="posab">
		<img src="imgs/bottomwhitecircle.svg" />
	</div>
	<div class="container">
		<div class="owl-carousel-wrapper" data-target=".testimonials">
			<div class="owl-carousel owl-theme testimonials">
				<%
					ArrayList<TestimonialBean> testimonialBeans = (ArrayList<TestimonialBean>) new TestimonialDAO().getList();
					for (int i = 0; i < testimonialBeans.size(); i++) {
				%>
				<div class="item tcenter">
					<div class="testimonial">
						<img src="<%=testimonialBeans.get(i).getPhotoLink()%>" /> <span><%=testimonialBeans.get(i).getName()%></span>
						<p>
							&ldquo;<%=testimonialBeans.get(i).getDescription()%>&rdquo;
						</p>
					</div>
				</div>
				<%
					}
				%>
			</div>
			<img src="imgs/left.svg" class="left-arrow" /> <img
				src="imgs/right.svg" class="right-arrow" />
		</div>
	</div>
</section>
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
<%@include file="UserFooter.jsp"%>
<script type="text/javascript">
	var curmodelindex;
	var medicineCount =
<%=ingredientBeans.size()%>
	;
	$(".medicineNode").click(function() {
		curmodelindex = $(this).attr("data-index");
		loadModelData($(".medicine" + curmodelindex));
	});
	function loadModelData(target) {
		$(".modelImage").attr("src", target.attr("data-img"));
		$(".modelTitle").text(target.attr("data-title"));
		$(".modelDesc").text(target.attr("data-desc"));
	}
	$(".modelNextButton").click(function() {
		curmodelindex++;
		if (curmodelindex > medicineCount - 1)
			curmodelindex = 0;
		loadModelData($(".medicine" + curmodelindex));
	});
	$(".modelPrevButton").click(function() {
		curmodelindex--;
		if (curmodelindex < 0)
			curmodelindex = medicineCount - 1;
		loadModelData($(".medicine" + curmodelindex));
	});
	$("body").keydown(function(e) {
		if (e.keyCode == 37)
			$(".modelPrevButton").click();
		if (e.keyCode == 39)
			$(".modelNextButton").click();
	});
	$('.remedies').owlCarousel({
		loop : true,
		margin : 20,
		nav : false,
		dots : false,
		pagination : false,
		responsive : {
			0 : {
				items : 1
			},
			560 : {
				items : 2
			},
			767 : {
				items : 2
			},
			991 : {
				items : 3
			}
		},
		autoplay : true,
		autoplayTimeout : 4000,
		autoHeight : true
	});
	$('.testimonials').owlCarousel({
		loop : true,
		margin : 20,
		nav : false,
		dots : false,
		pagination : false,
		responsive : {
			0 : {
				items : 1
			},
			767 : {
				items : 2
			},
			991 : {
				items : 3
			}
		},
		autoplay : true,
		autoplayTimeout : 10000,
		autoHeight : true
	});
	$('.knowYourMedicines').owlCarousel({
		loop : true,
		margin : 20,
		nav : false,
		dots : false,
		pagination : false,
		responsive : {
			0 : {
				items : 1
			},
			767 : {
				items : 2
			},
			991 : {
				items : 3
			}
		},
		autoplay : true,
		autoplayTimeout : 5000,
		autoHeight : true
	});
	$('.main-banner-carousel').owlCarousel({
		loop : true,
		margin : 0,
		nav : false,
		dots : false,
		pagination : false,
		items : 1,
		smartSpeed:900,
		autoplay : true,
		autoplayTimeout : 5000,
		autoHeight : true,
		animateOut: 'fadeOut'
	});
</script>
</html>