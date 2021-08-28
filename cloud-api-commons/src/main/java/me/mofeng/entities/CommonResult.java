package me.mofeng.entities;

import lombok.Data;

/**
 * @author mofeng
 * @create 2021/8/27 14:52
 */
@Data
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;


    public CommonResult() {}

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


}
