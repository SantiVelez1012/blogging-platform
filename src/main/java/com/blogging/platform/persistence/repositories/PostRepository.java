package com.blogging.platform.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogging.platform.persistence.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
