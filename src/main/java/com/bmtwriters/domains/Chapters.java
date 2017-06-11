package com.bmtwriters.domains;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name="chapters")
@Transactional
public class Chapters {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="number")
	private int number;
	@Column(name="data")
	private String data;
	@JoinColumn(name = "chapters")
	@ManyToOne
	private Book book;
	@JoinColumn(name = "page")
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Page> page;




	
}
