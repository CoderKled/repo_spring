package com.controller;


import com.domain.Test;
import com.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController    //相当于@Controller + @ResponseBody  返回的结果转成JSON响应到页面上
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;
    @RequestMapping("/findAllTest")
    public List<Test> findAllTest(){
        return testService.findAllTest();
    }
}
