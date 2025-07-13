package com.sam.zhang.multithread.pool.scenario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/order_detail")
public class OrderDetailController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ExecutorService executorService;

    @RequestMapping("/get/detail_new/{id}")
    public Map<String, Object> getOrderDetailNew(@PathVariable int id) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        Future<Map<String, Object>> f1 = executorService.submit(() -> {
            return restTemplate.getForObject("http://localhost:8080/order/get/{id}", Map.class, id);
        });

        Future<Map<String, Object>> f2 = executorService.submit(() -> {
            return restTemplate.getForObject("http://localhost:8080/product/get/{id}", Map.class, id);
        });

        Future<Map<String, Object>> f3 = executorService.submit(() -> {
            return restTemplate.getForObject("http://localhost:8080/logistics/get/{id}", Map.class, id);
        });
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("order", f1.get());
        resultMap.put("product", f2.get());
        resultMap.put("logistics", f3.get());

        long end = System.currentTimeMillis();
        System.out.println("Totally time used in thread pool:" + (end - start) + "ms");
        return resultMap;
    }

    @RequestMapping("/get/detail/{id}")
    public Map<String, Object> getOrderDetail(@PathVariable int id) {
        long start = System.currentTimeMillis();
        Map<String, Object> order = restTemplate.getForObject("http://localhost:8080/order/get/{id}", Map.class, id);

        Map<String, Object> product = restTemplate.getForObject("http://localhost:8080/product/get/{id}", Map.class, id);

        Map<String, Object> logistics = restTemplate.getForObject("http://localhost:8080/logistics/get/{id}", Map.class, id);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("order", order);
        resultMap.put("product", product);
        resultMap.put("logistics", logistics);

        long end = System.currentTimeMillis();
        System.out.println("Totally time used in the single thread:" + (end - start) + "ms");
        return resultMap;
    }
}
