package com.blogging.platform.api.services;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogging.platform.persistence.entities.Post;
import com.blogging.platform.persistence.repositories.PostRepository;
import com.blogging.platform.utils.dtos.PostDto;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post save(PostDto postDto){
        Post newPost = new Post( postDto.getTitle(), postDto.getContent(), postDto.getCategory() );
        
        newPost.setTags(postDto.getTags());
        newPost.setCreatedAt(LocalDateTime.now());
        return postRepository.save(newPost);
    }
}
