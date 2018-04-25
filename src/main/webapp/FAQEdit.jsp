<%@page import="DrRAJ.Bean.FAQBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | FAQ Update</title>
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
			FAQ <small>Update</small>
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
					FAQBean bean = (FAQBean) request.getAttribute("faqBean");
					if (bean != null) {
				%>
				<form action="FAQUpdateServlet" method="post">
					<input type="hidden" name="faqId" value="<%=bean.getFaqId()%>">
					<br />
					<div class="row">
						<label class="col-sm-2"> <font size="+1">Enter
								Question :</font>
						</label>

						<div class="col-lg-6">
							<input type="text" class="form-control"
								value="<%=bean.getQuestion()%>" name="txtQuestion" />${question}
						</div>
					</div>
					<br />


					<div class="row">
						<label class="col-sm-2"> <font size="+1">Enter
								Answer:</font>
						</label>

						<div class="col-lg-6">
							<input class="form-control" type="text"
								value="<%=bean.getAnswer()%>" name="txtAnswer" />${answer}
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

					}
				%>
			</div>
		</div>
	</div>
</body>
</html>










<%-- <%@page import="DrRAJ.Bean.FAQBean"%>
<%@page import="DrRAJ.Bean.IngredientBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		FAQBean bean = (FAQBean) request.getAttribute("faqBean");
		if (bean != null) {
	%>
	<form action="FAQUpdateServlet">
		<input type="hidden" name="faqId" value="<%=bean.getFaqId()%>">
		<table>

			<tr>
				<td>Enter Question</td>
				<td><input type="text" name="txtQuestion"
					value="<%=bean.getQuestion()%>">${question}</td>
			</tr>
			<tr>
				<td>Enter Answer</td>
				<td><textarea rows="" cols="" name="txtAnswer"><%=bean.getAnswer()%></textarea>
					${answer}</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"></td>
			</tr>
		</table>
	</form>
	<%
		} else {

		}
	%>
</body>
</html> --%>