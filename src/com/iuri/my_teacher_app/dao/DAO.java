package com.iuri.my_teacher_app.dao;

import java.util.List;

public interface DAO<T>{

	public void add(T object);
	public void delete(T object);
	public void update(T object);
	public T search(T object);
	public List<T> searchAll();
}
