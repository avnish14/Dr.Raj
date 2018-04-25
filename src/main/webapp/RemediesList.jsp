<%@page import="DrRAJ.Bean.RemediesBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DrRAJ.Bean.TestimonialBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remedies</title>
</head>
<%@include file="AdminHeader.jsp"%>
<section class="content content-header">
	<h1>Remedies</h1>
	<br> <br> <a href="RemediesInsert.jsp"><input
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
								<th>NAME</th>
								<th>Link</th>
								<th>Forward URL</th>
								<th>ACTION</th>
							</tr>
						</thead>
						<tbody>
							<%
								List<RemediesBean> listOfRemedies = (ArrayList) request.getAttribute("listOfRemedies");

								if (listOfRemedies != null) {
									for (int i = 0; i < listOfRemedies.size(); i++) {
										RemediesBean remediesBean = listOfRemedies.get(i);
							%>
							<tr>
								<td><%=remediesBean.getName()%></td>
								<td><img src="<%=remediesBean.getPhotolink()%>" height="75" /></td>
								<td><%=remediesBean.getForwardLink()%></td>
								<td><a
									href="RemediesEditServlet?remediesId=<%=remediesBean.getRemediesId()%>"><img
										src="imgs/edit.svg" height="30" width="30" class="img-rounded" /></a>&nbsp;<a
									href="RemediesDeleteServlet?remediesId=<%=remediesBean.getRemediesId()%>"><img
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