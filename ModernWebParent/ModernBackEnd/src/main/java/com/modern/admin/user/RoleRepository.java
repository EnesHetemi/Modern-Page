package com.modern.admin.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.modern.common.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}
