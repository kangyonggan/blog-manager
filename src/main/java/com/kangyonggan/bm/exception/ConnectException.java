package com.kangyonggan.bm.exception;

/**
 * @author kangyonggan
 * @since 2016/11/2
 */
public class ConnectException extends Exception {

    private static String defaultMessage = "读取网页异常";

    public ConnectException() {
        super(defaultMessage);
    }

    public ConnectException(String message) {
        super(message);
    }

    public ConnectException(Throwable e) {
        super(defaultMessage, e);
    }

    public ConnectException(String message, Throwable e) {
        super(message, e);
    }

}
