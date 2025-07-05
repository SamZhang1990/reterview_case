package com.sam.zhang.stringremove.service.impl;

import com.sam.zhang.stringremove.service.StringStrategy;
import org.springframework.stereotype.Component;

@Component("stringStrategy01")
public class StringStrategy01Impl implements StringStrategy {
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

            //abbbcccdddaaee
            if ( (j-i) >= 3 ) {
                sb.delete(i,j);
                i=-1;
            }

        }

        return sb.toString();
    }
}
