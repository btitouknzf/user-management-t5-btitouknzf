<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>menu</title>
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>

<sec:authentication property="principal.userInfo" var="userInfo" />

<body>
    <div id="wrapper">
        <h1>Welcome to main menu</h1>
        <p>Login name: ${f:h(userInfo.username)}</p>
        
        <sec:authorize access="hasRole('ROLE_ADMIN')">  
        
        	<form:form method="get" action="${pageContext.request.contextPath}/user/register">
         	   <input type="submit" id="register" value="登録" />
        	</form:form>
        
        	<form:form method="post" action="${pageContext.request.contextPath}/order">
       			<input type="submit" id="order" value="一括登録" />
        	</form:form>
        
        	<form:form method="post" action="${pageContext.request.contextPath}/order">
            	<input type="submit" id="order" value="一括登録結果確認" />
        	</form:form>
        </sec:authorize>
        <form:form method="get" action="${pageContext.request.contextPath}/user/search">
            <input type="submit" id="search" value="検索" />
        </form:form>
        
        <hr>
		<form:form method="post" action="${pageContext.request.contextPath}/test">
            <input type="submit" name="lookrole" id="lookrole" value="権限見てみる？" />
        </form:form>
        <form:form action="${pageContext.request.contextPath}/logout">
            <button type="submit">Logout</button>
        </form:form>
        
        
	
    </div>
</body>
</html>