<%@page import="DrRAJ.DAO.JointVenturesDAO"%>
<%@page import="DrRAJ.Bean.JointVenturesBean"%>
<%@page import="DrRAJ.Bean.JointventuresURLDetailsBean"%>
<%@page import="java.util.List"%>
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
	<form action="JointVenturesURLDetailsUpdateServlet" method="post">
		<%
			JointventuresURLDetailsBean jointVenturesURLDetailsBean = (JointventuresURLDetailsBean) request
					.getAttribute("jointVenturesURLDetailsBean");

			if (jointVenturesURLDetailsBean != null) {
				String title = jointVenturesURLDetailsBean.getSubTitle();
				if (title == null)
					title = "";
				String content = jointVenturesURLDetailsBean.getContent();
				if (content == null)
					content = "";
				String link = jointVenturesURLDetailsBean.getPdfLink();
				if (link == null)
					link = "";
				String name = jointVenturesURLDetailsBean.getPdfName();
				if (name == null)
					name = "";
		%>
		<input type="hidden" name="id"
			value=<%=jointVenturesURLDetailsBean.getId()%>>
		<div class="row">
			<div class="col-md-6">
				<label>Joint Ventures</label> <select name="jointVenturesId"
					class="form-control">
					<option value="0" selected="selected">Select Joint
						Ventures</option>
					<%
						List<JointVenturesBean> jointVenturesList = new JointVenturesDAO().getList();
							for (int i = 0; i < jointVenturesList.size(); i++) {

								String tmp = "unselected";
								String type = (String) jointVenturesURLDetailsBean.getJointVenturesId();
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
				<label>Sub Title</label> <input type="text" class="form-control"
					value="<%=title%>" name="txtSubTitle" />${title}
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-6">
				<label>PDF Name</label> <input type="text" class="form-control"
					value="<%=name%>" name="txtPdfName" />${pdfName}
			</div>
		</div>
		<br />

		<div class="row">
			<div class="col-md-6">
				<label>PDF Link</label> <input type="text" class="form-control"
					value="<%=link%>" name="txtPdfLink" />${pdfLink}
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-6">
				<label>Content</label>
				<textarea rows="5" cols="50" class="form-control" name="txtContent"><%=content%></textarea>${content}
			</div>
		</div>
		<br /> <br /> <input type="Submit" value="Update" name="submit"
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