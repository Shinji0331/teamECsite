<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<link rel="stylesheet" href="./css/rose.css">
<title>決済確認</title>
<script type="text/javascript">
	function onClick(id){
		var a = document.getElementsByClassName("radio");
		var index = id - 1;
		a[index].checked=true;
	}
</script>
</head>
<body>
	<s:include value="header.jsp" />
	<div id="main">
		<h1>決済確認画面</h1>
		<s:if test="#session.destinationInfoDTOList.size()>0">
			<div class="message message_blue">
				送り先情報を選択してください
			</div>
			<div class = "pc">
			<s:form id="form" action="SettlementCompleteAction">
				<table class="tableA stm_cfm_table">
					<thead>
					<tr>
						<th></th>
						<th>姓</th>
						<th>名</th>
						<th>ふりがな</th>
						<th>住所</th>
						<th>電話番号</th>
						<th>メールアドレス</th>
					</tr>
					</thead>
					<tbody>
					<s:iterator value="#session.destinationInfoDTOList" status="st">
					<tr>
						<td>
							<s:if test="#st.index == 0">
								<input type="radio" name="destinationId" checked="checked" value="<s:property value='id'/>"/>
							</s:if>
							<s:else>
								<input type="radio" name="destinationId" value="<s:property value='id'/>"/>
							</s:else>
						</td>
						<td>
							<s:property value="familyName"/>
						</td>
						<td>
							<s:property value="firstName"/>
						</td>
						<td>
							<s:property value="familyNameKana"/><span> </span><s:property value="firstNameKana"/><br>
						</td>
						<td>
							<s:property value="userAddress"/>
						</td>
						<td>
							<s:property value="telNumber"/>
						</td>
						<td>
							<s:property value="email"/>
						</td>
					</tr>
					</s:iterator>
					</tbody>
				</table>
					<s:submit value="決済" class="btn stm_cfm_btn"/>
			</s:form>
			</div>

			<div class="responsive">
			<s:form id="form" action="SettlementCompleteAction">
				<s:iterator value="#session.destinationInfoDTOList" status="st">
					<div class="stmbox" onClick= onClick(${id})>
						<div class="radiobox">
							<s:if test="#st.index == 0">
								<input type="radio" class="radio" name="destinationId" checked="checked" value="<s:property value='id'/>"/>
							</s:if>
							<s:else>
								<input type="radio" class="radio" name="destinationId" value="<s:property value='id'/>"/>
							</s:else>
						</div>
						<div class="contentsbox">
							<ul>
								<li>名前</li>
								<li>ふりがな</li>
								<li>住所</li>
								<li>電話番号</li>
								<li>メールアドレス</li>
							</ul>
						</div>
						<div class="destinationbox">
							<ul>
								<li><s:property value="familyName"/><span> </span><s:property value="firstName"/></li>
								<li><s:property value="familyNameKana"/><span> </span><s:property value="firstNameKana"/></li>
								<li><s:property value="userAddress"/></li>
								<li><s:property value="telNumber"/></li>
								<li><s:property value="email"/></li>
							</ul>
						</div>

					</div>
				</s:iterator>
					<s:submit value="決済" class="btn stm_cfm_btn"/>
			</s:form>
			</div>
		</s:if>
		<s:else>
		<div class="message message_blue">
		宛先情報がありません。
		</div>
		</s:else>
			<s:form action="CreateDestinationAction">
				<s:submit value="新規宛先登録" class="btn stm_cfm_btn"/>
			</s:form>
		</div>

	<s:include value="footer.jsp"/>
</body>
</html>