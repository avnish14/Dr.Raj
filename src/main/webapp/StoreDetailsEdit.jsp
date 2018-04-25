<%@page import="DrRAJ.Bean.StoreDetailsBean"%>
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
<title>Update Store Details</title>
<noscript>
	<div style="color: #FF0000">Please enable java script</div>
</noscript>
<script type="text/javascript" src="js/mainscript.js"></script>
</head>
<%@ include file="AdminHeader.jsp"%>
<section class="content-header">
	<h1>Update Store Details</h1>
	<br> <br>
	<div class="container" style="margin: 0;max-width: 1000px;">
		<%
			StoreDetailsBean storeDetailsBean = (StoreDetailsBean) request.getAttribute("storeBean");

			if (storeDetailsBean != null) {
		%>
		<form action="StoreDetailsUpdateServlet" method="post">
			<input type="hidden" name="storeId"
				value="<%=storeDetailsBean.getStoreId()%>">
			<div class="row">
				<div class="col-md-6">
					<label>Store Name</label> <input class="form-control" type="text"
						value="<%=storeDetailsBean.getName()%>" name="txtStoreName" />${name}
				</div>
				<div class="col-md-6">
					<label>Store City</label> <select name="txtCityId"
						class="form-control">
						<option value="0" selected="selected">Select City</option>
						<%
							List<CityBean> cityBeans = new CityDAO().getList();
								for (int i = 0; i < cityBeans.size(); i++) {

									String tmp = "unselected";
									String type = (String) storeDetailsBean.getCityId();
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
					<textarea class="form-control" rows="5" cols="50" name="txtAddress"><%=storeDetailsBean.getAddress()%></textarea>${address}
				</div>
				<div class="col-md-6">
					<label>Contact 1</label> <input class="form-control" type="text"
						value="<%=storeDetailsBean.getContact1()%>" name="txtCN1" />${CN1}<br>
					<label>Contact 2</label> <input class="form-control" type="text"
						value="<%=storeDetailsBean.getContact2()%>" name="txtCN2" />${CN2}
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