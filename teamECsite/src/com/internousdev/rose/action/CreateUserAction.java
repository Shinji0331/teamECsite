package com.internousdev.rose.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CreateUserAction extends ActionSupport implements SessionAware {

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private String email;
	private String loginId;

	public Map<String, Object> session;

	public String execute() {
		String result = ERROR;

		List<String> sexList = new ArrayList<String>();
		final String MALE = "男性";
		final String FEMALE = "女性";

		// セッションタイムアウト
		if(!session.containsKey("mCategoryDTOList")){
			return ERROR;
		}

		// 入力値をリセット（ログイン画面から再遷移した場合の対策）
		session.remove("familyName");
		session.remove("firstName");
		session.remove("familyNameKana");
		session.remove("firstNameKana");
		session.remove("sex");
		session.remove("email");
		session.remove("loginId");

		session.put("familyName", familyName);
		session.put("firstName", firstName);
		session.put("familyNameKana", familyNameKana);
		session.put("firstNameKana", firstNameKana);
		session.put("email", email);
		session.put("loginId", loginId);

		if(sex==null) {
			session.put("sex", MALE);
			sex = MALE;
		}else {
			session.put("sex", sex);
		}
		sexList.add(MALE);
		sexList.add(FEMALE);
		session.put("sexList", sexList);

		result = SUCCESS;
		return result;
	}

	// ====== getter, setter ======

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyNameKana() {
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}

	public String getFirstNameKana() {
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
}
