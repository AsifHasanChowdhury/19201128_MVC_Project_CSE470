package com.practice.demo.springsocialmedia.service;

import com.practice.demo.springsocialmedia.dto.SubredditDto;
import com.practice.demo.springsocialmedia.exceptions.PostNotFoundException;
import com.practice.demo.springsocialmedia.mapper.SubredditMapper;
import com.practice.demo.springsocialmedia.model.Subreddit;
import com.practice.demo.springsocialmedia.model.User;
import com.practice.demo.springsocialmedia.repository.SubredditRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;

class SubredditServiceTest {

    SubredditDto subredditDto= Mockito.mock(SubredditDto.class);
    SubredditRepository subredditRepository=Mockito.mock(SubredditRepository.class);
    SubredditMapper subredditMapper=Mockito.mock(SubredditMapper.class);
   // SubredditService subredditService=new SubredditService(subredditRepository,subredditMapper);
     SubredditService subredditService=Mockito.mock(SubredditService.class);
    @Test
    void save() {


        doThrow(new RuntimeException()).when(subredditService).save(subredditDto);

    }

    @Test
    void getAll() {
        doThrow(new RuntimeException()).when(subredditService).getAll();
    }

    @Test
    void getSubreddit() {
        doThrow(new RuntimeException()).when(subredditService).getSubreddit(123L);
    }
}