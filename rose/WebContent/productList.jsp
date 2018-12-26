<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>商品一覧画面</title>
</head>
<body>
<s:include value="header.jsp" />
<div id="main">
	<div>
		<h1>商品一覧画面</h1>
		<s:if test="!keywordsErrorMessageList.size() == 0">
			<div class="message message_red">
				<s:iterator value="keywordsErrorMessageList"><s:property /><br></s:iterator>
			</div>
		</s:if>
		<s:elseif test="#session.productInfoDTOList==null">
			<div class="message message_blue">
				検索結果がありません。
			</div>
		</s:elseif>
		<s:else>
		<div class="pc">
		<s:iterator value="#session.productInfoDTOList">
			<div class="item_list_box">
				<ul>
					<li>
						<a href='<s:url action="ProductDetailsAction">
						<s:param name="productId" value="productId"/>
						</s:url>'><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' class="image_l"/></a><br>
						<div class="product_name_etc">
						<s:property value="productName"/><br>
						<s:property value="productNameKana"/><br>
						<s:property value="price"/>円<br>
						</div>
					</li>
				</ul>
			</div>
		</s:iterator>
		</div>
		<div class="responsive">
		<s:iterator value="#session.devidedList[#session.devideNumber]">
			<div class="item_list_box">
				<ul>
					<li>
						<a href='<s:url action="ProductDetailsAction">
						<s:param name="productId" value="productId"/>
						</s:url>'><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' class="image_l"/></a><br>
						<div class="product_name_etc">
						<s:property value="productName"/><br>
						<s:property value="productNameKana"/><br>
						<s:property value="price"/>円<br>
						</div>
					</li>
				</ul>
			</div>
		</s:iterator>
		<s:iterator value="#session.devideNumberList" status="No">
			<s:if test="!#session.categoryId.isEmpty()">
				<a href="<s:url action='SearchItemAction'><s:param name='devideNumber' value='%{#No.index}'/><s:param name='categoryId' value='%{#session.categoryId}'/></s:url>"><s:property /></a>
			</s:if>
			<s:else>
				<a href="<s:url action='ProductListAction'><s:param name='devideNumber' value='%{#No.index}'/></s:url>"><s:property /></a>
			</s:else>
		</s:iterator>
	</div>
		</s:else>
	</div>
</div>
<s:include value="footer.jsp" />
</body>
</html>