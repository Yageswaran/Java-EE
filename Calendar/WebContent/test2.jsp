<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<link href='/Calendar/test/fullcalendar-2.2.3/fullcalendar.css'
	rel='stylesheet' />
<link href='/Calendar/test/fullcalendar-2.2.3/fullcalendar.print.css'
	rel='stylesheet' media='print' />
<script src='/Calendar/test/fullcalendar-2.2.3/lib/moment.min.js'></script>
<script src='/Calendar/test/fullcalendar-2.2.3/lib/jquery.min.js'></script>
<script src='/Calendar/test/fullcalendar-2.2.3/fullcalendar.min.js'></script>
<script>
	function go(i) {
		var form = document['HiddenForm'];
		//String d = (i + j + k);
		form['date'].value = i;
		form.submit();
	}
	$(document).ready(function() {

		try {
			$('#calendar').fullCalendar({

				dayClick : function(date, jsEvent, view) {
					//alert('Clicked on: ' + date.format());
					// change the day's background color just for fun
					//$(this).css('background-color', 'orange');
					go(date.format());

				},
				events : {

					url : '/Calendar/calevent'
					
					
				}

			});
		} catch (e) {
			alert(e.message);
		}

		//-
		//$("td.fc-day").click(function() {

		//var x = $( "td.fc-widget-content" );

		//console.log($(x).html);
		//$(this).css('background-color', 'orange');
		//$(this).js.date;
		//alert('Clicked on: ' + date.format());
		//$(this).js.date;
		//console.log("clicked");
		//});

		//-

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

	<form name="HiddenForm" action="Calendar.do?method=Remark"
		method="post">
		<input type="hidden" name="date" />
	</form>
	<div id='script-warning'></div>
	<div id='calendar'></div>

</body>
</html>