package com.sam.zhang.multithread.pool.scenario.service.impl;

import com.sam.zhang.multithread.pool.scenario.service.AppUserSearchService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AppUserSearchServiceImpl implements AppUserSearchService {

    @Async("taskExecutor")
    @Override
    public void insert(String keyword) {
        System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " search keyword: " + keyword + " have been saved into DB");
    }
}
