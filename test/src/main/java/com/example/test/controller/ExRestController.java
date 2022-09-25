package com.example.test.controller;

import com.example.test.service.FindPageCount;
import com.example.test.domain.Img;
import com.example.test.domain.Member;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class ExRestController {

    @RequestMapping("/show_img/test")
    public List<Img> send_img(HttpServletRequest request){
        List<Img> imgList =new ArrayList<>();
        FindPageCount findPageCount = new FindPageCount();
        String whatYouCall = request.getServletPath();
        findPageCount.setCount(whatYouCall);
        System.out.println("result = "+findPageCount.getCount());
        return imgList;
    }

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
