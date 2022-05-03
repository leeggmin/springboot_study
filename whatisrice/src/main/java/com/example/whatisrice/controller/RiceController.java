package com.example.whatisrice.controller;

import com.example.whatisrice.domain.Date;
import com.example.whatisrice.service.RiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class RiceController {

    private final RiceService riceService;
    Date date=new Date();

    @Autowired
    public RiceController(RiceService riceService) {
        this.riceService = riceService;
    }

    @GetMapping("/")
    public String rice(){
        return "Rice";
    }

    @PostMapping("/show")
    public String create(RiceForm form){
        date.setDay(form.getM_day());;
        return "redirect:/";
    }

    @GetMapping("/show")
    public String show(Model model){
        Optional<Date> dates = riceService.findone(this.date.getDay());
        model.addAttribute("dates",dates);
        return "Show";
    }

}
