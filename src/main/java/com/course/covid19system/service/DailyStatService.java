//package com.course.covid19system.service;
//
//import com.course.covid19system.entity.DailyStat;
//import com.course.covid19system.repository.DailyStatRepo;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.List;
//
//@Slf4j
//@Service
//public class DailyStatService {
//
//    @Autowired
//    private DailyStatRepo dailyStatRepo;
//
//    public DailyStat save(@RequestBody DailyStat day) {
//        log.info("In DailyStatService save {}", day);
//        return dailyStatRepo.save(day);
//    }
//    public DailyStat getByDate(String date){
//        log.info("In DailyStatService getByDate {}", date);
//        return dailyStatRepo.findByDate(date);
//    }
//    public DailyStat getById(Long id){
//        log.info("In DailyStatService getById {}", id);
//        return dailyStatRepo.getById(id);
//    }
//    public void delete(Long id) {
//        log.info("In DailyStatService delete {}", id);
//        dailyStatRepo.deleteById(id);
//    }
//    public List<DailyStat> getAll(){
//        log.info("In DailyStatService getAll");
//        return dailyStatRepo.findAll();
//    }
//    //Death Coefficient
//    public double calculateIFR(Long id) {
//        return dailyStatRepo.findById(id).get().getFatalities()/dailyStatRepo.findById(id).get().getInfections()*100;
//    }
//}
