package com.ro.demo.service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ro.demo.dto.AuthenticationResponse;
import com.ro.demo.dto.LoginRequest;
import com.ro.demo.dto.RegisterRequest;
import com.ro.demo.exceptions.SpringredditException;
import com.ro.demo.model.NotificationEmail;
import com.ro.demo.model.User;
import com.ro.demo.model.VerificationToken;
import com.ro.demo.repository.UserRepository;
import com.ro.demo.repository.VerificationTokenRepository;
import com.ro.demo.security.JwtProvider;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService {
	
	
	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;
	private final VerificationTokenRepository verificationTokenRepository;
	private final MailService mailService;
	private final AuthenticationManager authenticationManager;  
	private final JwtProvider jwtPrivider;
	
	@Transactional
	public void signup(RegisterRequest registerRequest ) {
		User u = new User();
		u.setUsername(registerRequest.getUsername());
		u.setEmail(registerRequest.getEmail());
		u.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
	//	u.setPassword(registerRequest.getPassword());
		u.setCreated(Instant.now());
		u.setEnable(false);
		
		userRepository.save(u);
		
		String token = generateVerificationToken(u);
		mailService.sendMail(new NotificationEmail("Please Activate your account", u.getEmail(),"Thank You "
				+ "Click"
				+ "http://localhost:8080/api/auth/accountVerification/"+ token));
	}

	private String generateVerificationToken(User user) {
		String verificationToken = UUID.randomUUID().toString();
		
		VerificationToken vt = new VerificationToken();
		vt.setToken(verificationToken);
		vt.setUser(user);
		
		verificationTokenRepository.save(vt);
		return verificationToken;
		
	}

	public void verifyAccount(String token) {
	Optional<VerificationToken> optional = verificationTokenRepository.findByToken(token);
	optional.orElseThrow(() -> new SpringredditException("Invalid Token"));
	fetchUserAndEnable(optional.get());
	}

	@Transactional
	private void fetchUserAndEnable(VerificationToken verificationToken) {
		String username = verificationToken.getUser().getUsername();
		User u = userRepository.findByUsername(username).orElseThrow(() -> new SpringredditException("User not found"));
		u.setEnable(true);
		userRepository.save(u);
		
	}

	public AuthenticationResponse login(LoginRequest loginRequest) {
		Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtPrivider.generateToken(authentication);
		return new AuthenticationResponse(token, loginRequest.getUsername());
		
	}
}
