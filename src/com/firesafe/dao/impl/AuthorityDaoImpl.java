package com.firesafe.dao.impl;

import org.springframework.stereotype.Repository;

import com.firesafe.dao.AuthorityDao;
import com.firesafe.model.Authority;
import com.firesafe.util.s2sh.BaseDaoImpl;

@Repository("authorityDao")
public class AuthorityDaoImpl extends BaseDaoImpl<Authority> implements
		AuthorityDao {

}
