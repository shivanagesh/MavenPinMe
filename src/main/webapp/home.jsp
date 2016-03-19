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
<form name="form1" id="categoryform" action="Check" method="post">
    <section class="category">
      <label>Category </label>
  <select name="Catergory" id="Catergory">
   <option value="All" selected">Please select below</option>
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
var userid = "<%=session.getAttribute("userid")%>";
function updateCouponList() {
	  $.ajax({
		  url: "/pinme/Check?Catergory="+$("#Catergory").val()
		}).done(function(data) {
			$('#couponlist').empty();
			loadData(data, userid);
		});
}

$(document).ready(function(){
	updateCouponList()
});


   $("#categoryform").submit(function(event) {
	event.preventDefault();
  	  
	updateCouponList();
  });
  
$("select#Catergory").on('change', function(event){
	event.preventDefault();  
	updateCouponList();
});    
</script>
</body>

</html>
