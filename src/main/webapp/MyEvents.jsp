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
<form name="form1" action="Check" method="Post">
    <section class="category">
        <label>Catergory </label>
        <select name="Catergory" id="Catergory" onchange="document.form1.submit()">
            <option value="None selected">Please select below</option>
            <option value="Food">Food</option>
            <option value="Clothing">Clothing</option>
            <option value="Entertainment">Entertainment</option>
            <option value="recreation">Recreation</option>
        </select>
    </section>
</form>
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
