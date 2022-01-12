package com.practice.demo.springsocialmedia.service;

import com.practice.demo.springsocialmedia.dto.CommentsDto;
import com.practice.demo.springsocialmedia.dto.PostRequest;
import com.practice.demo.springsocialmedia.dto.PostResponse;
import com.practice.demo.springsocialmedia.exceptions.PostNotFoundException;
import com.practice.demo.springsocialmedia.mapper.CommentMapper;
import com.practice.demo.springsocialmedia.mapper.PostMapper;
import com.practice.demo.springsocialmedia.model.Comment;
import com.practice.demo.springsocialmedia.model.Post;
import com.practice.demo.springsocialmedia.model.Subreddit;
import com.practice.demo.springsocialmedia.model.User;
import com.practice.demo.springsocialmedia.repository.CommentRepository;
import com.practice.demo.springsocialmedia.repository.PostRepository;
import com.practice.demo.springsocialmedia.repository.SubredditRepository;
import com.practice.demo.springsocialmedia.repository.UserRepository;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Optional;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CommentServiceTest {
    User user=Mockito.mock(User.class);
    PostRepository postRepository=Mockito.mock(PostRepository.class);
    UserRepository userRepository=Mockito.mock(UserRepository.class);
    AuthService authService=Mockito.mock(AuthService.class);
    CommentMapper commentMapper=Mockito.mock(CommentMapper.class);
    SubredditRepository subredditRepository=Mockito.mock(SubredditRepository.class);
    CommentRepository commentRepository=Mockito.mock(CommentRepository.class);
    CommentService commentService=Mockito.mock(CommentService.class);
    CommentsDto commentsDto=Mockito.mock(CommentsDto.class);
    PostMapper postMapper=Mockito.mock(PostMapper.class);
    Subreddit subreddit=Mockito.mock(Subreddit.class);
    MailContentBuilder mailContentBuilder=Mockito.mock(MailContentBuilder.class);
    MailService mailService=Mockito.mock(MailService.class);
    Comment comment=Mockito.mock(Comment.class);
    Post post=Mockito.mock(Post.class);
    PostRequest postRequest=Mockito.mock(PostRequest.class);
    @Before
    public void setUp() {
        this.commentService=new CommentService(this.commentRepository);
    }
    @Test
    @DisplayName("Checking whether the method saving information")
    void saveCheck() {

        Mockito.when(subredditRepository.findByName("First Subreddit"))
                .thenReturn(Optional.of(subreddit));
        Mockito.when(authService.getCurrentUser())
                .thenReturn(user);
        Mockito.when(commentMapper.map(commentsDto, post, user))
                .thenReturn(comment);
        Mockito.when(postMapper.map(postRequest, subreddit, user))
                .thenReturn(post);
        commentService.save(commentsDto);
      doThrow(new PostNotFoundException("Comment Not Saved")).when(commentService).save(commentsDto);

    }

    @org.junit.jupiter.api.Test
    void getAllCommentsForPost() {
        doThrow(new PostNotFoundException("Comment Not Saved")).when(commentService).getAllCommentsForPost(123L);
    }

    @org.junit.jupiter.api.Test
    void getAllCommentsForUser() {
        doThrow(new RuntimeException("Comment Not Saved")).when(commentService).getAllCommentsForUser("Asif");
    }
}