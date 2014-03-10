package com.firesafe.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.firesafe.dao.AuthorityDao;
import com.firesafe.model.Authority;
import com.firesafe.service.AuthorityService;
import com.firesafe.util.s2sh.BaseServiceImpl;

@Service("authorityService")
public class AuthorityServiceImpl extends BaseServiceImpl<Authority> implements
		AuthorityService {

	private AuthorityDao authorityDao;

	public AuthorityDao getAuthorityDao() {
		return authorityDao;
	}

	@Resource
	public void setAuthorityDao(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
	}
}
