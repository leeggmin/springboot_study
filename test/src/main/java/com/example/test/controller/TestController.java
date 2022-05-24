package com.example.test.controller;

import com.example.test.domain.Jimin2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

    @GetMapping("/name")
    public String name(Model model){
        model.addAttribute("name","엄준식");
        return "name";
    }

    public class Jimin{
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        String name;
    }

    @ResponseBody
    @GetMapping("helloworld")
    public String helloworld(){
        return "helloworld";
    }

    @ResponseBody
    @GetMapping("/jimin")
    public Jimin rejson(@RequestParam("name") String name){
        Jimin jimin=new Jimin();
        jimin.setName(name);
        return jimin;
    }

    @ResponseBody
    @PostMapping("/post")
    public String method(@RequestBody Jimin2 jimin2){
        return "post="+jimin2.getDate();
    }

}
