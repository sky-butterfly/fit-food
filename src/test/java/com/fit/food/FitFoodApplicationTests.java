package com.fit.food;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fit.food.entity.Menus;
import com.fit.food.service.FitFoodService;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class FitFoodApplicationTests {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	FitFoodService fitFoodService;

	@Test
	public void Test() {
		logger.info("�׽�Ʈ");
	}
	
	@Test
	public void ����ڵ���׽�Ʈ() {		
		int result = fitFoodService.insertUser("�ϴó���");		
		assertEquals(1, result);
	}
	
	@Test
	public void ������ߺ��׽�Ʈ() {
		fitFoodService.insertUser("�ϴó���");
		int result = fitFoodService.insertUser("�ϴó���");		
		assertEquals(-1, result);
	}
	
	@Test
	public void �޴���ȸ�׽�Ʈ() {
		List<Menus> list = fitFoodService.selectMenu();
		assertEquals(10, list.size());
	}
}