package com.internousdev.rose.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.rose.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserCompleteAction extends ActionSupport implements SessionAware {

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private String email;
	private String loginId;
	private String password;
	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;

		//セッションタイムアウト
		if(!session.containsKey("mCategoryDTOList")){
			return ERROR;
		}

		UserInfoDAO UserInfoDAO = new UserInfoDAO();
		// データベースに入れるために性別をString型=>int型に変換
		int sexNumber = 0;
		if (sex.equals("男性")) {
			sexNumber = 0;
		} else if (sex.equals("女性")) {
			sexNumber = 1;
		}
		int count = UserInfoDAO.createUser(familyName,firstName,familyNameKana,firstNameKana,sexNumber,email,loginId,password);
		if(count > 0) {

			result = SUCCESS;
		}
		return result;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
