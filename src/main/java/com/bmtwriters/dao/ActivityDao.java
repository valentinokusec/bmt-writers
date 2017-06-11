package com.bmtwriters.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmtwriters.domains.Activity;
import com.bmtwriters.domains.User;

public interface ActivityDao extends JpaRepository<Activity, Integer>{


	
}
