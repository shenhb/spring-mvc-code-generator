package com.muggle.convert;

import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.hannesdorfmann.annotationprocessing101.factory.annotation.Factory;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Collection;
import java.util.Map;

/**
 * Created on 2018/6/21.
 */
@Factory(id = "StrategyConfig", type = ConfigConvert.class)
public class StrategyConfigConvert implements ConfigConvert {

    @Override
    public Map<String, Object> convert(Map<String, Object> map) {

        for (String key : map.keySet()) {
            Object value = map.get(key);

            switch (key) {
                case "tablePrefix":
                    if (value instanceof Collection) {
                        value = ArrayUtils.toStringArray(((Collection) value).toArray());
                        ;
                    }
                    break;
                case "superEntityColumns":
                    if (value instanceof Collection) {
                        value = ArrayUtils.toStringArray(((Collection) value).toArray());
                        ;
                    }
                    break;
                case "include":
                    if (value instanceof Collection) {
                        value = ArrayUtils.toStringArray(((Collection) value).toArray());
                        ;
                    }
                    break;
                case "exclude":
                    if (value instanceof Collection) {
                        value = ArrayUtils.toStringArray(((Collection) value).toArray());
                        ;
                    }
                    break;
                case "naming":
                    if ("nochange".equals(value.toString())) {
                        value = NamingStrategy.nochange;
                    } else {
                        value = NamingStrategy.underline_to_camel;
                    }
                    break;

            }

            map.put(key, value);
        }

        return map;
    }
}
