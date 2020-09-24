package com.fit.food.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fit.food.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{

	@Query("select name from Menu order by random()")
	String findByRandom(PageRequest limit);

	boolean existsByName(String menu);
}