<%@page import="DrRAJ.DAO.JointVenturesDAO"%>
<%@page import="DrRAJ.Bean.JointVenturesBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Joint Ventures | Dr. Raj Homoeo Pharmacy</title>
<%@include file="UserHeader.jsp"%>
<section class="bgimage maincover regular"
	style="background-image: url(https://farm5.staticflickr.com/4606/40468139451_ae8bdbf2fd_o_d.jpg);">
<div class="blackcover"></div>
<div class="container">
	<h3>About Us</h3>
	<div class="jumbotext">Joint Ventures</div>
</div>
<div class="posab">
	<img src="imgs/bottomwhitecircle.svg"/>
</div>
</section>
<section>
<div class="container thousand">
	<div class="row">
		<%
			ArrayList<JointVenturesBean> arrayList = (ArrayList<JointVenturesBean>) new JointVenturesDAO().getList();
			if (arrayList.size() != 0) {
				for (JointVenturesBean mylist : arrayList) {
		%>
		<div class="cs4 remedies">
			<a href="<%=mylist.getForwardLink()%>" class="bgimage"
				style="background-image: url(<%=mylist.getImageLink()%>);">
				<div class="blackback"></div>
				<h3><%=mylist.getName()%></h3>
			</a>
		</div>
		<%
			}
			} else {
				response.sendRedirect("not-found");
			}
		%>
	</div>
</div>
</section>
<%@include file="UserFooter.jsp"%>
</body>
</html>