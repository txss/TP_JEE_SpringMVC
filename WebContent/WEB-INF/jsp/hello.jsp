<%@ include file="include.jsp"%>

<html>
<head>
<title>Hello :: Spring Application</title>
</head>
<body>
	Bienvenue <c:out value="${name}" default="None" />
	<h1>Hello - Spring Application</h1>
	<p>
		Greetings, it is now
		<c:out value="${now}" default="None" />
	</p>
	
	visite sur la page: <c:out value="${compteur}" default="None" />
	<br/>
	add: <c:out value="${number}" default="None" />
	<br/>
	param1: <c:out value="${param1}" default="None" /><br/>
	param2: <c:out value="${param2}" default="None" />
</body>
</html>