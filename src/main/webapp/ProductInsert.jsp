<%@page import="DrRAJ.DAO.ProductCategoryDAO"%>
<%@page import="DrRAJ.Bean.ProductCategoryBean"%>
<%@page import="DrRAJ.DAO.RemediesDAO"%>
<%@page import="DrRAJ.Bean.RemediesBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
<noscript>
	<div style="color: #FF0000">Please enable java script</div>
</noscript>
<script type="text/javascript" src="js/mainscript.js"></script>
<%@ include file="AdminHeader.jsp"%>
<section class="content-header">
	<h1>Add Product</h1>
	<br>
	<div class="container" style="max-width: 1000px; margin: 0;">
		<form action="ProductInsertServlet" method="post">
			<div class="row">
				<div class="col-md-6">
					<label>Name</label> <input type="text" class="form-control"
						value="${txtProductName}" name="txtProductName" />${name}
				</div>
				<div class="col-md-4">
					<label>Image Link</label> <input class="form-control imagetester"
						type="text" value="${txtPhotoLink}" name="txtPhotoLink"
						target=".imagetarget" />${photoLink}
				</div>
				<div class="col-md-2">
					<img src="" alt="Image not found" class="imagetarget"
						style="max-height: 200px; max-width: 200px;" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label>Online Link</label> <input class="form-control" type="text"
						value="${txtForwardLink}" name="txtForwardLink" />${forwardLink}
				</div>
				<div class="col-md-6">
					<label>Interaction</label> <input class="form-control" type="text"
						value="${txtInteraction}" name="txtInteraction" />${interaction}
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label>Side Effects</label> <input class="form-control" type="text"
						value="${txtSideEffect}" name="txtSideEffect" />${sideEffect}
				</div>
				<div class="col-md-6">
					<label>Contra-Indication</label> <input class="form-control"
						type="text" value="${txtContraIndication}"
						name="txtContraIndication" />${contraIndication}
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label>Product URL for SEO</label> <input class="form-control"
						type="text" value="${txtProductURL}" name="txtProductURL"
						placeholder="e.g. memoriup-brain-tonic" />${productURL}
				</div>
				<div class="col-md-6">
					<label>Purpose / Ailment</label> <input class="form-control"
						type="text" value="${txtPurpose}" name="txtPurpose" />${purpose}
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label>Description</label>
					<textarea class="form-control" rows="4" name="txtDescription">${txtDescription}</textarea>${description}
				</div>
				<div class="col-md-6">
					<label>Remedy of Product</label> <select name="selRemedies"
						class="form-control">
						<option value="0" selected="selected">Select Remedies</option>
						<%
							List<RemediesBean> remediesList = new RemediesDAO().getList();
							for (int i = 0; i < remediesList.size(); i++) {

								String tmp = "unselected";
								String type = request.getParameter("selRemedies");
								if (type == null || type.equals("0"))
									tmp = "unselected";
								else if (remediesList.get(i).getRemediesId().equals(type))
									tmp = "selected";
						%>

						<option value=<%=remediesList.get(i).getRemediesId()%> <%=tmp%>>
							<%=remediesList.get(i).getName()%></option>
						<%
							}
						%>
					</select><font color="red">${remedies}</font> <label>Category of
						Product</label> <select name="selProductCategoryName" class="form-control">
						<option value="0" selected="selected">Select Product
							Category</option>
						<%
							List<ProductCategoryBean> productCategoryList = new ProductCategoryDAO().getList();
							for (int i = 0; i < productCategoryList.size(); i++) {

								String tmp = "unselected";
								String type = request.getParameter("selProductCategoryName");
								if (type == null || type.equals("0"))
									tmp = "unselected";
								else if (productCategoryList.get(i).getProductCategoryId().equals(type))
									tmp = "selected";
						%>

						<option
							value=<%=productCategoryList.get(i).getProductCategoryId()%>
							<%=tmp%>>
							<%=productCategoryList.get(i).getProductCategoryName()%></option>
						<%
							}
						%>
					</select><font color="red">${productCateogory}</font>
				</div>
			</div>
			<br>
			<input type="Submit" value="Add" name="submit"
				class="btn btn-success">&nbsp;&nbsp;&nbsp;<input
				type="reset" value="Reset" name="reset" class="btn btn-danger">
		</form>
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