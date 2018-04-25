<%@page import="DrRAJ.Bean.AdminBean"%>
<%@page import="DrRAJ.Bean.IngredientBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		AdminBean bean = (AdminBean) request.getAttribute("adminBean");
		if (bean != null) {
	%>
	<form action="AdminUpdateServlet">
		<input type="hidden" name="adminId" value="<%=bean.getAdminId()%>">
		<table>

			<tr>
				<td>Enter First Name</td>
				<td><input type="text" name="txtFirstName"
					value="<%=bean.getFirstName()%>">${firstName}</td>
			</tr>

			<tr>
				<td>Enter Last Name</td>
				<td><input type="text" name="txtLastName"
					value="<%=bean.getLastName()%>">${lastName}</td>
			</tr>

			<tr>
				<td>Enter Email Id</td>
				<td><input type="text" name="txtIngredientTitle"
					value="<%=bean.getEmailId()%>">${ingredientTitle}</td>
			</tr>

			<tr>
				<td>Enter First Name</td>
				<td><input type="text" name="txtIngredientTitle"
					value="<%=/*bean.getTitle()*/%>">${ingredientTitle}</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"></td>
			</tr>
		</table>
	</form>
	<%
		} else {

		}
	%>
</body>
</html>