<%@page import="DrRAJ.DAO.BookTypeDAO"%>
<%@page import="DrRAJ.Bean.BookTypeBean"%>
<%@page import="java.util.List"%>
<%@page import="DrRAJ.Bean.BookBean"%>
<%@page import="DrRAJ.Bean.IngredientBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Book Update</title>
<noscript>
	<div style="color: #FF0000">Please enable java script</div>
</noscript>
<script type="text/javascript" src="js/mainscript.js"></script>
<link rel="icon" href="imgs/daiict.png" />
</head>
<body>
	<%@ include file="AdminHeader.jsp"%>
	<div style="margin-top: -850px; margin-left: 250px;">
		<section class="content-header">
		<h1>
			Book <small>Update</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="AdminDashBoard.jsp"><i class="fa fa-dashboard"></i>
					Home</a></li>
			<li class="active">Admin</li>
		</ol>
		</section>
		<br> <br>
		<div class="col-lg-6">
			<div class="container">
				<%
					BookBean bean = (BookBean) request.getAttribute("bookBean");
					if (bean != null) {
				%>
				<form action="BookUpdateServlet" method="post">
					<br /> <input type="hidden" name="bookId"
						value="<%=bean.getBookId()%>">
					<div class="row">
						<label class="col-sm-2"> <font size="+1">Enter
								Name:</font>
						</label>

						<div class="col-lg-6">
							<input type="text" class="form-control"
								value="<%=bean.getName()%>" name="txtBookName" />${name}
						</div>
					</div>
					<br />


					<%-- <div class="row">
						<label class="col-sm-2"> <font size="+1">Enter Type
								:</font>
						</label>

						<div class="col-lg-6">
							<input class="form-control" type="text"
								value="<%=bean.getType()%>" name="txtBookType" />${type}
						</div>
					</div> --%>

					<div class="row">
						<label class="col-sm-2"> <font size="+1">Select
								Book Type</font>
						</label>
						<div class="col-lg-6">
							<select name="txtBookType" id="txtBookType" class="form-control">
								<option value="0" selected="selected">Select State</option>
								<%
									List<BookTypeBean> stateList = new BookTypeDAO().getList();
										for (int i = 0; i < stateList.size(); i++) {
											BookTypeBean stateBean = stateList.get(i);
											if (stateBean.getName().equals(bean.getType())) {
								%>
								<option value="<%=stateBean.getName()%>" selected="selected"><%=stateBean.getName()%></option>
								<%
									} else {
								%>
								<option value="<%=stateBean.getName()%>"><%=stateBean.getName()%></option>
								<%
									}
										}
								%>
							</select><font color="red">${type}</font>
						</div>
					</div>
					<br />

					<div class="row">
						<label class="col-sm-2"> <font size="+1">Enter
								Photo Link :</font>
						</label>

						<div class="col-lg-6">
							<input class="form-control" type="text"
								value="<%=bean.getPhotolink()%>" name="txtBookPhotoLink" />${photoLink}
						</div>
					</div>
					<br />

					<div class="row">
						<label class="col-sm-2"> <font size="+1">Enter URL
								Link :</font>
						</label>

						<div class="col-lg-6">
							<input class="form-control" type="text"
								value="<%=bean.getUrllink()%>" name="txtBookURLLink" />${URLLink}
						</div>
					</div>
					<br />

					<div class="row">
						<label class="col-sm-2"> <font size="+1">Enter
								Author :</font>
						</label>

						<div class="col-lg-6">
							<input class="form-control" type="text"
								value="<%=bean.getAuthor()%>" name="txtBookAuthor" />${author}
						</div>
					</div>
					<br />

					<div class="row">
						<label class="col-sm-2"> <font size="+1">Enter ISBN
								:</font>
						</label>

						<div class="col-lg-6">
							<input class="form-control" type="text"
								value="<%=bean.getIsbn()%>" name="txtBookISBN" />${isbn}
						</div>
					</div>
					<br />

					<div class="row">
						<label class="col-sm-2"> <font size="+1">Enter
								Description :</font>
						</label>

						<div class="col-lg-6">
							<textarea class="form-control" rows="5" cols="50"
								name="txtBookDescription"><%=bean.getDescription()%></textarea>${description}
						</div>
					</div>
					<br /> <br /> <label class="col-sm-2 control-label"></label> <input
						type="reset" value="Reset" name="reset" class="btn  btn-danger">
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<input type="Submit" value="Add" name="submit"
						class="btn btn-success">

				</form>
				<%
					} else {
						System.out.print("hello");

					}
				%>
			</div>
		</div>
	</div>
</body>
</html>
