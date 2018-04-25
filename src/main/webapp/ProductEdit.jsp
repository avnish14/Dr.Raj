<%@page import="DrRAJ.Bean.ProductBean"%>
<%@page import="DrRAJ.DAO.ProductCategoryDAO"%>
<%@page import="DrRAJ.Bean.ProductCategoryBean"%>
<%@page import="DrRAJ.DAO.RemediesDAO"%>
<%@page import="DrRAJ.Bean.RemediesBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Product</title>
<noscript>
	<div style="color: #FF0000">Please enable java script</div>
</noscript>
<script type="text/javascript" src="js/mainscript.js"></script>
</head>
<%@ include file="AdminHeader.jsp"%>
<section class="content-header">
	<h1>Edit Product</h1>
	<br>
	<div class="container" style="max-width: 1000px; margin: 0;">
		<form action="ProductUpdateServlet" method="post">
			<%
				ProductBean productBean = (ProductBean) request.getAttribute("productBean");

				if (productBean != null) {
			%>
			<input type="hidden" name="productId"
				value="<%=productBean.getProductId()%>" />
			<div class="row">
				<div class="col-md-6">
					<label>Name</label> <input type="text" class="form-control"
						value="<%=productBean.getProductName()%>" name="txtProductName" />${name}
				</div>
				<div class="col-md-4">
					<label>Image Link</label> <input class="form-control" type="text"
						value="<%=productBean.getImageLink()%>" name="txtPhotoLink" />${photoLink}
				</div>
				<div class="col-md-2">
					<img src="<%=productBean.getImageLink()%>" alt="Image not found"
						class="imagetarget" style="max-height: 200px; max-width: 200px;" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label>Online Link</label> <input class="form-control" type="text"
						value="<%=productBean.getForwardLink()%>" name="txtForwardLink" />${forwardLink}
				</div>
				<div class="col-md-6">
					<label>Interaction</label> <input class="form-control" type="text"
						value="<%=productBean.getInteraction()%>}" name="txtInteraction" />${interaction}
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label>Side Effects</label> <input class="form-control" type="text"
						value="<%=productBean.getSideEffect()%>" name="txtSideEffect" />${sideEffect}
				</div>
				<div class="col-md-6">
					<label>Contra-Indication</label> <input class="form-control"
						type="text" value="<%=productBean.getContraIndication()%>"
						name="txtContraIndication" />${contraIndication}
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label>Product URL for SEO</label> <input class="form-control"
						type="text" value="<%=productBean.getProductURL()%>"
						name="txtProductURL" />${productURL}
				</div>
				<div class="col-md-6">
					<label>Purpose / Ailment</label> <input class="form-control"
						type="text" value="<%=productBean.getPurpose()%>"
						name="txtPurpose" />${purpose}
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label>Description</label>
					<textarea class="form-control" rows="4" name="txtDescription"><%=productBean.getDescription()%></textarea>${description}
				</div>
				<div class="col-md-6">
					<label>Remedy of Product</label> <select name="selRemedies"
						id="selRemedies" class="form-control">
						<option value="0" selected="selected">Select Remedies</option>
						<%
							List<RemediesBean> remediesList = new RemediesDAO().getList();
								for (int i = 0; i < remediesList.size(); i++) {
									RemediesBean remedyBean = remediesList.get(i);
									if (remedyBean.getRemediesId().equals(productBean.getRemediesId())) {
						%>
						<option value="<%=remedyBean.getRemediesId()%>"
							selected="selected"><%=remedyBean.getName()%></option>
						<%
							} else {
						%>
						<option value="<%=remedyBean.getRemediesId()%>"><%=remedyBean.getName()%></option>
						<%
							}
								}
						%>
					</select><font color="red">${remedies}</font> <label>Category of
						Product</label> <select name="selProductCategoryName" class="form-control">
						<option value="0" selected="selected">Select Remedies</option>
						<%
							List<ProductCategoryBean> productCategoryList = new ProductCategoryDAO().getList();
								for (int i = 0; i < productCategoryList.size(); i++) {
									ProductCategoryBean productCategoryBean = productCategoryList.get(i);
									if (productCategoryBean.getProductCategoryId().equals(productBean.getProductCategoryId())) {
						%>
						<option value="<%=productCategoryBean.getProductCategoryId()%>"
							selected="selected"><%=productCategoryBean.getProductCategoryName()%></option>
						<%
							} else {
						%>
						<option value="<%=productCategoryBean.getProductCategoryId()%>"><%=productCategoryBean.getProductCategoryName()%></option>
						<%
							}
								}
						%>
					</select><font color="red">${productCateogory}</font>
				</div>
			</div>
			<br>
			<input type="Submit" value="Update" name="submit"
				class="btn btn-success">&nbsp;&nbsp;<input type="reset" value="Reset"
				name="reset" class="btn btn-danger">
		</form>
		<%
			} else {

			}
		%>
	</div>
</section>
<%@ include file="AdminFooter.jsp"%>
<script type="text/javascript">
	$("body").on("change leave input", ".imagetester", function() {
		var target = $($(this).attr("target"));
		target.attr("src", $(this).val());
	});
	var link = $(".imagetester").val();
	if (link != "") {
		$(".imagetarget").attr("src", link);
	}
</script>
</body>
</html>