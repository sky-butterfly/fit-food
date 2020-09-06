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
		logger.info("테스트");
	}
	
	@Test
	public void 사용자등록테스트() {		
		int result = fitFoodService.insertUser("하늘나비");		
		assertEquals(1, result);
	}
	
	@Test
	public void 사용자중복테스트() {
		fitFoodService.insertUser("하늘나비");
		int result = fitFoodService.insertUser("하늘나비");		
		assertEquals(-1, result);
	}
	
	@Test
	public void 메뉴조회테스트() {
		List<Menus> list = fitFoodService.selectMenu();
		assertEquals(10, list.size());
	}
}