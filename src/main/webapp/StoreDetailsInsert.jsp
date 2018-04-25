<%@page import="DrRAJ.DAO.CityDAO"%>
<%@page import="DrRAJ.Bean.CityBean"%>
<%@page import="DrRAJ.DAO.PressInfoTypeDAO"%>
<%@page import="DrRAJ.Bean.PressInfoTypeBean"%>
<%@page import="DrRAJ.DAO.BookTypeDAO"%>
<%@page import="DrRAJ.Bean.BookTypeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Store</title>
<noscript>
	<div style="color: #FF0000">Please enable java script</div>
</noscript>
<script type="text/javascript" src="js/mainscript.js"></script>
</head>
<%@ include file="AdminHeader.jsp"%>
<section class="content-header">
	<h1>Add Store</h1>
	<br> <br>
	<div class="container" style="max-width: 1000px; margin: 0;">
		<form action="StoreDetailsInsertServlet" method="post">
			<div class="row">
				<div class="col-md-6">
					<label>Store Name</label> <input class="form-control" type="text"
						value="${txtStoreName}" name="txtStoreName" />${name}
				</div>
				<div class="col-md-6">
					<label>Store City</label> <select name="txtCityId"
						class="form-control">
						<option value="0" selected="selected">Select City</option>
						<%
							List<CityBean> cityBeans = new CityDAO().getList();
							for (int i = 0; i < cityBeans.size(); i++) {

								String tmp = "unselected";
								String type = (String) request.getAttribute("txtCityId");
								if (type == null || type.equals("0"))
									tmp = "unselected";
								else if (cityBeans.get(i).getCityId().equals(type))
									tmp = "selected";
						%>

						<option value=<%=cityBeans.get(i).getCityId()%> <%=tmp%>>
							<%=cityBeans.get(i).getCityName()%></option>
						<%
							}
						%>
					</select><font color="red">${city}</font>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-md-6">
					<label>Address</label>
					<textarea class="form-control" rows="5" cols="50" name="txtAddress">${txtAddress}</textarea>${address}
				</div>
				<div class="col-md-6">
					<label>Contact 1</label> <input class="form-control" type="text"
						value="${txtCN1}" name="txtCN1" />${CN1}<br> <label>Contact
						2</label> <input class="form-control" type="text" value="${txtCN2}"
						name="txtCN2" />${CN2}
				</div>
			</div>
			<br /> <input type="Submit" value="Add" name="submit"
				class="btn btn-success"> <input type="reset" value="Reset"
				name="reset" class="btn  btn-danger">
		</form>
	</div>
</section>
<%@ include file="AdminFooter.jsp"%>