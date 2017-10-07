package com.next.repository;

import org.springframework.data.repository.CrudRepository;

import com.next.model.internal.User;

public interface UserRepository extends CrudRepository<User, String> {

}