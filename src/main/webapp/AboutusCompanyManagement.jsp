<%@page import="DrRAJ.DAO.CompanyManagementDAO"%>
<%@page import="DrRAJ.Bean.CompanyManagementBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Company Management | Dr. Raj Homoeo Pharmacy</title>
<%@include file="UserHeader.jsp"%>
<section class="bgimage maincover regular"
	style="background-image: url(https://farm5.staticflickr.com/4606/40468139451_ae8bdbf2fd_o_d.jpg);">
<div class="blackcover"></div>
<div class="container">
	<h3>About Us</h3>
	<div class="jumbotext">Company Management</div>
</div>
<div class="posab">
	<img src="imgs/bottomwhitecircle.svg"/>
</div>
</section>
<section>
<div class="container tcenter thousand">
	<div class="row">
		<%
			ArrayList<CompanyManagementBean> arrayList = (ArrayList<CompanyManagementBean>) new CompanyManagementDAO()
					.getList();
			if (arrayList.size() != 0) {
				for (int i = 0; i < arrayList.size(); i++) {
		%>
		<div class="cs6 mgmttemplate">
			<img src="<%=arrayList.get(i).getPhotoLink()%>"/>
			<div>
				<span class="name"><%=arrayList.get(i).getName()%></span>
				<span class="designation"><%=arrayList.get(i).getTitle()%></span>
			</div>
		</div>
		<%
			}
			}
		%>
	</div>
</div>
</section>
<%@include file="UserFooter.jsp"%>
</html>