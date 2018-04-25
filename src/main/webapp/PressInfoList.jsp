<%@page import="DrRAJ.Bean.PressInfoBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DrRAJ.Bean.PressInfoTypeBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Press Info</title>
</head>
<%@include file="AdminHeader.jsp"%>
<section class="content content-header">
	<h1>Press Info</h1>
	<br> <br> <a href="PressInfoInsert.jsp" name="Add"
		class="btn btn-primary">Add</a> <br> <br>
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-body">
					<table id="example1"
						class="table table-bordered table-hover table-striped">
						<%
							List<PressInfoBean> listOfPressInfo = (ArrayList) request.getAttribute("listOfPressInfo");
						%>
						<thead class="gujju-theme text-uppercase">
							<tr>
								<th>Title</th>
								<th>NAME</th>
								<th>Link</th>
								<th>ACTION</th>
							</tr>
						</thead>
						<tbody>
							<%
								if (listOfPressInfo != null) {
									for (int i = 0; i < listOfPressInfo.size(); i++) {
										PressInfoBean pressInfo = listOfPressInfo.get(i);
							%>
							<tr>
								<td><%=pressInfo.getTitle()%></td>
								<td><%=pressInfo.getPressTypeName()%></td>
								<td><%=pressInfo.getLink()%></td>
								<td><a
									href="PressInfoEditServlet?pressInfoId=<%=pressInfo.getPressInfoId()%>"><img
										src="imgs/edit.svg" height="30" width="30" class="img-rounded" /></a>&nbsp;&nbsp;<a
									href="PressInfoDeleteServlet?pressInfoId=<%=pressInfo.getPressInfoId()%>"><img
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