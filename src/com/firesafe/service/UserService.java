package com.firesafe.service;

import java.util.List;

import com.firesafe.model.User;
import com.firesafe.util.s2sh.BaseService;
import com.firesafe.util.s2sh.Pagination;

public interface UserService extends BaseService<User> {

	public boolean login(User user);
	
	public List<User> findByProperty(String property , Object value);
	
	public Pagination<User> findByPage(int pageNo, int pageSize);
	
	public Pagination<User> findAllUser(int pageNo, int pageSize);
}
