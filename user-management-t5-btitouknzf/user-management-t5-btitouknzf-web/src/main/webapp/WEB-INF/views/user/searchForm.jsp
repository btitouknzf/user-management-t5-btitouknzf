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
        <p>Please enter the item you want to search!!</p>

		<div class="container">
			<form:form action="${pageContext.request.contextPath}/user/search" method="post" modelAttribute="searchForm">
            	<table>
                	<tr>
						<td><form:label path="userid" cssErrorClass="error-label">ユーザID:</form:label></td>
						<td>
                    		<form:input path="userid" cssErrorClass="error-input" />
							<form:errors path="userid" cssClass="error-messages" />
						</td>
					</tr>
					<tr>
                    	<td><form:label path="username" cssErrorClass="error-label">名前:</form:label></td>
                    	<td>
                    		<form:input path="username" cssErrorClass="error-input" />
                    		<form:errors path="username" cssClass="error-messages" />
                    	</td>
                	</tr>
                	<tr>
                    	<td><form:label path="birthday" cssErrorClass="error-label">生年月日:</form:label></td>
                    	<td>
                    		<fmt:formatDate value="${searchForm.birthday}" pattern="yyyy-MM-dd" var="formattedBirthday" />
							<input type="date" id="birthday" name="birthday" value="${formattedBirthday}">
							<form:errors path="birthday" cssClass="error-messages" />
						</td>
                	</tr>
                	<tr>
                    	<td><form:label path="address" cssErrorClass="error-label">住所:</form:label></td>
                    	<td>
                    		<form:input path="address" cssErrorClass="error-input" />
							<form:errors path="address" cssClass="error-messages" />
						</td>
                	</tr>
                	<tr>
                    	<td><form:label path="tellphone" cssErrorClass="error-label">電話番号:</form:label></td>
                    	<td>
                    		<form:input path="tellphone" cssErrorClass="error-input" />
                        	<form:errors path="tellphone" cssClass="error-messages" />
                        </td>
                	</tr>
                	<tr>
                    	<td><form:label path="role" cssErrorClass="error-label">権限:</form:label></td>
                    	<td>
                    		<form:select path="role" cssErrorClass="error-input">
                    			<option value=""></option>
                    			<option value="USER">USER</option>
                    			<option value="ADMN">ADMIN</option>
                    		</form:select>
                        	<form:errors path="role" cssClass="error-messages" />
                        </td>
                	</tr>
                	<tr>
                    	<td><form:label path="state" cssErrorClass="error-label">状態:</form:label></td>
                    	<td>
                    		<form:select path="state" cssErrorClass="error-input">
                    			<option value=""></option>
                    			<option value="ACTV">有効状態</option>
                    			<option value="INIT">初期状態</option>
                    			<option value="RMVD">削除済み</option>
                    		</form:select>
                    		<form:errors path="state" cssClass="error-messages" />
                        </td>
                	</tr>
                	<tr>
                    	<td>&nbsp;</td>
                    	<td><input type="submit" id="next" value="search" /></td>
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