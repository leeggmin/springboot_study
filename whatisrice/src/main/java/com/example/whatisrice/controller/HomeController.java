package com.example.whatisrice.controller;

import com.example.whatisrice.domain.Rice;
import com.example.whatisrice.service.RiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    public final RiceService riceService;
    Rice rice=new Rice();

    @Autowired
    public HomeController(RiceService riceService) {
        this.riceService = riceService;
    }

    @GetMapping("/")
    public String home(){
        return "Rice";
    }

    @PostMapping("/rice-post")
    public String rice_posting(RiceForm form){
        rice.setDay(form.getM_day());
        rice.setMenu(riceService.findMenu(rice));
        System.out.println(rice.getDay());
        System.out.println(rice.getMenu());
        return "redirect:show";
    }

    @GetMapping("/show")
    public String show(Model model){
        model.addAttribute("dates",rice);
        return "Show";
    }
}
