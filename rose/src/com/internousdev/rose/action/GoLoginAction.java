package com.internousdev.rose.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class GoLoginAction extends ActionSupport implements SessionAware{

	private String cartFlg;
	private Map<String, Object> session;

	public String execute() throws SQLException{
		cartFlg ="0";
		session.put("cartFlg", cartFlg);

		String result = SUCCESS;

		//セッションタイムアウト
		if(!session.containsKey("mCategoryDTOList")){
			return ERROR;
		}

		return result;
	}

	public String getCartFlg(){
		return cartFlg;
	}

	public void setCartFlg(String cartFlg){
		this.cartFlg = cartFlg;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
