package com.practice.demo.springsocialmedia.repository;
import com.practice.demo.springsocialmedia.model.Post;
import com.practice.demo.springsocialmedia.model.Subreddit;
import com.practice.demo.springsocialmedia.model.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class SubredditRepositoryTest {
    @Autowired
    private SubredditRepository subredditRepository;


    @Test
    public void CreateGroup(){
        User currentUser = new User(null, "test user", "secret password", "user@email.com", Instant.now(), true);

       Subreddit subreddit=Mockito.mock(Subreddit.class);
        Subreddit savedGroup= subredditRepository.save(subreddit);
        assertThat(savedGroup).usingRecursiveComparison().isEqualTo(subreddit);

    }

}
