package com.bmtwriters.domains;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="book")
public class Book {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@JoinColumn(name = "chapters")
	@OneToMany
	private List<Chapters> chapters;
	@JoinColumn(name = "category")
	@ManyToMany
	private List<Category> category;
	@Column(name = "created")
    private Timestamp created;
	@Column(name = "updated")
    private Timestamp updated;

	

	
}
