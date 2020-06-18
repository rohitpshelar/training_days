package com.ro.demo.security;

import static io.jsonwebtoken.Jwts.parser;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.annotation.PostConstruct;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.ro.demo.exceptions.SpringredditException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class JwtProvider {
	
	 private KeyStore keyStore;
	 
	    @PostConstruct
	    public void init() {
	        try {
	            keyStore = KeyStore.getInstance("JKS");
	            InputStream resourceAsStream = getClass().getResourceAsStream("/springblog.jks");
	            keyStore.load(resourceAsStream, "secret".toCharArray());
	        } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e) {
	            throw new SpringredditException("Exception occurred while loading keystore", e);
	        }

	    }
	
	public String generateToken(Authentication authentication) {
		User principle = (User) authentication.getPrincipal();
		return Jwts.builder().setSubject(principle.getUsername()).signWith(getPrivateKey()).compact();
	}
	
    private PrivateKey getPrivateKey() {
        try {
            return (PrivateKey) keyStore.getKey("springblog", "secret".toCharArray());
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
            throw new SpringredditException("Exception occured while retrieving public key from keystore", e);
        }
    }
    
    public boolean validateToken(String jwt) {
    	 parser().setSigningKey(getPublickey()).parseClaimsJws(jwt);
         return true;

	}
    
    private PublicKey getPublickey() {
        try {
            return keyStore.getCertificate("springblog").getPublicKey();
        } catch (KeyStoreException e) {
            throw new SpringredditException("Exception occured while " +
                    "retrieving public key from keystore", e);
        }
    }
    
    public String getUsernameFromJwt(String token) {
        Claims claims = parser()
                .setSigningKey(getPublickey())
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

}
