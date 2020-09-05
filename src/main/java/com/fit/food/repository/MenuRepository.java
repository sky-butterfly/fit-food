package com.fit.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fit.food.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{

}