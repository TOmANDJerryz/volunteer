package com.volunteer.base;

/**
 * //TODO 添加类/接口功能描述
 *
 * @author 作者信息
 * date 2019-01-18
 */
public class TableResult {
    public static <T> ResponseTable<T> success(String code, String message,Long count, T t) {
        return new ResponseTable<T>(code,message,count,t);
    }
}
