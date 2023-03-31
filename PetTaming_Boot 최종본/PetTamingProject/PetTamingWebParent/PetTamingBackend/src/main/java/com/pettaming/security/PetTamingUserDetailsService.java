package com.pettaming.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pettaming.entity.User;
import com.pettaming.home.userRepository;

public class PetTamingUserDetailsService implements UserDetailsService {

	@Autowired
	private userRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(email);
		if (user != null) {
			return new PetTamingUserDetails(user);
		}
		throw new UsernameNotFoundException("Could not find user with email: " + email);
	}

}
