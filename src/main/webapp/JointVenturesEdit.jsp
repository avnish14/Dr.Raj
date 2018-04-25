<%@page import="DrRAJ.Bean.JointVenturesBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Joint Venture</title>
<noscript>
	<div style="color: #FF0000">Please enable java script</div>
</noscript>
<script type="text/javascript" src="js/mainscript.js"></script>
<%@ include file="AdminHeader.jsp"%>
<section class="content-header">
<h1>Edit Joint Venture</h1>
<br>
<br>
<div class="container">
	<form action="JointVenturesUpdateServlet" method="post">
		<%
			JointVenturesBean jointVenturesBean = (JointVenturesBean) request.getAttribute("jointVenturesBean");

			if (jointVenturesBean != null) {
		%>
		<input type="hidden" name="id" value=<%=jointVenturesBean.getId()%>>
		<div class="row">
			<div class="col-md-6">
				<label>Name</label> <input type="text" class="form-control"
					value="<%=jointVenturesBean.getName()%>" name="txtName" />${name}
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-6">
				<label>Page URL for SEO</label> <input type="text"
					class="form-control" value="<%=jointVenturesBean.getForwardLink()%>"
					name="txtForwardURL" />${forwardURL}
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-6">
				<label>Image Link</label> <input type="text"
					class="form-control imagetester"
					value="<%=jointVenturesBean.getImageLink()%>" name="txtImageURL"
					target=".imagetarget" />${imageURL}
			</div>
			<div class="col-md-3">
				<img src="<%=jointVenturesBean.getImageLink()%>" alt="Image not found"
					class="imagetarget" style="max-height: 200px; max-width: 200px;" />
			</div>
		</div>
		<br /> <input type="Submit" value="Update" name="submit"
			class="btn btn-success">&nbsp;&nbsp; <input type="reset"
			value="Reset" name="reset" class="btn  btn-danger" />
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