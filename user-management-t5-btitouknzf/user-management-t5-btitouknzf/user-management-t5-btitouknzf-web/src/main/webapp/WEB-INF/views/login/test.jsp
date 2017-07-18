<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Home</title>
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>

<!-- (1) -->
<sec:authentication property="principal.userInfo" var="userInfo" />

<body>
    <div id="wrapper">
        <h1>Hello world!</h1>
        <p>The time on the server is ${serverTime}.</p>
        <!-- (2) -->
        <p>Welcome ${f:h(userInfo.username)} ${f:h(userInfo.state)} !!</p>
        <ul>
            <li><a href="${pageContext.request.contextPath}/account">view account</a></li>
        </ul>
    </div>
</body>
</html>