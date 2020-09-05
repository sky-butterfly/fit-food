package com.fit.food.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fit.food.entity.Menu;
import com.fit.food.repository.MenuRepository;

@Service
@Transactional
public class FitFoodService {
	
	@Autowired
	private MenuRepository repo;

	/**
	 * 메뉴 조회
	 * @return
	 */
	public List<Menu> selectMenu(){
		
		List<Menu> list = repo.findAll();
		
		return list;
	}
}