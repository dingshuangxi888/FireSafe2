package com.firesafe.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.firesafe.dao.DevtypeDao;
import com.firesafe.model.Device;
import com.firesafe.model.Devtype;
import com.firesafe.service.DevtypeService;
import com.firesafe.util.s2sh.BaseServiceImpl;
import com.firesafe.util.s2sh.OrderBy;
import com.firesafe.util.s2sh.Pagination;

@Service("devtypeService")
public class DevtypeServiceImpl extends BaseServiceImpl<Devtype> implements
		DevtypeService {

	private DevtypeDao devtypeDao;

	public DevtypeDao getDevtypeDao() {
		return devtypeDao;
	}

	@Resource
	public void setDevtypeDao(DevtypeDao devtypeDao) {
		this.devtypeDao = devtypeDao;
		super.setDao(devtypeDao);
	}

	@Override
	public Pagination<Device> findByPage(int pageNo, int pageSize) {
		return devtypeDao.findAll(pageNo, pageSize, OrderBy.desc("typeid"));
	}
}
