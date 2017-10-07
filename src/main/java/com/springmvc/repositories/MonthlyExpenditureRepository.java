package com.springmvc.repositories;

import com.springmvc.entity.MonthlyExpenditure;
import org.springframework.data.repository.CrudRepository;

import java.time.Month;
import java.util.List;

/**
 * Created by jalajtagra on 07/10/17.
 */
public interface MonthlyExpenditureRepository extends CrudRepository<MonthlyExpenditure,Long>{

    List<MonthlyExpenditure> findAllByMonth(Month month);

}
