package com.kangyonggan.bm.util;

import com.kangyonggan.bm.exception.ConfigException;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kangyonggan
 * @since 2016/10/22
 */
@Log4j2
public class ConfigFactory {

    private static Map<String, BaseConfig> configs;
    private static String configPath;

    static {
        configs = new HashMap();
        BaseConfig baseConfig;
        try {
            baseConfig = new BaseConfig(ConfigFactory.class.getResource("/").getFile().toString() + "app.properties");
            configs.put("appConfig", baseConfig);
            configPath = baseConfig.getValue("config.path");
        } catch (ConfigException e) {
            log.error("app.properties加载失败", e);
        }
    }

    public static BaseConfig getConfig(String code) throws ConfigException {
        BaseConfig apiConfig = configs.get(code);

        if (apiConfig == null) {

            synchronized (ConfigFactory.class) {
                if (apiConfig == null) {
                    apiConfig = new BaseConfig(configPath + code + ".properties");
                }
            }

        }

        return apiConfig;
    }

}
