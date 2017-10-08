package com.springmvc.repositories;

import com.springmvc.entity.CabRequest;
import com.springmvc.entity.Feedback;
import org.springframework.data.repository.CrudRepository;

public interface FeedbackRepository extends CrudRepository<Feedback, Long> {
    Feedback findByCabRequest(CabRequest cabRequest);
}
