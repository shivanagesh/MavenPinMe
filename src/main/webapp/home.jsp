<!Doctype html>
<html>
<head>
<%@ include file="import.jsp"%>
<%@ include file="SessionCheck.jsp"%>
<%@ include file="header.jsp"%>
</head>
<body class="padding">
	<section class="divider"></section>
	<form name="form1" id="categoryform" action="Check" method="post">
		<section class="category">
			<label>Category </label> <select name="Catergory" id="Catergory">
				<option value="All"selected">Please select below</option>
				<option value="Food">Food</option>
				<option value="Clothing">Clothing</option>
				<option value="Entertainment">Entertainment</option>
				<option value="Recreation">recreation</option>
			</select>
		</section>
	</form>
	<section class="coupon">
		<ul id="couponlist">
		</ul>
	</section>
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel"></h4>
				</div>
				<div class="modal-body">
					<div>
						<label>Event Date: <span id="eventDate"></span></label>
					</div>
					<div>
						<label>Event Time: <span id="eventTime"></span></label>
					</div>
					<div>
						<label>Event Address: <span id="eventAddress"></span></label>
					</div>
					<div>
						<label>Event Description: <span id="eventDescription"></span></label>
					</div>
					<div>
						<label>Event Category: <span id="eventCategory"></span></label>
					</div>
					<div>
						<label id="couponfield">Event coupons Left : <span
							id="eventcoupon"></span></label>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" id="pinButton"  class="btn btn-primary" onclick="newevents()">Pin
						Event</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/homepage.js"></script>
	<script type="text/javascript">
		var userid = "<%=session.getAttribute("userid")%>";
		var eventdata, selectedevent;
		function updateCouponList() {
			$.ajax({
				url : "/pinme/Check?Catergory=" + $("#Catergory").val()
			}).done(function(data) {
				eventdata = data;
				$('#couponlist').empty();
				loadData(data, userid);
			});
		}

		$(document).ready(function() {
			updateCouponList()
		});

		function newevents() {
			newevent(userid, selectedevent);
		}
		$("#categoryform").submit(function(event) {
			event.preventDefault();

			updateCouponList();
		});

		$("select#Catergory").on('change', function(event) {
			event.preventDefault();
			updateCouponList();
		});

		/* $('#my-modal').modal({
		 show: 'false'
		 }); */

		$('#couponlist').on('click', 'li', function(event) {
			var data = {};
			if ($(event.target).is('img')) {
				data = $(event.target).parent('li').data("info");
			} else {
				data = $(event.target).data("info");
			}
			
			data = JSON.parse(decodeURIComponent(data))
			
			$('#myModalLabel').html(data.Name);
			$('#eventDate').html(data.Date);
			$('#eventTime').html(data.Time);
			$('#eventAddress').html(data.Location);
			$('#eventDescription').html(data.Description);
			$('#eventCategory').html(data.category);
			var limited = data.Limit;
			selectedevent = data.Id;
			if(!data.isTokenized){
				$('#eventcoupon').html("No coupons are needed, it's Public event");
				$('#myModal').find('#pinButton').css('display', 'none');
			}
			else if (limited <= 0) {
				$('#eventcoupon').html("You missed it, no more coupons, better luck next time");
				$('#myModal').find('#pinButton').css('display', 'none');
			} else {
				$('#eventcoupon').html(data.Limit);
				$('#couponfield').css('display', 'inline');
				$('#myModal').find('#pinButton').css('display', 'inline');

			}
			
			$('#myModal').modal('show');
		})
	</script>
</body>

</html>
