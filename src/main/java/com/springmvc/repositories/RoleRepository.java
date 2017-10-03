package com.springmvc.repositories;

import com.springmvc.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by diwakar on 17/09/17.
 */
@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {

}
