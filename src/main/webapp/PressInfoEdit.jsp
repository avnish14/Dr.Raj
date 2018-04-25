<%@page import="DrRAJ.Bean.PressInfoBean"%>
<%@page import="DrRAJ.DAO.PressInfoTypeDAO"%>
<%@page import="DrRAJ.Bean.PressInfoTypeBean"%>
<%@page import="DrRAJ.DAO.BookTypeDAO"%>
<%@page import="DrRAJ.Bean.BookTypeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update PressInfo</title>
<noscript>
	<div style="color: #FF0000">Please enable java script</div>
</noscript>
<script type="text/javascript" src="js/mainscript.js"></script>
</head>
<%@ include file="AdminHeader.jsp"%>
<section class="content-header">
	<h1>Update Press Info</h1>
	<br> <br>
	<div class="container">
		<%
			PressInfoBean pressInfoBean = (PressInfoBean) request.getAttribute("pressInfoBean");

			if (pressInfoBean != null) {
		%>
		<form action="PressInfoUpdateServlet" method="post">
			<input type="hidden" name="pressInfoId"
				value="<%=pressInfoBean.getPressInfoId()%>">
			<div class="row">
				<div class="col-md-6">
					<label>Press Type</label> <select name="txtPressInfoType"
						class="form-control">
						<option value="0" selected="selected">Select Press Type</option>
						<%
							List<PressInfoTypeBean> pressTypeList = new PressInfoTypeDAO().getList();
								for (int i = 0; i < pressTypeList.size(); i++) {

									String tmp = "unselected";
									String type = (String) pressInfoBean.getTypeId();
									if (type == null || type.equals("0"))
										tmp = "unselected";
									else if (pressTypeList.get(i).getTypeId().equals(type))
										tmp = "selected";
						%>

						<option value=<%=pressTypeList.get(i).getTypeId()%> <%=tmp%>>
							<%=pressTypeList.get(i).getName()%></option>
						<%
							}
						%>
					</select><font color="red">${type}</font>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-md-6">
					<label>Title</label> <input class="form-control" type="text"
						value="<%=pressInfoBean.getTitle()%>" name="txtTitle" />${title}
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-md-6">
					<label>URL Link</label> <input class="form-control" type="text"
						value="<%=pressInfoBean.getLink()%>" name="txtURLLink" />${URLLink}
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