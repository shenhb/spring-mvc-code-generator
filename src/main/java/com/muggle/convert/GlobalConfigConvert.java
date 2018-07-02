package com.muggle.convert;

import com.baomidou.mybatisplus.enums.IdType;
import com.hannesdorfmann.annotationprocessing101.factory.annotation.Factory;

import java.util.Map;

/**
 * Created on 2018/6/21.
 */
@Factory(id = "GlobalConfig", type = ConfigConvert.class)
public class GlobalConfigConvert implements ConfigConvert {

    @Override
    public Map<String, Object> convert(Map<String, Object> map) {

        for (String key : map.keySet()) {
            Object value = map.get(key);

            switch (key) {
                case "idType":
                    int idType = 0;
                    if (value instanceof String) {
                        idType = Integer.valueOf((String) value);
                    } else if (value instanceof Integer) {
                        idType = (int) value;
                    }
                    value = IdType.getIdType(idType);

                    break;
            }

            map.put(key, value);
        }


        return map;
    }

}