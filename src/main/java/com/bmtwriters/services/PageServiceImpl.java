package com.bmtwriters.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmtwriters.dao.PageDao;
import com.bmtwriters.domains.Chapters;
import com.bmtwriters.domains.Page;

@Service("PageService")
public class PageServiceImpl implements PageService {

	@Autowired
	private PageDao pagedao;

	@Override
	public void save(Page p) {
		// TODO Auto-generated method stub
		pagedao.save(p);
	}

	@Override
	public List<Page> list() {
		// TODO Auto-generated method stub
		return pagedao.findAll();
	}

	@Override
	public Page findById(int id) {
		// TODO Auto-generated method stub
		return pagedao.findOne(id);
	}

	@Override
	public int countByChapter(Chapters chapter) {
		// TODO Auto-generated method stub
		return pagedao.countByChapter(chapter);
	}
	



}
