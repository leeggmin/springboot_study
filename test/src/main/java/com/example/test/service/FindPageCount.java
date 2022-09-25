package com.example.test.service;

import javax.servlet.http.HttpServletRequest;

public class FindPageCount {

    public int getCount() {
        return count;
    }

    public void setCount(String pageName) {
        String result=pageName.substring(10);
        if(result.equals("test")){
            this.count = 3;
        }
    }

    int count;

}