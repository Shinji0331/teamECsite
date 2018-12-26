package com.internousdev.rose.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.rose.dto.UserInfoDTO;
import com.internousdev.rose.util.DBConnector;

public class UserInfoDAO {
//-----------------------------ユーザー情報の登録----------------------------------------
	public int createUser(String familyName, String firstName, String familyNameKana,
			String firstNameKana, int sexNumber, String email, String loginId, String password) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;
		String sql = "INSERT INTO user_info(user_id, password, family_name, first_name, family_name_kana, "
				+ "first_name_kana, sex, email, status, logined, regist_date, update_date) "
				+ "VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now(), now())";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			ps.setString(3, familyName);
			ps.setString(4, firstName);
			ps.setString(5, familyNameKana);
			ps.setString(6, firstNameKana);
			ps.setInt(7, sexNumber);
			ps.setString(8, email);
			ps.setInt(9, 0); // status...使っていない
			ps.setInt(10, 1); // logined...ログイン状態にする
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
//-----------------------------ログイン認証用----------------------------------------
	public boolean isExistsUserInfo(String loginId,String password){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		boolean result = false;
		//ユーザーIDとパスワードが合致するレコードをカラムcountとしてuser_infoテーブルから取得
		String sql = "SELECT count(*) as count FROM user_info WHERE user_id=? AND password=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			//カラムcountのレコード数が１つ以上あれば
			while(rs.next()) {
				if(rs.getInt("count")>0) {
					result = true;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
//-----------------------------ユーザ登録用----------------------------------------
	public boolean isExistsUserInfo(String loginId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		boolean result = false;
		//ユーザーIDとパスワードが合致するレコードをカラムcountとしてuser_infoテーブルから取得
		String sql = "SELECT count(*) as count FROM user_info WHERE user_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ResultSet rs = ps.executeQuery();
			//カラムcountのレコード数が１つ以上あれば
			while(rs.next()) {
				if(rs.getInt("count")>0) {
					result = true;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
//-----------------------------ログインフラグ用----------------------------------------
	public int login(String logined,String loginId,String password) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int result = 0;
		//user_infoテーブルのuser_idが合致するloginedカラムにsession.loginedの値をセットする
		String sql = "UPDATE user_info SET logined = ? WHERE user_id = ? AND password = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, logined);
			ps.setString(2, loginId);
			ps.setString(3, password);
			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
//-----------------------------ユーザー情報の取得1(Login)---------------------------------------
	public UserInfoDTO getUserInfo(String loginId,String password) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		String sql = "SELECT * FROM user_info where user_id=? AND password=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				userInfoDTO.setId(rs.getInt("id"));
				userInfoDTO.setLoginId(rs.getString("user_id"));
				userInfoDTO.setPassword(rs.getString("password"));
				userInfoDTO.setFamilyName(rs.getString("family_name"));
				userInfoDTO.setFirstName(rs.getString("first_name"));
				userInfoDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				userInfoDTO.setSex(rs.getString("sex"));
				userInfoDTO.setEmail(rs.getString("email"));
				userInfoDTO.setStatus(rs.getString("status"));
				userInfoDTO.setLogined(rs.getInt("status"));
				userInfoDTO.setRegistDate(rs.getDate("regist_date"));
				userInfoDTO.setUpdateDate(rs.getDate("update_date"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return userInfoDTO;
	}
//-----------------------------ユーザー情報の取得2(MyPage)----------------------------------------
	public UserInfoDTO getUserInfo(String loginId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		String sql = "SELECT * FROM user_info where user_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				userInfoDTO.setId(rs.getInt("id"));
				userInfoDTO.setLoginId(rs.getString("user_id"));
				userInfoDTO.setPassword(rs.getString("password"));
				userInfoDTO.setFamilyName(rs.getString("family_name"));
				userInfoDTO.setFirstName(rs.getString("first_name"));
				userInfoDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				userInfoDTO.setFirstNameKana(rs.getString("first_name_kana"));
				userInfoDTO.setSex(rs.getString("sex"));
				userInfoDTO.setEmail(rs.getString("email"));
				userInfoDTO.setStatus(rs.getString("status"));
				userInfoDTO.setLogined(rs.getInt("status"));
				userInfoDTO.setRegistDate(rs.getDate("regist_date"));
				userInfoDTO.setUpdateDate(rs.getDate("update_date"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return userInfoDTO;
	}
//-----------------------------パスワード再設定----------------------------------------
	public int resetPassword(String loginId,String password) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "UPDATE user_info set password=? WHERE user_id=?";
		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, loginId);
			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
