package com.firesafe.util.s2sh;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BaseServiceImpl<T extends Serializable> implements BaseService<T> {
	private BaseDao<T> dao;

	public void setDao(BaseDao<T> dao) {
		this.dao = dao;
	}

	protected BaseDao<T> getDao() {
		return this.dao;
	}

	@Override
	@Transactional(readOnly = true)
	public T findById(Serializable id) {
		return dao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public T load(Serializable id) {
		return dao.load(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> findAll() {
		return dao.findAll();
	}

	@Transactional(readOnly = true)
	public Pagination findAll(int pageNo, int pageSize, OrderBy... orders) {
		return dao.findAll(pageNo, pageSize, orders);
	}

	/**
	 * 实例查找返回列表
	 */

	@Override
	public T save(T entity) {
		return dao.save(entity);
	}

	@Override
	public T saveAndRefresh(T entity) {
		this.save(entity);
		getDao().refresh(entity);
		return entity;
	}

	@Override
	public Object saveOrUpdate(Object o) {
		return getDao().saveOrUpdate(o);
	}

	@Override
	public void delete(Object o) {
		getDao().delete(o);
	}

	@Override
	public Object update(Object o) {
		return getDao().update(o);
	}

	public Object merge(Object o) {
		return getDao().merge(o);
	}

	@Override
	public T deleteById(Serializable id) {
		if (id == null) {
			return null;
		}
		return dao.deleteById(id);
	}

	@Override
	public List<T> deleteById(Serializable[] ids) {
		List<T> dts = new ArrayList<T>();
		T del = null;
		if (ids != null && ids.length > 0) {
			for (Serializable id : ids) {
				del = deleteById(id);
				if (del != null) {
					dts.add(del);
				}
			}
		}
		return dts;
	}
}