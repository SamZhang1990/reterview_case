package com.sam.zhang.multithread.pool.scenario.service.impl;

import com.sam.zhang.multithread.pool.scenario.service.AppUserSearchService;
import com.sam.zhang.multithread.pool.scenario.service.ArticleSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleSearchServiceImpl implements ArticleSearchService {

    @Autowired
    private AppUserSearchService appUserSearchService;

    @Override
    public List<Map> search(String keyword) {
        Map<String, String> map = new HashMap<>();
        if ( !keyword.isBlank() ) {
            map.put(keyword, keyword);
            appUserSearchService.insert(keyword);
        }
        return List.of(map);
    }
}
