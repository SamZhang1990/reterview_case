package com.sam.zhang.stringremove.service;

import com.sam.zhang.stringremove.common.Response;

public interface StringService {
    /**
     *
     * @param input
     * @param strategy
     * @return
     */
    Response verifyInput(String input, StringStrategy strategy);

    /**
     *
     * @param input
     * @param strategy
     * @return
     */
    Response remove(String input, StringStrategy strategy);
}
