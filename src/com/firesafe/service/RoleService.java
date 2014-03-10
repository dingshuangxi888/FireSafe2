package com.firesafe.service;

import java.util.List;

import com.firesafe.model.Role;
import com.firesafe.util.s2sh.BaseService;

public interface RoleService extends BaseService<Role> {

	public List<Role> findAllRole();
}
