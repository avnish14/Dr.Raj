<%@page import="java.util.ArrayList"%>
<%@page import="DrRAJ.DAO.ProductCategoryDAO"%>
<%@page import="DrRAJ.Bean.ProductCategoryBean"%>
<section>
	<div class="row join-community"
		style="background-image: url(https://farm5.staticflickr.com/4711/26597354138_11a7cc463d_o_d.jpg);">
		<div class="cs6">
			<div class="links">
				<div>
					<span>@DRRAJGLOBAL</span>
					<p>Join Our Community</p>
					<a href="#" target="_blank"><img src="imgs/facebook.svg" /></a> <a
						href="#" target="_blank"><img src="imgs/linkedin.svg" /></a> <a
						href="#" target="_blank"><img src="imgs/twitter.svg" /></a>
				</div>
				<div class="backface"></div>
			</div>
		</div>
		<div class="cs6"></div>
	</div>
</section>
<footer class="bggrey">
	<div class="container" style="padding-bottom: 10px;">
		<div class="tcenter">
			<a href="."><img src="imgs/logo.svg" style="height: 70px;" /></a>
		</div>
		<br>
		<div class="footerBlockWrapper">
			<div class="footerblock">
				<span>Health & Homoeopathy</span><a href="faq">FAQ on
					Homoeopathy</a><a href="know-your-medicine">Know Your Medicine</a><a
					href="mind-body-spirit">Mind, Body & Spirit</a><a
					href="homoeopathic-self-help">Homoeopathic Self-Help</a>
			</div>
			<div class="footerblock">
				<span>About Us</span> <a href="company-info">Company Info</a><a
					href="our-core-value-and-mission">Our Core Values & Mission</a><a
					href="manufacturing-practices">Manufacturing Practices</a> <a
					href="contract-manufacturing">Contract Manufacturing</a><a
					href="company-management">Company Management</a><a
					href="joint-ventures">Joint Ventures</a><a href="news">News</a><a
					href="contact-us">Contact Us</a>
			</div>
			<div class="footerblock">
				<span>Products</span>
				<%
					ArrayList<ProductCategoryBean> beans = (ArrayList<ProductCategoryBean>) new ProductCategoryDAO().getList();
					for (int i = 0; i < beans.size(); i++) {
				%>
				<a href="<%=beans.get(i).getForwardLink()%>"><%=beans.get(i).getProductCategoryName()%></a>
				<%
					}
				%>
				<a href="find-a-store-or-practitioner" class="mainLink">Find a
					Store or Practitioner</a>
			</div>
		</div>
		<!--<a class="designedby" target="_blank"
			 href="https://www.instagram.com/desk_of_design/"><img
			src="imgs/dod.svg" />Designed & Developed by Desk of Design</a> --> <span
			class="copyright"> &copy; <span class="cyear"></span> Dr. Raj
			Homoeo Pharmacy. All rights reserved.
		</span>
	</div>
</footer>
</body>
<script type="text/javascript" src="js/code.js"></script>
<script>
	$(".cyear").text((new Date()).getFullYear());
</script>