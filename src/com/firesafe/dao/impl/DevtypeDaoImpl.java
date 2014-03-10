package com.firesafe.dao.impl;

import org.springframework.stereotype.Repository;

import com.firesafe.dao.DevtypeDao;
import com.firesafe.model.Devtype;
import com.firesafe.util.s2sh.BaseDaoImpl;

@Repository("devtypeDao")
public class DevtypeDaoImpl extends BaseDaoImpl<Devtype> implements DevtypeDao {

}
