<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ログイン画面</title>
</head>
<body>

	<s:include value="header.jsp" />
	<div id="main">

	<h1>ログイン画面</h1>

	<s:if test="loginIdErrorMessageList.size()!=0">
		<div class="message_red message">
			<s:iterator value="loginIdErrorMessageList">
				<s:property/><br>
			</s:iterator>
		</div>
	</s:if>

	<s:if test="passwordErrorMessageList.size()!=0">
		<div class="message_red message">
			<s:iterator value="passwordErrorMessageList">
				<s:property/><br>
			</s:iterator>
		</div>
	</s:if>

	<s:if test="!loginErrorMessage.isEmpty()">
		<div class="message_red message">
			<s:property value="loginErrorMessage"/>
		</div>
	</s:if>

	<s:form action="LoginAction" class="form">
		<table class="tableB logintable">
			<tr>
				<th id="th">ユーザID</th>
				<td>
					<s:if test="#session.saveLoginId==false">
						<s:textfield name="loginId" class="text" value=""/>
					</s:if>
					<s:else>
						<s:textfield name="loginId" class="text" value='%{#session.userId}'/>
					</s:else>
				</td>
			</tr>
			<tr>
				<th id="th">パスワード</th>
				<td><s:password name="password" class="text"/></td>
			</tr>
		</table>
		<div class="box">
			<s:if test="#session.saveLoginId==true">
				<s:checkbox name="saveLoginId" checked="checked"/>
			</s:if>
			<s:else>
				<s:checkbox name="saveLoginId"/>
			</s:else>
			<s:label value="ユーザID保存" class=""/>
		</div>
		<s:submit value="ログイン" class="btn loginbtn"/>
	</s:form>
	<form action="CreateUserAction" class="form">
		<input type="submit" value="新規ユーザ登録" class="btn loginbtn"/>
	</form>
	<form action="ResetPasswordAction" class="form">
		<input type="submit" value="パスワード再設定" class="btn loginbtn"/>
	</form>

	</div>
	<s:include value="footer.jsp" />

</body>
</html>