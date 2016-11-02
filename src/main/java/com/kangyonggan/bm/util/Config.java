package com.kangyonggan.bm.util;

/**
 * @author kangyonggan
 * @since 2016/10/22
 */
public abstract class Config {

    /**
     * 获取配置的值
     *
     * @param key
     * @return
     */
    public abstract String getValue(String key);

    /**
     * 获取配置的值， 有默认值
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public abstract String getValueWithDefault(String key, String defaultValue);

}
