package com.blogging.platform.persistence.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blogging.platform.persistence.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

    @Query("SELECT p FROM Post p WHERE " +
           "p.title LIKE %:searchTerm% " +
           "OR p.category LIKE %:searchTerm% " +
           "OR p.content LIKE %:searchTerm%")
    List<Post> searchPosts(@Param("searchTerm") String searchTerm);

}
