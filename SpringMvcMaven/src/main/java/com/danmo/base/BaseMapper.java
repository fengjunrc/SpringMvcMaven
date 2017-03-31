package com.danmo.base;

import java.util.List;

import com.danmo.utils.PageHelper;

public interface BaseMapper<T> {

	public void insert(T t);
	
	public void update(T t);
	
	public void delete(int id);
	
	public List<T> queryList();
	
	public T queryById(int id);
	
	public List<T> queryByName(String name);
	
	public long queryTotal();
	
	public List<T> queryByPage(PageHelper page);
}
