package com.muggle.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 代码生成器演示
 * </p>
 */
public class MpGenerator {


    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        ExtraConfig extraConfig = ConfigUtils.getConfig(ExtraConfig.class);


        // 全局配置
        final GlobalConfig gc = ConfigUtils.getConfig(GlobalConfig.class);
        if (StringUtils.isNotBlank(extraConfig.getOutputDir())) {
            gc.setOutputDir(extraConfig.getOutputDir());
        }
        mpg.setGlobalConfig(gc);


        // 数据源配置
        DataSourceConfig dsc = ConfigUtils.getConfig(DataSourceConfig.class);
//        dsc.setDbType(DbType.MYSQL);
//        dsc.setTypeConvert(new MySqlTypeConvert() {
//            // 自定义数据库表字段类型转换【可选】
//            @Override
//            public DbColumnType processTypeConvert(String fieldType) {
//                System.out.println("转换类型：" + fieldType);
//                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
//                return super.processTypeConvert(fieldType);
//            }
//        });
        mpg.setDataSource(dsc);


        // 策略配置
        StrategyConfig strategy = ConfigUtils.getConfig(StrategyConfig.class);
        //extraConfig.include
        if (extraConfig.getInclude() != null && extraConfig.getInclude().length > 0) {
            strategy.setInclude(extraConfig.getInclude());
        }
        //extraConfig.exclude
        if (extraConfig.getExclude() != null && extraConfig.getExclude().length > 0) {
            strategy.setExclude(extraConfig.getExclude());
        }
        mpg.setStrategy(strategy);


        // 包配置
        PackageConfig pc = ConfigUtils.getConfig(PackageConfig.class);
        mpg.setPackageInfo(pc);


        //模板路径配置项
        TemplateConfig tc = ConfigUtils.getConfig(TemplateConfig.class);
        mpg.setTemplate(tc);


        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
//                Map<String, Object> map = new HashMap<String, Object>();
//                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
//                this.setMap(map);
            }
        };

        if (StringUtils.isNotBlank(tc.getXml()) && extraConfig.isXmlInRoot()) {
            //focList
            List<FileOutConfig> focList = new ArrayList<>();
            // 自定义xml生成目录
            focList.add(new FileOutConfig(tc.getXml()) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return gc.getOutputDir() + tableInfo.getEntityName() + "Mapper.xml";
                }
            });
            cfg.setFileOutConfigList(focList);

            tc.setXml(null);
        }

        mpg.setCfg(cfg);


        // 执行生成
        mpg.execute();
    }

}