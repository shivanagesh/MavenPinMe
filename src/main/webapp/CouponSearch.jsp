<!Doctype html>
<html>
<head>
    <%@ include file="import.jsp" %>  
    <%@ include file="SessionCheck.jsp" %>
      <%@ include file="header.jsp" %>
</head>
<body class="padding">
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
<script type="text/javascript">
    $.getJSON( "Search", function( data ) {
        loadData(data, "<%=session.getAttribute("userid")%>");
    });
</script>
</body>
</html>
