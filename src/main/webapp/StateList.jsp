<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DrRAJ.Bean.StateBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>States</title>
</head>
<%@include file="AdminHeader.jsp"%>
<section class="content content-header">
	<h1>States</h1>
	<br> <br> <a href="StateInsert.jsp"><input type="button"
		value="Add" name="Add" class="btn btn-primary"></a> <br> <br>
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-body">
					<table id="example1"
						class="table table-bordered table-hover table-striped">
						<thead class="gujju-theme text-uppercase">
							<tr>
								<th>NAME</th>
								<th>ACTION</th>
							</tr>
						</thead>
						<tbody>
							<%
								List<StateBean> listOfState = (ArrayList) request.getAttribute("listOfState");

								if (listOfState != null) {
									for (int i = 0; i < listOfState.size(); i++) {
										StateBean state = listOfState.get(i);
							%>
							<tr>
								<td><%=state.getStateName()%></td>
								<td><a
									href="StateEditServlet?stateId=<%=state.getStateId()%>"><img
										src="imgs/edit.svg" height="30" width="30" class="img-rounded" /></a>&nbsp;
									<a href="StateDeleteServlet?stateId=<%=state.getStateId()%>"><img
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