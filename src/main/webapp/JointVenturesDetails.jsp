<%@page import="DrRAJ.DAO.JointVenturesDetailsDAO"%>
<%@page import="DrRAJ.Bean.JointVenturesDetailsBean"%>
<%@page import="DrRAJ.DAO.JointVenturesURLDetailsDAO"%>
<%@page import="DrRAJ.Bean.JointventuresURLDetailsBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DrRAJ.Bean.JointVenturesBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.accordion {
	position: relative;
}

.accordion .header {
	padding: 10px;
	cursor: pointer;
	margin: 10px 0;
	padding-right: 50px;
}

.accordion img {
	position: absolute;
	top: -2px;
	right: 6px;
	transition: transform 0.6s ease;
}

.accordion.open img {
	transition: transform 0.3s ease;
	transform: rotate(180deg);
}

.accordion .body {
	padding: 10px;
	padding-top: 3px;
	padding-bottom: 0;
	margin-bottom: 0;
	display: none;
	margin-bottom: 30px;
}

.accordion.open .body {
	display: block;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
	JointVenturesBean bean = (JointVenturesBean) request.getAttribute("jointVenturesBean");
	if (bean != null) {

		ArrayList<JointventuresURLDetailsBean> urlDetailsBeans = new JointVenturesURLDetailsDAO()
				.getDetails(bean.getId());
		ArrayList<JointVenturesDetailsBean> detailsBeans = new JointVenturesDetailsDAO().getList(bean.getId());
%>
<title><%=bean.getName()%> | Dr. Raj Homoeo Pharmacy</title>
<%@include file="UserHeader.jsp"%>
<section class="bgimage"
	style="background-image: url(<%=bean.getImageLink()%>);">
<div class="blackcover opaq2"></div>
<div class="container posrel" style="z-index: 2;">
	<br> <br> <br> <br>
	<div class="tcenter fgwhite jumbotext text-2"
		style="margin-bottom: 40px;"><%=bean.getName()%></div>
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
		if (detailsBeans.size() != 0 || detailsBeans != null) {
				for (JointVenturesDetailsBean detailBean : detailsBeans) {
	%>
	<h2 style="margin-bottom: 10px;" class="fgmain"><%=detailBean.getTitle()%></h2>
	<p class="paragraph"><%=detailBean.getContent()%></p>
	<%
		}
			}
	%>
	<%
		if (urlDetailsBeans.size() != 0 || urlDetailsBeans != null) {
				for (JointventuresURLDetailsBean urlDetailBeans : urlDetailsBeans) {
	%>
	<div class="accordion">
		<img src="imgs/down.svg" />
		<div class="bold size11 header"><%=urlDetailBeans.getSubTitle()%></div>
		<p class="paragraph body" style="margin-top: 5px;"><%=urlDetailBeans.getContent()%><br><a href="<%=urlDetailBeans.getPdfLink()%>" class="link" target="_blank">Download PDF : <%=urlDetailBeans.getPdfName()%></a></p>
	</div>
	<%
		}
			}
	%>

	<%
		} else
			response.sendRedirect("not-found");
	%>
</div>
</section>
<%@include file="UserFooter.jsp"%>
<script type="text/javascript">
	if ($(".accordion")[0]) {
		/*$(".accordion:first-child").addClass("open");
		$(".accordion:first-child").children(".header").addClass("bggrey");*/
	}
	$(".accordion").click(function() {
		if ($(this).hasClass("open")) {
			$(this).removeClass("open");
			$(this).children(".header").removeClass("bggrey");
		} else {
			$(".accordion").removeClass("open");
			$(".accordion").children(".header").removeClass("bggrey");
			$(this).addClass("open");
			$(this).children(".header").addClass("bggrey");
		}
	});
</script>
</body>
</html>