package com.next.repository;

import org.springframework.data.repository.CrudRepository;

import com.next.model.internal.Stop;

public interface StopRepository extends CrudRepository<Stop, String> {

}