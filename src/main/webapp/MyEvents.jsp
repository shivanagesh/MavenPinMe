<!Doctype html>
<html>

<head>
    <%@ include file="import.jsp" %>
    <%@ include file="SessionCheck.jsp" %>
    <%@ include file="header.jsp" %>

    <title>Pin Me</title>
</head>

<body class="padding">
<!-- <header class="adjust">
    <div class="icon">
        <img src="images/icon.png" alt="pin image">
    </div>
    <h1 class="header">Pin Me!</h1>
    <div class="user">
        <button class="account"><i class="fa fa-user"></i></button>
        <div class="user-content">
            <ul>
                <li><a href="home.jsp">Home</a></li>
                <li><a href="History.jsp">History</a></li>
                <li><a href="postAd.jsp">Post Event</a></li>
                <li><a href="CouponSearch.jsp">Find Event</a></li>
                <li><a href="myevents.jsp"> My Events</a> </li>
                <li><a href="Logout"> Logout</a> </li>
            </ul>
        </div>
    </header> -->
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
            <option value="recreation">recreation</option>
        </select>
    </section>
</form>
<section class="coupon">
    <ul id="couponlist">
    </ul>
</section>
<footer>
    @CopyRights:Pin Me
    <br> developed by Prathyusha Rani,Prathyusha,Shiva  Divya
</footer>
<script type="text/javascript" src="js/homepage.js"></script>
<script type="text/javascript">
    $.getJSON( "PinEvent", {UserId: "<%=session.getAttribute("userid")%>"}, function( data ) {
        loadMyEvents(data);
    });
</script>
</script> -->
</body>

</html>
