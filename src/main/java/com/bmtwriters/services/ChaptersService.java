package com.bmtwriters.services;

import java.util.List;

import com.bmtwriters.domains.Chapters;

public interface ChaptersService {

	public void save(Chapters p);
	
	public List<Chapters> list();
	
	public Chapters findById(int id);
	
}
