package com.springmvc.repositories;

import com.springmvc.entity.Newer;
import com.springmvc.enums.UserRole;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewerRepository extends CrudRepository<Newer,Long> {

    List<Newer> findAllByUserRoleNot(UserRole role, Pageable pageable);

    Newer findByNewerId(long newerId);

    Newer findByEmail(String email);
}
