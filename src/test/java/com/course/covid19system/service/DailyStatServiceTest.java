//package com.course.covid19system.service;
//
//import com.course.covid19system.entity.DailyStat;
//import com.course.covid19system.repository.DailyStatRepo;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.persistence.EntityNotFoundException;
//import javax.transaction.Transactional;
//import java.math.BigDecimal;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@Transactional
//@RunWith(SpringRunner.class)
//@SpringBootTest
//class DailyStatServiceTest {
//
//    @Autowired
//    private DailyStatRepo dailyStatRepo;
//
//    @Autowired
//    private DailyStatService dailyStatService;
//
//    public DailyStat dailyStat;
//    @BeforeEach
//    void init() {
//        dailyStat = new DailyStat(1L, "01/01/2021", 1000, 15, 750, 235);
//    }
//
//    @Test
//    void save(){
//        assertEquals(dailyStatService.save(dailyStat).getDate(), dailyStat.getDate());
//        assertEquals(dailyStatService.save(dailyStat).getInfections(), dailyStat.getInfections());
//        assertEquals(dailyStatService.save(dailyStat).getFatalities(), dailyStat.getFatalities());
//        assertEquals(dailyStatService.save(dailyStat).getRecovered(), dailyStat.getRecovered());
//        assertEquals(dailyStatService.save(dailyStat).getAreSickNow(), dailyStat.getAreSickNow());
//    }
//
//    @Test
//    void getById(){
//        dailyStatService.save(dailyStat);
//        DailyStat dailyStat1 = dailyStatService.getById(1L);
//        assertEquals(dailyStat1.getInfections(), dailyStat.getInfections());
//    }
//
//    @Test
//    void getByDate(){
//        dailyStatService.save(dailyStat);
//        DailyStat dailyStat1 = dailyStatService.getByDate("01/01/2021");
//        assertEquals(dailyStat1.getInfections(), dailyStat.getInfections());
//    }
//
//    @Test
//    void getAll(){
//        dailyStatService.save(dailyStat);
//        List list = dailyStatService.getAll();
//        assertFalse(list.isEmpty());
//    }
//
//    @Test
//    void delete(){
//        dailyStatService.save(dailyStat);
//        dailyStatService.delete(1L);
//    }
//
//    @Test
//    void calculateIFR() {
//        DailyStat dailyStat = new DailyStat(1L, "01/01/2021", 1000, 15, 750, 235);
//        dailyStatService.save(dailyStat);
//        BigDecimal result = new BigDecimal(dailyStatService.calculateIFR(1L));
//        BigDecimal expected = new BigDecimal(15/1000*100);
//        assertEquals(result, expected);
//    }
//}