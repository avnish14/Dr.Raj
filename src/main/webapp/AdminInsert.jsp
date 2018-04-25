<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Admin Insert</title>
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
			Admin <small>Insert</small>
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
				<form action="AdminInsertServlet" method="post">
					<br />
					<div class="row">
						<label class="col-sm-2"> <font size="+1">Enter
								First Name :</font>
						</label>

						<div class="col-lg-6">
							<input type="text" class="form-control" value="${txtFirstName}"
								name="txtFirstName" />${firstName}
						</div>
					</div>
					<br />


					<div class="row">
						<label class="col-sm-2"> <font size="+1">Enter Last
								Name :</font>
						</label>

						<div class="col-lg-6">
							<input class="form-control" type="text" value="${txtLastName}"
								name="txtLastName" />${lastName}
						</div>
					</div>
					<br />


					<div class="row">
						<label class="col-sm-2"> <font size="+1">Enter
								Email Id :</font>
						</label>

						<div class="col-lg-6">
							<input class="form-control" type="text" value="${txtEmailId}"
								name="txtEmailId" />${emailId}
						</div>
					</div>
					<br />

					<div class="row">
						<label class="col-sm-2"> <font size="+1">Enter
								Password:</font>
						</label>

						<div class="col-lg-6">
							<input class="form-control" type="text" value="${txtPassword}"
								name="txtPassword" />${password}
						</div>
					</div>
					<br /> <br /> <br /> <label class="col-sm-2 control-label"></label>
					<input type="reset" value="Reset" name="reset"
						class="btn  btn-danger">
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<input type="Submit" value="Add" name="submit"
						class="btn btn-success">

				</form>
			</div>
		</div>
	</div>
</body>
</html>






<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="AdminInsertServlet" method="post">

		<table>

			<tr>
				<td>Enter First Name</td>
				<td><input type="text" name="txtFirstName"
					value="${txtFirstName}">${firstName}</td>
			</tr>

			<tr>
				<td>Enter Last Name</td>
				<td><input type="text" name="txtLastName"
					value="${txtLastName}">${lastName}</td>
			</tr>

			<tr>
				<td>Enter Email</td>
				<td><input type="text" name="txtEmailId" value="${txtEmailId}">${emailId}</td>
			</tr>

			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="txtPassword">${password}</td>
			</tr>
			<tr>
				<td colspan="2"><center>
						<input type="submit">
					</center></td>
			</tr>
		</table>

	</form>

</body>
</html> --%>