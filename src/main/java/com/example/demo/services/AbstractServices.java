package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.AdressDto;

public interface AbstractServices<T> {

	
	Integer save(T Dto);
	
	List<T> findAll();
	
	T findById(Integer id);
	
	void delleteById(Integer id);

	
	
}
