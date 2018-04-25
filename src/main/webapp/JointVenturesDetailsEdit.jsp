<%@page import="DrRAJ.DAO.JointVenturesDAO"%>
<%@page import="DrRAJ.Bean.JointVenturesBean"%>
<%@page import="java.util.List"%>
<%@page import="DrRAJ.Bean.JointVenturesDetailsBean"%>
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
<h1>Edit Joint Venture Details</h1>
<br>
<br>
<div class="container">
	<form action="JointVenturesDetailsUpdateServlet" method="post">
		<%
			JointVenturesDetailsBean jointVenturesDetailsBean = (JointVenturesDetailsBean) request
					.getAttribute("jointVenturesDetailsBean");

			if (jointVenturesDetailsBean != null) {
				String title = jointVenturesDetailsBean.getTitle();
				if (title == null)
					title = "";
				String content = jointVenturesDetailsBean.getContent();
				if (content == null)
					content = "";
				String link = jointVenturesDetailsBean.getImageLink();
				if (link == null)
					link = "";
		%>
		<input type="hidden" name="id"
			value=<%=jointVenturesDetailsBean.getId()%>>
		<div class="row">
			<div class="col-md-6">
				<label>Joint Ventures</label> <select name="txtJointVentures"
					class="form-control">
					<option value="0" selected="selected">Select Joint Ventures</option>
					<%
						List<JointVenturesBean> jointVenturesList = new JointVenturesDAO().getList();
							for (int i = 0; i < jointVenturesList.size(); i++) {

								String tmp = "unselected";
								String type = (String) jointVenturesDetailsBean.getJointVenturesId();
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
					value="<%=title%>" name="txtTitle" />${title}
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-6">
				<label>Content</label>
				<textarea rows="5" cols="50" class="form-control" name="txtContent"><%=content%></textarea>${content}
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-6">
				<label>Image Link</label> <input type="text"
					class="form-control imagetester"
					value="<%=link%>"
					name="txtImageURL" target=".imagetarget" />${imageURL}
			</div>
			<div class="col-md-3">
				<img src="<%=jointVenturesDetailsBean.getImageLink()%>"
					alt="Image not found" class="imagetarget"
					style="max-height: 200px; max-width: 200px;" />
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