package com.springmvc.repositories;

import com.springmvc.entity.Feedback;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by diwakar on 02/10/17.
 */
public interface FeedbackRepository extends CrudRepository<Feedback, Long> {
}
