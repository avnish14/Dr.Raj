<%@page import="DrRAJ.DAO.TestimonialDAO"%>
<%@page import="DrRAJ.Bean.TestimonialBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Satisfied Customers | Dr. Raj Homoeo Pharmacy</title>
<%@include file="UserHeader.jsp"%>
<body>
	<section class="bgimage"
		style="background-image: url(https://farm5.staticflickr.com/4758/26597341938_f5594beb73_o_d.jpg);">
	<div class="blackcover opaq2"></div>
	<div class="container posrel" style="z-index: 2;">
		<br> <br> <br> <br>
		<h3 class="tcenter bold text-2 fgwhite">About Us</h3>
		<div class="tcenter fgwhite jumbotext text-2"
			style="margin-bottom: 40px;">Satisfied Customers</div>
		<br> <br> <br>
	</div>
	<div class="posab overhidden"
		style="z-index: 3; width: 100%; bottom: -7px;">
		<img src="imgs/bottomwhitecircle.svg" class="posrel"
			style="width: 120%; left: -10%" />
	</div>
	</section>
	<section>
	<div class="container" style="max-width: 900px;">
		<%
			ArrayList<TestimonialBean> testimonialBeans = (ArrayList<TestimonialBean>) new TestimonialDAO().getList();
			for (int i = 0; i < testimonialBeans.size(); i++) {
		%>
		<div class="row" style="margin-bottom: 25px;">
			<div class="cs2">
				<img src="<%=testimonialBeans.get(i).getPhotoLink()%>"
					style="max-height: 150px; max-width: 100%;border-radius:500px;" />
			</div>
			<div class="cs10">
				<div class="fgmain bold size12"><%=testimonialBeans.get(i).getName()%></div>
				<p class="paragraph" style="margin-top: 3px; font-style: italic;">
					&ldquo;<%=testimonialBeans.get(i).getDescription()%>&rdquo;
				</p>
			</div>
		</div>
		<%
			}
		%>
	</div>
	</section>
	<%@include file="UserFooter.jsp"%>
	<script type="text/javascript"></script>
</body>
</html>