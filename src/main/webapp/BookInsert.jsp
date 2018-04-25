<%@page import="DrRAJ.DAO.BookTypeDAO"%>
<%@page import="DrRAJ.Bean.BookTypeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Book Insert</title>
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
			Book <small>Insert</small>
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
				<form action="BookInsertServlet" method="post">
					<br />
					<div class="row">
						<label class="col-sm-2"> <font size="+1">Enter
								Name:</font>
						</label>

						<div class="col-lg-6">
							<input type="text" class="form-control" value="${txtBookName}"
								name="txtBookName" />${name}
						</div>
					</div>
					<br />


					<%-- 					<div class="row">
						<label class="col-sm-2"> <font size="+1">Enter Type
								:</font>
						</label>

						<div class="col-lg-6">
							<input class="form-control" type="text" value="${txtBookType}"
								name="txtBookType" />${type}
						</div>
					</div>
					<br />
 --%>

					<div class="row">
						<label class="col-sm-2"> <font size="+1">Select
								Book Type</font>
						</label>
						<div class="col-lg-6">
							<select name="txtBookType" class="form-control">
								<option value="0" selected="selected">Select Book Type</option>
								<%
									List<BookTypeBean> bookTypeList = new BookTypeDAO().getList();
									for (int i = 0; i < bookTypeList.size(); i++) {

										String tmp = "unselected";
										String type = request.getParameter("txtBookType");
										if (type == null || type.equals("0"))
											tmp = "unselected";
										else if (bookTypeList.get(i).getName().equals(type))
											tmp = "selected";
								%>

								<option value="<%=bookTypeList.get(i).getName()%>" <%=tmp%>>
									<%=bookTypeList.get(i).getName()%></option>
								<%
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
							<input class="form-control imagetester" type="text"
								value="${txtBookPhotoLink}" name="txtBookPhotoLink" target=".imagetarget" />${photoLink}
						</div>
						<div class="col-md-3">
							<img src="" alt="Image not found" class="imagetarget"
								style="max-height: 200px; max-width: 200px;" />
						</div>
					</div>
					<br />

					<div class="row">
						<label class="col-sm-2"> <font size="+1">Enter URL
								Link :</font>
						</label>

						<div class="col-lg-6">
							<input class="form-control" type="text" value="${txtBookURLLink}"
								name="txtBookURLLink" />${URLLink}
						</div>
					</div>
					<br />

					<div class="row">
						<label class="col-sm-2"> <font size="+1">Enter
								Author :</font>
						</label>

						<div class="col-lg-6">
							<input class="form-control" type="text" value="${txtBookAuthor}"
								name="txtBookAuthor" />${author}
						</div>
					</div>
					<br />

					<div class="row">
						<label class="col-sm-2"> <font size="+1">Enter ISBN
								:</font>
						</label>

						<div class="col-lg-6">
							<input class="form-control" type="text" value="${txtBookISBN}"
								name="txtBookISBN" />${isbn}
						</div>
					</div>
					<br />

					<div class="row">
						<label class="col-sm-2"> <font size="+1">Enter
								Description :</font>
						</label>

						<div class="col-lg-6">
							<textarea class="form-control" rows="5" cols="50"
								name="txtBookDescription">${txtBookDescription}</textarea>${description}
						</div>
					</div>
					<br /> <br /> <label class="col-sm-2 control-label"></label> <input
						type="reset" value="Reset" name="reset" class="btn  btn-danger">
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<input type="Submit" value="Add" name="submit"
						class="btn btn-success">

				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$("body").on("change leave input", ".imagetester", function() {
		var target = $($(this).attr("target"));
		target.attr("src", $(this).val());
	});
	var link = $(".imagetester").val();
	if (link != "") {
		$(".imagetarget").attr("src", link);
	}
</script>
</html>
