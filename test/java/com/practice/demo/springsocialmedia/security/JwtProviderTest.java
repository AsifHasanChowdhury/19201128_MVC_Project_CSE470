package com.practice.demo.springsocialmedia.security;

import com.practice.demo.springsocialmedia.model.User;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;

import java.io.IOException;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JwtProviderTest {

    JwtProvider jwtProvider=Mockito.mock(JwtProvider.class);

  //  User user=new User("Asif","Hello","Hello@gmail.com",2222l,true);



  //   JwtProvider jwtProvider=new JwtProvider();
    

    @Test
    @DisplayName("Test Should Pass When Generate Token Pass")
    public void generateToken() {

        //Assertions.fail(jwtProvider.generateToken(authentication));
    }

    @Test
    public void generateTokenWithUserName() {
      //  Assertions.fail(jwtProvider.generateTokenWithUserName("Asif"));
      // verify(jwtProvider, times(1)).generateTokenWithUserName("Asif Hasan");
        doThrow(new RuntimeException()).when(jwtProvider).generateTokenWithUserName("Asif Hasan");
       // verify(jwtProvider, times(1)).generateTokenWithUserName("Asif Hasan");
    }

    @Test
    void validateToken() {
        Assertions.assertFalse(jwtProvider.validateToken("Asif Hasan"));
    }

    @Test
    void getUsernameFromJwt() {
      //jwtProvider.getUsernameFromJwt("Asif Hasan");
        doThrow(new RuntimeException()).when(jwtProvider).getUsernameFromJwt("Asif Hasan");
    }

    @Test
    void getJwtExpirationInMillis() {
        doThrow(new RuntimeException()).when(jwtProvider).getJwtExpirationInMillis();
    }

    @Test
    public void hello(){
        doThrow(new RuntimeException()).when(jwtProvider).hello();
    }
}