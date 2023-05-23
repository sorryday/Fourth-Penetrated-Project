package com.gumi.enjoytrip.domain.hotplace.service;

import com.gumi.enjoytrip.domain.hotplace.dao.HotPlaceDaoImpl;
import com.gumi.enjoytrip.domain.hotplace.dto.HotPlaceCreateDto;
import com.gumi.enjoytrip.domain.hotplace.dto.HotPlaceDto;
import com.gumi.enjoytrip.domain.hotplace.dto.HotPlaceListDto;
import com.gumi.enjoytrip.domain.hotplace.dto.HotPlaceUpdateDto;
import com.gumi.enjoytrip.util.SizeConstant;

import java.util.List;

public class HotPlaceServiceImpl implements HotPlaceService {
	private static HotPlaceServiceImpl instance;

	public static HotPlaceServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new HotPlaceServiceImpl();
		}
		return instance;
	}

	@Override
	public void createHotPlace(HotPlaceCreateDto hotPlaceCreateDto) {
		HotPlaceDaoImpl.getInstance().createHotPlace(hotPlaceCreateDto);
	}

	@Override
	public List<HotPlaceListDto> getHotPlaceListByKeyword(String condition, String keyword, int pageNumber) {
		int limit = SizeConstant.LIST_SIZE;
		int offset = pageNumber * limit - limit;
		return HotPlaceDaoImpl.getInstance().getHotPlaceListByKeyword(condition, keyword, offset, limit);
	}

	@Override
	public List<HotPlaceListDto> getHotplaceList(int pageNumber) {
		int limit = SizeConstant.LIST_SIZE;
		int offset = pageNumber * limit - limit;
		return HotPlaceDaoImpl.getInstance().getHotplaceList(offset, limit);
	}

	//	@Override
//	public int getTotalHotPlaceCount(Map<String, Object> param) throws SQLException {
//		return 0;
//	}

//	@Override
//	public PageNavigation makePageNavigation(Map<String, String> map) {
//		PageNavigation pageNavigation = new PageNavigation();
//
//		int naviSize = SizeConstant.NAVIGATION_SIZE;
//		int sizePerPage = SizeConstant.LIST_SIZE;
//		int currentPage = Integer.parseInt(map.get("pgno"));
//
//		pageNavigation.setCurrentPage(currentPage);
//		pageNavigation.setNaviSize(naviSize);
//		Map<String, Object> param = new HashMap<String, Object>();
//		String key = map.get("key");
//		param.put("key", key.isEmpty() ? "" : key);
//		param.put("word", map.get("word").isEmpty() ? "" : map.get("word"));
//		int totalCount = HotPlaceDaoImpl.getInstance().getTotalHotPlaceCount(param);
//		pageNavigation.setTotalCount(totalCount);
//		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
//		pageNavigation.setTotalPageCount(totalPageCount);
//		boolean startRange = currentPage <= naviSize;
//		pageNavigation.setStartRange(startRange);
//		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
//		pageNavigation.setEndRange(endRange);
//		pageNavigation.makeNavigator();
//
//		return pageNavigation;
//	}

	@Override
	public HotPlaceDto getHotPlace(long id) {
		return HotPlaceDaoImpl.getInstance().getHotPlace(id);
	}

	@Override
	public void updateHotPlace(long id, HotPlaceUpdateDto hotPlaceUpdateDto) {
		HotPlaceDaoImpl.getInstance().updateHotPlace(id, hotPlaceUpdateDto);
	}

	@Override
	public void deleteHotPlace(long id) {
		HotPlaceDaoImpl.getInstance().deleteHotPlace(id);
	}
}
