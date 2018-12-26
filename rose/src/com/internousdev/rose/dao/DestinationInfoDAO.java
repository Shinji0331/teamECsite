package com.internousdev.rose.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.rose.dto.DestinationInfoDTO;
import com.internousdev.rose.util.DBConnector;

public class DestinationInfoDAO {

	public int insert(String user_id,String family_name,String first_name,String family_name_kana,String first_name_kana,String user_address,String tel_number,String email){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		int count = 0;
		String sql = "INSERT into destination_info("
				+ "user_id,family_name,first_name,"
				+ "family_name_kana,first_name_kana,user_address,"
				+ "tel_number,email,regist_date)"
				+ "VALUES(?,?,?,?,?,?,?,?,now())";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setString(2, family_name);
			ps.setString(3, first_name);
			ps.setString(4, family_name_kana);
			ps.setString(5, first_name_kana);
			ps.setString(6, user_address);
			ps.setString(7, tel_number);
			ps.setString(8, email);
			count = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	public List<DestinationInfoDTO> getDestinationInfo(String loginId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		List<DestinationInfoDTO> destinationInfoDTOList = new ArrayList<DestinationInfoDTO>();
		String sql = "SELECT id,family_name,first_name,family_name_kana,"
				+ "first_name_kana,user_address,tel_number,email "
				+ "FROM destination_info "
				+ "WHERE user_id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				DestinationInfoDTO dto = new DestinationInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setFamilyName(rs.getString("family_name"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setFamilyNameKana(rs.getString("family_name_kana"));
				dto.setFirstNameKana(rs.getString("first_name_kana"));
				dto.setUserAddress(rs.getString("user_address"));
				dto.setTelNumber(rs.getString("tel_number"));
				dto.setEmail(rs.getString("email"));
				destinationInfoDTOList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return destinationInfoDTOList;
	}
}
