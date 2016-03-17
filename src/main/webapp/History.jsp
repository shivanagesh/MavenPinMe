<!Doctype html>
<html>

<head>
<%@ include file="import.jsp"%>
    <title>Pin Me</title>
</head>
<body class="padding">
<header class="adjust">
<div class="icon">
<img src="images/icon.png" alt="pin image">
</div>
<h1 class="header">Pin Me!</h1>
        <div class="user">
            <button class="account"><i class="fa fa-user fa-3x"></i></button>
            <div class="user-content">
                <ul>
             <li><a href="home.html">Home</a></li>
                    <li><a href="History.html">History</a></li>
                    <li><a href="postAd.jsp">Post Event</a></li>
                    <li><a href="CouponSearch.html">Find Event</a></li>
                    <li><a href="/pinme/Event"> My Events</a> </li>
                    <li><a href="Logout"> Logout</a> </li>
                      </ul>
            </div>
        </div>
    </header>
<section class="divider">
</section>

    <section class="setting">
        <div>Your Past Coupons Are</div>
        <ul class="past">
        </ul>
    </section>
    <footer>
@CopyRights:Pin Me <br>
 developed by Prathyusha Rani,Prathyusha,Shiva & Divya
</footer>
</body>

</html>
