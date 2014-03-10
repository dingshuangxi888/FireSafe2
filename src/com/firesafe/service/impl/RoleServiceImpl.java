package com.firesafe.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.firesafe.dao.RoleDao;
import com.firesafe.model.Role;
import com.firesafe.service.RoleService;
import com.firesafe.util.s2sh.BaseServiceImpl;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements
		RoleService {

	private RoleDao roleDao;

	public RoleDao getRoleDao() {
		return roleDao;
	}

	@Resource
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
		super.setDao(roleDao);
	}

	@Override
	public List<Role> findAllRole() {
		List<Role> roles = new ArrayList<Role>();
		String sql = "select * from role where 1=1";
		List<Object[]> list = roleDao.findBySql(sql, null);
		for (Object[] objs : list) {
			roles.add(new Role((Integer)objs[0], (String)objs[1], (String)objs[2]));
		}
		return roles;
	}

}
