package com.springmvc.repositories;

import com.springmvc.entity.Attendance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by diwakar on 02/10/17.
 */
@Repository
public interface AttendanceRepository extends CrudRepository<Attendance, Long> {

}
