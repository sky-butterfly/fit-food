package com.fit.food.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fit.food.entity.Menus;
import com.fit.food.entity.Users;
import com.fit.food.repository.MenuRepository;
import com.fit.food.repository.UserRepository;

@Service
@Transactional
public class FitFoodService {
	
	@Autowired
	private MenuRepository menuRepo;
	
	@Autowired
	private UserRepository userRepo;

	/**
	 * 사용자 등록
	 * @param user
	 */
	public int insertUser(String name) {
		
		int result = 1;
		
		// 중복검사
		Users user = userRepo.findByName(name);
		
		if(user != null) {
			return -1;
		}
		
		// 사용자 등록
		user = new Users();
		user.setName(name);
		userRepo.save(user);		
		
		return result;
	}

	/**
	 * 메뉴 조회
	 * @return
	 */
	public List<Menus> selectMenu(){
		
		List<Menus> list = menuRepo.findAll();
		
		return list;
	}
}