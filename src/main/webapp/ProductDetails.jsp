<%@page import="DrRAJ.Bean.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		ProductBean bean = (ProductBean) request.getAttribute("product");
		if (bean != null) {
			int a = Integer.parseInt(bean.getCnt());
	%>

	<h3>Product Name</h3><%=bean.getProductName()%><h2></h2>
	<h3>Product Interaction</h3><%=bean.getInteraction()%><h2></h2>
	<h3>Product Category</h3><%=bean.getProductCategoryName()%><h2></h2>
	<h3>Product Description</h3><%=bean.getDescription()%><h2></h2>
	<h3>Product Purpose</h3><%=bean.getPurpose()%><h2></h2>
	<h3>Product Purpose</h3><%=++a%><h2></h2>
	<%
		} else {
	%>
	<h3>No Product Details</h3>
	<%
		}
	%>
</body>
</html>