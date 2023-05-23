package com.gumi.enjoytrip.domain.tourinfo.service;

import com.gumi.enjoytrip.domain.tourinfo.dao.RegionDaoImpl;
import com.gumi.enjoytrip.domain.tourinfo.dto.GugunDto;
import com.gumi.enjoytrip.domain.tourinfo.dto.SidoDto;

import java.util.List;

public class RegionServiceImpl implements RegionService{

    private static RegionServiceImpl instance;

    public static RegionService getInstance() {
        if (instance == null)
            instance = new RegionServiceImpl();
        return instance;
    }

    @Override
    public List<SidoDto> getSidoList() {
        return RegionDaoImpl.getInstance().getSidoList();
    }

    @Override
    public List<GugunDto> getGugunList(int sidoCode) {
        return RegionDaoImpl.getInstance().getGugunList(sidoCode);
    }
}
