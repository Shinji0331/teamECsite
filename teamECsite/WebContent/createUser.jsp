<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ情報入力</title>
</head>
<body>
	<s:include value="header.jsp" />
	<div id="main">
	<h1>ユーザー情報入力画面</h1>
	<s:if test="!(familyNameErrorMessageList.isEmpty())" >
		<div class="message message_red">
			<s:iterator value="%{familyNameErrorMessageList}"><s:property /><br></s:iterator>
		</div>
	</s:if>
	<s:if test="!(firstNameErrorMessageList.isEmpty())">
		<div class="message message_red">
			<s:iterator value="%{firstNameErrorMessageList}"><s:property /><br></s:iterator>
		</div>
	</s:if>
	<s:if test="!(familyNameKanaErrorMessageList.isEmpty())">
		<div class="message message_red">
			<s:iterator value="%{familyNameKanaErrorMessageList}"><s:property /><br></s:iterator>
		</div>
	</s:if>
	<s:if test="!(firstNameKanaErrorMessageList.isEmpty())">
		<div class="message message_red">
			<s:iterator value="%{firstNameKanaErrorMessageList}"><s:property /><br></s:iterator>
		</div>
	</s:if>
	<s:if test="!(emailErrorMessageList.isEmpty())">
		<div class="message message_red">
			<s:iterator value="%{emailErrorMessageList}"><s:property /><br></s:iterator>
		</div>
	</s:if>
	<s:if test="!(loginIdErrorMessageList.isEmpty())">
		<div class="message message_red">
			<s:iterator value="%{loginIdErrorMessageList}"><s:property /><br></s:iterator>
		</div>
	</s:if>
	<s:if test="!(passwordErrorMessageList.isEmpty())">
		<div class="message message_red">
			<s:iterator value="%{passwordErrorMessageList}"><s:property /><br></s:iterator>
		</div>
	</s:if>
	<div class="pass_form">
	<s:form action="CreateUserConfirmAction" >
		<table class="tableB">
			<tr>
				<th>姓</th>
				<td>
					<s:textfield name="familyName" class="txt" placeholder="姓" />
				</td>
			</tr>
			<tr>
				<th>名</th>
				<td>
					<s:textfield name="firstName"  class="txt" placeholder="名" />
				</td>
			</tr>
			<tr>
				<th>姓ふりがな</th>
				<td>
					<s:textfield name="familyNameKana"  class="txt" placeholder="姓ふりがな" />
				</td>
			</tr>
			<tr>
				<th>名ふりがな</th>
				<td>
					<s:textfield name="firstNameKana"  class="txt" placeholder="名ふりがな" />
				</td>
			</tr>
			<tr>
				<th>性別</th>
				<td>
					<s:radio name="sex" list="%{#session.sexList}" value="%{sex}" />
				</td>
			</tr>
			<tr>
				<th>メールアドレス</th>
				<td>
					<s:textfield name="email" class="txt" placeholder="メールアドレス" />
				</td>
			</tr>
			<tr>
				<th>ユーザID</th>
				<td>
					<s:textfield name="loginId" class="txt" placeholder="ユーザID" />
				</td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td><!-- パスワードだけ再遷移時に入力リセット -->
					<s:password name="password" value="" class="txt" placeholder="パスワード" />
				</td>
			</tr>
		</table>
		<s:submit class="btn btn_center" value="確認" />
	</s:form>
	</div>
	</div>
	<s:include value="footer.jsp"/>
</body>
</html>