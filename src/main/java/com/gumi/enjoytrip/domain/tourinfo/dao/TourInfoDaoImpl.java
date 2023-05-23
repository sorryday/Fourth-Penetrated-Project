package com.gumi.enjoytrip.domain.tourinfo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gumi.enjoytrip.domain.tourinfo.dto.TourInfoDto;
import com.gumi.enjoytrip.util.DBUtil;

public class TourInfoDaoImpl implements TourInfoDao {
	private static TourInfoDaoImpl instance;
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static TourInfoDto map = null;
	private ResultSet rs = null;

	public static TourInfoDao getInstance() {
		if (instance == null) {
			instance = new TourInfoDaoImpl();
		}
		return instance;
	}

	@Override
	public List<TourInfoDto> getTourInfoList(int sidoCode, int gugunCode, int type) {
		List<TourInfoDto> list = new ArrayList<TourInfoDto>();

		try {
			conn = DBUtil.getInstance().getConnection();
			String sql = "select * from attraction_info where content_type_id = ? and sido_code = ? and gugun_code = ?";
			String sql2 = "select * from attraction_description where content_id = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, type);
			pstmt.setInt(2, sidoCode);
			pstmt.setInt(3, gugunCode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int tmp = rs.getInt("content_id");
				map = new TourInfoDto();
				map.setAddress(rs.getString("addr1"));
				map.setContentId(rs.getInt("content_id"));
				map.setContentTypeId(rs.getInt("content_type_id"));
				map.setImage(rs.getString("first_image"));
				map.setGugunCode(rs.getInt("gugun_code"));
				map.setLatitude(rs.getDouble("latitude"));
				map.setLongitude(rs.getDouble("longitude"));
				map.setTitle(rs.getString("title"));

				// ---- content 내용 추가
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setInt(1, tmp);
				ResultSet rs2 = pstmt2.executeQuery();
				while (rs2.next()) {
					map.setContent(rs2.getString("overview"));
				}

				list.add(map);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}