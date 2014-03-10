package com.firesafe.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firesafe.dao.AreaDao;
import com.firesafe.dao.DeviceDao;
import com.firesafe.dao.DevstatusDao;
import com.firesafe.dao.DevtypeDao;
import com.firesafe.dao.LocationDao;
import com.firesafe.model.Device;
import com.firesafe.model.Location;
import com.firesafe.service.DeviceService;
import com.firesafe.util.s2sh.BaseServiceImpl;
import com.firesafe.util.s2sh.OrderBy;
import com.firesafe.util.s2sh.Pagination;

@Service("deviceService")
@Transactional
public class DeviceServiceImpl extends BaseServiceImpl<Device> implements
		DeviceService {

	private DeviceDao deviceDao;
	private DevstatusDao devstatusDao;
	private DevtypeDao devtypeDao;
	private LocationDao locationDao;
	private AreaDao areaDao;

	public DeviceDao getDeviceDao() {
		return deviceDao;
	}

	@Resource
	public void setDeviceDao(DeviceDao deviceDao) {
		this.deviceDao = deviceDao;
		super.setDao(deviceDao);
	}

	public DevstatusDao getDevstatusDao() {
		return devstatusDao;
	}

	@Resource
	public void setDevstatusDao(DevstatusDao devstatusDao) {
		this.devstatusDao = devstatusDao;
	}

	public DevtypeDao getDevtypeDao() {
		return devtypeDao;
	}

	@Resource
	public void setDevtypeDao(DevtypeDao devtypeDao) {
		this.devtypeDao = devtypeDao;
	}

	public LocationDao getLocationDao() {
		return locationDao;
	}

	@Resource
	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}

	public AreaDao getAreaDao() {
		return areaDao;
	}

	@Resource
	public void setAreaDao(AreaDao areaDao) {
		this.areaDao = areaDao;
	}

	@Override
	public Pagination findByPage(int pageNo, int pageSize) {
		return deviceDao.findAll(pageNo, pageSize, OrderBy.desc("deviceid"));
	}

	@Override
	public Device findDeviceAllInfo(long deviceid) {
		Device device = deviceDao.get(deviceid);
		device.setDevstatus(devstatusDao.get(deviceid));
		device.setDevtype(devtypeDao.get(device.getTypeid()));
		device.setArea(areaDao.get(device.getAreaid()));
		List<Location> locs = new ArrayList<Location>();
		Location loc = locationDao.findLatest(deviceid);
		locs.add(loc);
		device.setLocations(locs);
		return device;
	}

	@Override
	public Pagination<Device> findByPage(int pageNo, int pageSize, Integer userid) {
		Map<String, Object> props = new HashMap<String, Object>();
		props.put("userid", userid);
		return deviceDao.findByProperty(pageNo, pageSize, props, OrderBy.desc("deviceid"));
	}

	@Override
	public Pagination<Device> findByPageWithAreaid(int pageNo, int pageSize, Integer areaid) {
		if (areaid == 0) {
			return deviceDao.findAll(pageNo, pageSize, OrderBy.desc("deviceid"));
		} else {
			Map<String, Object> props = new HashMap<String, Object>();
			props.put("areaid", areaid);
			return deviceDao.findByProperty(pageNo, pageSize, props, OrderBy.desc("deviceid"));
		}
	}
}
