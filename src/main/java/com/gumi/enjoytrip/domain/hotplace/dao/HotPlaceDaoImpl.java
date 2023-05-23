package com.gumi.enjoytrip.domain.hotplace.dao;

import com.gumi.enjoytrip.domain.hotplace.dto.HotPlaceCreateDto;
import com.gumi.enjoytrip.domain.hotplace.dto.HotPlaceDto;
import com.gumi.enjoytrip.domain.hotplace.dto.HotPlaceListDto;
import com.gumi.enjoytrip.domain.hotplace.dto.HotPlaceUpdateDto;
import com.gumi.enjoytrip.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotPlaceDaoImpl implements HotPlaceDao {
    private static HotPlaceDaoImpl instance;

    private HotPlaceDaoImpl() {
    }

    public static HotPlaceDaoImpl getInstance() {
        if (instance == null)
            instance = new HotPlaceDaoImpl();
        return instance;
    }

    @Override
    public void createHotPlace(HotPlaceCreateDto hotPlaceCreateDto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            String sql = "INSERT INTO hotplace (title, content, place_type, latitude, longitude, user_id, date) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, hotPlaceCreateDto.getTitle());
            pstmt.setString(2, hotPlaceCreateDto.getContent());
            pstmt.setInt(3, hotPlaceCreateDto.getPlaceType());
            pstmt.setDouble(4, hotPlaceCreateDto.getLatitude());
            pstmt.setDouble(5, hotPlaceCreateDto.getLongitude());
            pstmt.setLong(6, hotPlaceCreateDto.getCreatorId());
            pstmt.setDate(7, new Date(hotPlaceCreateDto.getDate().getTime()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close(pstmt, conn);
        }
    }

    @Override
    public List<HotPlaceListDto> getHotplaceList(int offset, int size) {
        List<HotPlaceListDto> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            String sql = "SELECT hotplace.id, hotplace.title, hotplace.place_type, hotplace.created_at, hotplace.user_id, hotplace.latitude, hotplace.longitude, user.nickname FROM hotplace INNER JOIN user ON hotplace.user_id = user.id ORDER BY hotplace.id DESC LIMIT ? OFFSET ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, size);
            pstmt.setInt(2, offset);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                HotPlaceListDto dto = new HotPlaceListDto();
                dto.setId(rs.getLong("hotplace.id"));
                dto.setTitle(rs.getString("hotplace.title"));
                dto.setPlaceType(rs.getInt("hotplace.place_type"));
                dto.setCreatedAt(rs.getString("hotplace.created_at"));
                dto.setCreatorId(rs.getLong("hotplace.user_id"));
                dto.setCreatorNickname(rs.getString("user.nickname"));
                list.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close(rs, pstmt, conn);
        }
        return list;
    }

    @Override
    public List<HotPlaceListDto> getHotPlaceListByKeyword(String condition, String keyword, int offset, int size) {
        List<HotPlaceListDto> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            if (condition.equals("id")) {
                String sql = "SELECT hotplace.id, hotplace.title, hotplace.place_type, hotplace.created_at, hotplace.user_id, hotplace.latitude, hotplace.longitude, user.nickname FROM hotplace INNER JOIN user ON hotplace.user_id = user.id WHERE hotplace.id = ? ORDER BY hotplace.id DESC LIMIT ? OFFSET ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setLong(1, Long.parseLong(keyword));
                pstmt.setInt(2, size);
                pstmt.setInt(3, offset);
            } else if (condition.equals("nickname")) {
                String sql = "SELECT hotplace.id, hotplace.title, hotplace.place_type, hotplace.created_at, hotplace.user_id, hotplace.latitude, hotplace.longitude, user.nickname FROM hotplace INNER JOIN user ON hotplace.user_id = user.id WHERE user.nickname = ? ORDER BY hotplace.id DESC LIMIT ? OFFSET ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, keyword);
                pstmt.setInt(2, size);
                pstmt.setInt(3, offset);
            } else {
                String sql = "SELECT hotplace.id, hotplace.title, hotplace.place_type, hotplace.created_at, hotplace.user_id, hotplace.latitude, hotplace.longitude, user.nickname FROM hotplace INNER JOIN user ON hotplace.user_id = user.id WHERE hotplace.title = ? ORDER BY hotplace.id DESC LIMIT ? OFFSET ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, keyword);
                pstmt.setInt(2, size);
                pstmt.setInt(3, offset);
            }
            rs = pstmt.executeQuery();
            while (rs.next()) {
                HotPlaceListDto dto = new HotPlaceListDto();
                dto.setId(rs.getLong("hotplace.id"));
                dto.setTitle(rs.getString("hotplace.title"));
                dto.setPlaceType(rs.getInt("hotplace.place_type"));
                dto.setCreatedAt(rs.getString("hotplace.created_at"));
                dto.setCreatorId(rs.getLong("hotplace.user_id"));
                dto.setCreatorNickname(rs.getString("user.nickname"));
                list.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close(rs, pstmt, conn);
        }
        return list;
    }

//	@Override
//	public int getTotalHotPlaceCount(Map<String, Object> param) {
//		int cnt = 0;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBUtil.getInstance().getConnection();
//			StringBuilder sql = new StringBuilder();
//			sql.append("select count(id) \n");
//			sql.append("from hotplace \n");
//			String key = (String) param.get("key");
//			String word = (String) param.get("word");
//			if (!key.isEmpty() && !word.isEmpty()) {
//				if ("title".equals(key)) {
//					sql.append("where title like concat('%', ?, '%') \n");
//				} else {
//					sql.append("where ").append(key).append(" = ? \n");
//				}
//			}
//			pstmt = conn.prepareStatement(sql.toString());
//			if (!key.isEmpty() && !word.isEmpty())
//				pstmt.setString(1, word);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				cnt = rs.getInt(1);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBUtil.getInstance().close(rs, pstmt, conn);
//		}
//		return cnt;
//	}

    @Override
    public HotPlaceDto getHotPlace(long id) {
        HotPlaceDto hotPlaceDto = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            String sql = "SELECT hotplace.id, hotplace.title, hotplace.content, hotplace.place_type, hotplace.created_at, hotplace.user_id, user.nickname, hotplace.latitude, hotplace.longitude \n"
                    + "FROM hotplace \n"
                    + "INNER JOIN user ON hotplace.user_id = user.id \n"
                    + "WHERE hotplace.id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                hotPlaceDto = new HotPlaceDto();
                hotPlaceDto.setId(rs.getLong("hotplace.id"));
                hotPlaceDto.setTitle(rs.getString("hotplace.title"));
                hotPlaceDto.setContent(rs.getString("hotplace.content"));
                hotPlaceDto.setPlaceType(rs.getInt("hotplace.place_type"));
                hotPlaceDto.setCreatedAt(rs.getString("hotplace.created_at"));
                hotPlaceDto.setCreatorId(rs.getLong("hotplace.user_id"));
                hotPlaceDto.setCreatorNickname(rs.getString("user.nickname"));
                hotPlaceDto.setLatitude(rs.getDouble("hotplace.latitude"));
                hotPlaceDto.setLongitude(rs.getDouble("hotplace.longitude"));
                hotPlaceDto.setDate(rs.getString("hotplace.date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close(rs, pstmt, conn);
        }
        return hotPlaceDto;
    }

    @Override
    public void updateHotPlace(long id, HotPlaceUpdateDto hotPlaceUpdateDto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            String sql = "UPDATE hotplace SET title = ?, content = ?, place_type = ? WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, hotPlaceUpdateDto.getTitle());
            pstmt.setString(2, hotPlaceUpdateDto.getContent());
            pstmt.setInt(3, hotPlaceUpdateDto.getPlaceType());
            pstmt.setLong(4, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close(pstmt, conn);
        }
    }

    @Override
    public void deleteHotPlace(long id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            String sql = "DELETE FROM hotplace WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close(pstmt, conn);
        }
    }
}
