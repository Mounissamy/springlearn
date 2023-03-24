package com.learn.user.controller;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learn.controller.exeception.UserNotFoundException;
import com.learn.controller.model.User;
import com.learn.user.daorespostiory.UserDaoService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	private UserDaoService userService;

	UserController(UserDaoService userService) {
		this.userService = userService;
	}
	/*
	 * if we want to use the HATEOS(Data and Links to be returned to customer),
	 * There are two things we need to do. 1. EntityModel 2. WebMvcLinkBuilder
	 */

	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.findAll();
	}

	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable int id) {
		userService.deleteUserById(id);

	}

	// This will give Response code is 200
	/*
	 * @PostMapping("/users") public User addUser(@RequestBody User users) { return
	 * userService.save(users); }
	 */

	// This will return Response code is 201
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User users) {
		User savedUser = userService.save(users);
		// below will return location URL to redirect like /users/4/
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	/*
	 * if we want to use the HATEOS(Data and Links to be returned to customer),
	 * There are two things we need to do. 1. EntityModel 2. WebMvcLinkBuilder
	 */
	@GetMapping("/users/{id}")
	public EntityModel<User> getUsersById(@PathVariable int id) {
		User u = userService.findOne(id);

		if (u == null)
			throw new UserNotFoundException("Given User Id = " + id + " is not Found ");
		System.out.println("User Onject==" + u.toString());
		//Below steps for HATEOS Implementation.
		WebMvcLinkBuilder link=  linkTo(methodOn(this.getClass()).getUsers());
		link.withRel("all-user");
		EntityModel<User> em = EntityModel.of(u);
		em.add(link.withRel("all-user"));
		//linkTo(methodOn(this.getClass()).deleteUserById(), new Object[methodOn(this.getClass()).deleteUserById().getParameterTypes().length]));
		//WebMvcLinkBuilder link2 = linkTo(methodOn(this.getClass()).deleteUserById());
		//em.add(link.withRel("deleteUserById"));
		return em;

	}

}
