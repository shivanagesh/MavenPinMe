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

<script type="text/javascript" src="js/homepage.js"></script>
<script type="text/javascript">
    $.getJSON( "Event", function( data ) {
        loadData(data, "<%=session.getAttribute("userid")%>");
    });
</script>
<!-- <script>
    $(document).ready(function(){
	loadData();
});
/* var selected;
$('#Catergory').change(function(event){
	selected=$(this).val();
	alert("you have selected"+selected)});
	var selecting=document.getElementById("Catergory");
	var value=selecting.options[selecting.selectedIndex].text;
	alert("value using javascript"+value); */
    </script>
        $.getJSON( "Event", function( data ) {
            loadData(data);
        });
    });
</script> -->
</body>

</html>
