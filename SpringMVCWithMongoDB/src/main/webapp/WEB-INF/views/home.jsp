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
<a href="AddData">Add Data</a>
<a href="FindAll">Find All Data</a><br>
<table border="1">
<c:forEach items="${myList}" var="element"> 
  <tr>
    <td>${element.name}</td>
    <td>${element.age}</td>
    <td><a href="delete?name=${element.name}"><input type="button" value="delete"/></a></td>
  </tr>
</c:forEach>
</table>
${Signle.name}<br>
${Signle.age}

</body>
</html>
