package com.firesafe.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.firesafe.dao.AreaDao;
import com.firesafe.dao.DeviceDao;
import com.firesafe.model.Area;
import com.firesafe.model.Device;
import com.firesafe.service.AreaService;
import com.firesafe.util.s2sh.BaseServiceImpl;
import com.firesafe.util.s2sh.OrderBy;
import com.firesafe.util.s2sh.Pagination;

@Service("areaService")
public class AreaServiceImpl extends BaseServiceImpl<Area> implements AreaService {

	private AreaDao areaDao;
	private DeviceDao deviceDao;

	public DeviceDao getDeviceDao() {
		return deviceDao;
	}

	@Resource
	public void setDeviceDao(DeviceDao deviceDao) {
		this.deviceDao = deviceDao;
	}

	public AreaDao getAreaDao() {
		return areaDao;
	}

	@Resource
	public void setAreaDao(AreaDao areaDao) {
		this.areaDao = areaDao;
		super.setDao(areaDao);
	}

	@Override
	public List<Device> findDevice(int areaid) {
		List<Device> devices = new ArrayList<Device>();
		List<Area> childrenAreas = new ArrayList<Area>();
		if (areaid != 0) {
			childrenAreas.add(areaDao.get(areaid));
		}
		this.childArea(childrenAreas, areaid);
		for (Iterator iter = childrenAreas.iterator(); iter.hasNext();) {
			Area area = (Area) iter.next();
			List<Device> devtemp = deviceDao.findByProperty("areaid", area.getAreaid());
			devices.addAll(devtemp);
		}
		return devices;
	}

	private void childArea(List<Area> areas, int areaid) {
		List<Area> temp = areaDao.findByProperty("parentid", areaid);
		if (temp != null && !temp.isEmpty()) {
			areas.addAll(temp);
			for (Area area : temp) {
				this.childArea(areas, area.getAreaid());
			}
		}
	}

	@Override
	public Pagination<Area> findByPage(int pageNo, int pageSize) {
		return areaDao.findAll(pageNo, pageSize, OrderBy.desc("areaid"));
	}

	@Override
	public List<Area> findChildArea(int parentAreaid) {
		List<Area> childrenAreas = new ArrayList<Area>();
		if (parentAreaid != 0) {
			Area rootArea = areaDao.get(parentAreaid);
			if (rootArea != null) {
				childrenAreas.add(rootArea);
				this.childArea(childrenAreas, parentAreaid);
			}
		} else {
			this.childArea(childrenAreas, parentAreaid);
		}
		return childrenAreas;
	}
}
