//package com.course.covid19system.controller;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//class DailyStatControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private DailyStatController dailyStatController;
//
//    @Test
//    public void mainPageTest() throws Exception {
//
//        this.mockMvc.perform(get("/main"))
//                .andDo(print())
//                .andExpect(authenticated())
//                .andExpect(xpath("//*[@id='navbarSupportedContent']/div").string("01/01/2021"));
//    }
//
//    @Test
//    public void messageListTest() throws Exception {
//        this.mockMvc.perform(get("/main"))
//                .andDo(print())
//                .andExpect(authenticated())
//                .andExpect(xpath("//*[@id=dailystats-list']/div").nodeCount(4));
//    }
//
//    @Test
//    public void filterMessageTest() throws Exception {
//        this.mockMvc.perform(get("/main").param("filter", "01/01/2021"))
//                .andDo(print())
//                .andExpect(authenticated())
//                .andExpect(xpath("//*[@id='dailystats-list']/div").nodeCount(2))
//                .andExpect(xpath("//*[@id='dailystats-list']/div[@data-id='1']").exists())
//                .andExpect(xpath("//*[@id='dailystats-list']/div[@data-id='3']").exists());
//    }
//
//
//}