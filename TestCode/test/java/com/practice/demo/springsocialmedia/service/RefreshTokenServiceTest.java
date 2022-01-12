package com.practice.demo.springsocialmedia.service;

import com.practice.demo.springsocialmedia.exceptions.PostNotFoundException;
import com.practice.demo.springsocialmedia.model.Post;
import com.practice.demo.springsocialmedia.model.RefreshToken;
import com.practice.demo.springsocialmedia.repository.RefreshTokenRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;

class RefreshTokenServiceTest {
    RefreshTokenService refreshTokenService= Mockito.mock(RefreshTokenService.class);
    RefreshTokenRepository refreshTokenRepository=Mockito.mock(RefreshTokenRepository.class);
    RefreshToken refreshToken=Mockito.mock(RefreshToken.class);
    @Test
    void generateRefreshToken() {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setCreatedDate(Instant.now());

        refreshTokenRepository.save(refreshToken);
        Mockito.verify(refreshTokenRepository, Mockito.times(1)).save(ArgumentMatchers.any(RefreshToken.class));

    }

    @Test
    void validateRefreshToken() {
        String token=refreshToken.getToken();
        doThrow(new RuntimeException()).when(refreshTokenService).validateRefreshToken(token);

    }

    @Test
    void deleteRefreshToken() {
        String token=refreshToken.getToken();
        refreshTokenRepository.deleteByToken(token);
        Mockito.verify(refreshTokenRepository, Mockito.times(1)).save(ArgumentMatchers.any(RefreshToken.class));

    }
}