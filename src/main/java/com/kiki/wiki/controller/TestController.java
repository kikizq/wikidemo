package com.kiki.wiki.controller;

import com.kiki.wiki.domain.Test;
import com.kiki.wiki.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author qizhang
 * @date 2021/9/27
 * @desc
 */
@RestController
public class TestController {

    @Value("${test.hello:TEST}")
    private String testHello;

    @Resource
    private TestService testService;


    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    //@GetMapping
    public String hello(){
        return "hello ," + testHello;
    }

    @GetMapping("/test/list")
    public List<Test> list(){
        return testService.list();
    }
}
