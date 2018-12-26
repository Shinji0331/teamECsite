<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>

<html>

<head>
	<meta charset=UTF-8>
	<link rel="stylesheet" href="./css/rose.css">
	<link rel="stylesheet" href="./css/responsive.css">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
	<title>header</title>
	<script>
		function goLoginAction(){
			document.getElementById('form').action="GoLoginAction"
		}
		function goMyPageAction(){
			document.getElementById('form').action="MyPageAction"
		}
		function goCartAction(){
			document.getElementById('form').action="CartAction"
		}
		function goProductListAction(){
			document.getElementById('form').action="ProductListAction"
		}
		function goLogoutAction(){
			document.getElementById('form').action="LogoutAction"
		}
		function goSearchItemAction(){
			document.getElementById('form').action="SearchItemAction"
		}
		function goSearchItemAction2(){
			document.getElementById('form2').action="SearchItemAction"
		}
	</script>
</head>
<body>
	<div id="header">
		<div class="responsive">
			<div id="nav-drawer">
		     	<input id="nav-input" type="checkbox" class="nav-unshown">
		     	<label id="nav-open" for="nav-input"><span></span></label>
		      	<label class="nav-unshown" id="nav-close" for="nav-input"></label>
		      	<div id="nav-content">
		      　		<s:form id="form2">
			      		<s:if test="#session.containsKey('mCategoryDTOList')">
							<s:select name="categoryId" class="category" list="#session.mCategoryDTOList" listValue="categoryName" listKey="categoryId"/>
						</s:if>
						<div class="serchframe">
							<s:textfield name="keywords" class="keywords" placeholder=" 検索ワード" />
							<button type="submit" class="serchbtn" onclick="goSearchItemAction2();">
								<img src="./images/s.png" width="13px" height="13px">
							</button>
						</div>
					</s:form>
					<div class="btn_box">
				      	<s:if test="#session.logined==1">
				      		<br><a href="<s:url action='LogoutAction'/>">ログアウト</a><br>
				      	</s:if>
						<s:else>
				      		<a href="<s:url action='GoLoginAction'/>">ログイン</a><br>
				      	</s:else>
			      	</div>
			      	<div class="btn_box">
			      		<a href="<s:url action='CartAction'/>">カート</a><br>
			      	</div>
			      	<div class="btn_box">
			      		<a href="<s:url action='ProductListAction'/>">商品一覧</a><br>
			      	</div>
			      	<s:if test="#session.logined==1">
			      		<div class="btn_box">
			      			<a href="<s:url action='MyPageAction'/>">マイページ</a><br>
			      		</div>
			      	</s:if>
			    </div>
			</div>
		</div>
		<div id="team">Rose</div>
		<div id="header2">
			<s:form id="form">
				<div id="search">
				<s:if test="#session.containsKey('mCategoryDTOList')">
					<s:select name="categoryId" class="category" list="#session.mCategoryDTOList" listValue="categoryName" listKey="categoryId"/>
				</s:if>
				<s:textfield name="keywords" class="keywords" placeholder=" 検索ワード"/>
				</div>
				<div id="btn_box">
				<s:submit value="商品検索" class="btn headerbtn" onclick="goSearchItemAction();"/>
				<s:if test="#session.logined==1">
					<s:submit value="ログアウト" class="btn headerbtn" onclick="goLogoutAction();"/>
				</s:if>
				<s:else>
					<s:submit value="ログイン" class="btn headerbtn" onclick="goLoginAction();"/>
				</s:else>
				<s:submit value="カート" class="btn headerbtn" onclick="goCartAction();"/>
				<s:submit value="商品一覧" class="btn headerbtn" onclick="goProductListAction();"/>
				<s:if test="#session.logined==1">
					<s:submit value="マイページ" class="btn headerbtn" onclick="goMyPageAction();"/>
				</s:if>
				</div>
			</s:form>
		</div>
	</div>

</body>
</html>