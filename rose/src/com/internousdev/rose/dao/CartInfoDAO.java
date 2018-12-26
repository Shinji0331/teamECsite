package com.internousdev.rose.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; // select 文でのPreparedStatement戻り値に必要
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.rose.dto.CartInfoDTO;
import com.internousdev.rose.util.DBConnector;

public class CartInfoDAO {

//	============================================
//	カート画面に表示する項目を取得する
	public List<CartInfoDTO> getCartInfoDTOList(String loginId) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();
//		テーブルの結合
//		pi : product_info   ,  ci : cart_info
		String sql = "select"
				+ " ci.id as id,"
				+ " ci.user_id as user_id,"
				+ " ci.temp_user_id as temp_user_id,"
				+ " ci.product_id as product_id,"
				+ " sum(ci.product_count) as product_count,"
				+ " pi.price as price,"
				+ " pi.regist_date as regist_date,"
				+ " pi.update_date as update_date,"
				+ " pi.product_name as product_name,"
				+ " pi.product_name_kana as product_name_kana,"
				+ " pi.product_description as product_description,"
				+ " pi.category_id as category_id,"
				+ " pi.image_file_path as image_file_path,"
				+ " pi.image_file_name as image_file_name,"
				+ " pi.release_date as release_date,"
				+ " pi.release_company as release_company,"
				+ " pi.status as status,"
				+ " (sum(ci.product_count) * ci.price) as subtotal"
				+ " FROM cart_info as ci"
				+ " LEFT JOIN product_info as pi"
				+ " ON ci.product_id = pi.product_id"
				+ " WHERE ci.user_id = ?"
				+ " group by product_id";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				CartInfoDTO dto = new CartInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setUserId(rs.getString("user_id"));
				dto.setTempUserId(rs.getString("temp_user_id"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductCount(rs.getInt("product_count"));
				dto.setPrice(rs.getInt("price"));
				dto.setRegistDate(rs.getDate("regist_date"));
				dto.setUpdateDate(rs.getDate("update_date"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductNameKana(rs.getString("product_name_kana"));
				dto.setProductDescription(rs.getString("product_description"));
				dto.setCategoryId(rs.getInt("category_id"));
				dto.setImageFilePath(rs.getString("image_file_path"));
				dto.setImageFileName(rs.getString("image_file_name"));
				dto.setReleaseDate(rs.getDate("release_date"));
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setStatus(rs.getString("status"));
				dto.setSubtotal(rs.getInt("subtotal"));
				cartInfoDTOList.add(dto);
			}
		} catch (SQLException e){
			e.printStackTrace();

		} finally {

	    	try {
			con.close();
		  } catch (SQLException e) {
			e.printStackTrace();
		  }
	    }

		return cartInfoDTOList;
	}

//	============================================
//	カート内合計金額を取得する
    public int getTotalPriceInCart(String userId) {

    	DBConnector db = new DBConnector();
    	Connection con = db.getConnection();

    	int totalPrice = 0;

//    	user_id で集約した分からproduct_count * price を計算、合計する
//      → このメソッド内で有効な total_price という名前のカラムに格納
    	String sql = "select sum(product_count * price) "
    			+ "as total_price from cart_info where user_id=? group by user_id";

    	try {
    		PreparedStatement ps = con.prepareStatement(sql);
    		ps.setString(1, userId);
    		ResultSet rs = ps.executeQuery();

    		if(rs.next()) {
    			totalPrice = rs.getInt("total_price");
    		}
    	} catch (SQLException e){
    		e.printStackTrace();

		} finally {

	    	try {
			con.close();
		  } catch (SQLException e) {
			e.printStackTrace();
		  }
	    }
    	return totalPrice;
    }

//	============================================
//	カートに商品を追加する
    public int registToCart(String userId, String tempUserId, int productId, int productCount, int price) {

    	DBConnector db = new DBConnector();
    	Connection con = db.getConnection();

    	int result = 0;
    	String sql = "insert into cart_info"
    			+ "(user_id, temp_user_id, product_id, product_count, price, regist_date)"
    			+ " values (?,?,?,?,?,now())";

    	try {
    		PreparedStatement ps = con.prepareStatement(sql);
    		ps.setString(1, userId);
    		ps.setString(2, tempUserId);
    		ps.setInt(3, productId);
    		ps.setInt(4, productCount);
    		ps.setInt(5, price);
    		result = ps.executeUpdate();

    	} catch (SQLException e) {

    		e.printStackTrace();

		} finally {

	    	try {
			con.close();
		  } catch (SQLException e) {
			e.printStackTrace();
		  }
	    }

    	return result;
    }

//	============================================
//	選択されたカート内商品を削除する
    public int deleteOneInCart(String productId, String userId) {

    	DBConnector db = new DBConnector();
    	Connection con = db.getConnection();

    	int count = 0;
    	String sql = "delete from cart_info where product_id=? and user_id=?";

    	try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, productId);
			ps.setString(2, userId);
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

//	============================================
//	カート内の全商品を削除する
	public int deleteAllInCart(String userId) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		int result = 0;
		String sql = "delete from cart_info where user_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,userId);
			result = ps.executeUpdate();

		} catch (SQLException e){

			e.printStackTrace();

		} finally {

	    	try {
			con.close();
		  } catch (SQLException e) {
			e.printStackTrace();
		  }
	    }

		return result;
	}

//	============================================
//	ログイン済ユーザー情報を取得する
	public int linkToLoginId(String tempUserId, String loginId) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		int result = 0;
		String sql = "update cart_info set user_id=? , temp_user_id= NULL "
				+ "where temp_user_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, tempUserId);
			result = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

	    	try {
			con.close();
		  } catch (SQLException e) {
			e.printStackTrace();
		  }
	    }

		return result;
	}

	public CartInfoDTO getCartInfoDTOList(String loginId,String product_id) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		CartInfoDTO dto = new CartInfoDTO();
	//	テーブルの結合
	//	pi : product_info   ,  ci : cart_info
		String sql = "select product_id,product_count,price from cart_info where user_id = ? and product_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, product_id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductCount(rs.getInt("product_count"));
				dto.setPrice(rs.getInt("price"));
			}
		} catch (SQLException e){
			e.printStackTrace();

		} finally {
	    	try {
			con.close();
		  } catch (SQLException e) {
			e.printStackTrace();
		  }
	    }
		return dto;
	}
}
