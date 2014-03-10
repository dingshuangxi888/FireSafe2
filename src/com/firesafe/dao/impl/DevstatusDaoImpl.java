package com.firesafe.dao.impl;

import org.springframework.stereotype.Repository;

import com.firesafe.dao.DevstatusDao;
import com.firesafe.model.Devstatus;
import com.firesafe.util.s2sh.BaseDaoImpl;

@Repository("devstatusDao")
public class DevstatusDaoImpl extends BaseDaoImpl<Devstatus> implements
		DevstatusDao {

}
