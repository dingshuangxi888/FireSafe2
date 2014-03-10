package com.firesafe.dao.impl;

import org.springframework.stereotype.Repository;

import com.firesafe.dao.RoleDao;
import com.firesafe.model.Role;
import com.firesafe.util.s2sh.BaseDaoImpl;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

}
