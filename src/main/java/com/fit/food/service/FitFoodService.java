package com.fit.food.service;

import java.awt.print.Pageable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fit.food.entity.Menu;
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
	public List<Menu> selectMenu(){
		
		List<Menu> list = menuRepo.findAll();
		
		return list;
	}

	/**
	 * �޴� ���翩�� üũ
	 * @param string
	 * @return
	 */
	public boolean selectMenuNameCnt(String menu) {
		
		boolean existTf = menuRepo.existsByName(menu);
		
		return existTf;
	}
	
	/**
	 * �޴� �������� ����
	 * @return
	 */
	public String selectRandomMenu() {
		
		String menu = menuRepo.findByRandom(PageRequest.of(0, 1));
		
		return menu;
	}
}