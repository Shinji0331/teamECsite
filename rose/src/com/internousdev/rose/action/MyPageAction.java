 package com.internousdev.rose.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.rose.dao.UserInfoDAO;
import com.internousdev.rose.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {
	private Map<String,Object> session;

	public String execute() {
		String result = ERROR;

		//セッションタイムアウト
//		if(!session.containsKey("mCategoryDTOList")){
//			return ERROR;
//		}
		if(session == null){
			return ERROR;
		}

		UserInfoDAO userInfoDAO = new UserInfoDAO();
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		try {
			userInfoDTO = userInfoDAO.getUserInfo(session.get("loginId").toString());
		}catch(NullPointerException e) {
			return ERROR;
		}
		if(userInfoDTO != null) {
			session.put("familyName", userInfoDTO.getFamilyName());
			session.put("firstName", userInfoDTO.getFirstName());
			session.put("familyNameKana", userInfoDTO.getFamilyNameKana());
			session.put("firstNameKana", userInfoDTO.getFirstNameKana());
			String sex = userInfoDTO.getSex();
			if(sex.equals("0")) {
				session.put("sex", "男性");
			} else if(sex.equals("1")) {
				session.put("sex", "女性");
			}
			session.put("email", userInfoDTO.getEmail());
			result = SUCCESS;
		}
		return result;
	}

	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
