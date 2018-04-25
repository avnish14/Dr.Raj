<%@page import="DrRAJ.Bean.BlogBean"%>
<%@page import="DrRAJ.Bean.BookBean"%>
<%@page import="DrRAJ.Bean.IngredientBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Blog List</title>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
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
			Blog <small>List</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="AdminDashBoard.jsp"><i class="fa fa-dashboard"></i>
					Home</a></li>
			<li class="active">Admin</li>
		</ol>
		<br>
		<br>
		<a href="BlogInsert.jsp" name="Add" class="btn btn-primary">Add</a> <br>
		<br>
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-body">
						<table id="example1"
							class="table table-bordered table-hover table-striped">

							<%
								ArrayList<BlogBean> list = (ArrayList<BlogBean>) request.getAttribute("listOfBlog");
							%>
							<thead class="gujju-theme text-uppercase">
								<tr>
									<th>Title</th>
									<th>Date</th>
									<th>Photo</th>
									<th>URLLink</th>
									<th>Content</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<%
									for (BlogBean bean : list) {
								%>
								<tr>
									<td><%=bean.getBlogTitle()%></td>
									<td><%=bean.getDate()%></td>
									<td><img src="<%=bean.getImageLink()%>" width="150" height="150"/></td>
									<td><%=bean.getUrlLink()%></td>
									<td><textarea disabled="disabled"><%=bean.getContent()%></textarea></td>
									<td><a href="BlogEditServlet?blogId=<%=bean.getBlogId()%>"><img
											src="imgs/edit.svg" height="30" width="30"
											class="img-rounded" /></a>&nbsp;&nbsp; <a
										href="BlogDeleteServlet?blogId=<%=bean.getBlogId()%>"><img
											src="imgs/delete.svg" height="30" width="30"
											class="img-rounded" /></a>
								</tr>
								<%
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