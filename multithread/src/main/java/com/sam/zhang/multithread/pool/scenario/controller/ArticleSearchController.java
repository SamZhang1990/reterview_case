package com.sam.zhang.multithread.pool.scenario.controller;

import com.sam.zhang.multithread.pool.scenario.service.ArticleSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/article")
public class ArticleSearchController {

    @Autowired
    private ArticleSearchService articleSearchService;

    @GetMapping("/search")
    public List<Map> search(String keyword) {
        return articleSearchService.search(keyword);
    }

}
