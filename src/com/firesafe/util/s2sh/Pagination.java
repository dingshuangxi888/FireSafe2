package com.firesafe.util.s2sh;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Pagination<E> extends SimplePage implements Serializable,
		Paginable {

	public Pagination() {
	}

	public Pagination(int pageNo, int pageSize, int totalCount) {
		super(pageNo, pageSize, totalCount);
	}

	@SuppressWarnings("unchecked")
	public Pagination(int pageNo, int pageSize, int totalCount, List<E> list) {
		super(pageNo, pageSize, totalCount);
		this.list = list;

	}

	public int getFirstResult() {
		return (pageNo - 1) * pageSize;
	}

	/**
	 * 当前页的数据
	 */
	@SuppressWarnings("unchecked")
	private List<E> list;

	@SuppressWarnings("unchecked")
	public List<E> getList() {
		return list;
	}

	@SuppressWarnings("unchecked")
	public void setList(List<E> list) {
		this.list = list;
	}
}