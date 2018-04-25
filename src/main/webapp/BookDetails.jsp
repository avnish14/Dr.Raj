<%@page import="com.google.gson.Gson"%>
<%@page import="DrRAJ.Bean.BookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
	BookBean bean = (BookBean) request.getAttribute("bean");
%>
<title><%=bean.getName() %> | Dr. Raj Homoeo Pharmacy</title>
<%@include file="UserHeader.jsp"%>
<body>
	<section>
		<div class="container">
			<div class="row">
				<div class="cs3 tcenter">
					<img class="imgResponsive card-3" style="max-height: 300px;" src="<%=bean.getPhotolink() %>"/>
				</div>
				<div class="cs9">
					<h2><%=bean.getName() %></h2>
					<div>
						<span class="bold">By <%=bean.getAuthor() %></span>&nbsp;&nbsp;&nbsp;
						<span class="bold opaq6 text-nowrap">ISBN <%=bean.getIsbn() %></span>
					</div>
					<p class="paragraph" style="text-align: justify;"><%=bean.getDescription() %></p>
				</div>
			</div>
		</div>
	</section>
<%@include file="UserFooter.jsp"%>
</body>
</html>