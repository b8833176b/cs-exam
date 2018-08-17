package com.ares.exam.exception;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by guoyouwei on 2018/8/17.
 */
public class ApplicationException extends RuntimeException {

    private Map<String, Object> additionalInfo = new HashMap<>();
    private Object[] args;

    /**
     */
    public ApplicationException(Throwable cause) {
        super(cause);
    }

    /**
     */
    public ApplicationException(String messageOrCode) {
        super(messageOrCode);
    }

    /**
     */
    public ApplicationException(String messageOrCode, Object[] args) {
        super(MessageFormat.format(messageOrCode, args));
        this.args = args;
    }

    /**
     */
    public ApplicationException(String messageOrCode, Throwable cause) {
        super(messageOrCode, cause);
    }

    /**
     */
    public ApplicationException(String messageOrCode, Object[] args, Throwable cause) {
        super(MessageFormat.format(messageOrCode, args), cause);
        this.args = args;
    }

    /**
     */
    public Map<String, Object> getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     */
    public void setAdditionalInfo(Map<String, Object> additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    /**
     */
    public void putAdditionalInfo(String key, Object value) {
        this.additionalInfo.put(key, value);
    }

    /**
     */
    public void removeAdditionalInfo(String key) {
        this.additionalInfo.remove(key);
    }

    /**
     */
    public Object[] getArgs() {
        return args;
    }

    /**
     */
    public void setArgs(Object[] args) {
        this.args = args;
    }

}
