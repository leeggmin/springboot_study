package com.example.test.controller;

import com.example.test.domain.Member;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class ExRestController {

    @GetMapping("/map")
    public HashMap<String,Object> testMap(){
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("name","jimin");
        hashMap.put("age","17");
        hashMap.put("gender","woman");
        return hashMap;
    }

    @GetMapping("/member")
    public Member findJimin(@RequestParam("name")String name, @RequestParam("age")int age){
        Member member=new Member();
        member.setName(name);
        member.setAge(age);
        return member;
    }

    @RequestMapping(value="/hello2",method = RequestMethod.GET)
    public String reHello2(){
        return "hello2";
    }

    @GetMapping("/hello")
    public String reHello(){
        return "hello";
    }
}
