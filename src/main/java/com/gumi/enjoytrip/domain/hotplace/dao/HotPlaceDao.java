package com.gumi.enjoytrip.domain.hotplace.dao;

import com.gumi.enjoytrip.domain.hotplace.dto.HotPlaceCreateDto;
import com.gumi.enjoytrip.domain.hotplace.dto.HotPlaceDto;
import com.gumi.enjoytrip.domain.hotplace.dto.HotPlaceListDto;
import com.gumi.enjoytrip.domain.hotplace.dto.HotPlaceUpdateDto;

import java.util.List;

public interface HotPlaceDao {
	void createHotPlace(HotPlaceCreateDto hotPlaceCreateDto) throws Exception;

	List<HotPlaceListDto> getHotplaceList(int offset, int size);

	List<HotPlaceListDto> getHotPlaceListByKeyword(String condition, String keyword, int offset, int size);

//	int getTotalHotPlaceCount(Map<String, Object> param);

	HotPlaceDto getHotPlace(long id);

	void updateHotPlace(long id, HotPlaceUpdateDto hotPlaceUpdateDto);

	void deleteHotPlace(long id);
}
