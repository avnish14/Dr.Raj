<%@page import="DrRAJ.Bean.BookKeywordBean"%>
<%@page import="DrRAJ.DAO.BookDAO"%>
<%@page import="DrRAJ.Bean.BookBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Book Keyword Update</title>
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
			Book Keyword <small>Update</small>
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
					BookKeywordBean bean = (BookKeywordBean) request.getAttribute("bookKeywordBean");
					if (bean != null) {
				%>
				<form action="BookKeywordUpdateServlet" method="post">
					<input type="hidden" name="bookKeywordId"
						value="<%=bean.getBookKeywordId()%>"> <br />
					<div class="row">
						<label class="col-sm-2"> <font size="+1">Enter Key
								word :</font>
						</label>

						<div class="col-lg-6">
							<input type="text" class="form-control"
								value="<%=bean.getKeyword()%>" name="txtKeyword" />${keyWord}
						</div>
					</div>


					<br />

					<div class="row">
						<label class="col-sm-2"> <font size="+1">Book :</font>
						</label>
						<div class="col-lg-6">
							<select name="bookId" class="form-control" id="bookId">
								<option value="0">Select Book</option>
								<%
									List<BookBean> listOfBook = new BookDAO().getList();

										if (listOfBook != null) {
											for (BookBean t : listOfBook) {
												String s = t.getName() + "-" + t.getAuthor();
												if (t.getBookId().equals(bean.getBookId())) {
								%>
								<option value="<%=t.getBookId()%>" selected="selected"><%=s%></option>
								<%
									} else {
													System.out.println("h " + bean.getBookId());
								%>
								<option value="<%=t.getBookId()%>"><%=s%></option>
								<%
									}
											}
										}
								%>
							</select> <font color="red">${book}</font>
						</div>
					</div>
					<br /> <br /> <br /> <br /> <label
						class="col-sm-2 control-label"></label> <input type="reset"
						value="Reset" name="reset" class="btn  btn-danger">
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