package com.learn.user.daorespostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.controller.model.Post;


public interface PostRepository extends JpaRepository<Post, Integer> {

}
