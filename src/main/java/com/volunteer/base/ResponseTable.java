package com.volunteer.base;

import org.apache.poi.ss.formula.functions.T;

/**
 * layuiTable分页
 *
 * @author 作者信息
 * date 2019-01-18
 */
public class ResponseTable<T> {
    private String code;
    private String msg;
    private T data;
    private Long count;

    public ResponseTable() {
    }


    public ResponseTable(String code, String msg, Long count, T data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
