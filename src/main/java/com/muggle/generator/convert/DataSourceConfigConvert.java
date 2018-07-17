package com.muggle.generator.convert;

import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.hannesdorfmann.annotationprocessing101.factory.annotation.Factory;

import java.util.Map;

/**
 * Created on 2018/6/21.
 */
@Factory(id = "DataSourceConfig", type = ConfigConvert.class)
public class DataSourceConfigConvert implements ConfigConvert {

    @Override
    public Map<String, Object> convert(Map<String, Object> map) {

        for (String key : map.keySet()) {
            Object value = map.get(key);

            switch (key) {
                case "dbType":
                    DbType dbType = null;
                    DbType[] values = DbType.values();
                    for (DbType dbTypeItem : values) {
                        if (dbTypeItem.getValue().equals(value.toString())) {
                            dbType = dbTypeItem;
                        }
                    }

                    value = dbType;
                    break;
            }

            map.put(key, value);
        }

        return map;
    }

}