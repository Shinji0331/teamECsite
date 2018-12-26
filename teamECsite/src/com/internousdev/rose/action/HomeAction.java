package com.internousdev.rose.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.rose.dao.MCategoryDAO;
import com.internousdev.rose.dto.MCategoryDTO;
import com.internousdev.rose.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;

	public String execute(){

		List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();

		if(!session.containsKey("mCategoryDTOList")) {
			MCategoryDAO mCategoryDAO = new MCategoryDAO();
			try {
				mCategoryDTOList = mCategoryDAO.getMCategoryList();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			session.put("mCategoryDTOList", mCategoryDTOList);
		}

		// 仮のログインIDを発行
		if(!(session.containsKey("loginId")) && !(session.containsKey("tempUserId"))){
			CommonUtility commonUtility = new CommonUtility();
			session.put("tempUserId", commonUtility.getRamdomValue());
		}
		// ログイン状態不明のとき、未ログイン状態にする
		if(!(session.containsKey("logined"))){
			session.put("logined",0);
		}


		return SUCCESS;
	}

	// getter・setter
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
