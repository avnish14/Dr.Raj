<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DrRAJ.Bean.ReviewBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reviews</title>
</head>
<%@include file="AdminHeader.jsp"%>
<section class="content content-header">
<h1>Reviews</h1>
<br>
<br>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-body">
				<table id="example1"
					class="table table-bordered table-hover table-striped">
					<thead class="gujju-theme text-uppercase">
						<tr>
							<th>Customer Name</th>
							<th>Product Name</th>
							<th>Title</th>
							<th>Rating</th>
							<th>Description</th>
							<th>IsValid</th>
							<th>ACTION</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<ReviewBean> listOfReview = (ArrayList) request.getAttribute("reviewList");

							if (listOfReview != null) {
								for (int i = 0; i < listOfReview.size(); i++) {
									ReviewBean review = listOfReview.get(i);
						%>
						<tr>
							<td><%=review.getCustomerName()%></td>
							<td><%=review.getProductName()%></td>
							<td><%=review.getTitle()%></td>
							<td><%=review.getRating()%></td>
							<td><%=review.getDescription()%></td>
							<td>
								<%
									if (review.getIsValid().equals("1")) {
								%> <input type="button" target="<%=review.getReviewId()%>"
								targetValue="0" class="btn btn-success reviewStateChangeButton"
								value="Yes" /> <%
 	} else {
 %> <input type="button" target="<%=review.getReviewId()%>"
								targetValue="1" class="btn btn-danger reviewStateChangeButton"
								value="No" /> <%
 	}
 %>
							</td>
							<td><a
								href="ReviewDeleteServlet?reviewId=<%=review.getReviewId()%>"><img
									src="imgs/delete.svg" height="30" width="30"
									class="img-rounded" /></a></td>
						</tr>
						<%
							}
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
<script type="text/javascript" src="js/code.js"></script>
<script type="text/javascript">
		$("body").on("click",".reviewStateChangeButton",function(){
			if(!$(this).hasClass("disabled")){
				var reviewId=$(this).attr("target");
				var value=$(this).attr("targetValue");
				var me=$(this);
				$(this).val("Wait");
				$(this).addClass("disab btn-warning");
				callAjax("AJAXServlet?method=reviewUpdate&reviewId="+reviewId+"&value="+value,function(data,extra=me){
					if(data=="1"){
						$(extra).removeClass("disab btn-warning btn-danger btn-success");
						var value=$(extra).attr("targetValue");
						if(value=="1"){
							$(extra).addClass("btn-success");
							$(extra).val("Yes");
							$(extra).attr("targetValue","0");
						}
						else{
							$(extra).addClass("btn-danger");
							$(extra).val("No");
							$(extra).attr("targetValue","1");
						}
					}
				});
			}
		});
	</script>
</body>
</html>
