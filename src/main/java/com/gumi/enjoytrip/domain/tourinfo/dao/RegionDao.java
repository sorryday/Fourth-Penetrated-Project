package com.gumi.enjoytrip.domain.tourinfo.dao;

import com.gumi.enjoytrip.domain.tourinfo.dto.GugunDto;
import com.gumi.enjoytrip.domain.tourinfo.dto.SidoDto;

import java.util.List;

public interface RegionDao {
    List<SidoDto> getSidoList();
    List<GugunDto> getGugunList(int sidoCode);
}
