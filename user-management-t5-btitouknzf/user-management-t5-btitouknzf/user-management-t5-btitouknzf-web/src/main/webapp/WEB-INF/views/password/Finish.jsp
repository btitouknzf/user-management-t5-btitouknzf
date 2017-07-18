<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>chengePassword</title>
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>

<sec:authentication property="principal.userInfo" var="userInfo" />

<body>
    <div id="wrapper">
        <h1>Hello ${f:h(userInfo.username)}!</h1>
        <h1>Password change finished!!</h1>

		<hr>

		<form:form action="${pageContext.request.contextPath}/logout">
            <button type="submit">Logout</button>
        </form:form>
	
        <form method="get" action="${pageContext.request.contextPath}/top/menu">
            <input type="submit" name="home" id="home" value="home" />
        </form>

    </div>
    
</body>
</html>