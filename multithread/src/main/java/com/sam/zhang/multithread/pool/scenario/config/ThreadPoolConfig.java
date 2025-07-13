package com.sam.zhang.multithread.pool.scenario.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class ThreadPoolConfig {

    /**
     *
     */
    private static final int CORE_POOL_SIZE = 17;

    private static final int MAX_POOL_SIZE = 50;

    private static final int QUEUE_CAPACITY = 1000;

    private static final int KEPP_ALIVE_SECONDS = 500;

    @Bean("taskExecutor")
    public ExecutorService executorService() {

        AtomicInteger c = new AtomicInteger(1);
        LinkedBlockingDeque queue = new LinkedBlockingDeque(QUEUE_CAPACITY);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEPP_ALIVE_SECONDS,
                TimeUnit.SECONDS,
                queue,
                r -> new Thread(r, "sam-thread-pool-" + c.getAndIncrement()),
                new ThreadPoolExecutor.AbortPolicy()
        );
        return threadPoolExecutor;
    }

}
