<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー情報入力完了</title>
<script type="text/javascript">
	setTimeout('document.form1.submit()',3000);
</script>
</head>
<body>
<s:include value="header.jsp" />
<div id="main">
<h1>ユーザ情報入力完了画面</h1>
<div class="message message_green">ユーザ情報入力が完了しました。</div>
<s:form name="form1" action="LoginAction">
<s:hidden name="loginId" value="%{loginId}" />
<s:hidden name="password" value="%{password}" />
</s:form>
</div>
<s:include value="footer.jsp"/>
</body>
</html>