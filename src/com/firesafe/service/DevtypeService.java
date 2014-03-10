package com.firesafe.service;

import com.firesafe.model.Device;
import com.firesafe.model.Devtype;
import com.firesafe.util.s2sh.BaseService;
import com.firesafe.util.s2sh.Pagination;

public interface DevtypeService extends BaseService<Devtype> {

	public Pagination<Device> findByPage(int pageNo, int pageSize);

}
