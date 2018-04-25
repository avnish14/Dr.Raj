<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>404 Page Not Found | Dr. Raj Homoeo Pharmacy</title>
<%@include file="UserHeader.jsp"%>
<body>
	<section class="bgimage"
		style="background-image: url(https://farm5.staticflickr.com/4758/26597341938_f5594beb73_o_d.jpg);">
	<div class="blackcover opaq2"></div>
	<div class="container posrel" style="z-index: 2;">
		<br> <br> <br> <br>
		<div class="tcenter fgwhite jumbotext text-2"
			style="margin-bottom: 40px;">): 404 :(</div>
		<br> <br> <br>
	</div>
	<div class="posab overhidden"
		style="z-index: 3; width: 100%; bottom: -7px;">
		<img src="imgs/bottomwhitecircle.svg" class="posrel"
			style="width: 120%; left: -10%" />
	</div>
	</section>
	<section>
	<div class="container">
		<div class="tcenter">
			<br> <br>
			<h1>:(</h1><br>
			<h2>Sorry, Page Not Found</h2>
			<div style="font-size: 2em;">We can't find whatever you are searching.</div>
			<br> <br>
		</div>
	</div>
	</section>
	<%@include file="UserFooter.jsp"%>
	<script type="text/javascript">
		var sendflag = false;
		$(".sendbutton").click(
				function() {
					if (!sendflag) {
						var name = $(".namebox").val();
						var domain = $(".domainbox").val();
						var email = $(".emailbox").val();
						var query = $(".querybox").val();
						var cnt = $(".cntbox").val();
						if (name == "")
							name = "-";
						if (domain == "0" || email == "" || query == ""
								|| cnt == "") {
							$(".error").removeClass("hidden");
						} else {
							sendflag = true;
							$(this).val("Sending...");
							$(".error").addClass("hidden");
							callAjax("AJAXServlet?method=businessPInsert&name="
									+ name + "&emailId=" + email + "&query="
									+ query + "&domain=" + domain
									+ "&contactNumber=" + cnt, function(data) {
								$(".formcontainer").addClass("hidden");
								if (data == "true") {
									$(".successmsg").removeClass("hidden");
								} else {
									$(".failmsg").removeClass("hidden");
								}
							});
						}
					}
				});
		$(".namebox,.emailbox,.querybox,.cntbox").keyup(function() {
			$(".error").addClass("hidden");
		});
		$(".domainbox").change(function() {
			$(".error").addClass("hidden");
		});
	</script>
</body>
</html>