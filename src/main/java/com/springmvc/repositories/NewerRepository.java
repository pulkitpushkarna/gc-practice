package com.springmvc.repositories;

import com.springmvc.entity.Newer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewerRepository extends CrudRepository<Newer,Long> {

    Newer findByUsername(String userName);

}
