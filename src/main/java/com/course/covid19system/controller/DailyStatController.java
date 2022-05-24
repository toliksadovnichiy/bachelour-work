package com.course.covid19system.controller;

import com.course.covid19system.entity.DailyStat;
import com.course.covid19system.repository.DailyStatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.Iterator;

@Controller
public class DailyStatController {

    @Autowired
    private DailyStatRepo dailyStatRepo;

    @GetMapping("/statistics")
    public String statistics(Model model){
        Iterable<DailyStat> dailyStats = dailyStatRepo.findAll();
        model.addAttribute("stats", dailyStats);
        if (dailyStats instanceof Collection) {
            model.addAttribute("stats_length", ((Collection<?>) dailyStats).size());
        } else {
            int count = 0;
            Iterator iterator = dailyStats.iterator();
            while(iterator.hasNext()) {
                iterator.next();
                count++;
            }
            model.addAttribute("stats_length", count);
        }
        return "statistics";
    }
}
