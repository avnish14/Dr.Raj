<%@page import="DrRAJ.Bean.PriceBean"%>
<%@page import="DrRAJ.Bean.ProductBean"%>
<%@page import="DrRAJ.DAO.ProductDAO"%>
<%@page import="DrRAJ.Controller.ProductDeleteServlet"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Product Price</title>
<noscript>
	<div style="color: #FF0000">Please enable java script</div>
</noscript>
<script type="text/javascript" src="js/mainscript.js"></script>
</head>
<%@ include file="AdminHeader.jsp"%>
<section class="content-header">
	<h1>Edit Product Price</h1>
	<br> <br>
	<div class="container" style="margin: 0; max-width: 1000px;">
		<form action="PriceUpdateServlet" method="post">
			<%
				PriceBean bean = (PriceBean) request.getAttribute("priceBean");

				if (bean != null) {
			%>
			<input type="hidden" name="priceId" value="<%=bean.getPriceId()%>">
			<div class="row">
				<div class="col-md-6">
					<label>Product Name</label> <select name="txtProductId"
						class="form-control">
						<option value="0" selected="selected">Select Product</option>
						<%
							List<ProductBean> productBeans = new ProductDAO().getList();
								for (int i = 0; i < productBeans.size(); i++) {

									String tmp = "unselected";
									String type = (String) bean.getProductId();
									if (type == null || type.equals("0"))
										tmp = "unselected";
									else if (productBeans.get(i).getProductId().equals(type))
										tmp = "selected";
						%>
						<option value=<%=productBeans.get(i).getProductId()%> <%=tmp%>>
							<%=productBeans.get(i).getProductName()%></option>
						<%
							}
						%>
					</select><font color="red">${product}</font>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-md-6">
					<label>Package Size</label> <input type="text" class="form-control"
						value="<%=bean.getPackageSize()%>" name="txtPackageSize" />${packageName}
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-md-6">
					<label>Package Price</label> <input type="text"
						class="form-control" value="<%=bean.getPrice()%>"
						name="txtPackagePrice" />${price}
				</div>
			</div>
			<br /> <input type="Submit" value="Update" name="submit"
				class="btn btn-success"> <input type="reset" value="Reset"
				name="reset" class="btn  btn-danger">
		</form>
		<%
			} else {

			}
		%>
	</div>
</section>
<%@ include file="AdminFooter.jsp"%>