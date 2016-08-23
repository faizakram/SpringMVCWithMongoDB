<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<h1>Add Data</h1>
<form action="dataAdding" method="Post">
Name <input type="text" name="name"/><br>
Age <input type="text" name="age"/><br>
<input type="submit"/>
</form>
<form action="findData" method="GET">
Name <input type="text" name="name"/><br>
<input type="submit"/>
</form>
</body>
</html>
