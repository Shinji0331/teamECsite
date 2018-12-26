<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>パスワード再設定確認</title>
</head>
<body>
<s:include value="header.jsp" />
<div id="main">
<h1>パスワード再設定確認画面</h1>
<div class="pass_form">
	<s:form action="ResetPasswordCompleteAction">
	<table class="tableB">
	<tr>
		<th>ログインID</th>
		<td>
			<s:property value="#session.resetPasswordLoginId" />
		</td>
	</tr>
	<tr>
		<th>パスワード</th>
		<td>
			<s:property value="#session.concealedPassword" />
		</td>
	</tr>
	</table>
	<s:submit class="btn btn_center" value="パスワード再設定" />
	</s:form>
	<s:form action="ResetPasswordAction">
		<s:hidden name="loginId" value="%{loginId}" />
		<s:submit class="btn btn_center" value="戻る" />
	</s:form>
</div>
</div>
<s:include value="footer.jsp" />
</body>
</html>