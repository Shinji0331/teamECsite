package com.internousdev.rose.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.rose.dao.CartInfoDAO;
import com.internousdev.rose.dao.DestinationInfoDAO;
import com.internousdev.rose.dao.UserInfoDAO;
import com.internousdev.rose.dto.DestinationInfoDTO;
import com.internousdev.rose.dto.UserInfoDTO;
import com.internousdev.rose.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
//-----------------------------フィールド変数----------------------------------------
	private String loginId;
	private String password;
	private boolean saveLoginId;
	private Map<String,Object> session;

	private List<String> loginIdErrorMessageList = new ArrayList<String>();
	private List<String> passwordErrorMessageList = new ArrayList<String>();
	private String loginErrorMessage;
//-----------------------------ログイン処理----------------------------------------
	public String execute() throws SQLException{


		String result = ERROR;

		//セッションタイムアウト
		if(!session.containsKey("mCategoryDTOList")){
			return ERROR;
		}


		//ログインIDの保存のチェックの可否
		if(saveLoginId==true) {
			session.put("saveLoginId",true);
			session.put("userId",loginId);
		}else {
			session.put("saveLoginId",false);
			session.remove("userId");
		}

		//入力チェック
		InputChecker inputChecker = new InputChecker();
		loginIdErrorMessageList = inputChecker.doCheck("ログインID", loginId, 1, 8, true, false, false, true, false, false, false, false, false);
		passwordErrorMessageList = inputChecker.doCheck("パスワード", password, 1, 16, true, false, false, true, false, false, false, false, false);

		//どちらかのエラーメッセージがある場合
		if(loginIdErrorMessageList.size()!=0 || passwordErrorMessageList.size()!=0) {
			//リダイレクト
			result = "message";
			return result;
		//エラーメッセージがない場合
		}else {
			UserInfoDAO userInfoDAO = new UserInfoDAO();
			//ユーザー情報がテーブルに存在する場合
			if(userInfoDAO.isExistsUserInfo(loginId,password)) {
				//ログインフラグの付与が完了したら
				if(userInfoDAO.login(String.valueOf(1), loginId,password) > 0) {
					//ログインフラグの付与
					session.put("logined", 1);
					//ログインしたユーザー情報の取得
					UserInfoDTO userInfoDTO = userInfoDAO.getUserInfo(loginId,password);
					session.put("loginId",userInfoDTO.getLoginId());
					session.put("password",userInfoDTO.getPassword());
					int count = 0;
					CartInfoDAO cartInfoDAO = new CartInfoDAO();

					//loginせずに買い物した客の仮IDを正式なIDに置き換える
					//tempUserIdとloginIdを引数で渡してIDを正式に変更したレコード数を変数countに代入
					count = cartInfoDAO.linkToLoginId(String.valueOf(session.get("tempUserId")),loginId);

					//カートフラグを持っている場合
					if(String.valueOf(session.get("cartFlg")).equals("1")) {
						//上記アップデートが完了すれば
						if(count > 0) {
							//決済確認画面へ
							result = "settlement";
							//宛先情報の格納（決済確認画面で使用するため）
							DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
							List<DestinationInfoDTO> destinationInfoDTOList = new ArrayList<DestinationInfoDTO>();
							destinationInfoDTOList = destinationInfoDAO.getDestinationInfo(loginId);
							Iterator<DestinationInfoDTO> iterator = destinationInfoDTOList.iterator();
							//もし宛先情報がない場合はnullを入れておく
							if(!(iterator.hasNext())) {
								destinationInfoDTOList = null;
							}
							session.put("destinationInfoDTOList",destinationInfoDTOList);
						}
					//カートフラグを持っていない場合
					}else{
						//ホーム画面へ
						result = SUCCESS;
					}
				}
			//ユーザー情報がテーブルに存在しない場合
			}else {
				loginErrorMessage = "入力されたユーザIDまたはパスワードが異なります。";
				//リダイレクト
				result = "message";
			}
			return result;
		}
	}

//-----------------------------getterとsetter-------------------------------------

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
	public void setSaveLoginId(boolean saveLoginId) {
		this.saveLoginId = saveLoginId;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
	public List<String> getLoginIdErrorMessageList(){
		return loginIdErrorMessageList;
	}
	public void setLoginIdErrorMessageList(List<String> loginIdErrorMessageList) {
		this.loginIdErrorMessageList = loginIdErrorMessageList;
	}
	public List<String> getPasswordErrorMessageList(){
		return passwordErrorMessageList;
	}
	public void setPasswordErrorMessageList(List<String> passwordErrorMessageList) {
		this.passwordErrorMessageList = passwordErrorMessageList;
	}

	public String getLoginErrorMessage() {
		return loginErrorMessage;
	}

	public void setLoginErrorMessage(String loginErrorMessage) {
		this.loginErrorMessage = loginErrorMessage;
	}
}
