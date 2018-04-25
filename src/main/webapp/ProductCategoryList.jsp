<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DrRAJ.Bean.ProductCategoryBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Categories</title>
<%@include file="AdminHeader.jsp"%>
<section class="content content-header">
<h1>Product Category</h1>
<br>
<a href="ProductCategoryInsert.jsp"><input type="button" value="Add"
	name="Add" class="btn btn-primary"></a> <br>
<br>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-body">
				<table id="example1"
					class="table table-bordered table-hover table-striped">
					<%
						List<ProductCategoryBean> listOfProductCategory = (ArrayList) request.getAttribute("listOfProductCategory");
					%>
					<thead class="gujju-theme text-uppercase">
						<tr>
							<th>NAME</th>
							<th>URL</th>
							<th>ACTION</th>
						</tr>
					</thead>
					<tbody>
						<%
							if (listOfProductCategory != null) {
								for (int i = 0; i < listOfProductCategory.size(); i++) {
									ProductCategoryBean productCategory = listOfProductCategory.get(i);
						%>
						<tr>
							<td><%=productCategory.getProductCategoryName()%></td>
							<td><%=productCategory.getForwardLink()%></td>
							<td><a
								href="ProductCategoryEditServlet?productCategoryId=<%=productCategory.getProductCategoryId()%>"><img
									src="imgs/edit.svg" height="30" width="30" class="img-rounded" /></a>&nbsp;<a
								href="ProductCategoryDeleteServlet?productCategoryId=<%=productCategory.getProductCategoryId()%>"><img
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