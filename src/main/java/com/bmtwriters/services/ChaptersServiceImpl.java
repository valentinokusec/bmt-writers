package com.bmtwriters.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmtwriters.dao.ChapterDao;
import com.bmtwriters.domains.Chapters;

@Service("ChaptersService")
public class ChaptersServiceImpl implements ChaptersService{

	@Autowired
    private ChapterDao chapterdao;

	@Override
	public void save(Chapters p) {
		// TODO Auto-generated method stub
		chapterdao.save(p);
	}

	@Override
	public List<Chapters> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chapters findById(int id) {
		// TODO Auto-generated method stub
		return chapterdao.findOne(id);
	}
	


}
