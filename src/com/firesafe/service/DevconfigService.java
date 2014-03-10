package com.firesafe.service;

import com.firesafe.vo.ConfigVO;
import com.firesafe.vo.DevConfigsVO;

public interface DevconfigService {

	public DevConfigsVO getConfig(long deviceid);
	
	public DevConfigsVO setConfig(ConfigVO configVO);
}
