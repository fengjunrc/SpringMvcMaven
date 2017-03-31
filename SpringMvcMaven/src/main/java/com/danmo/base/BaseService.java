package com.danmo.base;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import com.danmo.utils.PageHelper;

public abstract  class BaseService<T> {
	
	@Resource
	public abstract BaseMapper<T> baseMapper();
	
	public  void insert(T t) {
		baseMapper().insert(t);
	}
	
	@Transactional
	public  void update(T t) {
		baseMapper().update(t);
	}
	
	public  void delete(int id) {
		baseMapper().delete(id);
	}
	
	public  List<T> queryList() {
		return baseMapper().queryList();
	}
	
	public  T queryById(int id) {
		return baseMapper().queryById(id);
	}
	
	public List<T> queryByName(String name){
		return baseMapper().queryByName(name);
	}
	
	public long queryTotal(){
		return baseMapper().queryTotal();
	}
	
	public List<T> queryByPage(PageHelper page){
		return baseMapper().queryByPage(page);
	}
}
