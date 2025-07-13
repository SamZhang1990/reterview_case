package com.sam.zhang.multithread.pool.scenario.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/get/{id}")
    public Map<String, Object> getProduct(@PathVariable int id) throws InterruptedException {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", "苹果手机");
        Thread.sleep(800);
        return map;
    }
}
