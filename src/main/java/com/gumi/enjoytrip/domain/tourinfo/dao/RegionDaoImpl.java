package com.gumi.enjoytrip.domain.tourinfo.dao;

import com.gumi.enjoytrip.domain.tourinfo.dto.GugunDto;
import com.gumi.enjoytrip.domain.tourinfo.dto.SidoDto;
import com.gumi.enjoytrip.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegionDaoImpl implements RegionDao {
    private static RegionDaoImpl instance;

    public static RegionDaoImpl getInstance() {
        if (instance == null)
            instance = new RegionDaoImpl();
        return instance;
    }

    @Override
    public List<SidoDto> getSidoList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<SidoDto> dtos = new ArrayList<>();
        try {
            connection = DBUtil.getInstance().getConnection();
            String sql = "select * from sido";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                SidoDto dto = new SidoDto();
                dto.setSidoCode(resultSet.getInt("sido_code"));
                dto.setSidoName(resultSet.getString("sido_name"));
                dtos.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dtos;
    }

    @Override
    public List<GugunDto> getGugunList(int sidoCode) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<GugunDto> dtos = new ArrayList<>();
        try {
            connection = DBUtil.getInstance().getConnection();
            String sql = "select * from gugun where sido_code = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, sidoCode);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                GugunDto dto = new GugunDto();
                dto.setGugunCode(resultSet.getInt("gugun_code"));
                dto.setGugunName(resultSet.getString("gugun_name"));
                dto.setSidoCode(resultSet.getInt("sido_code"));
                dtos.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dtos;
    }
}
