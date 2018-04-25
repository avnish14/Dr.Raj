<%@page import="DrRAJ.DAO.BookTypeDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Homoeopathic Self-Help | Dr. Raj Homoeo Pharmacy</title>
<%@include file="UserHeader.jsp"%>
<section class="bgimage maincover regular"
	style="background-image: url(https://farm5.staticflickr.com/4744/26597342428_be0c40a818_o_d.jpg);">
<div class="blackcover"></div>
<div class="container">
	<h3>Health and Homoeopathy</h3>
	<div class="jumbotext">Homoeopathic Self-Help</div>
</div>
<div class="posab">
	<img src="imgs/bottomwhitecircle.svg" />
</div>
</section>
<section>
<div class="container thousand">
	<div class="row">
		<div class="cs6 cm4 bookTitle">
			<a href="first-aid-acutes">
				<div class="bgimage"
					style="background-image: url('imgs/first-aid-acutes.jpg');">
					<h3>First Aid Acutes</h3>
					<div class="blackback"></div>
				</div>
			</a>
		</div>
		<div class="cs6 cm4 bookTitle">
			<a href="homoeopathic-research">
				<div class="bgimage"
					style="background-image: url('imgs/homoeopathic-research.jpg');">
					<h3>Homoeopathic Research</h3>
					<div class="blackback"></div>
				</div>
			</a>
		</div>
		<div class="cs6 cm4 bookTitle">
			<a href="children">
				<div class="bgimage"
					style="background-image: url('imgs/children.jpg');">
					<h3>Children</h3>
					<div class="blackback"></div>
				</div>
			</a>
		</div>
		<div class="cs6 cm4 bookTitle">
			<a href="therapeutics">
				<div class="bgimage"
					style="background-image: url('imgs/therapeutics.jpg');">
					<h3>Therapeutics</h3>
					<div class="blackback"></div>
				</div>
			</a>
		</div>
		<div class="cs6 cm4 bookTitle">
			<a href="for-beginners">
				<div class="bgimage"
					style="background-image: url('imgs/for-beginners.jpg');">
					<h3>For Beginners</h3>
					<div class="blackback"></div>
				</div>
			</a>
		</div>
		<div class="cs6 cm4 bookTitle">
			<a href="general">
				<div class="bgimage"
					style="background-image: url('imgs/general.jpg');">
					<h3>General</h3>
					<div class="blackback"></div>
				</div>
			</a>
		</div>
	</div>
</div>
</section>
<%@include file="UserFooter.jsp"%>
</body>
</html>