package com.bmtwriters.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.bmtwriters.dao.UserDao;
import com.bmtwriters.domains.User;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service("UserService")
public class UserServiceImpl implements UserService,UserDetailsService{

	@Resource
	private UserDao userdao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=userdao.findByUsername(username);
		if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
		else
		{
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), 
                 true, true, true, true, getGrantedAuthorities(user));
		}
    }
	 private List<GrantedAuthority> getGrantedAuthorities(User user){
	        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	         
	        for (com.bmtwriters.domains.UserRole userRole : user.getUserRole()) {
	        	authorities.add(new SimpleGrantedAuthority(userRole.getRole()));
			}
	        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(authorities);
	        
	        System.out.print("authorities :"+authorities);
	        return Result;
	    }
	@Override
	public Page<User> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return userdao.findAll(pageable);
	}
	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		return userdao.save(user);
	}
	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return userdao.save(user);
	}
	@Override
	public User findByUserName(String username) {
		// TODO Auto-generated method stub
		return userdao.findByUsername(username);
	}
	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return userdao.findOne(id);
		
		
	}
}
