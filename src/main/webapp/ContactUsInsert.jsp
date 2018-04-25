<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homoeopathic Consultancy | Dr. Raj Homoeo Pharmacy</title>
<%@include file="UserHeader.jsp"%>
<body>
	<section class="bgimage maincover regular"
		style="background-image: url(https://farm5.staticflickr.com/4632/38663167720_cf21ac38f0_o_d.jpg);">
	<div class="blackcover"></div>
	<div class="container">
		<div class="jumbotext">Homoeopathic Consultancy</div>
	</div>
	<div class="posab">
		<img src="imgs/bottomwhitecircle.svg" />
	</div>
	</section>
	<section>
	<div class="container tcenter hidden successmsg">
		<br>
		<br>
		<br>
		<br>
		<h2>Thank You</h2>
		<div style="font-size: 2em;">Your response has been recorded, we
			will contact you soon.</div>
		<br>
		<br>
		<br>
		<br>
	</div>
	<div class="container tcenter failmsg hidden">
		<br>
		<br>
		<br>
		<br>
		<h2>Sorry</h2>
		<div style="font-size: 2em;">Your response has not been
			recorded, please try again later.</div>
		<br>
		<br>
		<br>
		<br>
	</div>
	<div class="container formcontainer" style="max-width: 800px;">
		<div class="row">
			<div class="cm6 nomargin">
				<label class="label">Name*</label> <input type="text"
					class="textbox namebox" />
			</div>
			<div class="cm6 nomargin">
				<label class="label">Email*</label> <input type="text"
					class="textbox emailbox" />
			</div>
		</div>
		<label class="label">Question*</label>
		<textarea class="textbox questionbox" rows="5" maxlength="1000"></textarea>
		<div class="tcenter">
			<span class="error bold hidden" style="color: crimson;">Please
				complete the mandatory information marked in asterisk(*)<br> <br>
				</b>
			</span> <input type="button" class="button responsive sendbutton blue"
				value="SUBMIT" />
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
						var email = $(".emailbox").val();
						var question = $(".questionbox").val();
						if (name == "" || email == "" || question == "") {
							$(".error").removeClass("hidden");
						} else {
							sendflag = true;
							$(this).val("Submitting...");
							$(".error").addClass("hidden");
							callAjax("AJAXServlet?method=contactUsInsert&name="
									+ name + "&emailId=" + email + "&query="
									+ question, function(data) {
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
		$(".namebox,.emailbox,.questionbox").keyup(function() {
			$(".error").addClass("hidden");
		});
	</script>
</body>
</html>