package com.firesafe.util.s2sh;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;

public interface BaseDao<T extends Serializable> {

	public abstract T save(T entity);

	public abstract Object update(Object entity);

	public abstract Object saveOrUpdate(Object entity);

	public abstract Object merge(Object entity);

	public abstract void delete(Object entity);

	public abstract T deleteById(Serializable id);

	public abstract T load(Serializable id);

	@SuppressWarnings("unchecked")
	public abstract T get(Serializable id);

	@SuppressWarnings("unchecked")
	public abstract T load(Serializable id, boolean lock);

	public abstract List<T> findAll();

	@SuppressWarnings("unchecked")
	public abstract List<T> findAll(OrderBy... orders);

	public abstract Pagination findAll(int pageNo, int pageSize, OrderBy... orders);

	/**
	 * 按属性查找对象列表.
	 */
	@SuppressWarnings("unchecked")
	public abstract List<T> findByProperty(String property, Object value);

	@SuppressWarnings("unchecked")
	public abstract List<T> findByProperty(String property, Object value, OrderBy... orders);

	@SuppressWarnings("unchecked")
	public abstract List<T> findByProperties(Map<String, Object> properties, OrderBy... orders);
	
	@SuppressWarnings("unchecked")
	public abstract Pagination findByProperty(int pageNo, int pageSize, Map<String, Object> properties, OrderBy... orders);

	/**
	 * 按属性查找唯一对象.
	 */
	@SuppressWarnings("unchecked")
	public abstract T findUniqueByProperty(String property, Object value);

	@SuppressWarnings("unchecked")
	public abstract List<T> findByCriteria(Criteria crit);

	@SuppressWarnings("unchecked")
	public abstract List<T> findByExample(T t);

	public abstract int countByProperty(String property, Object value);

	public abstract void refresh(Object entity);

	public abstract T createNewEntiey();

	public abstract List<Object[]> findByHql(String hql, Object... objects);

	public abstract List<Object[]> findBySql(String sql, Object... objects);

}