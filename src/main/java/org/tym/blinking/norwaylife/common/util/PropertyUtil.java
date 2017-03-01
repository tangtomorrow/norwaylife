package org.tym.blinking.norwaylife.common.util;

import java.util.Properties;

/**
 * Created by wgli on 2017/2/8.
 */
public class PropertyUtil {
    private static final Properties prop = new Properties();

    static {
        try {
            prop.load(PropertyUtil.class.getClassLoader().getResourceAsStream("system.properties"));
        } catch (Exception e) {
            //LogUtil.getLogger().error("load system.properties exception", e);
        }
    }

    public static String getString(String key) {
        return prop.getProperty(key);
    }

    public static String getString(String key, String defaultValue) {
        String value = prop.getProperty(key);
        if (value == null) {
            value = defaultValue;
        }
        return value;
    }

    public static boolean getBoolean(String key) {
        String value = prop.getProperty(key);
        return Boolean.valueOf(value);
    }

    public static int getInt(String key) {
        String value = prop.getProperty(key);
        return Integer.valueOf(value);
    }

    public static int getInt(String key, int defaultValue) {
        try {
            return Integer.valueOf(prop.getProperty(key));
        } catch (Exception e) {
            //LogUtil.getLogger().error("getInt exception", e);
        }
        return defaultValue;
    }
}
