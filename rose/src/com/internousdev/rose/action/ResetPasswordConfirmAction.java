package com.internousdev.rose.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.rose.dao.UserInfoDAO;
import com.internousdev.rose.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordConfirmAction extends ActionSupport implements SessionAware {

	private String loginId;
	private String password;
	private String newPassword;
	private String reConfirmationPassword;
	private Map<String, Object> session;
	private List<String> loginIdErrorMessageList = new ArrayList<String>();
	private List<String> passwordErrorMessageList = new ArrayList<String>();
	private List<String> passwordIncorrectErrorMessageList = new ArrayList<String>();
	private List<String> newPasswordErrorMessageList = new ArrayList<String>();
	private List<String> reConfirmationNewPasswordErrorMessageList = new ArrayList<String>();
	private List<String> newPasswordIncorrectErrorMessageList = new ArrayList<String>();

	public String execute() {

		String result = ERROR;

		// セッションタイムアウト
		if(!session.containsKey("mCategoryDTOList")){
			return ERROR;
		}

		InputChecker inputChecker = new InputChecker();

		loginIdErrorMessageList = inputChecker.doCheck("ユーザID", loginId, 1, 8, true, false, false, true, false, false, false, false, false);
		passwordErrorMessageList = inputChecker.doCheck("現在のパスワード", password, 1, 16, true, false, false, true, false, false, false, false, false);
		newPasswordErrorMessageList = inputChecker.doCheck("新しいパスワード", newPassword, 1, 16, true, false, false, true, false, false, false, false, false);
		reConfirmationNewPasswordErrorMessageList = inputChecker.doCheck("（再確認）", reConfirmationPassword, 1, 16, true, false, false, true, false, false, false, false, false);

		// 一度目のパスワードと二度目のパスワードが同じかを検証
		newPasswordIncorrectErrorMessageList = inputChecker.doPasswordCheck(newPassword, reConfirmationPassword);

		// セッションにユーザIDを格納して再遷移時にも表示
		session.put("resetPasswordLoginId", loginId);

		// □文字のエラーメッセージがない場合
		if(loginIdErrorMessageList.size()==0
		&& passwordErrorMessageList.size()==0
		&& newPasswordErrorMessageList.size()==0
		&& reConfirmationNewPasswordErrorMessageList.size()==0
		) {

			UserInfoDAO userInfoDAO = new UserInfoDAO();
			// ◯ 入力したID、パスワードが存在する場合
			if(userInfoDAO.isExistsUserInfo(loginId, password)) {
				// △ 新しいパスワードと（再入力）が一致する場合
				if (newPasswordIncorrectErrorMessageList.size()==0) {
					// 隠されたパスワードを変数に代入
					int beginIndex = 0;
					int endIndex = 1;
					StringBuilder stringBuilder = new StringBuilder("****************");
					String concealedPassword = stringBuilder.replace(beginIndex, endIndex, newPassword.substring(beginIndex,endIndex)).toString();
					// 新しいパスワード、隠されたパスワードを格納
					session.put("newPassword", newPassword);
					session.put("concealedPassword", concealedPassword);
					result = SUCCESS;
					// △ 新しいパスワードと（再入力）が一致しない場合
				} else {
					result = "message";
				}
				// ◯ 入力したID、パスワードが存在しないとき
			} else {
				// エラーメッセージをセッションに格納
				passwordIncorrectErrorMessageList.add("ユーザIDまたは現在のパスワードが異なります。");
				result = "message";
			}
			// □ エラーメッセージがある場合
		} else {
			result = "message";
		}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getReConfirmationPassword() {
		return reConfirmationPassword;
	}
	public void setReConfirmationPassword(String reConfirmationPassword) {
		this.reConfirmationPassword = reConfirmationPassword;
	}

	public List<String> getLoginIdErrorMessageList() {
		return loginIdErrorMessageList;
	}

	public void setLoginIdErrorMessageList(List<String> loginIdErrorMessageList) {
		this.loginIdErrorMessageList = loginIdErrorMessageList;
	}

	public List<String> getPasswordErrorMessageList() {
		return passwordErrorMessageList;
	}

	public void setPasswordErrorMessageList(List<String> passwordErrorMessageList) {
		this.passwordErrorMessageList = passwordErrorMessageList;
	}

	public List<String> getPasswordIncorrectErrorMessageList() {
		return passwordIncorrectErrorMessageList;
	}

	public void setPasswordIncorrectErrorMessageList(List<String> passwordIncorrectErrorMessageList) {
		this.passwordIncorrectErrorMessageList = passwordIncorrectErrorMessageList;
	}

	public List<String> getNewPasswordErrorMessageList() {
		return newPasswordErrorMessageList;
	}

	public void setNewPasswordErrorMessageList(List<String> newPasswordErrorMessageList) {
		this.newPasswordErrorMessageList = newPasswordErrorMessageList;
	}

	public List<String> getReConfirmationNewPasswordErrorMessageList() {
		return reConfirmationNewPasswordErrorMessageList;
	}

	public void setReConfirmationNewPasswordErrorMessageList(List<String> reConfirmationNewPasswordErrorMessageList) {
		this.reConfirmationNewPasswordErrorMessageList = reConfirmationNewPasswordErrorMessageList;
	}

	public List<String> getNewPasswordIncorrectErrorMessageList() {
		return newPasswordIncorrectErrorMessageList;
	}

	public void setNewPasswordIncorrectErrorMessageList(List<String> newPasswordIncorrectErrorMessageList) {
		this.newPasswordIncorrectErrorMessageList = newPasswordIncorrectErrorMessageList;
	}
}
