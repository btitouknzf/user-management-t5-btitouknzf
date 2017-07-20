<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>update User</title>
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>

<sec:authentication property="principal.userInfo" var="userInfo" />

<body>
    <div id="wrapper">
        <h1>Hello ${f:h(userInfo.username)}!</h1>
        <p>Are you sure you want to delete it?</p>

		<div class="container">
			<form:form action="${pageContext.request.contextPath}/user/search" method="post" modelAttribute="deleteForm" id="user">
            	<table>
                	<tr>
						<td>ユーザID:</td>
						<td>
							${f:h(selectResultInfo.userid)}
                    		<form:hidden path="userid" value="${f:h(selectResultInfo.userid)}" />
						</td>
					</tr>
					<tr>
                    	<td>名前:</td>
                    	<td>${f:h(selectResultInfo.username)}</td>
                	</tr>
                	<tr>
                    	<td>生年月日:</td>
                    	<td>
                    		<fmt:formatDate value="${selectResultInfo.birthday}" type="DATE" pattern="yyyy-MM-dd" var="formattedBirthday" />
							${formattedBirthday}
						</td>
                	</tr>
                	<tr>
                    	<td>住所:</td>
                    	<td>${f:h(selectResultInfo.address)}</td>
                	</tr>
                	<tr>
                    	<td>電話番号:</td>
                    	<td>${f:h(selectResultInfo.tellphone)}</td>
                	</tr>
                	<tr>
                    	<td>権限:</td>
                    	<td>${f:h(selectResultInfo.role)}</td>
                    	<form:hidden path="role" value="${f:h(selectResultInfo.role)}" />
                	</tr>

                	<tr>
                    	<td>&nbsp;</td>
                    	<td>
                    		<input type="submit" id="back" name="back" value="戻る" />
                    		<input type="submit" id="deleteFinish" name="deleteFinish" value="削除" />
                    	</td>
                	</tr>
            	</table>
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
