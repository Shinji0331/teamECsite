<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="./css/rose.css">

<title>マイページ</title>

<style type="text/css">

</style>
</head>

<body>
<s:include value="header.jsp" />

<div id="main">
<h1>マイページ画面</h1>
	<s:form action="PurchaseHistoryAction">
	<table class="tableB">
		<tr>
			<th><s:label value="姓"/></th>
			<td><s:property value="#session.familyName"/></td>
		</tr>
		<tr>
			<th><s:label value="名"/></th>
			<td><s:property value="#session.firstName"/></td>
		</tr>
		<tr>
			<th><s:label value="ふりがな"/></th>
			<td><s:property value="#session.familyNameKana"/><span> </span>
			<s:property value="#session.firstNameKana"/></td>
		</tr>
		<tr>
			<th><s:label value="性別"/></th>
			<td><s:property value="#session.sex"/></td>
		</tr>
		<tr>
			<th><s:label value="メールアドレス"/></th>
			<td><s:property value="#session.email"/></td>
		</tr>
	</table>
	<div class="submit">
	<s:submit value="購入履歴" class="btn"/>
	</div>
	</s:form>
</div>
	<s:include value="footer.jsp"/>
</body>
</html>
