package com.firesafe.util.s2sh;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * DAO基类。
 * 
 * 提供hql分页查询，example分页查询，拷贝更新等功能。
 * 
 * @author liufang
 * 
 * @param <T>
 */
@Repository
@Transactional
public abstract class BaseDaoImpl<T extends Serializable> implements BaseDao<T> {
	static final Logger logger = Logger.getLogger(BaseDaoImpl.class.getName());

	@Autowired
	protected SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.firesafe.util.s2sh.BaseDao2#save(T)
	 */
	@Override
	public T save(T entity) {
		Assert.notNull(entity);
		getSession().save(entity);
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.firesafe.util.s2sh.BaseDao2#update(java.lang.Object)
	 */
	@Override
	public Object update(Object entity) {
		Assert.notNull(entity);
		getSession().update(entity);
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.firesafe.util.s2sh.BaseDao2#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public Object saveOrUpdate(Object entity) {
		Assert.notNull(entity);
		getSession().saveOrUpdate(entity);
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.firesafe.util.s2sh.BaseDao2#merge(java.lang.Object)
	 */
	@Override
	public Object merge(Object entity) {
		Assert.notNull(entity);
		return getSession().merge(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.firesafe.util.s2sh.BaseDao2#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object entity) {
		Assert.notNull(entity);
		getSession().delete(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.firesafe.util.s2sh.BaseDao2#deleteById(java.io.Serializable)
	 */
	@Override
	public T deleteById(Serializable id) {
		Assert.notNull(id);
		T entity = load(id);
		getSession().delete(entity);
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.firesafe.util.s2sh.BaseDao2#load(java.io.Serializable)
	 */
	@Override
	public T load(Serializable id) {
		Assert.notNull(id);
		return load(id, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.firesafe.util.s2sh.BaseDao2#get(java.io.Serializable)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public T get(Serializable id) {
		Assert.notNull(id);
		return (T) getSession().get(getPersistentClass(), id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.firesafe.util.s2sh.BaseDao2#load(java.io.Serializable, boolean)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public T load(Serializable id, boolean lock) {
		Assert.notNull(id);
		T entity = null;
		if (lock) {
			entity = (T) getSession().load(getPersistentClass(), id, LockMode.UPGRADE);
		} else {
			entity = (T) getSession().load(getPersistentClass(), id);
		}
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.firesafe.util.s2sh.BaseDao2#findAll()
	 */
	@Override
	public List<T> findAll() {
		return findByCriteria();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.firesafe.util.s2sh.BaseDao2#findAll(com.firesafe.util.s2sh.OrderBy)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll(OrderBy... orders) {
		Criteria crit = createCriteria();
		if (orders != null) {
			for (OrderBy order : orders) {
				crit.addOrder(order.getOrder());
			}
		}
		return crit.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.firesafe.util.s2sh.BaseDao2#findAll(int, int,
	 * com.firesafe.util.s2sh.OrderBy)
	 */
	@Override
	public Pagination findAll(int pageNo, int pageSize, OrderBy... orders) {
		Criteria crit = createCriteria();
		return findByCriteria(crit, pageNo, pageSize, null, OrderBy.asOrders(orders));
	}

	/**
	 * 按HQL查询对象列表.
	 * 
	 * @param hql
	 *            hql语句
	 * @param values
	 *            数量可变的参数
	 */

	@SuppressWarnings("unchecked")
	protected List<?> find(String hql, Object... values) {
		return createQuery(hql, values).list();
	}

	/**
	 * 按HQL查询唯一对象.
	 */
	protected Object findUnique(String hql, Object... values) {
		return createQuery(hql, values).uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.firesafe.util.s2sh.BaseDao2#findByProperty(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findByProperty(String property, Object value) {
		Assert.hasText(property);
		return createCriteria(Restrictions.eq(property, value)).list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.firesafe.util.s2sh.BaseDao2#findByProperty(java.lang.String,
	 * java.lang.Object, com.firesafe.util.s2sh.OrderBy)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findByProperty(String property, Object value, OrderBy... orders) {
		Criteria crit = createCriteria();
		crit.add(Restrictions.eq(property, value));
		for (OrderBy order : orders) {
			crit.addOrder(order.getOrder());
		}
		return crit.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.firesafe.util.s2sh.BaseDao2#findByProperties(java.util.Map,
	 * com.firesafe.util.s2sh.OrderBy)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findByProperties(Map<String, Object> properties, OrderBy... orders) {
		Assert.notEmpty(properties);
		Criteria crit = createCriteria();
		for (String property : properties.keySet()) {
			crit.add(Restrictions.eq(property, properties.get(property)));
		}
		for (OrderBy order : orders) {
			crit.addOrder(order.getOrder());
		}
		return crit.list();
	}

	@Override
	public Pagination findByProperty(int pageNo, int pageSize, Map<String, Object> properties, OrderBy... orders) {
		Assert.notEmpty(properties);
		Criteria crit = createCriteria();
		for (String property : properties.keySet()) {
			crit.add(Restrictions.eq(property, properties.get(property)));
		}
		for (OrderBy order : orders) {
			crit.addOrder(order.getOrder());
		}

		int totalCount = ((Number) crit.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		Pagination p = new Pagination(pageNo, pageSize, totalCount);
		if (totalCount < 1) {
			p.setList(new ArrayList());
			return p;
		}
		crit.setProjection(null);
		crit.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		crit.setFirstResult(p.getFirstResult());
		crit.setMaxResults(p.getPageSize());
		p.setList(crit.list());
		return p;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.firesafe.util.s2sh.BaseDao2#findUniqueByProperty(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public T findUniqueByProperty(String property, Object value) {
		Assert.hasText(property);
		Assert.notNull(value);
		return (T) createCriteria(Restrictions.eq(property, value)).uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.firesafe.util.s2sh.BaseDao2#findByCriteria(org.hibernate.Criteria)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findByCriteria(Criteria crit) {
		Criteria crit_temp = createCriteria();
		crit_temp = crit;
		return crit_temp.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.firesafe.util.s2sh.BaseDao2#findByExample(T)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findByExample(T t) {
		Example example = Example.create(t);
		Criteria crit = createCriteria();
		crit.add(example);
		return crit.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.firesafe.util.s2sh.BaseDao2#countByProperty(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public int countByProperty(String property, Object value) {
		Assert.hasText(property);
		Assert.notNull(value);
		return ((Number) (createCriteria(Restrictions.eq(property, value)).setProjection(Projections.rowCount()).uniqueResult())).intValue();
	}

	@SuppressWarnings("unchecked")
	protected Pagination find(Finder finder, int pageNo, int pageSize) {
		int totalCount = countQueryResult(finder);
		Pagination p = new Pagination(pageNo, pageSize, totalCount);
		if (totalCount < 1) {
			p.setList(new ArrayList());
			return p;
		}
		Query query = getSession().createQuery(finder.getOrigHql());
		finder.setParamsToQuery(query);
		query.setFirstResult(p.getFirstResult());
		query.setMaxResults(p.getPageSize());
		List list = query.list();
		p.setList(list);
		return p;
	}

	@SuppressWarnings("unchecked")
	protected List find(Finder finder) {
		Query query = getSession().createQuery(finder.getOrigHql());
		finder.setParamsToQuery(query);
		query.setFirstResult(finder.getFirstResult());
		if (finder.getMaxResults() > 0) {
			query.setMaxResults(finder.getMaxResults());
		}
		List list = query.list();
		return list;
	}

	/**
	 * 根据查询函数与参数列表创建Query对象,后续可进行更多处理,辅助函数.
	 */
	protected Query createQuery(String queryString, Object... values) {
		Assert.hasText(queryString);
		Query queryObject = getSession().createQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				queryObject.setParameter(i, values[i]);
			}
		}
		return queryObject;
	}

	/**
	 * 按Criterion查询对象列表.
	 * 
	 * @param criterion
	 *            数量可变的Criterion.
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion... criterion) {
		return createCriteria(criterion).list();
	}

	@SuppressWarnings("unchecked")
	protected Pagination findByCriteria(Criteria crit, int pageNo, int pageSize, Projection projection, Order... orders) {
		int totalCount = ((Number) crit.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		Pagination p = new Pagination(pageNo, pageSize, totalCount);
		if (totalCount < 1) {
			p.setList(new ArrayList());
			return p;
		}
		crit.setProjection(projection);
		if (projection == null) {
			crit.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		}
		if (orders != null) {
			for (Order order : orders) {
				crit.addOrder(order);
			}
		}
		crit.setFirstResult(p.getFirstResult());
		crit.setMaxResults(p.getPageSize());
		p.setList(crit.list());
		return p;
	}

	/**
	 * 通过count查询获得本次查询所能获得的对象总数.
	 * 
	 * @param finder
	 * @return
	 */
	protected int countQueryResult(Finder finder) {
		Query query = getSession().createQuery(finder.getRowCountHql());
		finder.setParamsToQuery(query);
		return ((Number) query.iterate().next()).intValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.firesafe.util.s2sh.BaseDao2#refresh(java.lang.Object)
	 */
	@Override
	public void refresh(Object entity) {
		getSession().refresh(entity);
	}

	/**
	 * 根据Criterion条件创建Criteria,后续可进行更多处理,辅助函数.
	 */
	protected Criteria createCriteria(Criterion... criterions) {
		Criteria criteria = getSession().createCriteria(getPersistentClass());
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}

	private Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.firesafe.util.s2sh.BaseDao2#createNewEntiey()
	 */
	@Override
	public T createNewEntiey() {
		try {
			return getPersistentClass().newInstance();
		} catch (Exception e) {
			throw new RuntimeException("不能创建实体对象：" + getPersistentClass().getName());
		}
	}

	@SuppressWarnings("unchecked")
	private ClassMetadata getCmd(Class clazz) {
		return sessionFactory.getClassMetadata(clazz);
	}

	public static final NotBlankPropertySelector NOT_BLANK = new NotBlankPropertySelector();

	/**
	 * 不为空的EXAMPLE属性选择方式
	 * 
	 * @author liufang
	 * 
	 */
	static final class NotBlankPropertySelector implements PropertySelector {
		private static final long serialVersionUID = 1L;

		@Override
		public boolean include(Object object, String property, Type type) {
			return object != null && !(object instanceof String && StringUtils.isBlank((String) object));
		}
	}

	@Override
	public List<Object[]> findByHql(String hql, Object... objects) {
		List<Object[]> list = new ArrayList();
		Query query = getSession().createQuery(hql);
		if (objects != null && objects.length != 0) {
			for (int i = 0; i < objects.length; i++) {
				query.setParameter(i, objects[i]);
			}
		}
		return query.list();
	}

	@Override
	public List<Object[]> findBySql(String sql, Object... objects) {
		List<Object[]> list = new ArrayList();
		Query query = getSession().createSQLQuery(sql);
		if (objects != null && objects.length != 0) {
			for (int i = 0; i < objects.length; i++) {
				query.setParameter(i, objects[i]);
			}
		}
		list = query.list();
		return list;
	}

}