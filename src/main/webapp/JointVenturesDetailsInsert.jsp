<%@page import="DrRAJ.DAO.JointVenturesDAO"%>
<%@page import="DrRAJ.Bean.JointVenturesBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Joint Ventures Details</title>
<noscript>
	<div style="color: #FF0000">Please enable java script</div>
</noscript>
<script type="text/javascript" src="js/mainscript.js"></script>
</head>
<%@ include file="AdminHeader.jsp"%>
<section class="content-header">
<h1>Add Joint Ventures Details</h1>
<br>
<br>
<div class="container" style="max-width: 1000px; margin: 0;">
	<form action="JointVenturesDetailsInsertServlet" method="post">
		<div class="row">
			<div class="col-md-6">
				<label>Press Type</label> <select name="txtJointVentures"
					class="form-control">
					<option value="0" selected="selected">Select Joint
						Ventures</option>
					<%
						List<JointVenturesBean> jointVenturesList = new JointVenturesDAO().getList();
						for (int i = 0; i < jointVenturesList.size(); i++) {

							String tmp = "unselected";
							String type = (String) request.getAttribute("txtJointVentures");
							if (type == null || type.equals("0"))
								tmp = "unselected";
							else if (jointVenturesList.get(i).getId().equals(type))
								tmp = "selected";
					%>

					<option value=<%=jointVenturesList.get(i).getId()%> <%=tmp%>>
						<%=jointVenturesList.get(i).getName()%></option>
					<%
						}
					%>
				</select><font color="red">${jointVenture}</font>
			</div>
		</div>
		<br />

		<div class="row">
			<div class="col-md-6">
				<label>Title</label> <input type="text" class="form-control"
					value="${txtTitle}" name="txtTitle" />${title}
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
		<br />
		<div class="row">
			<div class="col-md-6">
				<label>Content</label>
				<textarea rows="5" cols="50" class="form-control" name="txtContent">${txtContent}</textarea>${content}
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