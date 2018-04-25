
<%@page import="DrRAJ.Bean.ProductCategoryBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Product Category</title>
<noscript>
	<div style="color: #FF0000">Please enable java script</div>
</noscript>
<script type="text/javascript" src="js/mainscript.js"></script>
<link rel="icon" href="imgs/daiict.png" />
</head>
<%@ include file="AdminHeader.jsp"%>
<section class="content-header">
<h1>Edit Product Category</h1>
<br>
<br>
<div class="container" style="max-width: 1000px; margin: 0;">
	<form action="ProductCategoryUpdateServlet" method="post">
		<%
			ProductCategoryBean productCategoryBean = (ProductCategoryBean) request.getAttribute("productCategoryBean");

			if (productCategoryBean != null) {
		%>
		<input type="hidden" name="productCategoryId"
			value=<%=productCategoryBean.getProductCategoryId()%>>
		<div class="row">
			<div class="col-md-6">
				<label>Category Name</label> <input type="text" class="form-control"
					value="<%=productCategoryBean.getProductCategoryName()%>"
					name="txtProductCategoryName" />${productCategoryName}
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-6">
				<label>Category URL for SEO</label> <input type="text"
					class="form-control"
					value="<%=productCategoryBean.getForwardLink()%>"
					name="txtProductCategoryURL" />${productCategoryURL}
			</div>
		</div>
		<br /> <input type="Submit" value="Update" name="submit"
			class="btn btn-success">&nbsp;&nbsp;<input type="reset"
			value="Reset" name="reset" class="btn  btn-danger">
		<h1>
			<br> <br> <br> <br> <br> <br> <br>
			<br>
		</h1>
	</form>
	<%
		} else {

		}
	%>
</div>
</section>
<%@ include file="AdminFooter.jsp"%>
