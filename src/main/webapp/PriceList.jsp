<%@page import="DrRAJ.Bean.PriceBean"%>
<%@page import="DrRAJ.Bean.ProductIndicationBean"%>
<%@page import="DrRAJ.Bean.ContactUsBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Prices</title>
</head>
<%@include file="AdminHeader.jsp"%>
<section class="content content-header">
	<h1>Product Prices</h1>
	<br> <br> <a href="PriceInsert.jsp"><input type="button"
		value="Add" name="Add" class="btn btn-primary"></a> <br> <br>
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-body">
					<table id="example1"
						class="table table-bordered table-hover table-striped">
						<%
							ArrayList<PriceBean> list = (ArrayList<PriceBean>) request.getAttribute("listOfPrice");
						%>

						<thead class="gujju-theme text-uppercase">
							<tr>
								<th>Product Name</th>
								<th>Package Size</th>
								<th>Package Price</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (PriceBean bean : list) {
							%>
							<tr>
								<td><%=bean.getProductName()%></td>
								<td><%=bean.getPackageSize()%></td>
								<td><%=bean.getPrice()%></td>
								<td><a
									href="PriceEditServlet?priceId=<%=bean.getPriceId()%>"><img
										src="imgs/edit.svg" height="30" width="30" class="img-rounded" /></a>&nbsp;<a
									href="PriceDeleteServlet?priceId=<%=bean.getPriceId()%>"><img
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