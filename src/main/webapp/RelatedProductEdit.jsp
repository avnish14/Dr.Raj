<%@page import="DrRAJ.Bean.RelatedProductBean"%>
<%@page import="DrRAJ.Bean.ProductBean"%>
<%@page import="DrRAJ.DAO.ProductDAO"%>
<%@page import="DrRAJ.Controller.ProductDeleteServlet"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Related Product Update</title>
<noscript>
	<div style="color: #FF0000">Please enable java script</div>
</noscript>
<script type="text/javascript" src="js/mainscript.js"></script>
<link rel="icon" href="imgs/daiict.png" />
</head>
<body>
	<%@ include file="AdminHeader.jsp"%>
	<div style="margin-top: -850px; margin-left: 250px;">
		<section class="content-header">
		<h1>
			Related Product <small>Update</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="AdminDashBoard.jsp"><i class="fa fa-dashboard"></i>
					Home</a></li>
			<li class="active">Admin</li>
		</ol>
		</section>
		<br> <br>
		<div class="col-lg-6">
			<div class="container">
				<form action="ReletedProductUpdateServlet" method="post">
					<%
						RelatedProductBean relatedProductBean = (RelatedProductBean) request.getAttribute("relatedProductBean");

						if (relatedProductBean != null) {
					%>
					<input type="hidden" name="reletedProductId"
						value="<%=relatedProductBean.getReletedProductId()%>"> <br />
					<div class="row">
						<label class="col-sm-2"> <font size="+1">Select
								Product </font>
						</label>
						<div class="col-lg-6">
							<select name="txtProductId" class="form-control">
								<option value="0" selected="selected">Select Product</option>
								<%
									List<ProductBean> productBeans = new ProductDAO().getList();
										for (int i = 0; i < productBeans.size(); i++) {

											String tmp = "unselected";
											String type = (String) relatedProductBean.getProductId();
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
						<label class="col-sm-2"> <font size="+1">Select
								Related Product </font>
						</label>
						<div class="col-lg-6">
							<select name="txtRelatedProductId" class="form-control">
								<option value="0" selected="selected">Select Related
									Product</option>
								<%
									for (int i = 0; i < productBeans.size(); i++) {

											String tmp = "unselected";
											String type = (String) relatedProductBean.getReletedId();
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
							</select><font color="red">${relatedProduct}</font>
						</div>
					</div>
					<br /> <br /> <br /> <label class="col-sm-2 control-label"></label>
					<input type="reset" value="Reset" name="reset"
						class="btn  btn-danger">
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<input type="Submit" value="Add" name="submit"
						class="btn btn-success">

				</form>
				<%
					} else {
					}
				%>
			</div>
		</div>
	</div>
</body>
</html>
