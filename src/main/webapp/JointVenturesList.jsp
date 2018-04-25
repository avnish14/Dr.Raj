<%@page import="DrRAJ.Bean.JointVenturesBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Joint Ventures</title>
</head>
<%@include file="AdminHeader.jsp"%>
<section class="content content-header">
<h1>Joint Ventures</h1>
<br>
<br>
<a href="JointVenturesInsert.jsp"><input type="button" value="ADD"
	-	name="ADD" class="btn btn-primary"></a> <br>
<br>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-body">
				<table id="example1"
					class="table table-bordered table-hover table-striped">
					<%
						ArrayList<JointVenturesBean> list = (ArrayList<JointVenturesBean>) request.getAttribute("jointVenturesList");
					%>
					<thead class="gujju-theme text-uppercase">
						<tr>
							<th>Name</th>
							<th>Image</th>
							<th>Forward URL</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (JointVenturesBean bean : list) {
						%>
						<tr>
							<td><%=bean.getName()%></td>
							<td><img src="<%=bean.getImageLink()%>"
								style="max-height: 100px;"></td>
							<td><%=bean.getForwardLink()%></td>
							<td><a href="JointVenturesEditServlet?id=<%=bean.getId()%>"><img
									src="imgs/edit.svg" height="30" width="30" class="img-rounded" /></a>&nbsp;<a
								href="JointVenturesDeleteServlet?id=<%=bean.getId()%>"><img
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