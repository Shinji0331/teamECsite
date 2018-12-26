package com.internousdev.rose.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.rose.dao.CartInfoDAO;
import com.internousdev.rose.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware{

	private String keywords;
	private Map<String, Object> session;

	public String execute() {

		String result = ERROR;
		String userId = null;
		if(!session.containsKey("mCategoryDTOList")){

			return ERROR;
		}

		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();

		if (session.containsKey("loginId")) {

			userId = String.valueOf(session.get("loginId"));

		} else if (session.containsKey("tempUserId")) {

			userId = String.valueOf(session.get("tempUserId"));
		}

		cartInfoDTOList = cartInfoDAO.getCartInfoDTOList(userId);
		Iterator<CartInfoDTO> iterator = cartInfoDTOList.iterator();

		if (!(iterator.hasNext())){
			cartInfoDTOList = null;
		}

		session.put("cartInfoDTOList", cartInfoDTOList);

		int totalPrice = Integer.parseInt(String.valueOf(cartInfoDAO.getTotalPriceInCart(userId)));
		session.put("totalPrice", totalPrice);

		result = SUCCESS;

		return result;

	}

//		========================================
//		getters and setters

		public String getKeywords() {
			return keywords;
		}

		public void setKeywords(String keywords) {
			this.keywords = keywords;
		}

		public Map<String, Object> getSession() {
			return session;
		}

		@Override
		public void setSession(Map<String, Object> session) {
			this.session = session;
		}

	}