<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DrRAJ.Bean.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<%@include file="AdminHeader.jsp"%>
<section class="content content-header">
<h1>Products</h1>
<br>
<a href="ProductInsert.jsp"><input type="button" value="Add"
	name="Add" class="btn btn-primary"></a> <br>
<br>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-body">
				<table id="example1"
					class="table table-bordered table-hover table-striped">
					<thead class="gujju-theme text-uppercase">
						<tr>
							<th>Product Name</th>
							<th>Remedy Name</th>
							<th>ACTION</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<ProductBean> listOfProduct = (ArrayList) request.getAttribute("listOfProduct");

							if (listOfProduct != null) {
								for (int i = 0; i < listOfProduct.size(); i++) {
									ProductBean product = listOfProduct.get(i);
						%>
						<tr>
							<td><%=product.getProductName()%></td>
							<td><%=product.getRemediesName()%></td>
							<td><a href="<%=product.getProductURL()%>" target="_blank"><img
									src="imgs/eye.svg" height="30" width="30" class="img-rounded" /></a>&nbsp;
								<a href="ProductEditServlet?productId=<%=product.getProductId()%>"><img
									src="imgs/edit.svg" height="30" width="30"
									class="img-rounded" /></a>&nbsp;<a
								href="ProductDeleteServlet?productId=<%=product.getProductId()%>"><img
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