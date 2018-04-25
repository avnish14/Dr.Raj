<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DrRAJ.Bean.TestimonialBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Testimonial</title>
</head>
<%@include file="AdminHeader.jsp"%>
<section class="content content-header">
<h1>Testimonial</h1>
<br>
<br>
<a href="TestimonialInsert.jsp"><input type="button" value="Add"
	name="Add" class="btn btn-primary"></a> <br>
<br>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-body">
				<table id="example1"
					class="table table-bordered table-hover table-striped">
					<thead class="gujju-theme text-uppercase">
						<tr>
							<th>Photo</th>
							<th>Name</th>
							<th>Description</th>
							<th>ACTION</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<TestimonialBean> listOfTestimonial = (ArrayList) request.getAttribute("listOfTestimonial");

							if (listOfTestimonial != null) {
								for (int i = 0; i < listOfTestimonial.size(); i++) {
									TestimonialBean testimonial = listOfTestimonial.get(i);
						%>
						<tr>
							<td><img src="<%=testimonial.getPhotoLink()%>"
								style="max-height: 100px;" /></td>
							<td><%=testimonial.getName()%></td>
							<td><textarea rows="2" cols="30"><%=testimonial.getDescription()%></textarea>
							</td>
							<td><a
								href="TestimonialEditServlet?testimonialId=<%=testimonial.getTestimonialId()%>"><img
									src="imgs/edit.svg" height="30" width="30" class="img-rounded" /></a>&nbsp;<a
								href="TestimonialDeleteServlet?testimonialId=<%=testimonial.getTestimonialId()%>"><img
									src="imgs/delete.svg" height="30" width="30"
									class="img-rounded" /></a></td>
						</tr>
						<%
							}
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
</section>
<%@include file="AdminFooter.jsp"%>