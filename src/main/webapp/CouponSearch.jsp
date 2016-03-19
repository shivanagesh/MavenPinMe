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
    <form name="form1" id="searchForm" action="Search" method="post">
<label><input type="text" class="searchbar" id="searchelement" name="searchelement" placeholder="Event Name"></label>
<button type="submit"><i class="fa fa-search"></i></button>
</form>
    </section>
        <section class="coupon" >
        <ul id="couponlist" style="display:none">
        </ul>
    </section>
    <script type="text/javascript" src="js/homepage.js"></script>
<script type="text/javascript">

var userid = "<%=session.getAttribute("userid")%>";

 $( "#searchForm" ).submit(function( event ) {
	 
	  event.preventDefault();
	  $.ajax({
		  url: "/pinme/Search?searchelement="+$("#searchelement").val()
		}).done(function(data) {
			$('#couponlist').empty();
			 document.getElementById("couponlist").style.display="block";
			 loadSearchData(data, userid);
		});
	  
});


</script>
</body>
</html>
