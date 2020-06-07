package com.example.bushudemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ceshi")
public class CeShiController {

    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public String test1() {
        return "第一个测试接口！";
    }
}
