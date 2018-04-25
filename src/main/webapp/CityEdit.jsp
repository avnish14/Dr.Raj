<%@page import="DrRAJ.Bean.CityBean"%>
<%@page import="DrRAJ.DAO.StateDAO"%>
<%@page import="DrRAJ.Bean.StateBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update City</title>
<noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>
</head>
<%@ include file="AdminHeader.jsp"%>
<section class="content-header">
	<h1>Update City</h1>
	<br> <br>
	<div class="container" style="margin: 0; max-width: 1000px;">
		<%
			CityBean bean = (CityBean) request.getAttribute("cityBean");
			if (bean != null) {
		%>
		<form action="CityUpdateServlet" method="post">
			<input type="hidden" name="cityId" value="<%=bean.getCityId()%>">
			<div class="row">
				<div class="col-md-6">
					<label>City Name</label> <input type="text" class="form-control"
						name="txtCityName" placeholder="Ahmedabad" maxlength="50"
						oninput="nodigit(this);" value="<%=bean.getCityName()%>" /> <font
						color="red">${cityName}</font>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-md-6">
					<label>State</label> <select name="selStateName" id="selStateName"
						class="form-control">
						<option value="0" selected="selected">Select State</option>
						<%
							List<StateBean> stateList = new StateDAO().getList();
								for (int i = 0; i < stateList.size(); i++) {
									StateBean stateBean = stateList.get(i);
									if (stateBean.getStateId().equals(bean.getStateId())) {
						%>
						<option value="<%=stateBean.getStateId()%>" selected="selected"><%=stateBean.getStateName()%></option>
						<%
							} else {
						%>
						<option value="<%=stateBean.getStateId()%>"><%=stateBean.getStateName()%></option>
						<%
							}
								}
						%>
					</select><font color="red">${stateName}</font>
				</div>
			</div>
			<br /> <input type="Submit" value="Update" name="submit"
				class="btn btn-success">&nbsp;&nbsp;<input type="reset"
				value="Reset" name="reset" class="btn  btn-danger">
		</form>
	</div>
	<%
		} else {

			request.setAttribute("msgLogin", "Please Login To Continue");
			response.sendRedirect("login.jsp");

		}
	%>
</section>
<%@ include file="AdminFooter.jsp"%>