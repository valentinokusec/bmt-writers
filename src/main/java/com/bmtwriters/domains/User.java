package com.bmtwriters.domains;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="email")
	private String email;
	@JoinColumn(name = "activities")
	@OneToMany
	private List<Activity> activity;
	@JoinColumn(name = "book")
	@OneToMany
	private List<Book> book;
	@OneToMany(targetEntity=UserRole.class, mappedBy="user", fetch=FetchType.EAGER)
    public Set<UserRole> userRole = new HashSet<UserRole>(0);
	

	
}
