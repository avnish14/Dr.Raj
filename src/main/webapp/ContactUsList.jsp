<%@page import="DrRAJ.Bean.ContactUsBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homoeopathic Advice</title>
</head>
<%@include file="AdminHeader.jsp"%>
<section class="content content-header">
	<h1>Homoeopathic Advice</h1>
	<br> <br>
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-body">
					<table id="example1"
						class="table table-bordered table-hover table-striped">
						<%
							ArrayList<ContactUsBean> list = (ArrayList<ContactUsBean>) request.getAttribute("contactUsList");
						%>
						<thead class="gujju-theme text-uppercase">
							<tr>
								<th>Name</th>
								<th>Email Id</th>
								<th>Query</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (ContactUsBean bean : list) {
							%>
							<tr>
								<td><%=bean.getName()%></td>
								<td><%=bean.getEmailId()%></td>
								<td><%=bean.getQuery()%></td>
								<td><a
									href="ContactUsDeleteServlet?contactUsId=<%=bean.getContactUsId()%>"><img
										src="imgs/delete.svg" height="30" width="30"
										class="img-rounded" /></a></td>
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