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
        <p>Please change the item you want to update!!</p>

		<div class="container">
			<form:form action="${pageContext.request.contextPath}/user/search" method="post" modelAttribute="updateForm" id="user">
				<form:hidden path="selectNumber" value="${f:h(selectNumber)}" />
            	<table>
                	<tr>
						<td>ユーザID:</td>
						<td>
							${f:h(selectResultInfo.userid)}
                    		<form:hidden path="userid" value="${f:h(selectResultInfo.userid)}" />
						</td>
					</tr>
					<tr>
                    	<td><form:label path="username" cssErrorClass="error-label">名前:</form:label></td>
                    	<td>
                    		<form:input path="username" cssErrorClass="error-input" value="${f:h(selectResultInfo.username)}" />
                    		<form:errors path="username" cssClass="error-messages" />
                    	</td>
                	</tr>
                	<tr>
                    	<td><form:label path="birthday" cssErrorClass="error-label">生年月日:</form:label></td>
                    	<td>
                    		<fmt:formatDate value="${selectResultInfo.birthday}" type="DATE" pattern="yyyy-MM-dd" var="formattedBirthday" />
							<input type="date" id="birthday" name="birthday" value="${formattedBirthday}">
							<form:errors path="birthday" cssClass="error-messages" />
						</td>
                	</tr>
                	<tr>
                    	<td><form:label path="address" cssErrorClass="error-label">住所:</form:label></td>
                    	<td>
                    		<form:input path="address" cssErrorClass="error-input" value="${f:h(selectResultInfo.address)}" />
							<form:errors path="address" cssClass="error-messages" />
						</td>
                	</tr>
                	<tr>
                    	<td><form:label path="tellphone" cssErrorClass="error-label">電話番号:</form:label></td>
                    	<td>
                    		<form:input path="tellphone" cssErrorClass="error-input" value="${f:h(selectResultInfo.tellphone)}" />
                        	<form:errors path="tellphone" cssClass="error-messages" />
                        </td>
                	</tr>
                	<tr>
                    	<td><form:label path="role" cssErrorClass="error-label">権限:</form:label></td>
                    	<td>
                    		<form:select path="role" name="role" cssErrorClass="error-input">
                    			<option value="USER">USER</option>
                    			<option value="ADMN">ADMIN</option>
                    		</form:select>
                        	<form:errors path="role" cssClass="error-messages" />
                        	<input type="hidden" id="rolehidden" value="${f:h(selectResultInfo.role)}">
                        	<script type="text/javascript">
								var user = document.getElementById("user");
								var role = user.elements["role"];
								var userrole = document.getElementById("rolehidden");
								for(var i=0; i<role.length; i++){
									if(role[i].value == userrole.value){
										role[i].selected=true;
										break;
									}
								}
							</script>
                        </td>
                	</tr>

                	<tr>
                    	<td>&nbsp;</td>
                    	<td>
                    		<input type="submit" id="back" name="back" value="戻る" />
                    		<input type="submit" id="updateFinish" name="updateFinish" value="更新" />
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