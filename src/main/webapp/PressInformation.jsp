<%@page import="DrRAJ.DAO.NewsDAO"%>
<%@page import="DrRAJ.Bean.NewsBean"%>
<%@page import="DrRAJ.Controller.NewsListServlet"%>
<%@page import="DrRAJ.Bean.PressInfoBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="DrRAJ.DAO.PressInfoTypeDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DrRAJ.Bean.PressInfoTypeBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>News | Dr. Raj Homoeo Pharmacy</title>
<%@include file="UserHeader.jsp"%>
<section class="bgimage maincover regular"
	style="background-image: url(https://farm5.staticflickr.com/4606/40468139451_ae8bdbf2fd_o_d.jpg);">
<div class="blackcover"></div>
<div class="container">
	<h3>About Us</h3>
	<div class="jumbotext">News</div>
</div>
<div class="posab">
	<img src="imgs/bottomwhitecircle.svg"/>
</div>
</section>
<section>
<div class="container medium">
	<h2 class="fgmain">Press Information</h2>
	<br>
	<%
		HashMap<String, List<PressInfoBean>> map = (HashMap<String, List<PressInfoBean>>) new PressInfoTypeDAO()
				.getListMap();
		if (map.size() != 0) {
			for (String str : map.keySet()) {
				ArrayList<PressInfoBean> arrayList = (ArrayList<PressInfoBean>) map.get(str);
	%>

	<h3><%=str%></h3>

	<%
		if (arrayList.size() == 0) {
	%>
	<span>No Info</span>
	<%
		} else {
					for (int i = 0; i < arrayList.size(); i++) {
	%>
	<a href="<%=arrayList.get(i).getLink()%>" class="link"><%=arrayList.get(i).getTitle()%></a><br>
	<%
		}
	%><br>
	<%
		}
			}
		}
	%><br>
	<h2 class="fgmain">News</h2>
	<br>

	<%
		ArrayList<NewsBean> newsBeans = (ArrayList<NewsBean>) new NewsDAO().getList();
		if (newsBeans.size() == 0) {
	%>
	<h3>No News</h3>
	<%
		} else {
			for (int i = 0; i < newsBeans.size(); i++) {
	%>
	<div class="row news<%=i%>"
		data-img="<%=newsBeans.get(i).getPhotoLink()%>"
		data-title="<%=newsBeans.get(i).getTitle()%>"
		data-desc="<%=newsBeans.get(i).getContent()%>">
		<div class="cs4 tcenter">
			<img src="<%=newsBeans.get(i).getPhotoLink()%>" class="imgResponsive"
				style="max-height: 200px;" />
		</div>
		<div class="cs8 newsBlock">
			<h3><%=newsBeans.get(i).getTitle()%></h3>
			<p class="paragraph"><%=newsBeans.get(i).getContent()%></p>
			<div class="modelButton newsNode"
				target=".newsModel" data-index="<%=i%>">Read More</div>
		</div>
	</div>
	<%
		}
		}
	%>
	<div class="model newsModel open">
		<div class="backblack"></div>
		<div class="bodyParent">
			<div class="body">
				<div class="header tcenter" style="height:auto;">
					<img class="imgResponsive modelImage" /> <img
						src="imgs/closeBlack.svg" class="modelCloser" />
				</div>
				<div class="newsModalInner">
					<div class="modelTitle"></div>
					<p class="paragraph modelDesc"></p>
				</div>
			</div>
		</div>
	</div>
</div>
</section>
<%@include file="UserFooter.jsp"%>
<script type="text/javascript">
	var curmodelindex;
	var newsCount =<%=newsBeans.size()%>;
	$(".newsNode").click(function() {
		curmodelindex = $(this).attr("data-index");
		loadModelData($(".news" + curmodelindex));
	});
	function loadModelData(target) {
		$(".modelImage").attr("src", target.attr("data-img"));
		$(".modelTitle").text(target.attr("data-title"));
		$(".modelDesc").text(target.attr("data-desc"));
	}
</script>
</html>