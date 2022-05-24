package com.course.covid19system.repository;

import com.course.covid19system.entity.RegionInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionInfoRepo extends CrudRepository<RegionInfo, Long> {
}
