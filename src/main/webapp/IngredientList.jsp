<%@page import="DrRAJ.Bean.IngredientBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingredients</title>
</head>
<%@include file="AdminHeader.jsp"%>
<section class="content content-header">
	<h1>
		Ingredients
	</h1>
	<br> <br> <a href="IngredientInsert.jsp" name="Add"
		class="btn btn-primary">Add</a> <br> <br>
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-body">
					<table id="example1"
						class="table table-bordered table-hover table-striped">
						<%
							ArrayList<IngredientBean> list = (ArrayList<IngredientBean>) request.getAttribute("ingredientList");
						%>
						<thead class="gujju-theme text-uppercase">
							<tr>
								<th>Title</th>
								<th>Description</th>
								<th>PhotoLink</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (IngredientBean bean : list) {
							%>
							<tr>
								<td><%=bean.getTitle()%></td>
								<td><%=bean.getDescription()%></td>
								<td><img src="<%=bean.getPhotoLink()%>" style="max-height: 100px;"/></td>
								<td><a
									href="IngredientEditServlet?ingredientId=<%=bean.getIngredientsId()%>"><img
										src="imgs/edit.svg" height="30" width="30" class="img-rounded" /></a>&nbsp;
									<a
									href="IngredientDeleteServlet?ingredientId=<%=bean.getIngredientsId()%>"><img
										src="imgs/delete.svg" height="30" width="30"
										class="img-rounded" /></a>
							</tr>
							<%
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