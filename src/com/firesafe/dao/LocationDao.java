package com.firesafe.dao;

import com.firesafe.model.Location;
import com.firesafe.util.s2sh.BaseDao;

public interface LocationDao extends BaseDao<Location> {

	public Location findLatest(long deviceid);

}
