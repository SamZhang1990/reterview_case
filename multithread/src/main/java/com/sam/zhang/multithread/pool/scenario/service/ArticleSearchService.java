package com.sam.zhang.multithread.pool.scenario.service;

import java.util.List;
import java.util.Map;

public interface ArticleSearchService {

    List<Map> search(String keyword);
}
