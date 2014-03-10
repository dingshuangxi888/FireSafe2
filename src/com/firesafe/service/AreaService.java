package com.firesafe.service;

import java.util.List;

import com.firesafe.model.Area;
import com.firesafe.model.Device;
import com.firesafe.util.s2sh.BaseService;
import com.firesafe.util.s2sh.Pagination;

public interface AreaService extends BaseService<Area> {

	public List<Area> findChildArea(int parentAreaid);
	
	public List<Device> findDevice(int areaid);

	public Pagination<Area> findByPage(int pageNo, int pageSize);
}
