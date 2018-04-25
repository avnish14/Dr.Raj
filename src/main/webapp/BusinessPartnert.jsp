<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.textbox{margin-bottom:25px!important;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Us | Dr. Raj Homoeo Pharmacy</title>
<%@include file="UserHeader.jsp"%>
<body>
	<section class="bgimage maincover regular"
		style="background-image: url(https://farm5.staticflickr.com/4606/40468139451_ae8bdbf2fd_o_d.jpg);">
	<div class="blackcover"></div>
	<div class="container">
		<h3>About Us</h3>
		<div class="jumbotext">Contact Us</div>
	</div>
	<div class="posab">
		<img src="imgs/bottomwhitecircle.svg"/>
	</div>
	</section>
	<section>
	<div class="container thousand">
		<div class="tcenter hidden successmsg">
			<br> <br> <br> <br>
			<h2>Thank You</h2>
			<div style="font-size: 32px;">Your response has been saved, we
				will contact you soon.</div>
			<br> <br> <br> <br>
		</div>
		<div class="tcenter failmsg hidden">
			<br> <br> <br> <br>
			<h2>Sorry</h2>
			<div style="font-size: 32px;">Your response has not been saved,
				please try again later.</div>
			<br> <br> <br> <br>
		</div>
		<div class="row">
			<div class="cm8">
				<div class="formcontainer">
					<div class="row">
						<div class="cm6 nomargin">
							<label class="label">Your Domain*</label> <select
								class="textbox domainbox">
								<option value="0" selected>Select your domain</option>
								<option value="Pharmacy Retailers / Dealers / Distributors">Pharmacy
									Retailers / Dealers / Distributors</option>
								<option value="Pharmaceutical Companies">Pharmaceutical
									Companies</option>
								<option value="Ad / Media Agencies">Ad / Media Agencies</option>
								<option value="Diagnostic Labs">Diagnostic Labs</option>
								<option value="Others">Others</option>
							</select>
						</div>
						<div class="cm6 nomargin">
							<label class="label">Name of Organization</label> <input
								type="text" class="textbox namebox" />
						</div>
					</div>
					<label class="label">Brief your query / proposal*</label>
					<textarea class="textbox querybox" rows="8" maxlength="1000"></textarea>
					<div class="row">
						<div class="cm6 nomargin">
							<label class="label">Email*</label> <input type="text"
								class="textbox emailbox" />
						</div>
						<div class="cm6 nomargin">
							<label class="label">Contact No.*</label> <input type="text"
								class="textbox cntbox" />
						</div>
					</div>
					<div class="tcenter">
						<span class="error bold hidden" style="color: crimson;">Please
							complete the mandatory information marked in asterisk(*)<br> </b>
						</span> <br> <input type="button"
							class="button responsive sendbutton blue bordered" value="SUBMIT" />
					</div>
				</div>
			</div>
			<div class="cm4">
				<img src="imgs/logo.svg"
					style="max-width: 200px; margin-bottom: 13px;" />
				<table class="contractInfo">
					<tr>
						<td style="vertical-align: top;"><span class="bold">Tel:
						</span></td>
						<td>+91 72288 66904<br>+91 70699 95785
						</td>
					</tr>
					<tr>
						<td style="vertical-align: top;"><span class="bold">Email:
						</span></td>
						<td>stayhealthy@drrajglobal.com</td>
					</tr>
					<tr>
						<td style="vertical-align: top;"><span class="bold">Hours:
						</span></td>
						<td>Monday - Saturday<br>9 AM - 7 PM
						</td>
					</tr>
				</table>
				<div style="margin-bottom: 13px;">
					<span class="bold inblock">Operation & Distribution
						Information</span><br> Email : operation@drrajglobal.com<br>Tel
					: +91 99254 96904
				</div>
				<div style="margin-bottom: 13px;">
					<span class="bold inblock">Sales & Marketing Information</span><br>
					Email : sales@drrajglobal.com <br>Tel : +91 70699
					95785, +91 72288 66904, +91 94263 64460
				</div>
				<div style="margin-bottom: 13px;">
					<span class="bold inblock">Press/Media Inquiries</span><br>Please email us at mediainfo@drrajglobal.com
				</div>
				<div style="margin-bottom: 13px;">
					<span class="bold inblock">Career</span><br>Email us to see job openings career@drrajglobal.com
				</div>
			</div>
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
							$(this).val("Submitting...");
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
			if ($(this).val() == "Others") {
				$(".namebox").attr("disabled", "true");
			} else {
				$(".namebox").removeAttr("disabled");
			}
		});
	</script>
</body>
</html>