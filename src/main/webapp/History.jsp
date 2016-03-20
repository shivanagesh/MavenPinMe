<!Doctype html>
<html>

<head>
<%@ include file="import.jsp"%>
<%@ include file="header.jsp"%>
<%@ include file="SessionCheck.jsp" %>
<title>Pin Me</title>
</head>
<body class="padding">
	<section class="divider"></section>

	<section class="setting">
		<div>Your Past Coupons Are</div>
		<section class="coupon">
			<ul id="couponlist">
			</ul>
		</section>
	</section>
	<footer>
		@CopyRights:Pin Me <br> developed by Prathyusha
		Rani,Prathyusha,Shiva & Divya
	</footer>

</body>
<script type="text/javascript" src="js/homepage.js"></script>
<script type="text/javascript">
 	$.getJSON( "History", {UserId: "<%=session.getAttribute("userid")%>"}, function( data ) {
 		loadHistory(data);
	});
</script>
</html>
