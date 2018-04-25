<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ReviewInsertServlet" method="post">
		Customer Name:<input type="text" name="txtCustomerName"
			value="${txtCustomerName}">${customerName}<br /> <br />Title
		<input type="text" name="txtTitle" value="${txtTitle}">${title}<br />
		Product:<input type="text" name="txtProductId" value="${txtProductId}">${productId}<br />
		<br /> Rating:<input type="text" name="txtRating"
			value="${txtRating}">${rating}<br />
		<br /> Customer Name:
		<textarea cols="50" rows="5" name="txtDescription">${txtDescription}</textarea>${description}<br />
		<br /> <input type="submit">
	</form>
</body>
</html>