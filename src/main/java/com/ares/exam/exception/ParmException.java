package com.ares.exam.exception;

/**
 * Created by guoyouwei on 2018/8/17.
 */
public class ParmException extends ApplicationException {

    public ParmException(String messageOrCode) {
        super(messageOrCode);
    }

    public ParmException(String messageOrCode, Object[] args) {
        super(messageOrCode, args);
    }

    public ParmException(String messageOrCode, Object[] args, Throwable cause) {
        super(messageOrCode, args, cause);
    }

    public ParmException(String messageOrCode, Throwable cause) {
        super(messageOrCode, cause);
    }

    public ParmException(Throwable cause) {
        super(cause);
    }

}
