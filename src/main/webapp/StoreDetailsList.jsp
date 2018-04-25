<%@page import="DrRAJ.Bean.StoreDetailsBean"%>
<%@page import="DrRAJ.Bean.PressInfoBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DrRAJ.Bean.PressInfoTypeBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stores</title>
</head>
<%@include file="AdminHeader.jsp"%>
<section class="content content-header">
<h1>
	Store Details <small>List</small>
</h1>
<br>
<a href="StoreDetailsInsert.jsp" name="Add" class="btn btn-primary">Add</a>
<br>
<br>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-body">
				<table id="example1"
					class="table table-bordered table-hover table-striped">
					<%
						List<StoreDetailsBean> listOfStores = (ArrayList) request.getAttribute("listOfStores");
					%>
					<thead class="gujju-theme text-uppercase">
						<tr>
							<th>City-State</th>
							<th>NAME</th>
							<th>Address</th>
							<th>Contact Number</th>
							<th>ACTION</th>
						</tr>
					</thead>
					<tbody>
						<%
							if (listOfStores != null) {
								for (int i = 0; i < listOfStores.size(); i++) {
									StoreDetailsBean pressInfo = listOfStores.get(i);
						%>
						<tr>
							<td><%=pressInfo.getCityname() + "-" + pressInfo.getStatename()%></td>
							<td><%=pressInfo.getName()%></td>
							<td><%=pressInfo.getAddress()%></td>
							<td><%=pressInfo.getContact1() + " , " + pressInfo.getContact2()%></td>
							<td><a
								href="StoreDetailsEditServlet?storeId=<%=pressInfo.getStoreId()%>"><img
									src="imgs/edit.svg" height="30" width="30" class="img-rounded" /></a>&nbsp;<a
								href="StoreDetailsDeleteServlet?storeId=<%=pressInfo.getStoreId()%>"><img
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