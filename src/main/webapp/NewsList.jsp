<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DrRAJ.Bean.NewsBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>News | News List</title>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	content="viewport">
<link rel="icon" href="imgs/daiict.png" />
<style>
td, tr, th {
	/*text-transform: uppercase;*/
	
}
</style>

</head>
<body>
	<%@include file="AdminHeader.jsp"%>
	<div style="margin-top: -850px; margin-left: 250px;">
		<section class="content content-header">
		<h1>
			News <small>List</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="AdminDashBoard.jsp"><i class="fa fa-dashboard"></i>
					Home</a></li>
			<li class="active">News</li>
		</ol>
		<br>
		<br>
		<a href="NewsInsert.jsp"><input type="button" value="Add"
			content="Add" class="btn btn-primary"></a> <br>
		<br>
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-body">
						<table id="example1"
							class="table table-bordered table-hover table-striped">

							<thead class="gujju-theme text-uppercase">
								<tr>
									<th>Title</th>
									<th>Photo</th>
									<th>Content</th>
									<th>ACTION</th>
								</tr>
							</thead>
							<tbody>
								<%
									List<NewsBean> listOfNews = (ArrayList) request.getAttribute("listOfNews");

									if (listOfNews != null) {
										for (int i = 0; i < listOfNews.size(); i++) {
											NewsBean news = listOfNews.get(i);
								%>

								<tr>
									<td><%=news.getTitle()%></td>
									<td><img src="<%=news.getPhotoLink()%>" height="20%" width="40%"></img></td>
									<td><textarea rows="3" cols="20" disabled="disabled"><%=news.getContent()%></textarea></td>
									<td><a href="NewsEditServlet?newsId=<%=news.getNewsId()%>"><img
											src="imgs/edit.svg" height="30" width="30"
											class="img-rounded" /></a>&nbsp;&nbsp;<a
										href="NewsDeleteServlet?newsId=<%=news.getNewsId()%>"><img
											src="imgs/delete.svg" height="30" width="30"
											class="img-rounded" /></a></td>
								</tr>
								<%
									}
									}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		</section>
	</div>
</body>
</html>