<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/rose.css">

<title>商品詳細画面</title>
</head>
<body>
<s:include value="header.jsp" />
<div id="main">
<h1>商品詳細</h1>
	<s:form action="AddCartAction">
		<div class=image_m_box>
				<img src='<s:property value="%{#session.imageFilePath}"/>/<s:property value="%{#session.imageFileName}"/>' class="image_ll">
		</div>
		<div class="item_detail">
		<table class="tableB_small">
			<tr>
				<th scope="row">商品名</th>
				<td><s:property value="%{#session.productName}"/></td>
			</tr>
			<tr>
				<th scope="row">商品名ふりがな</th>
				<td><s:property value="%{#session.productNameKana}"/></td>
			</tr>
			<tr>
				<th scope="row">値段</th>
				<td><s:property value="%{#session.price}"/>円</td>
			</tr>
			<tr>
				<th scope="row">購入個数</th>
				<td><s:select name="productCount" list="%{#session.productCountList}"/>個</td>
			</tr>
			<tr>
				<th scope="row">発売会社名</th>
				<td><s:property value="%{#session.releaseCompany}"/></td>
			</tr>
			<tr>
				<th scope="row">発売年月日</th>
				<td><s:property value="%{#session.releaseDate}"/></td>
			</tr>
			<tr>
				<th scope="row">商品詳細情報</th>
				<td><s:property value="%{#session.productDescription}"/></td>
			</tr>
		</table>
		<s:hidden name="productId" value="%{#session.productId}"/>
		<s:submit value="カートに追加" class="btn add_cart_btn" />
		</div>
	</s:form>

	<div class="similar_products">
		<s:iterator value="#session.productInfoDTOList">
			<div class="recommend_box">
			<a href='<s:url action="ProductDetailsAction">
			<s:param name="productId" value="%{productId}"/>
			</s:url>'><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' class="image_m"/></a>
			<s:property value="productName"/><br>
			</div>
		</s:iterator>
	</div>
</div>

<s:include value="footer.jsp"/>
</body>
</html>