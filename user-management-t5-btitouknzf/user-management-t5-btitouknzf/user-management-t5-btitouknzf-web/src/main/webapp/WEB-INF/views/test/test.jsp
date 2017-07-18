<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>view role page</title>
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/app/css/styles.css">
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/vendor/bootstrap-3.0.0/css/bootstrap.css"
    type="text/css" media="screen, projection">
</head>
<body>
	<div>
		<table>
            <tr>
                <th>ID</th>
                <th>role</th>
            </tr>
            <c:forEach items="${role}" var="role" varStatus="status">
                <tr>
                    <td>
						${f:h(role.userid)}
					</td>
                    <td>
						${f:h(role.role)}
					</td>
                </tr>
            </c:forEach>
        </table>
        
                <hr>
        <form method="get" action="${pageContext.request.contextPath}/top/menu">
            <input type="submit" name="home" id="home" value="home" />
        </form>
        <form:form action="${pageContext.request.contextPath}/logout">
            <button type="submit">Logout</button>
        </form:form>
	</div>

</body>
</html>