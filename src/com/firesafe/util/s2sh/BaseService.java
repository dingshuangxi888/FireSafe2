package com.firesafe.util.s2sh;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T extends Serializable> {
	/**
	 * 通过ID查找对象
	 * 
	 * @param id
	 *            记录的ID
	 * @return 实体对象
	 */
	public T findById(Serializable id);

	public T load(Serializable id);

	/**
	 * 查找所有对象
	 * 
	 * @return 对象列表
	 */
	public List<T> findAll();

	/**
	 * 保存对象
	 * 
	 * @param entity
	 *            实体对象
	 * @return 操作信息
	 */
	public T save(T entity);

	public Object update(Object o);

	public Object saveOrUpdate(Object o);

	public void delete(Object o);

	/**
	 * 根据ID删除记录
	 * 
	 * @param id
	 *            记录ID
	 */
	public T deleteById(Serializable id);

	/**
	 * 根据ID数组删除记录，当发生异常时，操作终止并回滚
	 * 
	 * @param ids
	 *            记录ID数组
	 * @return 删除的对象
	 */
	public List<T> deleteById(Serializable[] ids);

	/**
	 * 保存并刷新对象，避免many-to-one属性不完整
	 * 
	 * @param entity
	 */
	public T saveAndRefresh(T entity);
}