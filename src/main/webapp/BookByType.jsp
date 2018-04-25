<%@page import="DrRAJ.DAO.BookDAO"%>
<%@page import="DrRAJ.Bean.BookBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>| Dr. Raj Homoeo Pharmacy</title>
<%@include file="UserHeader.jsp"%>
<body>
	<%
		Gson gson = new Gson();
		String type = (String) request.getAttribute("type");
		ArrayList<BookBean> mybeans = new BookDAO().getBySubtypes(type);
		String books = gson.toJson(mybeans);
	%>

	<div class="rawdata hidden"><%=books%></div>

	<section class="bgimage"
		style="background-image: url(imgs/<%=type%>.jpg);">
	<div class="blackcover opaq2"></div>
	<div class="container posrel" style="z-index: 2;">
		<br> <br> <br> <br> <br>
		<div class="tcenter fgwhite jumbotext text-2 title"
			style="margin-bottom: 40px; text-transform: capitalize;"></div>
		<br> <br> <br> <br>
	</div>
	<div class="posab overhidden"
		style="z-index: 3; width: 100%; bottom: -7px;">
		<img src="imgs/bottomwhitecircle.svg" class="posrel"
			style="width: 120%; left: -10%" />
	</div>
	</section>
	<section>
	<div class="container">
		<div class="bookContainer"></div>
	</div>
	</section>
	<%@include file="UserFooter.jsp"%>
	<script type="text/javascript">
		var rawdata = $.parseJSON($(".rawdata").text());
		if (rawdata.length > 0) {
			$("title").text(rawdata[0].type +" "+ $("title").text());
			$(".title").text(rawdata[0].type);
		}
		var rowcount=0;
		var template='';
		for(var r of rawdata){
			if(rowcount==0)template+='<div class="row">';
			rowcount++;
			template+='<div class="cs3 tcenter" style="overflow:hidden;">';
			template+='<img src="'+r.photolink+'" style="max-height: 200px; margin-bottom: 5px;" />';
			template+='<div class="bold text-nowrap">'+r.name+'</div>';
			template+='<div class="opaq6 text-nowrap">'+r.author+'</div>';
			template+='<div class="opaq6 text-nowrap" style="margin-bottom:5px;">ISBN : '+r.isbn+'</div>';
			template+='<a href="'+r.urllink+'" class="button blue">More Info</a>';
			template+='</div>';
			if(rowcount==4){
				template+='</div>';
				rowcount=0;
			}
		}
		if(rowcount!=4){
			template+='</div>';
		}
		$(".bookContainer").append(template);
	</script>
</body>
</html>