package com.aoeai.common.exception;

/**
 * 分页对象异常
 */
public class PageException extends RuntimeException {

    public PageException(){
        super();
    }

    public PageException(String message){
        super(message);
    }

}
