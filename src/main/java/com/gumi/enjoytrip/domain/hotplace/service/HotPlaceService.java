package com.gumi.enjoytrip.domain.hotplace.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.gumi.enjoytrip.domain.hotplace.dto.HotPlaceCreateDto;
import com.gumi.enjoytrip.domain.hotplace.dto.HotPlaceDto;
import com.gumi.enjoytrip.domain.hotplace.dto.HotPlaceListDto;
import com.gumi.enjoytrip.domain.hotplace.dto.HotPlaceUpdateDto;
import com.gumi.enjoytrip.util.PageNavigation;

public interface HotPlaceService {
	void createHotPlace(HotPlaceCreateDto hotPlaceCreateDto);

	List<HotPlaceListDto> getHotPlaceListByKeyword(String condition, String keyword, int pageNumber);

	List<HotPlaceListDto> getHotplaceList(int pageNumber);

//	int getTotalHotPlaceCount(Map<String, Object> param) throws SQLException;

	HotPlaceDto getHotPlace(long id);

	void updateHotPlace(long id, HotPlaceUpdateDto hotPlaceUpdateDto);

	void deleteHotPlace(long id);

//	PageNavigation makePageNavigation(Map<String, String> map);
}
