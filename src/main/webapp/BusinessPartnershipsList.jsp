<%@page import="DrRAJ.Bean.BusinessPartnershipsBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Us</title>
</head>
<%@include file="AdminHeader.jsp"%>
<section class="content content-header">
	<h1>Contact Us</h1>
	<br> <br>
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-body">
					<table id="example1"
						class="table table-bordered table-hover table-striped">
						<%
							ArrayList<BusinessPartnershipsBean> list = (ArrayList<BusinessPartnershipsBean>) request
									.getAttribute("businessPartnershipsList");
						%>
						<thead class="gujju-theme text-uppercase">
							<tr>
								<th>Domain</th>
								<th>Query</th>
								<th>Name of Organization</th>
								<th>Email Id</th>
								<th>Contact Number</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (BusinessPartnershipsBean bean : list) {
							%>
							<tr>
								<td><%=bean.getDomain()%></td>
								<td><%=bean.getQuery()%></td>
								<td><%=bean.getName()%></td>
								<td><%=bean.getEmailId()%></td>
								<td><%=bean.getContactNumber()%></td>
								<td><a
									href="BusinessPartnershipsDeleteServlet?businessPartnershipsId=<%=bean.getBusinessPartnershipsId()%>"><img
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
<%@include file="AdminFooter.jsp"%>