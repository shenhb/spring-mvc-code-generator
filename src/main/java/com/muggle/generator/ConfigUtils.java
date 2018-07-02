package com.muggle.generator;

import com.muggle.convert.ConfigConvert;
import com.muggle.convert.ConfigConvertFactory;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.ibatis.io.Resources;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shenh on 2017/12/12.
 */
public class ConfigUtils {


    public static <T> T getConfig(Class<T> tClass) {
        try {
            T config = tClass.newInstance();
            Map<String, Map<String, Object>> load = getConfigMap();
            Map<String, Object> stringObjectMap = load.get(tClass.getSimpleName());
            //
            ConfigConvertFactory configConvertFactory = new ConfigConvertFactory();
            ConfigConvert configConvert;
            try {
                configConvert = configConvertFactory.create(tClass.getSimpleName());
                if (configConvert != null) {
                    stringObjectMap = /*(Map<String, Object>)*/ configConvert.convert(stringObjectMap);
                }
            } catch (IllegalArgumentException ignored) {
            }

            for (String name : stringObjectMap.keySet()) {
                Object value = stringObjectMap.get(name);

                try {
                    setField(config, name, value);
                } catch (Exception e) {
                    throw new RuntimeException(
                            tClass.getName() + " " + name + " set failed, " +
                                    "Plase check " + tClass.getSimpleName() + " " + name + " setting!");
                }

            }

            return config;

        } catch (IOException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        throw new RuntimeException(tClass.getName() + " create failed, Plase check " + tClass.getSimpleName() + " setting!");
    }

    private static Map<String, Map<String, Object>> getConfigMap() throws IOException {
        return getConfigMapFromYml("generator/generator.yml");
    }

    private static Map<String, Map<String, Object>> getConfigMapFromYml(String ymlResourcePath) throws IOException {
        Yaml yaml = new Yaml();
        Map<String, Map<String, Object>> load = (HashMap<String, Map<String, Object>>) yaml.load(
                new FileInputStream(
                        Resources.getResourceAsFile(ymlResourcePath)
                )
        );
        return load;
    }

    private static void setField(Object targetObject, String name, Object value) {
        if (targetObject == null) {
            throw new RuntimeException("targetObject for the field must be specified");
        }

        Class<?> targetClass = targetObject.getClass();

        Field field = FieldUtils.getField(targetClass, name, true);
        if (field == null) {
            throw new IllegalArgumentException(String.format("Could not find field '%s' on target object [%s] ", new Object[]{name, targetObject}));
        } else {
            try {
                FieldUtils.writeField(targetObject, name, value, true);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
