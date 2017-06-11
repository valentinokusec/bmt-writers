package com.bmtwriters.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmtwriters.domains.Chapters;
import com.bmtwriters.domains.Page;

public interface PageDao extends JpaRepository<Page, Integer>{
	
	public int countByChapter(Chapters chapter);
	
}
