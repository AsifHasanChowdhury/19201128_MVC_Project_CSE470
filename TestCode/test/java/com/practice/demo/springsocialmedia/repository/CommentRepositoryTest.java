package com.practice.demo.springsocialmedia.repository;



import com.practice.demo.springsocialmedia.model.Comment;
import com.practice.demo.springsocialmedia.model.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void ShouldSaveComment(){
        Comment comment=new Comment(1L,"Today's Comment",null,Instant.now(),null);
        Comment savedcomment= commentRepository.save(comment);
        assertThat(savedcomment).usingRecursiveComparison().ignoringFields("post","user").isEqualTo(comment);

    }
}
