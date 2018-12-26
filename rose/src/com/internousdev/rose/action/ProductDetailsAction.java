package com.internousdev.rose.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.rose.dao.ProductInfoDAO;
import com.internousdev.rose.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductDetailsAction extends ActionSupport implements SessionAware {
	private Map<String,Object> session;
	private int productId;

	public String execute() {
		String result = ERROR;
		if(!session.containsKey("mCategoryDTOList")){
			return ERROR;
		}

		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();
		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
		productInfoDTO = productInfoDAO.getProductInfo(productId);
		if(productInfoDTO.getProductName()==null) {
			return ERROR;
		}else {
			session.put("productId", productInfoDTO.getProductId());
			session.put("productName", productInfoDTO.getProductName());
			session.put("productNameKana", productInfoDTO.getProductNameKana());
			session.put("imageFilePath", productInfoDTO.getImageFilePath());
			session.put("imageFileName", productInfoDTO.getImageFileName());
			session.put("price", productInfoDTO.getPrice());
			session.put("releaseCompany", productInfoDTO.getReleaseCompany());
			session.put("releaseDate", productInfoDTO.getReleaseDate());
			session.put("productDescription", productInfoDTO.getProductDescription());
		}
		//商品詳細画面で使う個数の数をリストに入れてます↓
		List<Integer> productCountList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		session.put("productCountList", productCountList);

		//商品詳細画面下の類似商品を並べるための処理です↓
		productInfoDTOList = productInfoDAO.getProductInfoListByCategoryId(productInfoDTO.getCategoryId(), productInfoDTO.getProductId(), 0, 3);
		Iterator<ProductInfoDTO> iterator = productInfoDTOList.iterator();
		if(!(iterator.hasNext())) {
			productCountList = null;
		}
		if(!productInfoDTOList.isEmpty() || productCountList == null) {
			session.put("productInfoDTOList", productInfoDTOList);
			result = SUCCESS;
		}
		return result;
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
