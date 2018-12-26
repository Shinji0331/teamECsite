package com.internousdev.rose.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.rose.dao.ProductInfoDAO;
import com.internousdev.rose.dto.ProductInfoDTO;
import com.internousdev.rose.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class ProductListAction extends ActionSupport implements SessionAware {
	private int devideNumber;
	private Map<String,Object> session;

	public String execute() {
		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
		String result = ERROR;
		if(!session.containsKey("mCategoryDTOList")){
			return ERROR;
		}

		productInfoDTOList = productInfoDAO.getProductInfoList();
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
		for(int i = 0; i < devidedList.size(); i++) {
			devideNumberList.add(i + 1);
		}
		System.out.println(devideNumberList);
		session.put("devideNumberList", devideNumberList);
		session.remove("categoryId");// productList.jspの分岐対策（SearchItemActionとの競合）
		//==============================

		result = SUCCESS;
		return result;

	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}
	public Map<String,Object> getSession(){
		return this.session;
	}

	public int getDevideNumber() {
		return devideNumber;
	}

	public void setDevideNumber(int devideNumber) {
		this.devideNumber = devideNumber;
	}
}
