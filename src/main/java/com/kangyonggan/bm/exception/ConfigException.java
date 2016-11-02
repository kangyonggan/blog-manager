package com.kangyonggan.bm.exception;

/**
 * @author kangyonggan
 * @since 2016/11/2
 */
public class ConfigException extends Exception {

    private static String defaultMessage = "读取配置文件异常";

    public ConfigException() {
        super(defaultMessage);
    }

    public ConfigException(String message) {
        super(message);
    }

    public ConfigException(Throwable e) {
        super(defaultMessage, e);
    }

    public ConfigException(String message, Throwable e) {
        super(message, e);
    }

}
