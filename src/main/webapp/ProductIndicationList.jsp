<%@page import="DrRAJ.Bean.ProductIndicationBean"%>
<%@page import="DrRAJ.Bean.ContactUsBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Indication</title>
</head>
<%@include file="AdminHeader.jsp"%>
<section class="content content-header">
<h1>Product Indication</h1>
<br>
<br>
<a href="ProductIndicationInsert.jsp"><input type="button"
	value="Add" name="Add" class="btn btn-primary"></a> <br>
<br>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-body">
				<table id="example1"
					class="table table-bordered table-hover table-striped">
					<%
						ArrayList<ProductIndicationBean> list = (ArrayList<ProductIndicationBean>) request
								.getAttribute("listOfProductIndication");
					%>

					<thead class="gujju-theme text-uppercase">
						<tr>
							<th>Product Name</th>
							<th>Indication</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (ProductIndicationBean bean : list) {
						%>
						<tr>
							<td><%=bean.getProductName()%></td>
							<td><%=bean.getIndication()%></td>
							<td><a
								href="ProductIndicationEditServlet?productIndicationId=<%=bean.getProductIndicationId()%>"><img
									src="imgs/edit.svg" height="30" width="30" class="img-rounded" /></a>&nbsp;<a
								href="ProductIndicationDeleteServlet?productIndicationId=<%=bean.getProductIndicationId()%>"><img
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