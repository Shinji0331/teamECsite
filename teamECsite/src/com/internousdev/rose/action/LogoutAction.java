package com.internousdev.rose.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.rose.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware{
//-----------------------------フィールド変数----------------------------------------
	private Map<String,Object> session;
//-----------------------------ログアウト処理----------------------------------------
	public String execute(){

		//セッションタイムアウト
		if(!session.containsKey("mCategoryDTOList")){
			return ERROR;
		}

		UserInfoDAO dao = new UserInfoDAO();

		boolean saveLoginId = Boolean.valueOf(String.valueOf(session.get("saveLoginId")));
		String loginId = session.get("loginId").toString();
		//DBのloginedを更新
		dao.login(String.valueOf(0),session.get("loginId").toString(),
				session.get("password").toString());

		//セッションクリア
		session.clear();
		//セッションのloginedをログアウト状態で入力
		session.put("logined",0);
		//IDの保存の有無・IDをセッションに格納し直す
		session.put("saveLoginId", saveLoginId);
		session.put("userId", loginId);

		return SUCCESS;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

}
