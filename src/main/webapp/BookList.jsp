<%@page import="DrRAJ.Bean.BookBean"%>
<%@page import="DrRAJ.Bean.IngredientBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Books</title>
</head>
<%@include file="AdminHeader.jsp"%>
<section class="content content-header">
	<h1>Books</h1>
	<br> <a href="BookInsert.jsp" name="Add" class="btn btn-primary">Add</a>
	<br> <br>
	<div class="row">
		<div class="col-xs-12" style="overflow-x: auto;">
			<div class="box">
				<div class="box-body">
					<table id="example1"
						class="table table-bordered table-hover table-striped" style="overflow-x: auto;">
						<%
							ArrayList<BookBean> list = (ArrayList<BookBean>) request.getAttribute("listOfBook");
						%>
						<thead class="gujju-theme text-uppercase">
							<tr>
								<th>Name</th>
								<th>Author</th>
								<th>Type</th>
								<th>ISBN</th>
								<th>PhotoLink</th>
								<th>URLLink</th>
								<th>Description</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (BookBean bean : list) {
							%>
							<tr>
								<td><%=bean.getName()%></td>
								<td><%=bean.getAuthor()%></td>
								<td><%=bean.getType()%></td>
								<td><%=bean.getIsbn()%></td>
								<td><%=bean.getPhotolink()%></td>
								<td><%=bean.getUrllink()%></td>
								<td><textarea disabled="disabled"><%=bean.getDescription()%></textarea></td>
								<td><a href="BookEditServlet?bookId=<%=bean.getBookId()%>"><img
										src="imgs/edit.svg" height="30" width="30" class="img-rounded" /></a>&nbsp;
									<a href="BookDeleteServlet?bookId=<%=bean.getBookId()%>"><img
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