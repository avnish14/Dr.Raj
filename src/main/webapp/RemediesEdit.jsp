<%@page import="DrRAJ.Bean.RemediesBean"%>
<%@page import="DrRAJ.Bean.TestimonialBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Remedies</title>
<noscript>
	<div style="color: #FF0000">Please enable java script</div>
</noscript>
<script type="text/javascript" src="js/mainscript.js"></script>
</head>
<%@ include file="AdminHeader.jsp"%>
<section class="content-header">
	<h1>Edit Remedies</h1>
	<br> <br>
	<div class="container" style="max-width: 1000px; margin: 0;">
		<form action="RemediesUpdateServlet" method="post">
			<%
				RemediesBean remediesBean = (RemediesBean) request.getAttribute("remediesBean");

				if (remediesBean != null) {

					String name = remediesBean.getName();
					if (name == null)
						name = "";

					String photoLink = remediesBean.getPhotolink();
					if (photoLink == null)
						photoLink = "";

					String forwardLink = remediesBean.getForwardLink();
					if (forwardLink == null)
						forwardLink = "";
			%>
			<input type="hidden" name="remediesId"
				value=<%=remediesBean.getRemediesId()%>> <br />
			<div class="row">
				<div class="col-md-6">
					<label>Name</label> <input type="text" class="form-control"
						value="<%=name%>" name="txtRemediesName" />${name}
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
			<br />
			<div class="row">
				<div class="col-md-6">
					<label>Remedies URL for SEO</label> <input type="text"
						class="form-control" value="<%=forwardLink%>"
						name="txtForwardLink" />${forwardLink}
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