package com.learn.user.daorespostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.controller.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
