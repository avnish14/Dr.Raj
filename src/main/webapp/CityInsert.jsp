<%@page import="DrRAJ.DAO.StateDAO"%>
<%@page import="DrRAJ.Bean.StateBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add City</title>
<noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>
</head>
<%@ include file="AdminHeader.jsp"%>
<section class="content-header">
	<h1>Add City</h1>
	<br> <br>
	<div class="container" style="max-width: 1000px; margin: 0;">
		<form action="CityInsertServlet" method="post">
			<div class="row">
				<div class="col-md-6">
					<label>City Name</label> <input type="text" class="form-control"
						name="txtCityName" placeholder="Ahmedabad" maxlength="50"
						oninput="nodigit(this);" value="${txtCityName}" /> <font
						color="red">${cityName} </font>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-md-6">
					<label>State</label> <select name="selStateName"
						class="form-control">
						<option value="0" selected="selected">Select State</option>
						<%
							List<StateBean> stateList = new StateDAO().getList();
							for (int i = 0; i < stateList.size(); i++) {

								String tmp = "unselected";
								String type = request.getParameter("selStateName");
								if (type == null || type.equals("0"))
									tmp = "unselected";
								else if (stateList.get(i).getStateId().equals(type))
									tmp = "selected";
						%>

						<option value=<%=stateList.get(i).getStateId()%> <%=tmp%>>
							<%=stateList.get(i).getStateName()%></option>
						<%
							}
						%>
					</select><font color="red">${stateName}</font>
				</div>
			</div>
			<br /> <input type="Submit" value="Add" name="submit"
				class="btn btn-success">&nbsp;&nbsp;<input type="reset"
				value="Reset" name="reset" class="btn  btn-danger">
		</form>
	</div>
</section>
<%@ include file="AdminFooter.jsp"%>