<%@page import="DrRAJ.Bean.ProductKeywordBean"%>
<%@page import="DrRAJ.DAO.ProductDAO"%>
<%@page import="DrRAJ.Bean.ProductBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Product Keyword</title>
<noscript>
	<div style="color: #FF0000">Please enable java script</div>
</noscript>
<script type="text/javascript" src="js/mainscript.js"></script>
</head>
<%@ include file="AdminHeader.jsp"%>
<section class="content-header">
<h1>Edit Product Keyword</h1>
<br>
<br>
<div class="container" style="margin: 0; max-width: 1000px;">
	<%
		ProductKeywordBean bean = (ProductKeywordBean) request.getAttribute("productKeywordBean");
		if (bean != null) {
	%>
	<form action="ProductKeywordUpdateServlet" method="post">
		<input type="hidden" name="productKeywordId"
			value="<%=bean.getProductKeywordId()%>">
		<div class="row">
			<div class="col-md-6">
				<label>Product Name</label> <select name="productId"
					class="form-control" id="productId">
					<option value="0">Select Product</option>
					<%
						List<ProductBean> listOfProduct = new ProductDAO().getList();

							if (listOfProduct != null) {
								for (ProductBean t : listOfProduct) {
									String s = t.getProductName();
									if (t.getProductId().equals(bean.getProductId())) {
					%>
					<option value="<%=t.getProductId()%>" selected="selected"><%=s%></option>
					<%
						} else {
										System.out.println("h " + bean.getProductId());
					%>
					<option value="<%=t.getProductId()%>"><%=s%></option>
					<%
						}
								}
							}
					%>
				</select> <font color="red">${product}</font>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-6">
				<label>Keyword</label> <input type="text" class="form-control"
					value="<%=bean.getKeyword()%>" name="txtKeyword" />${keyWord}
			</div>
		</div>
		<br /> <input type="Submit" value="Update" name="submit"
			class="btn btn-success">&nbsp;&nbsp; <input type="reset"
			value="Reset" name="reset" class="btn  btn-danger">
	</form>
	<%
		} else {
			System.out.print("hello");

		}
	%>
</div>
</section>
<%@ include file="AdminFooter.jsp"%>