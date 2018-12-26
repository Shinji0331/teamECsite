<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ情報入力確認</title>
</head>
<body>
	<s:include value="header.jsp" />
	<div id="main">
	<h1>ユーザ情報入力確認画面</h1>
	<div class="pass_form">
	<s:form action="CreateUserCompleteAction">
		<table class="tableB">
			<tr>
				<th>姓</th>
				<td>
					<s:property value="familyName" />
				</td>
			</tr>
			<tr>
				<th>名</th>
				<td>
					<s:property value="firstName" />
				</td>
			</tr>
			<tr>
				<th>姓ふりがな</th>
				<td>
					<s:property value="familyNameKana" />
				</td>
			</tr>
			<tr>
				<th>名ふりがな</th>
				<td>
					<s:property value="firstNameKana" />
				</td>
			</tr>
			<tr>
				<th>性別</th>
				<td>
					<s:property value="sex" />
				</td>
			</tr>
			<tr>
				<th>メールアドレス</th>
				<td>
					<s:property value="email" />
				</td>
			</tr>
			<tr>
				<th>ユーザID</th>
				<td>
					<s:property value="loginId" />
				</td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td>
					<s:property value="password" />
				</td>
			</tr>
		</table>
		<s:submit class="btn btn_center" value="登録" />
		<s:hidden name="loginId" value="%{loginId}"/>
		<s:hidden name="password" value="%{password}"/>
		<s:hidden name="familyName" value="%{familyName}"/>
		<s:hidden name="firstName" value="%{firstName}"/>
		<s:hidden name="familyNameKana" value="%{familyNameKana}"/>
		<s:hidden name="firstNameKana" value="%{firstNameKana}"/>
		<s:hidden name="sex" value="%{sex}"/>
		<s:hidden name="email" value="%{email}"/>
	</s:form>

	<s:form action="CreateUserAction">
		<s:hidden name="loginId" value="%{loginId}"/>
		<s:hidden name="familyName" value="%{familyName}"/>
		<s:hidden name="firstName" value="%{firstName}"/>
		<s:hidden name="familyNameKana" value="%{familyNameKana}"/>
		<s:hidden name="firstNameKana" value="%{firstNameKana}"/>
		<s:hidden name="sex" value="%{sex}"/>
		<s:hidden name="email" value="%{email}"/>
		<s:submit class="btn btn_center" value="戻る" />
	</s:form>
	</div>
	<s:include value="footer.jsp"/>
	</div>
</body>
</html>