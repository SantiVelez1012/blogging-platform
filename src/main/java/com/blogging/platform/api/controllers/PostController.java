package com.blogging.platform.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogging.platform.api.services.PostService;
import com.blogging.platform.persistence.entities.Post;
import com.blogging.platform.utils.dtos.PostDto;
import com.blogging.platform.utils.exceptions.BlogPostException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/api/posts")
public class PostController {

    @Autowired
    private PostService postService;


    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody PostDto post) throws BlogPostException {
        Post entity = postService.save(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }
    



}
