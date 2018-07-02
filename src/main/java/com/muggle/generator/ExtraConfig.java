package com.muggle.generator;

/**
 * Created on 2018/6/30.
 */
public class ExtraConfig {

    /**
     * mapper xml是否生成在根目录
     */
    private boolean xmlInRoot = true;


    /**
     * 生成文件的输出目录【默认 D 盘根目录】
     */
    private String outputDir = null;

    /**
     * 需要包含的表名（与exclude二选一配置）
     */
    private String[] include = null;

    /**
     * 需要排除的表名
     */
    private String[] exclude = null;


    public boolean isXmlInRoot() {
        return xmlInRoot;
    }

    public void setXmlInRoot(boolean xmlInRoot) {
        this.xmlInRoot = xmlInRoot;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    public String[] getInclude() {
        return include;
    }

    public void setInclude(String... include) {
        this.include = include;
    }

    public String[] getExclude() {
        return exclude;
    }

    public void setExclude(String... exclude) {
        this.exclude = exclude;
    }
}
