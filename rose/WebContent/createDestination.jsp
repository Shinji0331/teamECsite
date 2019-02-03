<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>宛先情報入力画面</title>

</head>
<body>
<s:include value="header.jsp" />
<div id="main">
<div id="contents">
<h1>宛先情報入力画面</h1>

<s:if test="!familyNameErrorMessageList.size() == 0">
	<div class="message message_red">
		<s:iterator value="familyNameErrorMessageList"><s:property /><br></s:iterator>
	</div>
</s:if>
<s:if test="!firstNameErrorMessageList.size() == 0">
	<div class="message message_red">
		<s:iterator value="firstNameErrorMessageList"><s:property /><br></s:iterator>
	</div>
</s:if>
<s:if test="!familyNameKanaErrorMessageList.size() == 0">
	<div class="message message_red">
		<s:iterator value="famimyNameKanaErrorMessageList"><s:property /><br></s:iterator>
	</div>
</s:if>
<s:if test="!firstNameKanaErrorMessageList.size() == 0">
	<div class="message message_red">
		<s:iterator value="firstNameKanaErrorMessageList"><s:property /><br></s:iterator>
	</div>
</s:if>
<s:if test="!userAddressErrorMessageList.size() == 0">
	<div class="message message_red">
		<s:iterator value="userAddressErrorMessageList"><s:property /><br></s:iterator>
	</div>
</s:if>
<s:if test="!telNumberErrorMessageList.size() == 0">
	<div class="message message_red">
		<s:iterator value="telNumberErrorMessageList"><s:property /><br></s:iterator>
	</div>
</s:if>
<s:if test="!emailErrorMessageList.size() == 0">
	<div class="message message_red">
		<s:iterator value="emailErrorMessageList"><s:property /><br></s:iterator>
	</div>
</s:if>
<div class="bigbox">
<s:form action="CreateDestinationConfirmAction">
<table class="tableB">
<tr>
	<th scope="row"><s:label value="姓"/></th>
	<td><s:textfield name="familyName" class="txt" ></s:textfield></td>
</tr>

<tr>
	<th scope="row"><s:label value="名"/></th>
	<td><s:textfield name="firstName" class="txt" ></s:textfield></td>
</tr>

<tr>
	<th scope="row"><s:label value="姓ふりがな"/></th>
	<td><s:textfield name="familyNameKana" class="txt" ></s:textfield></td>
</tr>

<tr>
	<th scope="row"><s:label value="名ふりがな"/></th>
	<td><s:textfield name="firstNameKana" class="txt" ></s:textfield></td>
</tr>

<tr>
	<th scope="row"><s:label value="住所"/></th>
	<td><s:textfield name="userAddress" class="txt" ></s:textfield></td>
</tr>

<tr>
	<th scope="row"><s:label value="電話番号"/></th>
	<td><s:textfield name="telNumber" class="txt" ></s:textfield></td>
</tr>

<tr>
	<th scope="row"><s:label value="メールアドレス"/></th>
	<td><s:textfield name="email" class="txt" ></s:textfield></td>
</tr>
</table>
<br><br>
	<s:submit value="宛先情報確認" class="btn" />
</s:form>
</div>
</div>
</div>
<s:include value="footer.jsp"/>
</body>
</html>