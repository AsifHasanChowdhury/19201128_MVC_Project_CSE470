package com.practice.demo.springsocialmedia.repository;

import com.practice.demo.springsocialmedia.model.Comment;
import com.practice.demo.springsocialmedia.model.Post;
import com.practice.demo.springsocialmedia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}
