package com.fit.food;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fit.food.entity.Menu;
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
		List<Menu> list = fitFoodService.selectMenu();
		assertEquals(10, list.size());
	}
	
	@Test
	public void 메뉴존재여부테스트() {
		boolean existTf = fitFoodService.selectMenuNameCnt("떡볶이");
		assertTrue(existTf);
	}
	
	@Test
	public void 랜덤메뉴선택테스트() {
		String menu = fitFoodService.selectRandomMenu();
		
		boolean existTf = fitFoodService.selectMenuNameCnt(menu);
		assertTrue(existTf);
	}
}