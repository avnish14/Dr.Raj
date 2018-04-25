<%@page import="DrRAJ.Bean.CityBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cities</title>
</head>
<%@include file="AdminHeader.jsp"%>
<section class="content content-header">
	<h1>Cities</h1>
	<br> <br> <a href="CityInsert.jsp"><input type="button"
		value="Add" name="Add" class="btn btn-primary"></a> <br> <br>
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-body">
					<table id="example1"
						class="table table-bordered table-hover table-striped">
						<%
							ArrayList<CityBean> list = (ArrayList<CityBean>) request.getAttribute("listOfCity");
							if (list != null && list.size() != 0) {
						%>
						<thead class="gujju-theme text-uppercase">
							<tr>
								<th>City Name</th>
								<th>Country Name</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (CityBean bean : list) {
							%>
							<tr>
								<td><%=bean.getCityName()%></td>
								<td><%=bean.getStateName()%></td>
								<td><a title="Update"
									href="CityEditServlet?cityId=<%=bean.getCityId()%>"><img
										src="imgs/edit.svg" height="30" width="30" class="img-rounded" /></a>&nbsp;
									<a title="Delete"
									href="CityDeleteServlet?cityId=<%=bean.getCityId()%>"><img
										src="imgs/delete.svg" height="30" width="30"
										class="img-rounded" /></a> <%
 	}
 %>
							</tr>
							<%
								}

								else {
							%>
							<h1>No Record Found....!</h1>
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