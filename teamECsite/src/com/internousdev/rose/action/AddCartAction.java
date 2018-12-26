package com.internousdev.rose.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.rose.dao.CartInfoDAO;
import com.internousdev.rose.dao.ProductInfoDAO;
import com.internousdev.rose.dto.CartInfoDTO;
import com.internousdev.rose.dto.ProductInfoDTO;
import com.internousdev.rose.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class AddCartAction extends ActionSupport implements SessionAware {

	private int productId;
	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private int price;
	private int productCount;
	private String releaseCompany;
	private Date releaseDate;
	private String productDescription;

	private Map<String, Object> session;

	public String execute() {

		String result = ERROR;
		if(!session.containsKey("mCategoryDTOList")){
			return ERROR;
		}

		// 検証ツールでの購入個数変更の対策
		if (productCount <= 0 || productCount > 5) {
			return ERROR;
		}

		String userId = null;
		String tempUserId = null;

//		ゲストユーザーに仮ユーザーIDを発行する
		if (!(session.containsKey("loginId")) && !(session.containsKey("tempUserId"))) {

            CommonUtility commonUtility = new CommonUtility();
            session.put("tempUserId", commonUtility.getRamdomValue());
		}

		if (session.containsKey("loginId")) {

			userId = String.valueOf(session.get("loginId"));
		}

		if (!(session.containsKey("loginId")) && session.containsKey("tempUserId")) {

			userId = String.valueOf(session.get("tempUserId"));
			tempUserId = String.valueOf(session.get("tempUserId"));
		}

		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();
		productInfoDTO = productInfoDAO.getProductInfo(productId);
		if(productInfoDTO.getProductName()==null) {
			return ERROR;
		}

		CartInfoDAO cartInfoDAO = new CartInfoDAO();

		int countAddedItem = cartInfoDAO.registToCart(userId, tempUserId, productId, productCount, (int)session.get("price"));

		if (countAddedItem > 0) {
			result = SUCCESS;
		}

		List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();
		cartInfoDTOList = cartInfoDAO.getCartInfoDTOList(userId);
		Iterator<CartInfoDTO> iterator = cartInfoDTOList.iterator();

		if(!(iterator.hasNext())) {

			cartInfoDTOList = null;
		}

		session.put("cartInfoDTOList", cartInfoDTOList);

		int totalPrice = Integer.parseInt(String.valueOf(cartInfoDAO.getTotalPriceInCart(userId)));
		session.put("totalPrice", totalPrice);

		return result;

	}

//	=========================================
//	getters and setters

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public String getReleaseCompany() {
		return releaseCompany;
	}

	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
