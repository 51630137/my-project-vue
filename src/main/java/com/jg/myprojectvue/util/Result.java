package com.jg.myprojectvue.util;

import lombok.Data;

@Data
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    public Result() {
    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(String msg, Object data) {
        this.code=200;
        this.msg = msg;
        this.data = data;
    }

    public Result(Object data) {
        this.code=200;
        this.data = data;
    }

    public Result(String msg) {
        this.code=200;
        this.msg = msg;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
