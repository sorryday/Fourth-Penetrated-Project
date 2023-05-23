package com.gumi.enjoytrip.domain.user.dao;

import com.gumi.enjoytrip.domain.user.dto.UserCreateDto;
import com.gumi.enjoytrip.domain.user.dto.UserDto;
import com.gumi.enjoytrip.domain.user.dto.UserUpdateDto;
import com.gumi.enjoytrip.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private static UserDaoImpl instance = null;

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }

    @Override
    public UserDto getLoginUser(String userId, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        UserDto dto = null;
        try {
            String sql = "select * from user where user_id=? and password=?";
            conn = DBUtil.getInstance().getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                dto = new UserDto();
                dto.setId(rs.getLong("id"));
                dto.setUserId(rs.getString("user_id"));
                dto.setEmail(rs.getString("email"));
                dto.setNickname(rs.getString("nickname"));
                dto.setRole(rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close(rs, pstmt, conn);
        }
        return dto;
    }

    @Override
    public UserDto getUser(long id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        UserDto dto = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            String sql = "select * from user where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                dto = new UserDto();
                dto.setId(rs.getLong("id"));
                dto.setUserId(rs.getString("user_id"));
                dto.setEmail(rs.getString("email"));
                dto.setNickname(rs.getString("nickname"));
                dto.setRole(rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close(rs, pstmt, conn);
        }
        return dto;
    }

    @Override
    public UserDto getUser(String userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        UserDto dto = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            String sql = "select * from user where user_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                dto = new UserDto();
                dto.setId(rs.getLong("id"));
                dto.setUserId(rs.getString("user_id"));
                dto.setEmail(rs.getString("email"));
                dto.setNickname(rs.getString("nickname"));
                dto.setRole(rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close(rs, pstmt, conn);
        }
        return dto;
    }

    @Override
    public void changePassword(long id, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            String sql = "update user set password=? where id=?";
            pstmt = conn.prepareStatement(sql);
            int cnt = 1;
            pstmt.setString(cnt++, password);
            pstmt.setLong(cnt++, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close(pstmt, conn);
        }
    }

    @Override
    public void updateUser(long id, UserUpdateDto dto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            String sql = "update user set nickname=?, email=? where id=?";
            pstmt = conn.prepareStatement(sql);
            int cnt = 1;
            pstmt.setString(cnt++, dto.getNickname());
            pstmt.setString(cnt++, dto.getEmail());
            pstmt.setLong(cnt++, dto.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close(pstmt, conn);
        }
    }

    @Override
    public void createUser(UserCreateDto dto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            String sql = "insert into user(user_id,password,nickname,email) values(?,?,?,?)";
            conn = DBUtil.getInstance().getConnection();
            pstmt = conn.prepareStatement(sql);
//            int cnt = 1;
            pstmt.setString(1, dto.getUserId());
            pstmt.setString(2, dto.getPassword());
            pstmt.setString(3, dto.getNickname());
            pstmt.setString(4, dto.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close(pstmt, conn);
        }
    }

    @Override
    public void deleteUser(long id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            String sql = "delete from user where id=?";
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
