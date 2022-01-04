package com.practice.demo.springsocialmedia.repository;

import com.practice.demo.springsocialmedia.model.Post;
import com.practice.demo.springsocialmedia.model.Subreddit;
import com.practice.demo.springsocialmedia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllBySubreddit(Subreddit subreddit);

    List<Post> findByUser(User user);
}
