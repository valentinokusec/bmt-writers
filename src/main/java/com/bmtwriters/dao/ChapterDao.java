package com.bmtwriters.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmtwriters.domains.Chapters;

public interface ChapterDao extends JpaRepository<Chapters, Integer>{
	

	
}
