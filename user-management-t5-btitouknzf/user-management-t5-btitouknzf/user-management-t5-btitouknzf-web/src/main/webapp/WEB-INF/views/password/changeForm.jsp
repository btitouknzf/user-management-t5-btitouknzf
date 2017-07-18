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
        <p>please change Password</p>

		<hr>

		<form:form action="${pageContext.request.contextPath}/password/change" method="post" modelAttribute="passwordUpdateForm">
			<table>
				<tr>
					<td><label for="password1">new password</label></td>
					<td><label for="password2">once again new password</label></td>

				</tr>
				<tr>
					<td>
						<input type="password" id="password1" name="password1">
						<form:errors path="password1" cssClass="error-messages" />
					</td>
					<td>
						<input type="password" id="password2" name="password2" />
						<form:errors path="password2" cssClass="error-messages" />
					</td>

				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input name="changepassword" type="submit" id="changePassword" value="changePassword" /></td>
				</tr>
			</table>
		</form:form>

		<form:form action="${pageContext.request.contextPath}/logout">
            <button type="submit">Logout</button>
        </form:form>
        
    </div>
    
</body>
</html>