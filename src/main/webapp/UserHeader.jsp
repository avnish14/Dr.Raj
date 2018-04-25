<%@page import="DrRAJ.DAO.ProductCategoryDAO"%>
<%@page import="DrRAJ.Bean.ProductCategoryBean"%>
<%@page import="DrRAJ.DAO.RemediesDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DrRAJ.Bean.RemediesBean"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="css/owl.carousel.min.css" />
<link rel="stylesheet" type="text/css" href="css/design.css" />
<link
	href="https://fonts.googleapis.com/css?family=Nunito+Sans:300,400,600,700"
	rel="stylesheet">
<script type="text/javascript" src="js/jq.js"></script>
<script type="text/javascript" src="js/owl.carousel.min.js"></script>
</head>
<%
	ArrayList<RemediesBean> list = (ArrayList<RemediesBean>) new RemediesDAO().getList();
	ArrayList<ProductCategoryBean> productCategoryList = (ArrayList<ProductCategoryBean>) new ProductCategoryDAO()
			.getList();
%>
<body>
	<div class="mobilemenu">
		<div style="height: 55px; width: 100%;"></div>
		<div class="closebutton">
			<img src="imgs/close.svg" />
		</div>
		<div class="tcenter fgwhite links">
			<div class="whiteSeperator"></div>
			<div class="bold">Health & Homoeopathy</div>
			<div class="whiteSeperator"></div>
			<a href="faq">FAQ on Homoeopathy</a> <a href="know-your-medicine">Know
				Your Medicine</a> <a href="mind-body-spirit">Mind, Body & Spirit</a> <a
				href="homoeopathic-self-help">Homoeopathic Self-Help</a>
			<div class="whiteSeperator"></div>
			<div class="bold">About Us</div>
			<div class="whiteSeperator"></div>
			<a href="company-info">Company Info</a> <a
				href="our-core-value-and-mission">Our Core Values & Mission</a> <a
				href="manufacturing-practices">Manufacturing Practices</a>
			<!-- <a href="satisfied-customer">Satisfied Customers</a> -->
			<a href="contract-manufacturing">Contract Manufacturing</a> <a
				href="company-management">Company Management</a><a
				href="joint-ventures">Joint Ventures</a> <a href="news">News</a> <a
				href="contact-us">Contact Us</a>
			<div class="whiteSeperator"></div>
			<div class="bold">Remedies</div>
			<div class="whiteSeperator"></div>
			<%
				for (int i = 0; i < list.size(); i++) {
			%>

			<a href="<%=list.get(i).getForwardLink()%>"><%=list.get(i).getName()%></a>
			<%
				}
			%>
			<div class="whiteSeperator"></div>
			<div class="bold">Products</div>
			<div class="whiteSeperator"></div>
			<%
				for (int i = 0; i < productCategoryList.size(); i++) {
			%>

			<a href="<%=productCategoryList.get(i).getForwardLink()%>"><%=productCategoryList.get(i).getProductCategoryName()%></a>
			<%
				}
			%>
			<div class="whiteSeperator"></div>
			<a class="bold" href="homoeopathic-consultancy">Homoeopathic Consultancy</a>
			<div class="whiteSeperator"></div>
			<a class="bold" href="find-a-store-or-practitioner">Find a Store
				or Practitioner</a>
			<div class="whiteSeperator"></div>
		</div>
		<div style="height: 55px; width: 100%;"></div>
	</div>
	<header>
		<div class="container">
			<div class="navbar">
				<div class="leftnavbar">
					<div class="logo">
						<a href="." class="inblock"><img src="imgs/logo.svg" /></a>
					</div>
				</div>
				<div class="menubutton">
					<span></span><span></span><span></span>
				</div>
				<div class="rightnavbar">
					<div class="topnavbar">
						<a class="smallLink" href="find-a-store-or-practitioner">Find
							a Store or Practitioner</a> <a href="contact-us" class="smallLink">Contact</a>
						<a class="smallButton"
							href="https://www.homeomart.com/seo_key_word?&filter_name=dr.%20raj&filter=ATTRIBU=Dr+Raj+Homoeo+Pharmacy=2=Manufacturer"
							target="_blank">Buy Online</a>
						<div class="iconTextBox">
							<input type="text" class="smallTextBox"
								placeholder="Type here to search" /> <img src="imgs/search.svg"
								style="height: 15px; top: 9px;" />
						</div>
					</div>
					<div class="bottomnavbar">
						<div class="headerlink link">
							<span>Health & Homoeopathy</span>
							<div class="container-dropdown">
								<a href="faq" class="dropdown-link">
									<div style="background-image: url(https://farm5.staticflickr.com/4764/26597344768_46b0d0daee_o_d.jpg);"></div>
									<br> <span>FAQ on Homoeopathy</span>
								</a> <a href="know-your-medicine" class="dropdown-link">
									<div
										style="background-image: url(imgs/know_your_medicine_banner.jpg);"></div>
									<br> <span>Know Your Medicine</span>
								</a> <a href="mind-body-spirit" class="dropdown-link">
									<div
										style="background-image: url(https://farm5.staticflickr.com/4740/26597339438_a03e7dbab5_o_d.jpg);"></div>
									<br> <span>Mind, Body & Spirit</span>
								</a> <a href="homoeopathic-self-help" class="dropdown-link">
									<div
										style="background-image: url(https://farm5.staticflickr.com/4714/26597339928_e45660a633_o_d.jpg);"></div>
									<br> <span>Homoeopathic Self-Help</span>
								</a>
							</div>
						</div>
						<div class="headerlink link">
							<span>About Us</span>
							<div class="container-dropdown">
								<a href="company-info" class="dropdown-link">
									<div
										style="background-image: url(https://farm5.staticflickr.com/4622/26597346998_29b56b8059_o_d.jpg);"></div>
									<br> <span>Company Info</span>
								</a> <a href="our-core-value-and-mission" class="dropdown-link">
									<div style="background-image: url(https://farm5.staticflickr.com/4742/25697423517_79e796c0f7_o_d.jpg);"></div>
									<br> <span>Our Core Values & Mission</span>
								</a> <a href="manufacturing-practices" class="dropdown-link">
									<div
										style="background-image: url(https://farm5.staticflickr.com/4656/26602937348_38d1ee76e2_o_d.jpg);"></div>
									<br> <span>Manufacturing Practices</span>
								</a> <a href="contract-manufacturing" class="dropdown-link">
									<div
										style="background-image: url(https://farm5.staticflickr.com/4756/26597346058_5bf181b8c3_o_d.jpg);"></div>
									<br> <span>Contract Manufacturing</span>
								</a><br> <a href="company-management" class="dropdown-link">
									<div
										style="background-image: url(https://farm5.staticflickr.com/4743/26597346668_588eb6b254_o_d.jpg);"></div>
									<br> <span>Company Management</span>
								</a> <a href="joint-ventures" class="dropdown-link">
									<div
										style="background-image: url(https://farm5.staticflickr.com/4704/26597339608_bdb58edb91_o_d.jpg);"></div>
									<br> <span>Joint Ventures</span>
								</a> <a href="news" class="dropdown-link">
									<div style="background-image: url(https://farm5.staticflickr.com/4618/26597339228_b6827e0de3_o_d.png);"></div>
									<br> <span>News</span>
								</a> <a href="contact-us" class="dropdown-link">
									<div
										style="background-image: url(https://farm5.staticflickr.com/4659/26597346408_1ab1e85457_o_d.jpg);"></div>
									<br> <span>Contact Us</span>
								</a>
							</div>
						</div>
						<div class="headerlink link">
							<span>Remedies</span>
							<div class="container-dropdown" style="margin-left:-586px;">
								<%
									for (int i = 0; i < list.size(); i++) {
								%>
								<a href="<%=list.get(i).getForwardLink()%>"
									class="dropdown-link">
									<div
										style="background-image: url(http://www.shailmewada.ml/temp/?image=<%=list.get(i).getPhotolink()%>&h=300&w=300);"></div>
									<br> <span><%=list.get(i).getName()%></span>
								</a>
								<%
									if ((i+1) % 6 == 0) {
								%>
									<br>
								<%
									}
									}
								%>
							</div>
						</div>
						<div class="headerlink link">
							<span>Products</span>
							<div class="container-dropdown" style="margin-left:-489px;">
								<a href="drops"	class="dropdown-link">
									<div style="background-image: url(https://farm5.staticflickr.com/4649/26597345918_e9529533ec_o_d.jpg);"></div>
									<br> <span>Drops</span>
								</a>
								<a href="herbal-care"	class="dropdown-link">
									<div style="background-image: url(https://farm5.staticflickr.com/4758/26597341938_f5594beb73_o_d.jpg);"></div>
									<br> <span>Herbal Care</span>
								</a>
								<a href="tablets"	class="dropdown-link">
									<div style="background-image: url(https://farm5.staticflickr.com/4697/26597336928_6e42fa5ff5_o_d.jpg);"></div>
									<br> <span>Tablets</span>
								</a>
								<a href="tonics"	class="dropdown-link">
									<div style="background-image: url(https://farm5.staticflickr.com/4661/26597337198_ccaef0326a_o_d.jpg);"></div>
									<br> <span>Tonics</span>
								</a>
								<a href="triturations"	class="dropdown-link">
									<div style="background-image: url(https://farm5.staticflickr.com/4699/40525517942_5d8c25906b_o_d.jpg);"></div>
									<br> <span>Triturations</span>
								</a>
							</div>
						</div>
<%-- 						<div class="hover-dropdown">
							Products
							<div class="hover-dropdown-menu">
								<%
									for (int i = 0; i < productCategoryList.size(); i++) {
								%>

								<a href="<%=productCategoryList.get(i).getForwardLink()%>"><%=productCategoryList.get(i).getProductCategoryName()%></a>
								<%
									}
								%>
							</div>
						</div> --%>
						<a class="link headerlink" href="homoeopathic-consultancy">Homoeopathic
							Consultancy</a>
					</div>
				</div>
			</div>
		</div>
	</header>