<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>パスワード再設定</title>
</head>
<body>
<s:include value="header.jsp" />
<div id="main">
<h1>パスワード再設定画面</h1>

	<s:if test="!(loginIdErrorMessageList.isEmpty())">
	<div class="message message_red">
		<s:iterator value="loginIdErrorMessageList"><s:property />
		<br></s:iterator>
	</div>
	</s:if>

	<s:if test="!(passwordErrorMessageList.isEmpty())">
	<div class="message message_red">
		<s:iterator value="passwordErrorMessageList"><s:property />
		<br></s:iterator>
	</div>
	</s:if>

	<s:if test="!(passwordIncorrectErrorMessageList.isEmpty())">
	<div class="message message_red">
		<s:iterator value="passwordIncorrectErrorMessageList"><s:property />
		<br></s:iterator>
	</div>
	</s:if>

	<s:if test="!(newPasswordErrorMessageList.isEmpty())">
	<div class="message message_red">
		<s:iterator value="newPasswordErrorMessageList"><s:property />
		<br></s:iterator>
	</div>
	</s:if>

	<s:if test="!(reConfirmationNewPasswordErrorMessageList.isEmpty())">
	<div class="message message_red">
		<s:iterator value="reConfirmationNewPasswordErrorMessageList"><s:property />
		<br></s:iterator>
	</div>
	</s:if>

	<s:if test="!(newPasswordIncorrectErrorMessageList.isEmpty())">
	<div class="message message_red">
		<s:iterator value="newPasswordIncorrectErrorMessageList"><s:property />
		<br></s:iterator>
	</div>
	</s:if>
<div class="pass_form">
<s:form action="ResetPasswordConfirmAction">
	<table class="tableB">
		<tr>
			<th>ユーザID</th>
			<td>
				<s:textfield name="loginId" value="%{#session.resetPasswordLoginId}" class="txt" placeholder="ユーザID"/>
			</td>
		</tr>
		<tr>
			<th>現在のパスワード</th>
			<td>
				<s:password name="password" value="" class="txt" placeholder="現在のパスワード"/>
			</td>
		</tr>
		<tr>
			<th>新しいパスワード</th>
			<td>
				<s:password name="newPassword" value="" class="txt" placeholder="新しいパスワード"/>
			</td>
		</tr>
		<tr>
			<th>（再確認）</th>
			<td>
				<s:password name="reConfirmationPassword" value="" class="txt" placeholder="新しいパスワード（再確認用）"/>
			</td>
	</tr>
	</table>
	<s:submit class="btn btn_center" value="確認" />
</s:form>
</div>
</div>
<s:include value="footer.jsp" />
</body>
</html>