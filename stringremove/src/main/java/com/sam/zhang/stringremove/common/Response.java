package com.sam.zhang.stringremove.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private int code;
    private String message;
    private T data;

    public static <T> Response<T> success(int code, T data) {
        return new Response<>(code, "success", data);
    }

    public static <T> Response<T> error(int code, String message) {
        return new Response<>(code, message,null);
    }

}
