package com.course.covid19system.controller;

import com.course.covid19system.entity.RegionInfo;
import com.course.covid19system.repository.RegionInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class RegionInfoController {

    @Autowired
    private RegionInfoRepo regionInfoRepo;

    @GetMapping("/regions")
    public String regions(Model model){
        Iterable<RegionInfo> regionInfos = regionInfoRepo.findAll();
        model.addAttribute("region_infos", regionInfos);
        model.addAttribute("title", "Області");
        return "regions";
    }
}
