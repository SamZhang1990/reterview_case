package com.sam.zhang.multithread.pool.scenario.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/logistics")
public class LogisticsController {

    @RequestMapping("/get/{id}")
    public Map<String, Object> getLogistics(@PathVariable int id) throws InterruptedException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", "中通快递");
        Thread.sleep(500);
        return map;
    }
}
