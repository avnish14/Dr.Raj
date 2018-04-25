<%@page import="DrRAJ.Bean.StateBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update State</title>
<noscript>
	<div style="color: #FF0000">Please enable java script</div>
</noscript>
<script type="text/javascript" src="js/mainscript.js"></script>
</head>
<%@ include file="AdminHeader.jsp"%>
<section class="content-header">
<h1>Update State</h1>
<br>
<div class="container" style="margin: 0; max-width: 1000px;">
	<form action="StateUpdateServlet" method="post">
		<%
			StateBean stateBean = (StateBean) request.getAttribute("stateBean");

			if (stateBean != null) {
		%>
		<br /> <input type="hidden" name="stateId"
			value=<%=stateBean.getStateId()%>>
		<div class="row">
			<div class="col-md-6">
				<label>State Name</label> <input type="text" class="form-control"
					value="<%=stateBean.getStateName()%>" name="txtStateName" />${stateName}
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