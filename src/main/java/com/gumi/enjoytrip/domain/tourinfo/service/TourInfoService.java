package com.gumi.enjoytrip.domain.tourinfo.service;

import java.util.List;

import com.gumi.enjoytrip.domain.tourinfo.dto.TourInfoDto;

public interface TourInfoService {
	List<TourInfoDto> getTourInfoList(int sidoCode, int gugunCode, int type);
}
