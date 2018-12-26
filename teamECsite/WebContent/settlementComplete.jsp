<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="3;URL='HomeAction'">
<title>決済完了</title>
</head>
<body>
	<s:include value="header.jsp" />
	<div id="main">
	<h1>決済完了画面</h1>
	<div class="message message_green">
	決済が完了しました。
	</div>
	</div>

	<s:include value="footer.jsp" />
</body>
</html>