package com.practice.demo.springsocialmedia.service;

import com.practice.demo.springsocialmedia.dto.PostRequest;
import com.practice.demo.springsocialmedia.dto.PostResponse;
import com.practice.demo.springsocialmedia.mapper.PostMapper;
import com.practice.demo.springsocialmedia.model.Post;
import com.practice.demo.springsocialmedia.model.Subreddit;
import com.practice.demo.springsocialmedia.model.User;
import com.practice.demo.springsocialmedia.repository.PostRepository;
import com.practice.demo.springsocialmedia.repository.SubredditRepository;
import com.practice.demo.springsocialmedia.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.time.Instant;
import java.util.Optional;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;

class PostServiceTest {


    private PostRepository postRepository= Mockito.mock(PostRepository.class);
    private SubredditRepository subredditRepository= Mockito.mock(SubredditRepository.class);
    private UserRepository userRepository= Mockito.mock(UserRepository.class);
    private AuthService authService= Mockito.mock(AuthService.class);
    private PostMapper postMapper=Mockito.mock(PostMapper.class);



    @Test
    @DisplayName("Should Retrieve Post by Id")
    public void shouldFindPostById() {

        PostService postService = new PostService(postRepository, subredditRepository, userRepository, authService, postMapper);

        Post post = new Post(123L, "First Post", "http://url.site", "Test", 0, null, Instant.now(), null);
        PostResponse expectedPostResponse = new PostResponse(123L, "First Post", "http://url.site", "Test",
                "Test User", "Test Subredit", 0, 0, "1 Hour Ago", false, false);

        Mockito.when(postRepository.findById(123L)).thenReturn(Optional.of(post));
        Mockito.when(postMapper.mapToDto(Mockito.any(Post.class))).thenReturn(expectedPostResponse);

        PostResponse actualPostResponse = postService.getPost(123L);

        Assertions.assertThat(actualPostResponse.getId()).isEqualTo(expectedPostResponse.getId());
        Assertions.assertThat(actualPostResponse.getPostName()).isEqualTo(expectedPostResponse.getPostName());
    }


    @Test
    @DisplayName("Should Save Posts")
    public void shouldSavePosts() {

        PostService postService = new PostService(postRepository, subredditRepository, userRepository, authService, postMapper);
        User currentUser = new User(123L, "test user", "secret password", "user@email.com", Instant.now(), true);
        Subreddit subreddit = new Subreddit(123L, "First Subreddit", "Subreddit Description", emptyList(), Instant.now(), currentUser);
        Post post = new Post(123L, "First Post", "http://url.site", "Test",
                0, null, Instant.now(), subreddit);
        PostRequest postRequest = new PostRequest(null, "First Subreddit", "First Post", "http://url.site", "Test");

        Mockito.when(subredditRepository.findByName("First Subreddit"))
                .thenReturn(Optional.of(subreddit));
        Mockito.when(authService.getCurrentUser())
                .thenReturn(currentUser);
        Mockito.when(postMapper.map(postRequest, subreddit, currentUser))
                .thenReturn(post);

        postService.save(postRequest);
        Mockito.verify(postRepository, Mockito.times(1)).save(ArgumentMatchers.any(Post.class));


    }
}
