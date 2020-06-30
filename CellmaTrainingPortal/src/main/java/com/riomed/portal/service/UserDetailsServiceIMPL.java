package com.riomed.portal.service;

import static java.util.Collections.singletonList;

import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.riomed.portal.exceptions.CellmaTrainingPortalException;
import com.riomed.portal.model.User;
import com.riomed.portal.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsServiceIMPL implements UserDetailsService{

	private final UserRepository userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optional = userRepository.findByUsername(username);
		User user = optional.orElseThrow(() -> new CellmaTrainingPortalException("User not found"));
		
		// TODO learn org.springframework.security.core.userdetails.User
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, getAuthorities("USER"));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(String role) {
		// TODO learn singletonList
		return singletonList(new SimpleGrantedAuthority(role));
	}
	

}
