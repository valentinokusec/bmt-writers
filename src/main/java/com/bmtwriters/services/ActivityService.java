package com.bmtwriters.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bmtwriters.domains.Activity;
import com.bmtwriters.domains.User;

public interface ActivityService {

	public void save(Activity p);
	
	public List<Activity> list();
	
}
