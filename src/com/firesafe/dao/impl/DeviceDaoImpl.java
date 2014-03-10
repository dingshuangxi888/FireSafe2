package com.firesafe.dao.impl;

import org.springframework.stereotype.Repository;

import com.firesafe.dao.DeviceDao;
import com.firesafe.model.Device;
import com.firesafe.util.s2sh.BaseDaoImpl;

@Repository("deviceDao")
public class DeviceDaoImpl extends BaseDaoImpl<Device> implements DeviceDao {

}
