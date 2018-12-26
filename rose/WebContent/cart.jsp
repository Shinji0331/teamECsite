<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<link rel="stylesheet" href="./css/rose.css">

<title>カート</title>

<script>
function checkValue(){
	var checkList = document.getElementsByClassName("checkList");
	var checkFlag = 0;
	for (  var i = 0;  i < checkList.length;  i++  ) {
		if(checkFlag == 0){
			if(checkList[i].checked) {
				checkFlag = 1;
				break;
			}
		}
	}
	if (checkFlag == 1) {
		document.getElementById('delete_btn').disabled="";
	} else {
		document.getElementById('delete_btn').disabled="true";
	}
}

function checkValue2(){
	var checkList2 = document.getElementsByClassName("checkList2");
	var checkFlag2 = 0;
	for (  var i = 0;  i < checkList2.length;  i++  ) {
		if(checkFlag2 == 0){
			if(checkList2[i].checked) {
				checkFlag2 = 1;
				break;
			}
		}
	}
	if (checkFlag2 == 1) {
		document.getElementById('delete_btn2').disabled="";
	} else {
		document.getElementById('delete_btn2').disabled="true";
	}
}
</script>
<!-- ==================================== -->

</head>

<!-- ============ body ==============-->
<body>
	<s:include value="header.jsp" />
	<div id="main">

		<h1>カート画面</h1>
 		<br><br>

		<div class="pc">
			<s:if test="#session.cartInfoDTOList.size()>0">
				<s:form id="form" action="SettlementConfirmAction">

					<table class="tableA">

						<thead>
							<tr>
							  <th><s:label value="" /></th>
							  <th><s:label value="商品名" /></th>
							  <th><s:label value="ふりがな" /></th>
							  <th><s:label value="商品画像" /></th>
							  <th><s:label value="値段" /></th>
							  <th><s:label value="発売会社名" /></th>
							  <th><s:label value="発売年月日" /></th>
							  <th><s:label value="購入個数" /></th>
							  <th><s:label value="合計金額" /></th>
							</tr>
						</thead>

						<tbody>
							<s:iterator value="#session.cartInfoDTOList">
								<tr>
								  	<td><s:checkbox name="checkList" class="checkList" value="checked" fieldValue="%{productId}" onchange="checkValue()"/></td>
								   	<s:hidden name="productId" value="%{productId}" />
								   	<td><s:property value="productName"/></td>
								   	<td><s:property value="productNameKana"/></td>
								   	<td><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' width="50px" height="50px" /></td>
								   	<td><s:property value="price"/>円</td>
								   	<td><s:property value="releaseCompany"/></td>
								   	<td><s:property value="releaseDate"/></td>
								   	<td><s:property value="productCount"/></td>
								   	<td><s:property value="subtotal"/>円</td>
								</tr>

							</s:iterator>
						</tbody>

					</table>

					<br>
					<h2 class="totalPrice"><s:label value="カート合計金額 : "/><s:property value="#session.totalPrice"/>円</h2>
					<br>

					<div id="btnset">
					    <s:submit value="決済" cssClass="btn"/>
					    <s:submit value="削除" id="delete_btn" class="btn" onclick="this.form.action='DeleteCartAction';" disabled="true" />
					</div>
				</s:form>
			</s:if>
		</div>

		<div class="responsive">
			<s:if test="#session.cartInfoDTOList.size()>0">
				<s:form id="form" action="SettlementConfirmAction">

					<s:iterator value="#session.cartInfoDTOList">
						<div id="cartbox">
							<div class="checkListBox">
								<s:checkbox name="checkList" class="checkList2" value="checked" fieldValue="%{productId}" onchange="checkValue2()"/>
							</div>
							<img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' width="50px" height="50px" class="cartimg" />
							<ul class="cartList1">
								<li><s:label value="" /></li>
								<li><s:label value="商品名" /></li>
								<li><s:label value="ふりがな" /></li>
								<li><s:label value="値段" /></li>
								<li><s:label value="発売会社名" /></li>
								<li><s:label value="発売年月日" /></li>
								<li><s:label value="購入個数" /></li>
								<li><s:label value="合計金額" /></li>
							</ul>
							<ul class="cartList2">
							   	<s:hidden name="productId" value="%{productId}" />
							   	<li><s:property value="productName"/></li>
								<li><s:property value="productNameKana"/></li>
								<li><s:property value="price"/>円</li>
								<li><s:property value="releaseCompany"/></li>
								<li><s:property value="releaseDate"/></li>
								<li><s:property value="productCount"/></li>
								<li><s:property value="subtotal"/>円</li>
							</ul>

							<s:hidden name="productName" value="%{productName}"/>
							<s:hidden name="productNameKana" value="%{productNameKana}"/>
							<s:hidden name="imageFilePath" value="%{imageFilePath}"/>
							<s:hidden name="imageFileName" value="%{imageFileName}"/>
							<s:hidden name="price" value="%{price}"/>
							<s:hidden name="releaseCompany" value="%{releaseCompany}"/>
							<s:hidden name="releaseDate" value="%{releaseDate}"/>
							<s:hidden name="productCount" value="%{productCount}"/>
							<s:hidden name="subtotal" value="%{subtotal}"/>
						</div>

					</s:iterator>

					<br>
					<h2 class="totalPrice"><s:label value="カート合計金額 : "/><s:property value="#session.totalPrice"/>円</h2>
					<br>

					<div id="btnset">
					    <s:submit value="決済" cssClass="btn"/>
					    <s:submit value="削除" id="delete_btn2" class="btn" onclick="this.form.action='DeleteCartAction';" disabled="true"/>
					</div>

				</s:form>
			</s:if>

		</div>

		<s:else>
			<!-- <div class="message"> -->
			<p class="message message_blue">カート情報はありません。</p>
			<!-- </div> -->
		</s:else>

	</div> <!-- id="main"" -->

<!--  ============== footer ================= -->
	<div id="footer">
		<s:include value="footer.jsp"/>
	</div>

</body>
</html>