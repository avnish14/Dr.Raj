<%@page import="DrRAJ.Bean.ProductBean"%>
<%@page import="DrRAJ.DAO.ProductDAO"%>
<%@page import="DrRAJ.Controller.ProductDeleteServlet"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product Indication</title>
<noscript>
	<div style="color: #FF0000">Please enable java script</div>
</noscript>
<script type="text/javascript" src="js/mainscript.js"></script>
</head>
<%@ include file="AdminHeader.jsp"%>
<section class="content-header">
<h1>Add Product Indication</h1>
<br>
<br>
<div class="col-lg-6">
	<div class="container" style="max-width:1000px;margin:0;">
		<form action="ProductIndicationInsertServlet" method="post">
			<div class="row">
				<div class="col-md-6">
					<label>Product Name</label> <select name="txtProductId"
						class="form-control">
						<option value="0" selected="selected">Select Product</option>
						<%
							List<ProductBean> productBeans = new ProductDAO().getList();
							for (int i = 0; i < productBeans.size(); i++) {

								String tmp = "unselected";
								String type = (String) request.getAttribute("txtProductId");
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
					<label>Indication</label>
					<textarea class="form-control" rows="5" cols="50"
						name="txtProductIndication">${txtProductIndication}</textarea>${indication}
				</div>
			</div>
			<br /> <input type="Submit" value="Add" name="submit"
				class="btn btn-success">&nbsp;&nbsp;<input type="reset"
				value="Reset" name="reset" class="btn  btn-danger">
		</form>
	</div>
</div>
<%@ include file="AdminFooter.jsp"%>