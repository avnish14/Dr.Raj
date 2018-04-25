<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DrRAJ.Bean.CompanyManagementBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Company Management</title>
</head>
<%@include file="AdminHeader.jsp"%>
<section class="content content-header">
	<h1>Company Management</h1>
	<br> <br> <a href="CompanyManagementInsert.jsp"><input
		type="button" value="Add" name="Add" class="btn btn-primary"></a>
	<br> <br>
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-body">
					<table id="example1"
						class="table table-bordered table-hover table-striped">
						<thead class="gujju-theme text-uppercase">
							<tr>
								<th>Photo</th>
								<th>Name</th>
								<th>Title / Designation</th>
								<th>ACTION</th>
							</tr>
						</thead>
						<tbody>
							<%
								List<CompanyManagementBean> listOfCompanyManagement = (ArrayList) request
										.getAttribute("listOfCompanyManagement");

								if (listOfCompanyManagement != null) {
									for (int i = 0; i < listOfCompanyManagement.size(); i++) {
										CompanyManagementBean companyManagement = listOfCompanyManagement.get(i);
							%>
							<tr>
								<td><img src="<%=companyManagement.getPhotoLink()%>"
									style="max-height: 100px;" /></td>
								<td><%=companyManagement.getName()%></td>
								<td><%=companyManagement.getTitle()%></td>
								<td><a
									href="CompanyManagementEditServlet?companyManagementId=<%=companyManagement.getCompanyManagementId()%>"><img
										src="imgs/edit.svg" height="30" width="30" class="img-rounded" /></a>&nbsp;<a
									href="CompanyManagementDeleteServlet?companyManagementId=<%=companyManagement.getCompanyManagementId()%>"><img
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
<%@include file="AdminFooter.jsp"%>