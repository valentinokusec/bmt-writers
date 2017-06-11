package com.bmtwriters.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bmtwriters.dao.BookDao;
import com.bmtwriters.domains.Book;
import com.bmtwriters.domains.Category;

@Service("BookService")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookdao;
	@Override
	public void save(Book p) {
		// TODO Auto-generated method stub
		bookdao.save(p);
	}

	@Override
	public List<Book> list() {
		// TODO Auto-generated method stub
		return bookdao.findAll();
	}

	@Override
	public Page<Book> findAllByCategory(Pageable pageable, Category Category) {
		// TODO Auto-generated method stub
		return bookdao.findAllByCategory(pageable, Category);
	}

	@Override
	public Book findById(int id) {
		// TODO Auto-generated method stub
		return bookdao.findOne(id);
	}



}
