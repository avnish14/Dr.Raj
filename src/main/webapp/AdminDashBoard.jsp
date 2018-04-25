<%@page import="DrRAJ.DAO.ContactUsDAO"%>
<%@page import="DrRAJ.DAO.ReviewDAO"%>
<%@page import="DrRAJ.DAO.IngredientDAO"%>
<%@page import="DrRAJ.DAO.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="AdminHeader.jsp"%>
<section class="content-header">
	<h1>Dashboard</h1>
	<br> <br>
	<div class="container" style="max-width: 1000px; margin: 0;">
		<div class="row">
			<div class="col-md-3">
				<div class="panel panel-default  ">
					<div class="panel-heading "
						style="color: white; background-color: #367FA9;">
						<div style="font-size: 3em;">
							<i class="fa-ticket fa">&emsp; </i><%=new ProductDAO().getList().size()%></div>
					</div>
					<a href="ProductListServlet">
						<div class="panel-body gujju-theme-d2" style="font-weight: bold;">Products</div>
					</a>
				</div>
			</div>
			<div class="col-md-3">
				<div class="panel panel-default   gujju-card-16 ">
					<div class="panel-heading  "
						style="color: white; background-color: #367FA9;">
						<div style="font-size: 3em;">
							<i class="fa-ticket fa">&emsp; </i><%=new IngredientDAO().select().size()%></div>
					</div>
					<a href="IngredientListServlet"><div
							class="panel-body gujju-theme-d2" style="font-weight: bold;">Ingredients</div></a>
				</div>
			</div>
			<div class="col-md-3">
				<div class="panel panel-default   gujju-card-16 ">
					<div class="panel-heading  "
						style="color: white; background-color: #367FA9;">
						<div style="font-size: 3em;">
							<i class="fa-ticket fa">&emsp; </i><%=new ReviewDAO().getList().size()%></div>
					</div>
					<a href="ReviewListServlet"><div
							class="panel-body gujju-theme-d2" style="font-weight: bold;">Review</div></a>
				</div>
			</div>
			<div class="col-sm-1"></div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="panel panel-default     gujju-card-16 ">
					<div class="panel-heading "
						style="color: white; background-color: #367FA9;">
						<div style="font-size: 3em;">
							<i class="fa fa-user-plus">&emsp; </i>
							<%-- <%=new FeedbackDAO().todayFeedbackCounter()%> --%>
							Hi
						</div>
					</div>
					<div class="panel-body gujju-theme-d2" style="font-weight: bold;">Feedback
						Done</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="panel panel-default     gujju-card-16 ">
					<div class="panel-heading "
						style="color: white; background-color: #367FA9;">
						<div style="font-size: 3em;">
							<i class="fa fa-ticket">&emsp; </i>
							<%-- <%=new ContactUsDAO().todayQuery()%> --%>
						</div>
					</div>
					<div class="panel-body gujju-theme-d2" style="font-weight: bold;">
						Customer's Query</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="panel panel-default     gujju-card-16 ">
					<div class="panel-heading "
						style="color: white; background-color: #367FA9;">
						<div style="font-size: 3em;">
							<i class="fa fa-newspaper-o">&emsp; </i>
							<%-- <%=new ReviewDAO().todayReview()%> --%>
						</div>
					</div>
					<div class="panel-body gujju-theme-d2" style="font-weight: bold;">Review</div>
				</div>
			</div>
		</div>
	</div>
</section>
<%@include file="AdminFooter.jsp"%>