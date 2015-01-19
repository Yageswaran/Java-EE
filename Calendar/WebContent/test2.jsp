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
<script src='../Calendar/test/fullcalendar-2.2.3/fullcalendar.js'></script>
<script>
	function go(i) {
		var form = document['HiddenForm'];
		//String d = (i + j + k);
		form['date'].value = i;
		form.submit();
	}
	$(document)
			.ready(
					function() {

						try {
							$('#calendar')
									.fullCalendar(
											{

												dayClick : function(date,
														jsEvent, view) {
													//alert('Clicked on: ' + date.format());
													// change the day's background color just for fun
													//$(this).css('background-color', 'orange');
													go(date.format());

												},
												events : {

													url : '/Calendar/calevent'

												},
												eventClick : function(event,
														jsEvent, view) {
													// opens events in a popup window
													var eid = 'id=' + event.id;
													window
															.open(
																	'Calendar.do?method=EventShow&'
																			+ eid,
																	'Remarks',
																	'width=300,height=250');
													return false;
												},

												loading : function(bool) {
													$('#loading').toggle(bool);
												}

												,
												eventRender : function(event,
														element) {
													//element.qtip({
													//	content : 'I am here'
													//});
													if (event.title == "On-Site Work") {
														element
																.css(
																		'background-color',
																		'Chocolate ');
													}
													if (event.title == "Annual Leave") {
														element
																.css(
																		'background-color',
																		'blue');
													}
													if (event.title == "Emergency leave") {
														element
																.css(
																		'background-color',
																		'Red ');
													}
													if (event.title == "Vacation Leave") {
														element
																.css(
																		'background-color',
																		'green');
													}
													if (event.title == "Client Meeting") {
														element
																.css(
																		'background-color',
																		'purple');
													}
													if (event.title == "Meeting") {
														element
																.css(
																		'background-color',
																		'DarkGoldenRod ');
													}
													if (event.title == "Biweekly Meeting") {
														element
																.css(
																		'background-color',
																		'Teal  ');
													}
													if (event.title == "Planned Leave") {
														element
																.css(
																		'background-color',
																		'brown');
													}
													if (event.title == "Half-Day leave") {
														element
																.css(
																		'background-color',
																		'DeepPink ');
													}

													/* 	Annual leave
														Emergency Leave
														Vacation Leave
														On-Site Work
														Client Meeting
														Meeting
														Biweekly Meeting
														Planned leave
														Half-day leave */

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

#loading {
	display: none;
	position: absolute;
	top: 10px;
	right: 10px;
}

a.fc-event {
	cursor: pointer;
}

a.fc-event:HOVER {
	background-color: Black;
}
</style>
</head>
<body>

	<form name="HiddenForm" action="Calendar.do?method=Remark"
		method="post">
		<input type="hidden" name="date" />
	</form>
	<div id='script-warning'></div>
	<div id='loading'>loading...</div>
	<div id='calendar'></div>

</body>
</html>