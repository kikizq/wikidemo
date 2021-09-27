package com.kiki.wiki.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qizhang
 * @date 2021/9/27
 * @desc
 */
@RestController
public class TestController {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    //@GetMapping
    public String hello(){
        return "hello";
    }
}
