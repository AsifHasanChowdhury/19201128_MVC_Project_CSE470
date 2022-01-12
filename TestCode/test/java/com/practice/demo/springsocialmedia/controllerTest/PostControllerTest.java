package com.practice.demo.springsocialmedia.controllerTest;


import com.practice.demo.springsocialmedia.controller.PostController;
import com.practice.demo.springsocialmedia.dto.PostResponse;
import com.practice.demo.springsocialmedia.security.JwtProvider;
import com.practice.demo.springsocialmedia.service.PostService;
import com.practice.demo.springsocialmedia.service.UserDetailsServiceImpl;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcBuilderCustomizer;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilderSupport;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

@WebMvcTest(controllers = PostController.class)
public class PostControllerTest {

    @MockBean
    private PostService postService;

    @MockBean
    private JwtProvider jwtProvider;

    @MockBean
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should List All post when get Request to endpoint /api/posts/")
    public void shouldlistAllPost() throws Exception{

        PostResponse postreq1=new PostResponse(1L,"post-name","http://mysite","description",
                "user 1","subredditname",0,0,"1 days Ago",false,false);



        PostResponse postreq2=new PostResponse(2L,"post-name2","http://mysite2","description2",
                "user 1","subredditname2",0,0,"2 days Ago",false,false);


        Mockito.when(postService.getAllPosts()).thenReturn(Arrays.asList(postreq1,postreq2));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/post/"))
                .andExpect(MockMvcResultMatchers.status().is(2000))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id",Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].postName",Matchers.is("post-name")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].url",Matchers.is("http://mysite")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].url",Matchers.is("http://mysite2")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].postName",Matchers.is("post-name2")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id",Matchers.is(2)));
    }
}
