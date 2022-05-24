//package com.course.covid19system.service;
//
//import com.course.covid19system.entity.RegionInfo;
//import com.course.covid19system.repository.RegionInfoRepo;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import javax.transaction.Transactional;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@Transactional
//@RunWith(SpringRunner.class)
//@SpringBootTest
//class RegionInfoServiceTest {
//
//    @Autowired
//    private RegionInfoRepo regionInfoRepo;
//
//    @Autowired
//    private RegionInfoService regionInfoService;
//
//    public RegionInfo regionInfo;
//    @BeforeEach
//    void init() {
//        regionInfo = new RegionInfo(1L, "oblast", "Kyiv", 6000000, "Some Info");
//    }
//
//    @Test
//    void save(){
//        assertEquals(regionInfoService.save(regionInfo).getType(), regionInfo.getType());
//        assertEquals(regionInfoService.save(regionInfo).getName(), regionInfo.getName());
//        assertEquals(regionInfoService.save(regionInfo).getPopulation(), regionInfo.getPopulation());
//        assertEquals(regionInfoService.save(regionInfo).getInfo(), regionInfo.getInfo());
//    }
//
//    @Test
//    void getById(){
//        regionInfoService.save(regionInfo);
//        //RegionInfo dailyStat1 = regionInfoService.getById(1L);
//        assertEquals(regionInfoService.getById(1L).getName(), regionInfo.getName());
//    }
//
//    @Test
//    void getByName(){
//        regionInfoService.save(regionInfo);
//        RegionInfo dailyStat1 = regionInfoService.getByName("Kyiv");
//        assertEquals(dailyStat1.getPopulation(), regionInfo.getPopulation());
//    }
//
//    @Test
//    void getAll(){
//        regionInfoService.save(regionInfo);
//        List list = regionInfoService.getAll();
//        assertFalse(list.isEmpty());
//    }
//
//    @Test
//    void delete(){
//        regionInfoService.save(regionInfo);
//        regionInfoService.delete(1L);
//    }
//}