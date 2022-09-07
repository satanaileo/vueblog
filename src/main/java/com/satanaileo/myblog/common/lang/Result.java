package com.satanaileo.myblog.common.lang;

import lombok.Data;

import java.io.Serializable;

/**
 * satanaileo
 * 2022/8/19 20:41
 */

@Data
public class Result implements Serializable {
    private int code;
    private String msg;
    private Object data;

    public static Result succ(Object data) {
        Result result = new Result();
        result.setCode(200);
        result.setData(data);
        result.setMsg("操作成功!");
        return result;
    }

    public static Result succ(int code, String msg, Object data) {
        Result result = new Result();
        result.setMsg(msg);
        result.setCode(code);
        result.setData(data);
        return result;
    }

    public static Result fail(String msg) {
        Result result = new Result();
        result.setData(null);
        result.setCode(400);
        result.setMsg(msg);
        return result;
    }

    public static Result fail(String msg, Object data) {
        Result result = new Result();
        result.setMsg(msg);
        result.setData(data);
        result.setCode(400);
        return result;
    }

    public static Result fail(int code, String msg, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }
}
