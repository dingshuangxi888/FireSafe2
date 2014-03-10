package com.firesafe.service;

import com.firesafe.model.Device;
import com.firesafe.util.s2sh.BaseService;
import com.firesafe.util.s2sh.Pagination;

public interface DeviceService extends BaseService<Device> {

	public Pagination<Device> findByPage(int pageNo, int pageSize);

	public Device findDeviceAllInfo(long deviceid);

	public Pagination<Device> findByPage(int pageNo, int pageSize, Integer userid);

	public Pagination<Device> findByPageWithAreaid(int pageNo, int pageSize, Integer areaid);

}
