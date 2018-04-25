<%@page import="DrRAJ.Bean.ProductKeywordBean"%>
<%@page import="DrRAJ.Bean.ProductBean"%>
<%@page import="DrRAJ.Bean.IngredientBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Keywords</title>
</head>
<%@include file="AdminHeader.jsp"%>
<section class="content content-header">
<h1>
	Product Keyword<small>List</small>
</h1>
<br>
<br>
<a href="ProductKeywordInsert.jsp" name="Add" class="btn btn-primary">Add</a>
<br>
<br>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-body">
				<table id="example1"
					class="table table-bordered table-hover table-striped">

					<%
						ArrayList<ProductKeywordBean> list = (ArrayList<ProductKeywordBean>) request
								.getAttribute("listOfProductKeyword");
					%>
					<thead class="gujju-theme text-uppercase">
						<tr>
							<th>Keyword</th>
							<th>Product Name</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (ProductKeywordBean bean : list) {
						%>
						<tr>
							<td><%=bean.getKeyword()%></td>
							<td><%=bean.getProductName()%></td>
							<td><a
								href="ProductKeywordEditServlet?productKeywordId=<%=bean.getProductKeywordId()%>"><img
									src="imgs/edit.svg" height="30" width="30" class="img-rounded" /></a>&nbsp;
								<a
								href="ProductKeywordDeleteServlet?productKeywordId=<%=bean.getProductKeywordId()%>"><img
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