package com.muggle.test;

import com.baomidou.mybatisplus.generator.config.rules.DbType;
import org.junit.Test;

/**
 * Created on 2018/6/29.
 */
public class Test1 {

    @Test
    public void test1() {

        DbType mysql = null;
        DbType[] values = DbType.values();
        for (DbType value : values) {
            if (value.getValue().equals("mysql")) {
                mysql=value;
            }
        }
        System.out.println(mysql);
    }
}
