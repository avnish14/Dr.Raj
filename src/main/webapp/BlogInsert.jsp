<%@page import="DrRAJ.DAO.BookTypeDAO"%>
<%@page import="DrRAJ.Bean.BookTypeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Blog Insert</title>
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
			Blog <small>Insert</small>
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
				<form action="BlogInsertServlet" method="post">
					<br />
					<div class="row">
						<label class="col-sm-2"> <font size="+1">Enter
								Title:</font>
						</label>

						<div class="col-lg-6">
							<input type="text" class="form-control" value="${txtBlogTitle}"
								name="txtBlogTitle" />${title}
						</div>
					</div>

					<br />
					<div class="row">
						<label class="col-sm-2"> <font size="+1">Enter
								Photo Link :</font>
						</label>

						<div class="col-lg-6">
							<input class="form-control imagetester" type="text"
								value="${txtBlogPhotoLink}" name="txtBlogPhotoLink"
								target=".imagetarget" />${photoLink}
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
							<input class="form-control" type="text" value="${txtBlogURLLink}"
								name="txtBlogURLLink" />${URLLink}
						</div>
					</div>
					<br />

					<div class="row">
						<label class="col-sm-2"> <font size="+1">Enter Date
								:</font>
						</label>

						<div class="col-lg-6">
							<input class="form-control" type="text" value="${txtDate}"
								name="txtDate" />${date}
						</div>
					</div>
					<br />


					<div class="row">
						<label class="col-sm-2"> <font size="+1">Enter
								Content :</font>
						</label>

						<div class="col-lg-6">
							<textarea class="form-control" rows="15" cols="50"
								name="txtBlogContent">${txtBlogContent}</textarea>${content}
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
