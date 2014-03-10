package com.firesafe.dao.impl;

import org.springframework.stereotype.Repository;

import com.firesafe.dao.AreaDao;
import com.firesafe.model.Area;
import com.firesafe.util.s2sh.BaseDaoImpl;

@Repository("areaDao")
public class AreaDaoImpl extends BaseDaoImpl<Area> implements AreaDao {

}
