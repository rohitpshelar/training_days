package com.ro.demo.service;

import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ro.demo.exceptions.SpringRedditException;
import com.ro.demo.model.User;
import com.ro.demo.repository.UserRepository;

import lombok.AllArgsConstructor;

import static java.util.Collections.singletonList;

@Service
@AllArgsConstructor
public class UserDetailsServiceIMPL implements UserDetailsService{

	private final UserRepository userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optional = userRepository.findByUsername(username);
		User user = optional.orElseThrow(() -> new SpringRedditException("User not found"));
		
		// TODO learn org.springframework.security.core.userdetails.User
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, getAuthorities("USER"));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(String role) {
		// TODO learn singletonList
		return singletonList(new SimpleGrantedAuthority(role));
	}
	

}
