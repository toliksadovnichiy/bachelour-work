//package com.course.covid19system.service;
//
//import com.course.covid19system.entity.RegionInfo;
//import com.course.covid19system.repository.RegionInfoRepo;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.List;
//
//@Slf4j
//@Service
//public class RegionInfoService {
//
//    @Autowired
//    private RegionInfoRepo regionInfoRepo;
//
//    public RegionInfo save(@RequestBody RegionInfo region) {
//        log.info("In RegionInfoService save {}", region);
//        return regionInfoRepo.save(region);
//    }
//    public RegionInfo getByName(String name){
//        log.info("In RegionInfoService getByName {}", name);
//        return regionInfoRepo.findByName(name);
//    }
//    public RegionInfo getById(Long id){
//        log.info("In RegionInfoService getById {}", id);
//        return regionInfoRepo.getById(id);
//    }
//    public void delete(Long id) {
//        log.info("In RegionInfoService delete {}", id);
//        regionInfoRepo.deleteById(id);
//    }
//    public List<RegionInfo> getAll(){
//        log.info("In RegionInfoService getAll");
//        return regionInfoRepo.findAll();
//    }
//}
