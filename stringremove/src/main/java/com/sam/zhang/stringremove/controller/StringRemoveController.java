package com.sam.zhang.stringremove.controller;

import com.sam.zhang.stringremove.common.Response;
import com.sam.zhang.stringremove.service.StringService;
import com.sam.zhang.stringremove.service.StringStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class StringRemoveController {

    private final Map<String, StringStrategy> stringStrategyMap;

    @Autowired
    private StringService stringService;

    @Autowired
    public StringRemoveController(Map<String, StringStrategy> stringStrategyMap) {
        this.stringStrategyMap = stringStrategyMap;
    }

    @RequestMapping("/remove")
    public ResponseEntity<Response> remove(@RequestParam("input") String input, @RequestParam("strategy") String strategy) {
        try{
            StringStrategy stringStrategy = stringStrategyMap.get(strategy);
            Response response = stringService.verifyInput(input, stringStrategy);
            if ( !Objects.isNull(response) ) {
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(stringService.remove(input, stringStrategy), HttpStatus.OK);

        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
