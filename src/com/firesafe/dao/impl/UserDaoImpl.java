package com.firesafe.dao.impl;

import org.springframework.stereotype.Repository;

import com.firesafe.dao.UserDao;
import com.firesafe.model.User;
import com.firesafe.util.s2sh.BaseDaoImpl;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

}
