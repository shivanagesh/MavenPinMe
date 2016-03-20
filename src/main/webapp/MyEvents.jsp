<!Doctype html>
<html>

<head>
    <%@ include file="import.jsp" %>
    <%@ include file="SessionCheck.jsp" %>
    <%@ include file="header.jsp" %>

    <title>Pin Me</title>
</head>

<body class="padding">
<section class="divider">
</section>
<section class="coupon">
    <ul id="couponlist" class="myevents">
    </ul>
</section>
<script type="text/javascript" src="js/homepage.js"></script>
<script type="text/javascript">
    $.getJSON( "MyEvents", {UserId: "<%=session.getAttribute("userid")%>"}, function( data ) {
        loadMyEvents(data);
    });
</script>

</body>

</html>
