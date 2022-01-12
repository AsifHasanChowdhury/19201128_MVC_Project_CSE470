package com.practice.demo.springsocialmedia.service;

import com.practice.demo.springsocialmedia.dto.LoginRequest;
import com.practice.demo.springsocialmedia.dto.RegisterRequest;
import com.practice.demo.springsocialmedia.exceptions.PostNotFoundException;
import com.practice.demo.springsocialmedia.model.Post;
import com.practice.demo.springsocialmedia.model.User;
import com.practice.demo.springsocialmedia.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class AuthServiceTest {
    AuthService authService=Mockito.mock(AuthService.class);
    RegisterRequest registerRequest= Mockito.mock(RegisterRequest.class);
    LoginRequest loginRequest=Mockito.mock(LoginRequest.class);
    UserRepository userRepository=Mockito.mock(UserRepository.class);

    @Test
    void signup() {
        User currentUser = new User(123L, "test user", "secret password", "user@email.com", Instant.now(), true);
        userRepository.save(currentUser);
        Mockito.verify(userRepository, Mockito.times(1)).save(ArgumentMatchers.any(User.class));
    }

    @Test
    void getCurrentUser() {
        doThrow(new PostNotFoundException("Comment Not Saved")).when(authService).getCurrentUser();
    }

    @Test
    void verifyAccount() {
        doThrow(new PostNotFoundException("Comment Not Saved")).when(authService).verifyAccount("Token");
    }

    @Test
    void login() {
        User currentUser = new User(123L, "test user", "secret password", "user@email.com", Instant.now(), true);
      //  Mockito.verify(authService.login(loginRequest));
      //  Mockito.verify(userRepository, Mockito.times(1)).save(ArgumentMatchers.any(User.class));
        doThrow(new PostNotFoundException("Comment Not Saved")).when(authService).login(loginRequest);

    }

     @Test
    void refreshToken() {
        doThrow(new PostNotFoundException("Comment Not Saved")).when(authService).refreshToken(refreshTokenRequest);
    }

    @Test
    void isLoggedIn() {
        doThrow(new PostNotFoundException("Comment Not Saved")).when(authService).isLoggedIn();
    }
}
