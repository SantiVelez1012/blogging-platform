package com.blogging.platform.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogging.platform.api.services.PostService;
import com.blogging.platform.persistence.entities.Post;
import com.blogging.platform.utils.dtos.PostDto;
import com.blogging.platform.utils.exceptions.BlogPostException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping(path = "/api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody PostDto post) throws BlogPostException {
        Post entity = postService.save(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAllPosts() throws BlogPostException {
        List<Post> posts = postService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(posts);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) throws BlogPostException {
        Post post = postService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(post);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody PostDto post) throws BlogPostException {
        Post entity = postService.updateBlogPost(id, post);
        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) throws BlogPostException {
        postService.deletePost(id);
        return ResponseEntity.status(HttpStatus.OK).body("Post deleted successfully");
    }

    @GetMapping("/search/{term}")
    public ResponseEntity<List<Post>> searchPostByTerm(@PathVariable String term) throws BlogPostException {
        List<Post> posts = postService.searchPosts(term);
        return ResponseEntity.status(HttpStatus.OK).body(posts);
    }
    



}
