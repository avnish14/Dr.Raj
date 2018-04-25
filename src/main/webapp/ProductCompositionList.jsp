<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DrRAJ.Bean.ProductCompositionBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Composition</title>
</head>
<%@include file="AdminHeader.jsp"%>
<section class="content content-header">
	<h1>Product Composition</h1>
	<br> <br> <a href="ProductCompositionInsert.jsp"><input
		type="button" value="Add" name="Add" class="btn btn-primary"></a>
	<br><br>
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-body">
					<table id="example1"
						class="table table-bordered table-hover table-striped">
						<thead class="gujju-theme text-uppercase">
							<tr>
								<th>Product Name</th>
								<th>Ingredients Name</th>
								<th>Content</th>
								<th>ACTION</th>
							</tr>
						</thead>
						<tbody>
							<%
								List<ProductCompositionBean> listOfProductComposition = (ArrayList) request
										.getAttribute("listOfProductComposition");

								if (listOfProductComposition != null) {
									for (int i = 0; i < listOfProductComposition.size(); i++) {
										ProductCompositionBean productComposition = listOfProductComposition.get(i);
							%>
							<tr>
								<td><%=productComposition.getProductName()%></td>
								<td><%=productComposition.getIngredientsName()%></td>
								<td><%=productComposition.getCompositionContent()%></td>
								<td><a
									href="ProductCompositionEditServlet?productCompositionId=<%=productComposition.getProductCompositionId()%>"><img
										src="imgs/edit.svg" height="30" width="30" class="img-rounded" /></a>&nbsp;<a
									href="ProductCompositionDeleteServlet?productCompositionId=<%=productComposition.getProductCompositionId()%>"><img
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