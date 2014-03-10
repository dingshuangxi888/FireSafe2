package com.firesafe.service;

import java.util.List;

import com.firesafe.model.Location;
import com.firesafe.util.s2sh.BaseService;

public interface LocationService extends BaseService<Location> {

	public Location findLastLoction(long deviceid);

	public List<Location> findHistory(long deviceid, String start, String end);

}
