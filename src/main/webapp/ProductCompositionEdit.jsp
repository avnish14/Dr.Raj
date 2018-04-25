<%@page import="DrRAJ.DAO.IngredientDAO"%>
<%@page import="DrRAJ.Bean.IngredientBean"%>
<%@page import="DrRAJ.Bean.ProductCompositionBean"%>
<%@page import="DrRAJ.DAO.ProductDAO"%>
<%@page import="DrRAJ.Bean.ProductBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Product Composition</title>
<noscript>
	<div style="color: #FF0000">Please enable java script</div>
</noscript>
<script type="text/javascript" src="js/mainscript.js"></script>
</head>
<%@ include file="AdminHeader.jsp"%>
<section class="content-header">
	<h1>Edit Product Composition</h1>
	<br> <br>
	<div class="container" style="max-width: 1000px; margin: 0;">
		<form action="ProductCompositionUpdateServlet" method="post">
			<%
				ProductCompositionBean productCompositionBean = (ProductCompositionBean) request
						.getAttribute("productCompositionBean");

				if (productCompositionBean != null) {
			%>
			<input type="hidden" name="productCompositionId"
				value="<%=productCompositionBean.getProductCompositionId()%>">
			<div class="row">
				<div class="col-md-6">
					<label>Product Name</label> <select name="selProductName"
						class="form-control">
						<option value="0" selected="selected">Select Remedies</option>
						<%
							List<ProductBean> productList = new ProductDAO().getList();
								for (int i = 0; i < productList.size(); i++) {
									ProductBean productBean = productList.get(i);
									if (productBean.getProductId().equals(productCompositionBean.getProductId())) {
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
			<br />
			<div class="row">
				<div class="col-md-6">
					<label>Ingridient</label> <select name="selIngredientName"
						class="form-control">
						<option value="0" selected="selected">Select Remedies</option>
						<%
							List<IngredientBean> ingredientList = new IngredientDAO().select();
								for (int i = 0; i < ingredientList.size(); i++) {
									IngredientBean ingredientBean = ingredientList.get(i);
									if (ingredientBean.getIngredientsId().equals(productCompositionBean.getIngredientsId())) {
						%>
						<option value="<%=ingredientBean.getIngredientsId()%>"
							selected="selected"><%=ingredientBean.getTitle()%></option>
						<%
							} else {
						%>
						<option value="<%=ingredientBean.getIngredientsId()%>"><%=ingredientBean.getTitle()%></option>
						<%
							}
								}
						%>
					</select><font color="red">${ingredients}</font>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-md-6">
					<label>Content</label> <input class="form-control"
						name="txtContent"
						value="<%=productCompositionBean.getCompositionContent()%>" />${content}
				</div>
			</div>
			<br /> <input type="Submit" value="Update" name="submit"
				class="btn btn-success">&nbsp;&nbsp; <input type="reset"
				value="Reset" name="reset" class="btn  btn-danger">
		</form>
		<%
			} else {

			}
		%>
	</div>
</section>
<%@ include file="AdminFooter.jsp"%>