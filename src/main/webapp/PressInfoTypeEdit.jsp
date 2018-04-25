<%@page import="DrRAJ.Bean.PressInfoTypeBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Press Info Type Update</title>
<noscript>
	<div style="color: #FF0000">Please enable java script</div>
</noscript>
<script type="text/javascript" src="js/mainscript.js"></script>
</head>
<%@ include file="AdminHeader.jsp"%>
<section class="content-header">
	<h1>Update Press Info Type</h1>
	<br> <br>
	<div class="container">
		<form action="PressInfoTypeUpdateServlet" method="post">
			<%
				PressInfoTypeBean pressInfoTypeBean = (PressInfoTypeBean) request.getAttribute("pressInfoTypeBean");

				if (pressInfoTypeBean != null) {
			%>
			<input type="hidden" name="pressInfoTypeId"
				value=<%=pressInfoTypeBean.getTypeId()%>>
			<div class="row">
				<div class="col-md-6">
					<label>Press Type</label> <input type="text" class="form-control"
						value="<%=pressInfoTypeBean.getName()%>"
						name="txtPressInfoTypeName" />${pressInfoTypeName}
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