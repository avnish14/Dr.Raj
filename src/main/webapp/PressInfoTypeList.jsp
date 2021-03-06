<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DrRAJ.Bean.PressInfoTypeBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Press Info Type</title>
</head>
<%@include file="AdminHeader.jsp"%>
<section class="content content-header">
	<h1>Press Info Type</h1>
	<br> <br> <a href="PressInfoTypeInsert.jsp" name="Add"
		class="btn btn-primary">Add</a> <br> <br>
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-body">
					<table id="example1"
						class="table table-bordered table-hover table-striped">
						<%
							List<PressInfoTypeBean> listOfPressInfoType = (ArrayList) request.getAttribute("listOfPressInfoType");
						%>
						<thead class="gujju-theme text-uppercase">
							<tr>
								<th>NAME</th>
								<th>ACTION</th>
							</tr>
						</thead>
						<tbody>
							<%
								if (listOfPressInfoType != null) {
									for (int i = 0; i < listOfPressInfoType.size(); i++) {
										PressInfoTypeBean pressInfoType = listOfPressInfoType.get(i);
							%>
							<tr>
								<td><%=pressInfoType.getName()%></td>
								<td><a
									href="PressInfoTypeEditServlet?pressInfoTypeId=<%=pressInfoType.getTypeId()%>"><img
										src="imgs/edit.svg" height="30" width="30" class="img-rounded" /></a>&nbsp;<a
									href="PressInfoTypeDeleteServlet?pressInfoTypeId=<%=pressInfoType.getTypeId()%>"><img
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