package com.fit.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fit.food.entity.Menus;
import com.fit.food.entity.Users;

@Repository
public interface MenuRepository extends JpaRepository<Menus, Long>{

}