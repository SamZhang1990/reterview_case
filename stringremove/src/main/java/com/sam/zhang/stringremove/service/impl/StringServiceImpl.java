package com.sam.zhang.stringremove.service.impl;

import com.sam.zhang.stringremove.common.Response;
import com.sam.zhang.stringremove.service.StringService;
import com.sam.zhang.stringremove.service.StringStrategy;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StringServiceImpl implements StringService {
    @Override
    public Response verifyInput(String input, StringStrategy strategy) {
        if (strategy == null) {
            return Response.error(HttpStatus.BAD_REQUEST.value(), "Invalid Strategy");
        }

        if (Objects.isNull(input) || !input.matches("^[a-zA-Z]+$")) {
            return Response.error(HttpStatus.BAD_REQUEST.value(), "Invalid Input");
        }
        return null;
    }

    @Override
    public Response remove(String input, StringStrategy strategy) {
        return Response.success(HttpStatus.OK.value(), strategy.remove(input));
    }
}
