package com.springmvc.repositories;

import com.springmvc.entity.Newer;
import org.springframework.data.repository.CrudRepository;

public interface VerificationTokenRepository extends CrudRepository<Newer,Integer> {
}
