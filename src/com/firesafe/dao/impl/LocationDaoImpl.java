package com.firesafe.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.firesafe.dao.LocationDao;
import com.firesafe.model.Location;
import com.firesafe.util.s2sh.BaseDaoImpl;
import com.firesafe.util.s2sh.OrderBy;

@Repository("locationDao")
public class LocationDaoImpl extends BaseDaoImpl<Location> implements
		LocationDao {

	@Override
	public Location findLatest(long deviceid) {
		Session session = this.getSession();
		Criteria crit = session.createCriteria(getPersistentClass());
		crit.add(Restrictions.eq("deviceid", deviceid));
		crit.setMaxResults(1);
		crit.setFirstResult(0);
		crit.addOrder(OrderBy.desc("updatetime").getOrder());
		return (Location) crit.uniqueResult();
	}

}
