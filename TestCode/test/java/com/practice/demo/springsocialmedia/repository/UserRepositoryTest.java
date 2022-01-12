package com.practice.demo.springsocialmedia.repository;

import com.practice.demo.springsocialmedia.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {


    @Autowired
    private UserRepository userRepository;


    @Test
    public void ShouldSaveUser(){

        User currentUser = new User(null, "test user", "secret password", "user@email.com", Instant.now(), true);
        User savedUser= userRepository.save(currentUser);
        assertThat(savedUser).usingRecursiveComparison().ignoringFields("userid").isEqualTo(currentUser);

    }


}
