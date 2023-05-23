package com.gumi.enjoytrip.domain.tourinfo.service;

import com.gumi.enjoytrip.domain.tourinfo.dto.GugunDto;
import com.gumi.enjoytrip.domain.tourinfo.dto.SidoDto;

import java.util.List;

public interface RegionService {
    List<SidoDto> getSidoList();
    List<GugunDto> getGugunList(int sidoCode);
}
