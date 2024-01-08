package com.modern.admin.user;

import org.springframework.data.repository.CrudRepository;

import com.modern.common.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}