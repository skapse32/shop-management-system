package com.congdongjava.repo;

import java.util.List;

public interface BaseDao<T,V> {
	
	V findById(final T id);
	
	List<V> findAll();
	
	List<V> findAllWithPaging(final int startPage, final int pageSize);
	
	void create(final V entity);
	
	void update(final V entity);
	
	void deleteById(final T id);
}
