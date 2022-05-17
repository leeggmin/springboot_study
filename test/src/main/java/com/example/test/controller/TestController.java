package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

    public class Jimin{
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        String name;
    }

    public class Jimin2{
        public Long getAge() {
            return age;
        }

        public void setAge(Long age) {
            this.age = age;
        }

        private Long age;
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
//        jimin2.setName("jimin");
//        jimin2.setAge(17);
//        jimin2.setClass_num(2);
        return "post="+jimin2.getAge();
    }
}
