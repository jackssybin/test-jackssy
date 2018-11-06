package com.qding.test.sync.voliate;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("api/test/")
public class TestController  {

    public AtomicInteger count = new AtomicInteger(0);

    public     volatile int counttwo=1;

    @RequestMapping(value = "/add",method={RequestMethod.POST})
    public Integer add() {
        counttwo++;

//        logger.info("testNum add="+count.incrementAndGet());
        return counttwo;
    }

    @RequestMapping(value = "/minus",method={RequestMethod.POST})
    public Integer minus() {
        counttwo--;
//        logger.info("testNum minus="+count.decrementAndGet());
        return counttwo;
    }
}