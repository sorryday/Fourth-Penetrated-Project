package com.gumi.enjoytrip.domain.tourinfo.service;

import com.gumi.enjoytrip.domain.tourinfo.dao.TourInfoDaoImpl;
import com.gumi.enjoytrip.domain.tourinfo.dto.TourInfoDto;

import java.util.List;

public class TourInfoServiceImpl implements TourInfoService {
    private static TourInfoServiceImpl instance;

    public static TourInfoService getInstance() {
        if (instance == null)
            instance = new TourInfoServiceImpl();
        return instance;
    }

    @Override
    public List<TourInfoDto> getTourInfoList(int sidoCode, int gugunCode, int type) {
        return TourInfoDaoImpl.getInstance().getTourInfoList(sidoCode, gugunCode, type);
    }
}
