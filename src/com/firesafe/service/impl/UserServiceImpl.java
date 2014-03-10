package com.firesafe.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firesafe.dao.UserDao;
import com.firesafe.model.User;
import com.firesafe.service.UserService;
import com.firesafe.util.s2sh.BaseServiceImpl;
import com.firesafe.util.s2sh.OrderBy;
import com.firesafe.util.s2sh.Pagination;

@Service("userService")
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
		super.setDao(userDao);
	}

	@Override
	public boolean login(User user) {
		List<User> users = userDao.findByProperty("username", user.getUsername());
		if(!users.isEmpty()){
			if(user.getPassword().equals(users.get(0).getPassword())){
				return true;
			}
		}
		return false;
	}

	@Override
	public List<User> findByProperty(String property, Object value) {
		List<User> users = userDao.findByProperty(property, value);
		return users;
	}

	@Override
	public Pagination<User> findByPage(int pageNo, int pageSize) {
		return userDao.findAll(pageNo, pageSize, OrderBy.desc("userid"));
	}

	@Override
	public Pagination<User> findAllUser(int pageNo, int pageSize) {
		String sql = "select * from User where 1=1";
		int totalCount = userDao.findBySql(sql, null).size();
		Pagination<User> p = new Pagination<User>(pageNo, pageSize, totalCount);
		sql = "select * from user where 1=1 order by userid desc limit "+(pageNo-1)*pageSize+", "+pageSize;
		List<User> users = new ArrayList<User>();
		List<Object[]> list = userDao.findBySql(sql, null);
		for (Object[] objs : list) {
			users.add(new User((Integer)objs[0], (String)objs[1], (String)objs[2], (String)objs[3], (String)objs[4], (String)objs[5], (String)objs[6], (Integer)objs[7], (Timestamp)objs[8], (Timestamp)objs[9]));
		}
		p.setList(users);
		return p;
	}
	

}
