package com.caihao.springboot.exception;

/**
 * @author CaiHao
 * @create 2019-08-28 21:35:33
 */
public class UserNoException extends RuntimeException {

    public UserNoException() {

        super("用户不存在！");
    }
}
