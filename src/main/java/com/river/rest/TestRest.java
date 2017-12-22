package com.river.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/12/23.
 */
@RestController
public class TestRest {
    Logger log = LoggerFactory.getLogger(TestRest.class);

    @RequestMapping("testjenkins")
    public String testJenkins(){
        log.info("Hello Jenkins");
        return "Hello Jenkins";
    }
}
