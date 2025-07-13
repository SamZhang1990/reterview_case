package com.sam.zhang.multithread.pool.scenario.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/get/{id}")
    public Map<String, Object> getOrder(@PathVariable int id) throws InterruptedException {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("total", "2000.30");
        Thread.sleep(500);
        return map;
    }
}
