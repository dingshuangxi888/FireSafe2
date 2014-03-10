package com.firesafe.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firesafe.dao.LocationDao;
import com.firesafe.model.Location;
import com.firesafe.service.LocationService;
import com.firesafe.util.s2sh.BaseServiceImpl;

@Service("locationService")
@Transactional
public class LocationServiceImpl extends BaseServiceImpl<Location> implements
		LocationService {

	private LocationDao locationDao;

	@Resource
	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
		super.setDao(locationDao);
	}

	@Override
	public Location findLastLoction(long deviceid) {
		Location location = locationDao.findLatest(deviceid);
		return location;
	}

	@Override
	public List<Location> findHistory(long deviceid, String start, String end) {
		List<Location> locations = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date startDate = sdf.parse(start);
			Date endDate = sdf.parse(end);
			Timestamp startTime = new Timestamp(startDate.getTime());
			Timestamp endTime = new Timestamp(endDate.getTime());
			String hql = "from Location as loc where loc.updatetime between ? and ? and loc.deviceid = ? order by loc.updatetime desc";
			List<Object[]> list = locationDao.findByHql(hql, startTime, endTime, deviceid);
			if (list != null && !list.isEmpty()) {
				locations = new ArrayList<Location>();
				for (Object object : list) {
					Location loc = (Location) object;
					locations.add(loc);
				}
			}
			System.out.println(list.size());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return locations;
	}

}
