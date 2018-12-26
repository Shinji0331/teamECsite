package com.internousdev.rose.dto;

import java.util.Date;

public class CartInfoDTO {

//		====================================
//		fields
		private int id;  // 通しNo.
		private String userId;  // ユーザーID
		private String tempUserId;  // ゲストユーザー用一時ID

		private int productId;  // 商品ID
		private String productName;  // 商品名
		private String productNameKana;  // 商品名かな
		private String imageFilePath;  // 商品画像パス
		private String imageFileName;  // 商品画像名
		private int price;  // 値段（単価）
		private String releaseCompany;  // 発売会社
		private Date releaseDate;  // 発売年月日
		private int productCount;  // 購入個数？
		private String status;  // *****
		private int subtotal;  // カート内合計金額？

		private String productDescription;  // 商品詳細
		private int categoryId;  // 商品カテゴリID
		private Date registDate;  // 登録日
		private Date updateDate;  // 更新日

//		====================================
//		getters and setters
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getTempUserId() {
			return tempUserId;
		}
		public void setTempUserId(String tempUserId) {
			this.tempUserId = tempUserId;
		}
		public int getProductId() {
			return productId;
		}
		public void setProductId(int productId) {
			this.productId = productId;
		}
		public int getProductCount() {
			return productCount;
		}
		public void setProductCount(int productCount) {
			this.productCount = productCount;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public Date getRegistDate() {
			return registDate;
		}
		public void setRegistDate(Date registDate) {
			this.registDate = registDate;
		}
		public Date getUpdateDate() {
			return updateDate;
		}
		public void setUpdateDate(Date updateDate) {
			this.updateDate = updateDate;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public String getProductNameKana() {
			return productNameKana;
		}
		public void setProductNameKana(String productNameKana) {
			this.productNameKana = productNameKana;
		}
		public String getProductDescription() {
			return productDescription;
		}
		public void setProductDescription(String productDescription) {
			this.productDescription = productDescription;
		}
		public int getCategoryId() {
			return categoryId;
		}
		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}
		public String getImageFilePath() {
			return imageFilePath;
		}
		public void setImageFilePath(String imageFilePath) {
			this.imageFilePath = imageFilePath;
		}
		public String getImageFileName() {
			return imageFileName;
		}
		public void setImageFileName(String imageFileName) {
			this.imageFileName = imageFileName;
		}
		public Date getReleaseDate() {
			return releaseDate;
		}
		public void setReleaseDate(Date releaseDate) {
			this.releaseDate = releaseDate;
		}
		public String getReleaseCompany() {
			return releaseCompany;
		}
		public void setReleaseCompany(String releaseCompany) {
			this.releaseCompany = releaseCompany;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public int getSubtotal() {
			return subtotal;
		}
		public void setSubtotal(int subtotal) {
			this.subtotal = subtotal;
		}
}
