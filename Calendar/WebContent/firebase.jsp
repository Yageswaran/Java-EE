<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src='https://cdn.firebase.com/js/client/2.0.4/firebase.js'></script>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js'></script>
</head>
<body>

<script>
var ref = new Firebase('https://otw.firebaseio.com/');
/* //var name = "yo";
myDataRef.set({User : "changed"} );
myDataRef.on("User",myDataRef.push({Email : "@yahoo"} ) ); */

/* var usersRef = ref.child("users");
usersRef.update({
  Android_Test: {
    date_of_birth: "June 99, 9999",
    full_name: "terbaiklah!",
    status: "success"
  }
}); */

//var dat = ref.child("otw");
ref.update({
  Yages_says: {
    message: "success! nice!"
  }
});




</script>



</body>
</html>