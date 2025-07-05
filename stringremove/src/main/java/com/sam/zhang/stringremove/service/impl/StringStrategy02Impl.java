package com.sam.zhang.stringremove.service.impl;

import com.sam.zhang.stringremove.service.StringStrategy;
import org.springframework.stereotype.Component;

/**
 * if the string contains 'a', then delete it
 * others if char continue more than 3times, replace the char with the previous one, such as, bbb->a
 */
@Component("stringStrategy02")
public class StringStrategy02Impl implements StringStrategy {
    @Override
    public String remove(String input) {
        StringBuilder sb = new StringBuilder(input);
        for (int i=0; i<sb.length(); i++) {
            char ch = sb.charAt(i);
            int j;
            for (j=i+1; j<sb.length(); j++) {
                if (ch != sb.charAt(j)) {
                    break;
                }
            }

            if ( (j-i) >= 3 ) {
                if ('a' == ch) {
                    sb.delete(i,j);
                } else {
                    char pch = (char) (ch-1);
                    sb.replace(i,j, String.valueOf(pch));
                }
                i = -1;
            }
        }
        return sb.toString();
    }
}
