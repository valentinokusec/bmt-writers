package com.bmtwriters.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bmtwriters.domains.User;

public interface UserDao extends JpaRepository<User, Integer> {

	public User findByUsername(String user);

	Page<User> findAll(Pageable pageable);
	
}
