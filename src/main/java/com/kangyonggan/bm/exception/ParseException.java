package com.kangyonggan.bm.exception;

/**
 * @author kangyonggan
 * @since 2016/11/2
 */
public class ParseException extends Exception {

    private static String defaultMessage = "解析网页异常";

    public ParseException() {
        super(defaultMessage);
    }

    public ParseException(String message) {
        super(message);
    }

    public ParseException(Throwable e) {
        super(defaultMessage, e);
    }

    public ParseException(String message, Throwable e) {
        super(message, e);
    }

}
