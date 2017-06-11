package com.bmtwriters.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmtwriters.dao.ActivityDao;
import com.bmtwriters.dao.UserDao;
import com.bmtwriters.domains.Activity;
@Service("ActivitysService")
public class ActivityServiceImpl implements ActivityService{

	@Autowired
    private ActivityDao activitydao;
	
	@Override
	public void save(Activity p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Activity> list() {
		// TODO Auto-generated method stub
		return activitydao.findAll();
	}

}
