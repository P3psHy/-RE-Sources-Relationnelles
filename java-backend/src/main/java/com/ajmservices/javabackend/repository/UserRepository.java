package com.ajmservices.javabackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.ajmservices.javabackend.model.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

}