<%@page import="DrRAJ.Bean.FAQBean"%>
<%@page import="DrRAJ.Bean.IngredientBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>FAQ | FAQ List</title>
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
			FAQ <small>List</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="AdminDashBoard.jsp"><i class="fa fa-dashboard"></i>
					Home</a></li>
			<li class="active">FAQ</li>
		</ol>
		<br>
		<br>
		<a href="FAQInsert.jsp"><input type="button" value="Add"
			name="Add" class="btn btn-primary"></a> <br>
		<br>
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-body">
						<table id="example1"
							class="table table-bordered table-hover table-striped">

							<%
								ArrayList<FAQBean> list = (ArrayList<FAQBean>) request.getAttribute("faqList");
							%>
							<thead class="gujju-theme text-uppercase">
								<tr>
									<th>Question</th>
									<th>Answer</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<%
									for (FAQBean bean : list) {
								%>
								<tr>
									<td><%=bean.getQuestion()%></td>
									<td><textarea disabled="disabled"><%=bean.getAnswer()%></textarea></td>
									<td><a href="FAQEditServlet?faqId=<%=bean.getFaqId()%>"><img
											src="imgs/edit.svg" height="30" width="30"
											class="img-rounded" /></a>&nbsp;&nbsp; <a
										href="FAQDeleteServlet?faqId=<%=bean.getFaqId()%>"><img
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