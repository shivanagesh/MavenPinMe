<!Doctype html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <script src="js/jquery-1.12.1.min.js"></script>
    <link rel="stylesheet" href="stylesheet.css">
    <link rel="icon" href="images/pinfavicon.ico" />
    <title>Pin Me- My Events</title>
</head>
<body class="padding">
<header class="adjust">
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
                <li><a href="/pinme/Event"> My Events</a> </li>
                <li><a href="Logout"> Logout</a> </li>
            </ul>
        </div>
    </div>
</header>
<section class="divider">
</section>
<section>
    <table class="table">
        <thead class="thead-inverse">
        <tr>
            <th>#</th>
            <th>Event Name</th>
            <th>Description</th>
            <th>Start Time</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${sessionScope.userEvents}" var="userEvent">
            <tr>
                <th scope="row"> <c:out value="${userEvent.id}"/> </th>
                <td><c:out value="${userEvent.name}"/></td>
                <td><c:out value="${userEvent.description}"/></td>
                <td><c:out value="${userEvent.startDateTime}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


</section>
<footer>
    @CopyRights:Pin Me <br>
    developed by Prathyusha Rani,Prathyusha,Shiva & Divya
</footer>
<script type="text/javascript" src="js/app.js"></script>
</body>
</html>
