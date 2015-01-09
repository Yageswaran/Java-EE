<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<link href='../Calendar/test/fullcalendar-2.2.3/fullcalendar.css'
	rel='stylesheet' />
<link href='../Calendar/test/fullcalendar-2.2.3/fullcalendar.print.css'
	rel='stylesheet' media='print' />
<script src='../Calendar/test/fullcalendar-2.2.3/lib/moment.min.js'></script>
<script src='../Calendar/test/fullcalendar-2.2.3/lib/jquery.min.js'></script>
<script src='../Calendar/test/fullcalendar-2.2.3/fullcalendar.min.js'></script>
<script>
	$(document).ready(function() {

		$('#calendar').fullCalendar({

			editable : true,
			eventLimit : true, // allow "more" link when too many events

			/* dayClick : function(date, jsEvent, view) {

				alert('Clicked on: ' + date.format());

				// change the day's background color just for fun
				$(this).css('background-color', 'orange');
				
			

			} */
			events : [ {
				"title" : "Half-Day leave",
				"start" : "2015-01-06T08:00",
				"end" : ""
			}, {
				"title" : "Emergency leave",
				"start" : "2015-01-10T",
				"end" : ""
			}, {
				"title" : "0",
				"start" : "0",
				"end" : ""
			}, ]

		});

	});
</script>
<style>
body {
	margin: 40px 10px;
	padding: 0;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 900px;
	margin: 0 auto;
}
</style>
</head>
<body>

	<div id='calendar'></div>

</body>
</html>