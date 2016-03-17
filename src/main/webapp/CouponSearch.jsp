<!Doctype html>
<html>
<head>
    <%@ include file="import.jsp" %>
      <%@ include file="header.jsp" %>
</head>
<body class="padding">
<!-- <header>
<div class="icon">
<img src="images/icon.png" alt="pin image">
</div> -->
<!-- <h1 class="header">Pin Me!</h1>
        <div class="user">
            <button class="account"><i class="fa fa-user"></i></button>
            <div class="user-content">
                <ul>
                    <li><a href="home.jsp">Home</a></li>
                    <li><a href="History.jsp">History</a></li>
                    <li><a href="postAd.jsp">Post Event</a></li>
                    <li><a href="CouponSearch.jsp">Find Event</a></li>
                    <li><a href="/pinme/Event"> My Events</a> </li>
                    <li><a href="Logout"> Logout</a> </li>
                </ul>
            </div>
        </div>
    </header> -->
        <section class="divider">
    </section>
    <section class="searching">
    <form name="form1" action="Search" method="post">
<label><input type="text" class="searchbar" id="searchelement" name="searchelement" placeholder="category name" onblur="document.form1.submit()"></label>
<button onclick="getEventList()"><i class="fa fa-search" onclick="document.form1.submit()"></i></button>
</form>
        <section class="coupon" id="home">
        <ul id="couponlist">
        </ul>
    </section>
    </section>
    <script type="text/javascript" src="js/homepage.js"></script>
</body>
</html>
