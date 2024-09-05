package com.blogging.platform.api.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.blogging.platform.persistence.entities.Post;
import com.blogging.platform.persistence.repositories.PostRepository;
import com.blogging.platform.utils.dtos.PostDto;
import com.blogging.platform.utils.exceptions.BlogPostException;
import com.blogging.platform.utils.exceptions.Causes;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public Post save(PostDto postDto){
        Post newPost = new Post( postDto.getTitle(), postDto.getContent(), postDto.getCategory() );
        
        newPost.setTags(postDto.getTags());
        newPost.setCreatedAt(LocalDateTime.now());
        return postRepository.save(newPost);
    }

    public List<Post> findAll(){
        return postRepository.findAll();
    }


    public Post findById(Long id){
        Optional<Post> postFound = postRepository.findById(id);
        if(postFound.isEmpty()) throw new BlogPostException(Causes.BLOG_ID_DOES_NOT_EXIST, new Throwable("Post with id " + id + " does not exist"));
        return postFound.get();
    }

    public Post updateBlogPost(Long id, PostDto postDto){
        Post post = postRepository.findById(id).orElse(null);
        if(post != null){
            post.setTitle(postDto.getTitle());
            post.setContent(postDto.getContent());
            post.setCategory(postDto.getCategory());
            post.setTags(postDto.getTags());
            post.setUpdatedAt(LocalDateTime.now());
            return postRepository.save(post);
        }
        throw new BlogPostException(Causes.BLOG_ID_DOES_NOT_EXIST, new Throwable("Post with id " + id + " does not exist"));
    }

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }

    public List<Post> searchPosts(String term){
        List<Post> posts;
        if (term.isEmpty()) {
            posts = postRepository.findAll();
        } else {
            posts = postRepository.searchPosts(term);
        }
        return posts;
    }
}
