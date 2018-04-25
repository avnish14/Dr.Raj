<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashSet"%>
<%@page import="DrRAJ.DAO.BookTypeDAO"%>
<%@page import="DrRAJ.Bean.BookBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Mind, Body & Spirit | Dr. Raj Homoeo Pharmacy</title>
<%@include file="UserHeader.jsp"%>
<section class="bgimage maincover regular"
	style="background-image: url(https://farm5.staticflickr.com/4744/26597342428_be0c40a818_o_d.jpg);">
<div class="blackcover"></div>
<div class="container">
	<h3>Health and Homoeopathy</h3>
	<div class="jumbotext">Mind, Body & Spirit</div>
</div>
<div class="posab">
	<img src="imgs/bottomwhitecircle.svg" />
</div>
</section>
<section>
<div class="container thousand">
	<div class="row">
		<div class="cs6 cm4 bookTitle">
			<a href="chakras-kundalini">
				<div class="bgimage"
					style="background-image: url('imgs/chakras-kundalini.jpg');">
					<h3>Chakras Kundalini</h3>
					<div class="blackback"></div>
				</div>
			</a>
		</div>
		<div class="cs6 cm4 bookTitle">
			<a href="yoga">
				<div class="bgimage" style="background-image: url('imgs/yoga.jpg');">
					<h3>Yoga</h3>
					<div class="blackback"></div>
				</div>
			</a>
		</div>
		<div class="cs6 cm4 bookTitle">
			<a href="buddhism-meditation">
				<div class="bgimage"
					style="background-image: url('imgs/buddhism-meditation.jpg');">
					<h3>Buddhism Meditation</h3>
					<div class="blackback"></div>
				</div>
			</a>
		</div>
		<div class="cs6 cm4 bookTitle">
			<a href="spiritual-philosophy">
				<div class="bgimage"
					style="background-image: url('imgs/spiritual-philosophy.jpg');">
					<h3>Spiritual Philosophy</h3>
					<div class="blackback"></div>
				</div>
			</a>
		</div>
		<div class="cs6 cm4 bookTitle">
			<a href="eating-disorder">
				<div class="bgimage"
					style="background-image: url('imgs/eating-disorder.jpg');">
					<h3>Eating Disorder</h3>
					<div class="blackback"></div>
				</div>
			</a>
		</div>
		<div class="cs6 cm4 bookTitle">
			<a href="psychology-relationship">
				<div class="bgimage"
					style="background-image: url('imgs/psychology-relationship.jpg');">
					<h3>Psychology Relationship</h3>
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