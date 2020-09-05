package com.fit.food;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
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
	public void 메뉴조회테스트() {
		List<Menu> list = fitFoodService.selectMenu();
		assertEquals(10, list.size());
	}
}