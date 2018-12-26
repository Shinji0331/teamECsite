package com.internousdev.rose.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.rose.dto.PurchaseHistoryInfoDTO;
import com.internousdev.rose.util.DBConnector;

public class PurchaseHistoryInfoDAO {

	public List<PurchaseHistoryInfoDTO> getPurchaseHistoryList(String loginId){
	DBConnector db = new DBConnector();
	Connection con = db.getConnection();
	List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList = new ArrayList<PurchaseHistoryInfoDTO>();
	String sql = "SELECT phi.id as id,"/*ID*/
			+ " phi.user_id as user_id,"/*ユーザーID*/
			+ " phi.product_count as product_count,"/*個数*/
			+ " pi.product_id as product_id,"/*商品ID*/
			+ " pi.product_name as product_name,"/*商品名*/
			+ " pi.product_name_kana as product_name_kana,"
			+ " pi.product_description as product_description,"/*商品詳細*/
			+ " pi.price as pi_price,"/*商品価格*/
			+ " pi.image_file_name as image_file_name,"/*画像ファイル名*/
			+ " pi.image_file_path as image_file_path,"/*画像ファイルパス*/
			+ " pi.release_company as release_company,"/*発売会社*/
			+ " pi.release_date as release_date,"/*発売日*/
			+ " phi.price as price,"/*金額*/
			+ " phi.destination_id as destination_id,"//宛先情報ID
			+ " phi.regist_date as regist_date,"/*登録日*/
			+ " phi.update_date as update_date"/*更新日*/
			+ " FROM purchase_history_info as phi"
			+ " LEFT JOIN product_info as pi"
			+ " ON phi.product_id = pi.product_id"
			+ " WHERE phi.user_id = ?"
			+ " ORDER BY regist_date DESC";

	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, loginId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			dto.setId(rs.getInt("id"));
			dto.setUserId(rs.getString("user_id"));
			dto.setProductId(rs.getInt("product_id"));
			dto.setProductCount(rs.getInt("product_count"));
			dto.setPrice(rs.getInt("pi_price"));
			dto.setDestinationId(rs.getInt("destination_id"));
			dto.setRegistDate(rs.getDate("regist_date"));
			dto.setUpdateDate(rs.getDate("update_date"));
			dto.setProductName(rs.getString("product_name"));
			dto.setProductNameKana(rs.getString("product_name_kana"));
			dto.setImageFilePath(rs.getString("image_file_path"));
			dto.setImageFileName(rs.getString("image_file_name"));
			dto.setReleaseCompany(rs.getString("release_company"));
			dto.setReleaseDate(rs.getDate("release_date"));
			int total_price = rs.getInt("pi_price") * rs.getInt("product_count");//total_priceは（商品価格　＊　個数）の合計金額
			dto.setTotalPrice(total_price);
			purchaseHistoryInfoDTOList.add(dto);
		}
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	return purchaseHistoryInfoDTOList;
}

//	登録機能
	public int regist(String loginId, int productId, int productCount, int destinationId, int price) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "INSERT INTO purchase_history_info(user_id, product_id, product_count, price, destination_id, regist_date, update_date)"
				+ " VALUES(?,?,?,?,?,now(), now())";
		int count = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setInt(2, productId);
			ps.setInt(3, productCount);
			ps.setInt(4, price);
			ps.setInt(5, destinationId);
			count = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

//	削除機能
		public int deleteAll(String loginId) {
			DBConnector db = new DBConnector();
			Connection con = db.getConnection();
			String sql = "DELETE FROM purchase_history_info WHERE user_id=?";
			int count = 0;
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, loginId);
				count = ps.executeUpdate();
				con.close();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			return count;
		}
}
