package com.zhh.personal.dao.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @date 2017-3-14 下午4:52:36
 * @author zhaohaihao
 */
public interface BaseMapper<T> {
	
	public void save(@Param("example") T t);
	public void delete(@Param("id") int id);
	public void update(@Param("example") T t);
	public T getById(@Param("id") int id);
	public List<T> getList();
	
}
