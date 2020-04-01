package com.chainlinkproto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.chainlinkproto.dao.CLPDao;
import com.chainlinkproto.model.LoginUserDetails;
import com.chainlinkproto.model.Users;

public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private CLPDao loginRepository;
	
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
		Users user = loginRepository.getUserByEmail(emailAddress);
			
		if (user == null) {
			throw new UsernameNotFoundException("User not found");

		}	
		return new LoginUserDetails(user);
	}

}
