package com.kangyonggan.bm.util;

import com.kangyonggan.bm.exception.ConfigException;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.util.Properties;

/**
 * @author kangyonggan
 * @since 2016/10/22
 */
@Log4j2
@ToString
public class BaseConfig extends Config {

    private Properties props;

    public BaseConfig(String path) throws ConfigException {
        props = getProperties(path);
    }

    @Override
    public String getValue(String key) {
        return props.getProperty(key, "");
    }

    @Override
    public String getValueWithDefault(String key, String defaultValue) {
        return props.getProperty(key, defaultValue);
    }


    /**
     * 加载配置文件
     *
     * @param propPath
     * @return
     * @throws ConfigException
     */
    public static Properties getProperties(String propPath) throws ConfigException {
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(propPath));
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
            Properties p = new Properties();
            p.load(reader);
            return p;
        } catch (Exception e) {
            throw new ConfigException(e);
        }
    }
}
