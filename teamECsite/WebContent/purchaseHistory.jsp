<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>商品購入履歴</title>
</head>
<body>
<s:include value="header.jsp" />
	<div id="main">
		<h1>商品購入履歴画面</h1>
		<div class="pc">
			<!-- リストラベル -->
			<s:if test="#session.purchaseHistoryInfoDTOList.size() > 0">
				<table class="tableA">
					<tr>
						<th><s:label value="商品名"/></th>
						<th><s:label value="ふりがな"/></th>
						<th><s:label value="商品画像"/></th>
						<th><s:label value="発売会社名"/></th>
						<th><s:label value="発売年月日"/></th>
						<th><s:label value="値段"/></th>
						<th><s:label value="個数"/></th>
						<th><s:label value="合計金額"/></th>
					</tr>

					<!-- リストコンテンツ -->
					<s:iterator value="#session.purchaseHistoryInfoDTOList">
						<tr>
							<td><s:property value="productName"/></td>
							<td><s:property value="productNameKana"/></td>
							<td><img src='<s:property value="imageFilePath"/>/<s:property  value="imageFileName"/>' class="image_s"/></td>
							<td><s:property value="releaseCompany"/></td>
							<td><s:property value="releaseDate"/></td>
							<td><s:property value="price"/>円</td>
							<td><s:property value="productCount"/>個</td>
							<td><s:property value="totalPrice"/>円</td>
						</tr>
					</s:iterator>
				</table>
				<div class="submit_btn">
					<div id=".contents-btn-set">
						<s:form action="DeletePurchaseHistoryAction">
							<s:submit value="削除" class="btn"/>
						</s:form>
					</div>
				</div>
			 </s:if>
				<s:else>
					<div class="message_blue message">
						商品購入履歴情報はありません。
					</div>
				</s:else>
			</div>

<div class="responsive">
<s:if test="#session.purchaseHistoryInfoDTOList.size() > 0">
	<div class="resSat">
		<s:iterator value="#session.purchaseHistoryInfoDTOList">
			<table class="tableB_small purchaseH">
				<tr>
					<th><s:label value="商品名"/></th>
					<td><s:property value="productName"/></td>
				</tr>
				<tr>
					<th><s:label value="ふりがな"/></th>
					<td><s:property value="productNameKana"/></td>
				</tr>
				<tr>
					<th><s:label value="商品画像"/></th>
					<td><img src='<s:property value="imageFilePath"/>/<s:property  value="imageFileName"/>' class="image_s"/></td>
				</tr>
				<tr>
					<th><s:label value="発売会社名"/></th>
					<td><s:property value="releaseCompany"/></td>
				</tr>
				<tr>
					<th><s:label value="発売年月日"/></th>
					<td><s:property value="releaseDate"/></td>
				</tr>
				<tr>
					<th><s:label value="値段"/></th>
					<td><s:property value="price"/>円</td>
				</tr>
				<tr>
					<th><s:label value="個数"/></th>
					<td><s:property value="productCount"/>個</td>
				</tr>
				<tr>
					<th><s:label value="合計金額"/></th>
					<td><s:property value="totalPrice"/>円</td>
				</tr>
			</table>
		</s:iterator>
		<div class="submit_btn">
			<div id=".contents-btn-set">
				<s:form action="DeletePurchaseHistoryAction">
					<s:submit value="削除" class="btn"/>
				</s:form>
			</div>
		</div>
	</div>
</s:if>
	<s:else>
		<div class="message_blue message">
			商品購入履歴情報はありません。
		</div>
	</s:else>
	</div>
	</div>
<s:include value="footer.jsp"/>
</body>
</html>