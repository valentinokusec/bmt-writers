package com.bmtwriters.web;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.bmtwriters.domains.Chapters;
import com.bmtwriters.domains.Page;
import com.bmtwriters.services.ChaptersService;
import com.bmtwriters.services.PageService;


@Controller
public class SocketController {

	@Autowired
	PageService pageservice;
	
	@Autowired
	ChaptersService chapterservice;

	@MessageMapping("/editpage/{id}")
	@SendTo("/topic/editpage/{id}")
	public Page editPage(@DestinationVariable String id, Page data) throws Exception {

		
		Page page= pageservice.findById(data.getId());
		page.setData(data.getData());
		pageservice.save(page);
		return new Page();
	}
	@MessageMapping("/createpage/{id}")
	@SendTo("/topic/createpage/{id}")
	public Page createPage(@DestinationVariable String id, String data) throws Exception {

		JSONObject jo = new JSONObject(data);
		Chapters ch=chapterservice.findById(jo.getInt("data"));
		int pages=pageservice.countByChapter(ch);
		Page page= new Page();
		page.setChapter(ch);
		page.setNumber(pages+1);
		pageservice.save(page);
		List<Page> pageList= ch.getPage();
    	pageList.add(page);
    	ch.setPage(pageList);
    	chapterservice.save(ch);
		return new Page();
	}
	@MessageMapping("/deletepage/{id}")
	@SendTo("/topic/deletepage/{id}")
	public Page deletePage(@DestinationVariable String id, Page page) throws Exception {

		
		
		return new Page();
	}

}
