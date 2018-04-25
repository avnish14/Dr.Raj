<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product Category</title>
<noscript>
	<div style="color: #FF0000">Please enable java script</div>
</noscript>
<script type="text/javascript" src="js/mainscript.js"></script>
</head>
<%@ include file="AdminHeader.jsp"%>
<section class="content-header">
<h1>Add Product Category</h1>
<br>
<br>
<div class="container" style="max-width: 1000px; margin: 0;">
	<form action="ProductCategoryInsertServlet" method="post">
		<div class="row">
			<div class="col-md-6">
				<label>Category Name</label> <input type="text" class="form-control"
					value="${txtProductCategoryName}" name="txtProductCategoryName" />${productCategoryName}
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-6">
				<label>Category URL for SEO</label> <input type="text"
					class="form-control" value="${txtProductCategoryURL}"
					name="txtProductCategoryURL" />${productCategoryURL}
			</div>
		</div>
		<br /> <input type="Submit" value="Add" name="submit"
			class="btn btn-success">&nbsp;&nbsp;<input type="reset"
			value="Reset" name="reset" class="btn  btn-danger">
		<h1>
			<br> <br> <br> <br> <br> <br> <br>
			<br>
		</h1>
	</form>
</div>
</section>