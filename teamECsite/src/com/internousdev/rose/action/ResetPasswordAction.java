package com.internousdev.rose.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordAction extends ActionSupport implements SessionAware {

	private String loginId;
	private Map<String, Object> session;
	public String execute() {
		String result = ERROR;

		// セッションタイムアウト
		if(!session.containsKey("mCategoryDTOList")){
			return ERROR;
		}

		// // 入力値をリセット（ログイン画面から再遷移した場合の対策）
		session.remove("resetPasswordLoginId");
		session.remove("password");
		session.remove("newPassword");
		session.remove("concealedPassword");

		// confirm.jspで戻るボタンを押したときの対処
		session.put("resetPasswordLoginId", loginId);

		result = SUCCESS;
		return result;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
}
