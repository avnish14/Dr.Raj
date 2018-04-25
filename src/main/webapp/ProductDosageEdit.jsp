<%@page import="DrRAJ.Bean.ProductDosageBean"%>
<%@page import="DrRAJ.DAO.ProductDAO"%>
<%@page import="DrRAJ.Bean.ProductBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Product Dosage</title>
<noscript>
	<div style="color: #FF0000">Please enable java script</div>
</noscript>
<script type="text/javascript" src="js/mainscript.js"></script>
</head>
<%@ include file="AdminHeader.jsp"%>
<section class="content-header">
<h1>Edit Product Dosage</h1>
<br>
<br>
<div class="col-lg-6">
	<div class="container" style="max-width: 1000px; margin: 0;">
		<form action="ProductDosageUpdateServlet" method="post">
			<%
				ProductDosageBean productDosageBean = (ProductDosageBean) request.getAttribute("productDosageBean");

				if (productDosageBean != null) {
			%>
			<input type="hidden" name="productDosageId"
				value="<%=productDosageBean.getProductDosageId()%>">
			<div class="row">
				<div class="col-md-6">
					<label>Product Name</label> <select name="selProductName"
						class="form-control">
						<option value="0" selected="selected">Select Product Name</option>
						<%
							List<ProductBean> productList = new ProductDAO().getList();
								for (int i = 0; i < productList.size(); i++) {
									ProductBean productBean = productList.get(i);
									if (productBean.getProductId().equals(productDosageBean.getProductId())) {
						%>
						<option value="<%=productBean.getProductId()%>"
							selected="selected"><%=productBean.getProductName()%></option>
						<%
							} else {
						%>
						<option value="<%=productBean.getProductId()%>"><%=productBean.getProductName()%></option>
						<%
							}
								}
						%>
					</select><font color="red">${product}</font>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-6">
					<label>Content</label>
					<textarea class="form-control" rows="5" cols="50" name="txtContent"><%=productDosageBean.getContent()%></textarea>${content}
				</div>
			</div>
			<br /> <input type="Submit" value="Update" name="submit"
				class="btn btn-success"> &nbsp;&nbsp; <input type="reset"
				value="Reset" name="reset" class="btn  btn-danger">
		</form>
		<%
			} else {

			}
		%>
	</div>
</div>
<%@ include file="AdminFooter.jsp"%>