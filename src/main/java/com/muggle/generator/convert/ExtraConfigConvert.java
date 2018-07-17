package com.muggle.generator.convert;

import com.hannesdorfmann.annotationprocessing101.factory.annotation.Factory;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Collection;
import java.util.Map;

/**
 * Created on 2018/6/21.
 */
@Factory(id = "ExtraConfig", type = ConfigConvert.class)
public class ExtraConfigConvert implements ConfigConvert {

    @Override
    public Map<String, Object> convert(Map<String, Object> map) {

        for (String key : map.keySet()) {
            Object value = map.get(key);

            switch (key) {
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
            }

            map.put(key, value);
        }

        return map;
    }
}
