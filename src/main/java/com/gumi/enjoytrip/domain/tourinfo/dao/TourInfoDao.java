package com.gumi.enjoytrip.domain.tourinfo.dao;

import java.util.List;

import com.gumi.enjoytrip.domain.tourinfo.dto.TourInfoDto;

public interface TourInfoDao {
	List<TourInfoDto> getTourInfoList(int sidoCode, int gugunCode, int type);
}
