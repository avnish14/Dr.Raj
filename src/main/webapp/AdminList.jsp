<%@page import="DrRAJ.Bean.AdminBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admins</title>
</head>
<%@include file="AdminHeader.jsp"%>
<section class="content content-header">
<h1>Admins</h1>
<br>
<br>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-body">
				<table id="example1"
					class="table table-bordered table-hover table-striped">
					<%
						ArrayList<AdminBean> list = (ArrayList<AdminBean>) request.getAttribute("adminList");
					%>
					<thead class="gujju-theme text-uppercase">
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email Id</th>
							<!-- <th>Action</th> -->
						</tr>
					</thead>
					<tbody>
						<%
							for (AdminBean bean : list) {
						%>
						<tr>
							<td><%=bean.getFirstName()%></td>
							<td><%=bean.getLastName()%></td>
							<td><%=bean.getEmailId()%></td>
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