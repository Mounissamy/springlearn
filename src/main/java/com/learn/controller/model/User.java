package com.learn.controller.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
@Entity (name="USER_DETAIL")
public class User {
	
	@Size(min=2,max =20, message = "Name must be 2 to 20 charactors")
	@JsonProperty("user_name")
	private String name;
	//@NotNull(message = "Id should not be empty")
	@Id
	@GeneratedValue
	private Integer id;
	
	@Past( message = "BirthDate should be Past")
	@JsonProperty("user_DathOfBirth")
   	private LocalDate birthDate;
	
	@OneToMany(mappedBy ="user")
	@JsonIgnore
	private List<Post> post;
	

	public User() {
	}

	public User(Integer id, String name, LocalDate dateofBirth) {
        super();
		this.id = id;
		this.name = name;
		this.birthDate = dateofBirth;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", birthDate=" + birthDate + ", post=" + post + "]";
	}

	

}
