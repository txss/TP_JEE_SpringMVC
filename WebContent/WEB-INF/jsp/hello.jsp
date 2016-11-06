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
</body>
</html>