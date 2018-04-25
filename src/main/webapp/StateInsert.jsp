<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add State</title>
<noscript>
	<div style="color: #FF0000">Please enable java script</div>
</noscript>
<script type="text/javascript" src="js/mainscript.js"></script>
</head>
<%@ include file="AdminHeader.jsp"%>
<section class="content-header">
	<h1>
		Add State
	</h1>
	<br> <br>
	<div class="container" style="margin: 0;max-width: 1000px;">
		<form action="StateInsertServlet" method="post">
			<div class="row">
				<div class="col-md-6">
					<label>State Name</label> <input type="text" class="form-control"
						value="${txtStateName}" name="txtStateName" />${stateName}
				</div>
			</div>
			<br /> <input type="Submit" value="Add" name="submit"
				class="btn btn-success"> <input type="reset" value="Reset"
				name="reset" class="btn  btn-danger">
		</form>
	</div>
</section>
<%@ include file="AdminFooter.jsp"%>