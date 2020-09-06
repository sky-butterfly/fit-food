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
	 * ����� ���
	 * @param user
	 */
	public int insertUser(String name) {
		
		int result = 1;
		
		// �ߺ��˻�
		Users user = userRepo.findByName(name);
		
		if(user != null) {
			return -1;
		}
		
		// ����� ���
		user = new Users();
		user.setName(name);
		userRepo.save(user);		
		
		return result;
	}

	/**
	 * �޴� ��ȸ
	 * @return
	 */
	public List<Menus> selectMenu(){
		
		List<Menus> list = menuRepo.findAll();
		
		return list;
	}
}