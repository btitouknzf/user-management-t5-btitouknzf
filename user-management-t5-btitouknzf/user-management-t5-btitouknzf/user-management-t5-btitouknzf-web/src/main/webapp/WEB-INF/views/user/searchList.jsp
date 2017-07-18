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
		<h1>Search Result</h1>
		<div class="container">
		<form:form method="post" action="${pageContext.request.contextPath}/user/search" modelAttribute="userSelectForm">
			<table>
				<tr>
					<th>選択</th>
					<th>ユーザID</th>
					<th>名前</th>
					<th>生年月日</th>
					<th>住所</th>
					<th>電話番号</th>
					<th>権限</th>
					<th>状態</th>
				</tr>
				<c:forEach items="${resultInfo}" var="resultInfo" varStatus="status">
					<tr>
						<td><form:radiobutton path="radioselect" value="${status.index}" /></td>
						<td><span id="userid${status.index}">${f:h(resultInfo.userid)}</span></td>
						<td><span id="username${status.index}">${f:h(resultInfo.username)}</span></td>
						<td>
							<span id="birthday${status.index}">
								<fmt:formatDate value="${resultInfo.birthday}" pattern="yyyy/MM/dd" />
							</span>
						</td>
						<td><span id="address${status.index}">${f:h(resultInfo.address)}</span></td>
						<td><span id="tellphone${status.index}">${f:h(resultInfo.tellphone)}</span></td>
						<td><span id="role${status.index}">${f:h(resultInfo.role)}</span></td>
						
						<td><span id="state${status.index}">
							<c:choose>
								<c:when test="${resultInfo.state == '0'}">
									初期状態
								</c:when>
								<c:when test="${resultInfo.state == '1'}">
									有効状態
								</c:when>
								<c:when test="${resultInfo.state == '2'}">
									削除済み
								</c:when>
							</c:choose>
						</span></td>
					</tr>
				</c:forEach>
			</table>
			<form:errors path="radioselect" cssErrorClass="error-messages" />
			<input type="submit" name="update" id="update${status.index}" value="更新" />
			<input type="submit" name="update" id="delete${status.index}" value="削除" />
			
		</form:form>
		</div>

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