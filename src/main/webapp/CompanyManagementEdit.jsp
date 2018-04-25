<%@page import="DrRAJ.Bean.CompanyManagementBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Company Management</title>
<noscript>
	<div style="color: #FF0000">Please enable java script</div>
</noscript>
<script type="text/javascript" src="js/mainscript.js"></script>
</head>
<%@ include file="AdminHeader.jsp"%>
<section class="content-header">
<h1>Update Company Management</h1>
<br>
<br>
<div class="container" style="margin: 0; max-width: 1000px;">
	<form action="CompanyManagementUpdateServlet" method="post">
		<%
			CompanyManagementBean companyManagementBean = (CompanyManagementBean) request
					.getAttribute("companyManagementBean");

			if (companyManagementBean != null) {

				String name = companyManagementBean.getName();
				if (name == null)
					name = "";

				String photoLink = companyManagementBean.getPhotoLink();
				if (photoLink == null)
					photoLink = "";

				String title = companyManagementBean.getTitle();
				if (title == null)
					title = "";
		%>
		<input type="hidden" name="companyManagementId"
			value=<%=companyManagementBean.getCompanyManagementId()%>>
		<div class="row">
			<div class="col-md-6">
				<label>Name</label> <input type="text" class="form-control"
					value="<%=name%>" name="txtCompanyManagementName" />${name}
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-6">
				<label>Title / Designation</label> <input class="form-control"
					type="text" value="<%=title%>" name="txtTitle" />${title}
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-6">
				<label>Image Link</label> <input class="form-control imagetester"
					type="text" value="<%=photoLink%>" name="txtPhotoLink"
					target=".imagetarget" />${photoLink}
			</div>
			<div class="col-md-3">
				<img src="<%=photoLink%>" alt="Image not found" class="imagetarget"
					style="max-height: 200px; max-width: 200px;" />
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