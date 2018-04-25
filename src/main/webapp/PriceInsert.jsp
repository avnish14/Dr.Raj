<%@page import="DrRAJ.Bean.ProductBean"%>
<%@page import="DrRAJ.DAO.ProductDAO"%>
<%@page import="DrRAJ.Controller.ProductDeleteServlet"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product Prices</title>
<noscript>
	<div style="color: #FF0000">Please enable java script</div>
</noscript>
<script type="text/javascript" src="js/mainscript.js"></script>
</head>
<%@ include file="AdminHeader.jsp"%>
<section class="content-header">
	<h1>Add Product Price</h1>
	<br> <br>
	<div class="container" style="margin: 0; max-width: 1000px;">
		<div class="subform">
			<label>How many related products you want insert?</label> <input
				type="text" class="form-control howmanytextbox"
				style="width: 300px; margin-bottom: 5px;" value="1" /> <input
				type="button" value="Next" class="btn btn-success nextbutton">
		</div>
		<form action="PriceInsertServlet" method="post" class="mainform"
			style="display: none;">
			<div class="row">
				<div class="col-md-8">
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
			<br>
			<div class="row">
				<div class="col-sm-4 sizeContainer"></div>
				<div class="col-sm-4 priceContainer"></div>
			</div>
			<br /> <input type="Submit" value="Add" name="submit"
				class="btn btn-success"> <input type="hidden"
				name="txtDummy" class="priceFinalTextBox" /> <input type="reset"
				value="Reset" name="reset" class="btn  btn-danger">
		</form>
	</div>
</section>
<%@ include file="AdminFooter.jsp"%>
<script type="text/javascript">
	$(".howmanytextbox").blur(function() {
		if ($(this).val() == "")
			$(this).val("1");
	});
	var rprocount = 0;
	$(".nextbutton")
			.click(
					function() {
						var val = parseInt($(".howmanytextbox").val());
						if (isNaN(val)) {
							val = 1;
							$(".howmanytextbox").val();
						}
						rprocount = val;
						for (var i = 0; i < rprocount; i++) {
							var priceString = "";
							priceString += "<label>Price</label><input type='text' class='form-control price"+i+" priceBox' style='margin-bottom:5px;'/>";
							$(".priceContainer").append(priceString);
							var sizeString = "";
							sizeString += "<label>Package Size</label><input type='text' class='form-control size"+i+" sizeBox' style='margin-bottom:5px;'/>";
							$(".sizeContainer").append(sizeString);
						}
						$(".mainform").css("display", "block");
						$(".subform").css("display", "none");
					});
	$("body").on(
			"input",
			".priceBox,.sizeBox",
			function() {
				var particularString = "";
				for (var i = 0; i < rprocount; i++) {
					var price = $(".price" + i).val();
					var size = $(".size" + i).val();
					if (price != "" && size != "") {
						particularString += size + "=" + price + "~";
					}
				}
				particularString = particularString.substr(0,
						particularString.length - 1);
				$(".priceFinalTextBox").val(particularString);
			});
</script>
</body>
</html>