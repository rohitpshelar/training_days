package com.riomed.portal.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riomed.portal.model.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);

    void deleteByToken(String token);
}