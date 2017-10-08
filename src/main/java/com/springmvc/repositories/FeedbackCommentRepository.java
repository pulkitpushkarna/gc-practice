package com.springmvc.repositories;

import com.springmvc.entity.FeedbackComment;
import org.springframework.data.repository.CrudRepository;

public interface FeedbackCommentRepository extends CrudRepository<FeedbackComment, Long> {
}
