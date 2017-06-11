package com.bmtwriters.services;

import java.util.List;

import com.bmtwriters.domains.Chapters;
import com.bmtwriters.domains.Page;

public interface PageService {

	public void save(Page p);
	
	public List<Page> list();
	public Page findById(int id);
	public int countByChapter(Chapters chapter);
	
}
