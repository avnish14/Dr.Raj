<%@page import="DrRAJ.Bean.DosageCategoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DrRAJ.Bean.ProductCategoryBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Dosage Category List</title>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="icon" href="imgs/daiict.png" />
<style>
td, tr, th {
	/*text-transform: uppercase;*/
	
}
</style>
<body>
	<a href="DosageCategoryInsert.jsp">Add</a>

	<%@include file="AdminHeader.jsp"%>
	<div style="margin-top: -850px; margin-left: 250px;">
		<section class="content content-header">
		<h1>
			Dosage Category <small>List</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="AdminDashBoard.jsp"><i class="fa fa-dashboard"></i>
					Home</a></li>
			<li class="active">Admin</li>
		</ol>
		<br>
		<br>
		<a href="DosageCategoryInsert.jsp"><input type="button"
			value="Add" name="Add" class="btn btn-primary"></a> <br>
		<br>
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-body">
						<table id="example1"
							class="table table-bordered table-hover table-striped">
							<%
								List<DosageCategoryBean> listOfDosageCategory = (ArrayList) request.getAttribute("listOfdosageCategory");
							%>
							<thead class="gujju-theme text-uppercase">
								<tr>
									<th>NAME</th>
									<th>ACTION</th>
								</tr>
							</thead>
							<tbody>

								<%
									if (listOfDosageCategory != null) {
										for (int i = 0; i < listOfDosageCategory.size(); i++) {
											DosageCategoryBean dosageCategory = listOfDosageCategory.get(i);
								%>
								<tr>
									<td><%=dosageCategory.getDosageCategoryName()%></td>
									<td><a
										href="DosageCategoryEditServlet?dosageCategoryId=<%=dosageCategory.getDosageCategoryid()%>"><img
											src="imgs/edit.svg" height="30" width="30"
											class="img-rounded" /></a>&nbsp;&nbsp; <a
										href="DosageCategoryDeleteServlet?dosageCategoryId=<%=dosageCategory.getDosageCategoryid()%>"><img
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