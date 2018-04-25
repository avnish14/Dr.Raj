<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DrRAJ.Bean.ProductDosageBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Dosage</title>
</head>
<%@include file="AdminHeader.jsp"%>
<section class="content content-header">
<h1>Product Dosage</h1>
<br>
<br>
<a href="ProductDosageInsert.jsp"><input type="button" value="Add"
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
							<th>Content</th>
							<th>ACTION</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<ProductDosageBean> listOfProductDosage = (ArrayList) request.getAttribute("listOfProductDosage");

							if (listOfProductDosage != null) {
								for (int i = 0; i < listOfProductDosage.size(); i++) {
									ProductDosageBean productDosage = listOfProductDosage.get(i);
						%>
						<tr>
							<td><%=productDosage.getProductName()%></td>
							<td><%=productDosage.getContent()%></td>
							<td><a
								href="ProductDosageEditServlet?productDosageId=<%=productDosage.getProductDosageId()%>"><img
									src="imgs/edit.svg" height="30" width="30" class="img-rounded" /></a>&nbsp;<a
								href="ProductDosageDeleteServlet?productDosageId=<%=productDosage.getProductDosageId()%>"><img
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