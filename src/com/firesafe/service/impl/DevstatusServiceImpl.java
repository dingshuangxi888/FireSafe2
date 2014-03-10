package com.firesafe.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.firesafe.dao.DevstatusDao;
import com.firesafe.model.Devstatus;
import com.firesafe.service.DevstatusService;
import com.firesafe.util.s2sh.BaseServiceImpl;

@Service("devstatusService")
public class DevstatusServiceImpl extends BaseServiceImpl<Devstatus> implements
		DevstatusService {

	private DevstatusDao devstatusDao;

	public DevstatusDao getDevstatusDao() {
		return devstatusDao;
	}

	@Resource
	public void setDevstatusDao(DevstatusDao devstatusDao) {
		this.devstatusDao = devstatusDao;
		super.setDao(devstatusDao);
	}
}
