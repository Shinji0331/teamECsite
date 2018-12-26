package com.internousdev.rose.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.rose.dao.MCategoryDAO;
import com.internousdev.rose.dao.ProductInfoDAO;
import com.internousdev.rose.dto.MCategoryDTO;
import com.internousdev.rose.dto.ProductInfoDTO;
import com.internousdev.rose.util.CommonUtility;
import com.internousdev.rose.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class SearchItemAction extends ActionSupport implements SessionAware{

	private String categoryId;
	private String keywords;
	private int devideNumber;
	private Map<String, Object> session;
	private List<String> keywordsErrorMessageList = new ArrayList<String>();

	public String execute(){

		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
		List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();

		//セッションタイムアウト
		if(!session.containsKey("mCategoryDTOList")){
			return ERROR;
		}

		String result = ERROR;

		InputChecker inputChecker = new InputChecker();
		// keywords が空白、null、スペースのとき
		if(StringUtils.isBlank(keywords)){
			keywords = "";
		}else{
		// 全角スペースを半角スペースに置き換え、連続する複数の半角スペースを半角スペース１つに置き換える
			keywords = keywords.replaceAll("　", " ").replaceAll("\\s{2,}", " ").trim();
		}

		if(!(keywords.equals(""))){
		// keywords に入力していい文字を指定し確認を行う
			keywordsErrorMessageList = inputChecker.doCheck("検索ワード",keywords,0,16,true,true,true,true,false,true,false,true,true);

			if(!(keywordsErrorMessageList.isEmpty())){

				return SUCCESS;
			}
		}

		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		// 検索
		switch(categoryId){
			case "1":
				productInfoDTOList = productInfoDAO.getProductInfoListAll(keywords.split(" "));
				result = SUCCESS;
				break;

			default:
				productInfoDTOList = productInfoDAO.getProductInfoListByKeywords(keywords.split(" "), categoryId);
				result = SUCCESS;
				break;
		}
		if(productInfoDTOList.isEmpty()){
			productInfoDTOList = null;
		}
		session.put("productInfoDTOList", productInfoDTOList);

		//========= pagination =========
		CommonUtility cu = new CommonUtility();
		List<List<ProductInfoDTO>> devidedList = cu.devideList(productInfoDTOList, 6);
		session.put("devidedList", devidedList);
		if (session.get("devideNumber") == null) {
			session.put("devideNumber", 0);
		} else {
			session.put("devideNumber", devideNumber);
		}
		List<Object> devideNumberList = new ArrayList<Object>();
		// NullPointerException対策(devidedList.size())
		if (devidedList != null) {
			for(int i = 0; i < devidedList.size(); i++) {
				devideNumberList.add(i + 1);
			}
		}
		System.out.println(devideNumberList);
		session.put("devideNumberList", devideNumberList);
		session.put("categoryId", categoryId);
		//==============================

	// 検索カテゴリーの登録
	if(!session.containsKey("mCategoryList")) {
		MCategoryDAO mCategoryDAO = new MCategoryDAO();
		try {
			mCategoryDTOList = mCategoryDAO.getMCategoryList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.put("mCategoryDTOList", mCategoryDTOList);
	}
	return result;
	}

	// getter・setter
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public int getDevideNumber() {
		return devideNumber;
	}
	public void setDevideNumber(int devideNumber) {
		this.devideNumber = devideNumber;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public List<String> getKeywordsErrorMessageList() {
		return keywordsErrorMessageList;
	}
	public void setKeywordsErrorMessageList(List<String> keywordsErrorMessageList) {
		this.keywordsErrorMessageList = keywordsErrorMessageList;
	}
}
