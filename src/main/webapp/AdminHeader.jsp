<!DOCTYPE html>
<%@page import="DrRAJ.Bean.AdminBean"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>Dr. RAJ | Dashboard</title>

<noscript>
	<meta HTTP-EQUIV="Refresh" CONTENT="0;URL=JavaScriptErrorPage.jsp">
</noscript>
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/ionicons.min.css">
<link rel="stylesheet" href="css/AdminLTE.min.css">
<link rel="stylesheet" href="css/_all-skins.min.css">
<link rel="stylesheet" href="css/dataTables.bootstrap.css">
<link rel="icon" href="imgs/daiict.png" />
<link
	href="https://fonts.googleapis.com/css?family=Nunito+Sans:300,400,600,700"
	rel="stylesheet">
<style type="text/css">
*, input, button {
	font-family: 'Nunito Sans';
}
</style>
</head>
<body class="hold-transition skin-blue sidebar-mini fixed">
	<%
		AdminBean adminBeanHeader = (AdminBean) session.getAttribute("adminBean");

		if (adminBeanHeader != null) {
	%>
	<div class="wrapper">
		<header class="main-header">
			<a href="AdminDashBoard.jsp" class="logo"> <span
				class="logo-mini"><b></b></span> <span class="logo-lg"><b>Dr.
						Raj Homoeopathy</b></span>
			</a>
			<nav class="navbar navbar-static-top" role="navigation">
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
					role="button"></a>
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="fa-user fa"></i> <%=adminBeanHeader.getFirstName() + " " + adminBeanHeader.getLastName()%><b
								class="caret"></b>
						</a>
							<ul class="dropdown-menu" style="border-color: black;">
								<li class="user-header"><img src="imgs/daiict_main.png"
									class="img-circle" alt="User Image">
									<p>
										<%=adminBeanHeader.getFirstName() + " " + adminBeanHeader.getLastName()%><br>
										<small><%=adminBeanHeader.getEmailId()%></small>
									</p></li>
								<li class="user-footer">
									<div class="pull-left">
										<a href="ChangePassword.jsp" class="btn btn-default btn-flat">Change
											Password</a>
									</div>
									<div class="pull-right">
										<a href="AdminLogoutServlet" class="btn btn-default btn-flat">Sign
											out</a>
									</div>
								</li>
							</ul></li>
					</ul>
				</div>
			</nav>
		</header>
		<aside class="main-sidebar" style="min-height: 900px;">
			<section class="sidebar">
				<%-- <div class="user-panel">
					<div class="pull-left image">
						<img src="imgs/daiict_main.png" class="img-circle"
							alt="User Image">
					</div>
					<div class="pull-left info">
						<p>
							&emsp;
							<%=adminBeanHeader.getFirstName()%>
						</p>
					</div>
				</div> --%>
				<ul class="sidebar-menu">
					<li class=" treeview"><a href="AdminDashBoard.jsp"> <i
							class="fa fa-pie-chart"></i> <span>Dashboard</span> <!--<i class="fa fa-angle-left pull-right"></i>-->
					</a></li>




					<!-- -----------------------------------Products-------------------------------   -->
					<li class="treeview"><a href="ProductListServlet"> <i
							class="fa fa-plus-square"></i> <span>Products</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">


							<!-- -----------------------------------Products > Product List--------------------------------->

							<li><a href="ProductListServlet"><i class="fa fa-gg"></i>
									Products</a></li>

							<!-- -----------------------------------Products > Product Category-------------------------------   -->

							<li><a href="ProductCategoryListServlet"><i
									class="fa fa-gg"></i> Category</a></li>

							<!-- -----------------------------------Product Indication-------------------------------   -->

							<li><a href="ProductIndicationListServlet"><i
									class="fa fa-gg"></i> Indication</a></li>

							<!-- -----------------------------------Dosage Category-------------------------------   -->

							<!-- <li class="treeview"><a href="DosageCategoryListServlet">
									<i class="fa fa-plus-square"></i> <span>Dosage Category</span>
									<i class="fa fa-angle-left pull-right"></i>
							</a>
								<ul class="treeview-menu">
									<li><a href="DosageCategoryInsert.jsp"><i
											class="fa fa-gg"></i> Add </a></li>
									<li><a href="DosageCategoryListServlet"><i
											class="fa fa-gg"></i> List</a></li>
								</ul></li> -->

							<!-- -----------------------------------Product Dosage-------------------------------   -->

							<li><a href="ProductDosageListServlet"><i
									class="fa fa-gg"></i> Dosage</a></li>

							<!-- -----------------------------------Product Indication-------------------------------   -->

							<li><a href="ProductCompositionListServlet"><i
									class="fa fa-gg"></i> Composition</a></li>

							<!-- -----------------------------------Product Related Product-------------------------------   -->

							<!-- <li class="treeview"><a href="ReletedProductListServlet">
									<i class="fa fa-plus-square"></i> <span>Related Product</span>
									<i class="fa fa-angle-left pull-right"></i>
							</a>
								<ul class="treeview-menu">
									<li><a href="RelatedProductInsert.jsp"><i
											class="fa fa-gg"></i> Add </a></li>
									<li><a href="ReletedProductListServlet"><i
											class="fa fa-gg"></i> List </a></li>
								</ul></li>
 -->
							<!-- -----------------------------------Remedies-------------------------------   -->

							<li><a href="RemediesListServlet"><i class="fa fa-gg"></i>
									Remedies</a></li>

							<!-- -----------------------------------Ingredients-------------------------------   -->

							<li><a href="IngredientListServlet"><i class="fa fa-gg"></i>
									Ingredients</a></li>

							<!-- -----------------------------------Product Price-------------------------------   -->

							<li><a href="PriceListServlet"><i class="fa fa-gg"></i>
									Price</a></li>

							<!-- -----------------------------------Product Keyword-------------------------------   -->

							<li><a href="ProductKeywordListServlet"><i
									class="fa fa-gg"></i> Keyword</a></li>

							<!-- -----------------------------------Product Review-------------------------------   -->

						</ul></li>

					<!-- -----------------------------------Products close-------------------------------   -->


					<!-- <li class="treeview"><a href="AdminListServlet"> <i
							class="fa fa-user-secret"></i> <span>Admin Management</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="AdminInsert.jsp"><i class="fa fa-user-plus"></i>
									Insert</a></li>
							<li><a href="AdminListServlet"><i class="fa fa-users"></i>
									List</a></li>
						</ul></li> -->

					<li class=" treeview"><a href="AdminListServlet"> <i
							class="fa fa-lock"></i> <span>Admin</span>
					</a></li>


					<!-- <li class="treeview"><a href="BookListServlet"> <i
							class="fa fa-pencil-square-o"></i> <span>Book's Details</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">


							-----------------------------------Book > BookList-------------------------------

							<li><a href="BookListServlet"><i class="fa fa-gg"></i>
									Books</a></li>

							-----------------------------------Book > Book Keyword List-------------------------------

							<li><a href="BookKeywordListServlet"><i class="fa fa-gg"></i>
									Keyword</a></li>

							-----------------------------------Book > Book Type List-------------------------------

							<li><a href="BookTypeListServlet"><i class="fa fa-gg"></i>
									Types</a></li>
						</ul></li> -->

					<!-- -----------------------------------Store Management-------------------------------   -->

					<li class="treeview"><a href="StoreListServlet"> <i
							class="fa fa-street-view"></i> <span>Find a Store</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">

							<!-- -----------------------------------Store > StoreList--------------------------------->

							<li><a href="StoreDetailsListServlet"><i
									class="fa fa-gg"></i> Stores</a></li>

							<!-- -----------------------------------Store > State--------------------------------->

							<li><a href="StateListServlet"><i class="fa fa-gg"></i>
									States</a></li>

							<!-- -----------------------------------Store > City--------------------------------->

							<li><a href="CityListServlet"><i class="fa fa-gg"></i>
									Cities</a></li>
						</ul></li>

					<!-- -----------------------------------Store Management close-------------------------------   -->

					<li class="treeview"><a href="BookListServlet"> <i
							class="fa fa-newspaper-o"></i> <span>Press Info Details</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">

							<!-- -----------------------------------Press > Press Info--------------------------------->

							<li><a href="PressInfoListServlet"><i class="fa fa-gg"></i>
									Press Info</a></li>

							<!-- -----------------------------------Press > Press Type--------------------------------->

							<li><a href="PressInfoTypeListServlet"><i
									class="fa fa-gg"></i> Type</a></li>

						</ul></li>

					<li class="treeview"><a href="CompanyManagementListServlet"><i
							class="fa fa-users"></i><span> Company Management</span></a></li>

					<li class="treeview"><a href="TestimonialListServlet"><i
							class="fa fa-commenting"></i> <span>Testimonial</span></a></li>

					<li class="treeview"><a href="ReviewListServlet"> <i
							class="fa fa-comments"></i> <span>Review</span>
					</a></li>


					<li class="treeview"><a href="BusinessParternshipsListServlet">
							<i class="fa fa-phone-square"></i> <span>Contact Us</span>
					</a></li>


					<!-- <li class="treeview"><a href="FeedbackListServlet"> <i
							class="fa fa-comment"></i> <span>Feedback</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="feedbackByCourseSelection.jsp"><i
									class="fa fa-gg"></i> Feedback List</a></li>
							<li><a href="DateFeedbackCounterListServlet"><i
									class="fa fa-gg"></i> Feedback Counter List</a></li>
						</ul></li> -->

					<li class=" treeview"><a href="ContactUsListServlet"> <i
							class="fa fa-comment"></i> <span>Homoeopathic Advice</span>
					</a></li>

					<!-- -----------------------------------Joint Ventures Management-------------------------------   -->

					<li class="treeview"><a href="StoreListServlet"> <i
							class="fa fa-street-view"></i> <span>Joint Ventures</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">

							<!-- -----------------------------------Store > Joint VenturesList--------------------------------->

							<li><a href="JointVenturesListServlet"><i
									class="fa fa-gg"></i> Joint Ventures</a></li>

							<!-- -----------------------------------Store > Joint Ventures Details--------------------------------->

							<li><a href="JointVenturesDetailsListServlet"><i
									class="fa fa-gg"></i> Joint Ventures Details</a></li>

							<li><a href="JointVenturesURLDetailsListServlet"><i
									class="fa fa-gg"></i> Joint Ventures URL Details</a></li>
						</ul></li>

				</ul>
			</section>
		</aside>
		<div class="content-wrapper">
			<%
				} else {
					request.setAttribute("msgLogin", "Please Login To Continue");
					response.sendRedirect("login.jsp");
				}
			%>