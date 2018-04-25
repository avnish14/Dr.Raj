<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Joint Ventures</title>
<noscript>
	<div style="color: #FF0000">Please enable java script</div>
</noscript>
<script type="text/javascript" src="js/mainscript.js"></script>
</head>
<%@ include file="AdminHeader.jsp"%>
<section class="content-header">
<h1>Add Joint Ventures</h1>
<br>
<br>
<div class="container" style="max-width: 1000px; margin: 0;">
	<form action="JointVenturesInsertServlet" method="post">
		<div class="row">
			<div class="col-md-6">
				<label>Name</label> <input type="text" class="form-control"
					value="${txtName}" name="txtName" />${name}
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-6">
				<label>Page URL for SEO</label> <input type="text"
					class="form-control" value="${txtForwardURL}" name="txtForwardURL" />${forwardURL}
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-6">
				<label>Image Link</label> <input type="text"
					class="form-control imagetester" value="${txtImageURL}"
					name="txtImageURL" target=".imagetarget" />${imageURL}
			</div>
			<div class="col-md-3">
				<img src="" alt="Image not found" class="imagetarget"
					style="max-height: 200px; max-width: 200px;" />
			</div>
		</div>
		<br /> <input type="Submit" value="Add" name="submit"
			class="btn btn-success">&nbsp;&nbsp; <input type="reset"
			value="Reset" name="reset" class="btn  btn-danger">
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