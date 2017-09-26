package com.springmvc.repositories;

import com.springmvc.entity.Newer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Newer,Integer> {

    Newer findByUsername(String userName);

}
