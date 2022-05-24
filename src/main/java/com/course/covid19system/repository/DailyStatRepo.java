package com.course.covid19system.repository;

import com.course.covid19system.entity.DailyStat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyStatRepo extends CrudRepository<DailyStat, Long> {
}
