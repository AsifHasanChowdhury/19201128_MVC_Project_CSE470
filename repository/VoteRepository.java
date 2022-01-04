package com.practice.demo.springsocialmedia.repository;

import com.practice.demo.springsocialmedia.model.Post;
import com.practice.demo.springsocialmedia.model.User;
import com.practice.demo.springsocialmedia.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}
