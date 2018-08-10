package com.wbh.manage.common.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author
 */
public class AutoGeneratorChild extends AutoGenerator {
    private static final Logger logger = LoggerFactory.getLogger(AutoGenerator.class);
    protected ConfigBuilder config;
    private DataSourceConfig dataSource;
    private StrategyConfig strategy;
    private PackageConfig packageInfo;
    private TemplateConfig template;
    private GlobalConfig globalConfig;
    private AbstractTemplateEngine templateEngine;
    @Override
    public ConfigBuilder getConfig() {
        return config;
    }

    @Override
    public AutoGenerator setConfig(ConfigBuilder config) {
        this.config = config;
        return this;
    }

    @Override
    public DataSourceConfig getDataSource() {
        return dataSource;
    }

    @Override
    public AutoGenerator setDataSource(DataSourceConfig dataSource) {
        this.dataSource = dataSource;
        return this;
    }

    @Override
    public StrategyConfig getStrategy() {
        return strategy;
    }

    @Override
    public AutoGenerator setStrategy(StrategyConfig strategy) {
        this.strategy = strategy;
        return this;
    }

    @Override
    public PackageConfig getPackageInfo() {
        return packageInfo;
    }

    @Override
    public AutoGenerator setPackageInfo(PackageConfig packageInfo) {
        this.packageInfo = packageInfo;
        return this;
    }

    @Override
    public TemplateConfig getTemplate() {
        return template;
    }

    @Override
    public AutoGenerator setTemplate(TemplateConfig template) {
        this.template = template;
        return this;
    }

    @Override
    public GlobalConfig getGlobalConfig() {
        return globalConfig;
    }

    @Override
    public AutoGenerator setGlobalConfig(GlobalConfig globalConfig) {
        this.globalConfig = globalConfig;
        return this;
    }

    @Override
    public AbstractTemplateEngine getTemplateEngine() {
        return templateEngine;
    }

    @Override
    public AutoGenerator setTemplateEngine(AbstractTemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
        return this;
    }

    @Override
    public void execute() {
        logger.debug("==========================准备生成文件...==========================");
        if (null == this.config) {
            this.config = new ConfigBuilder(this.packageInfo, this.dataSource, this.strategy, this.template, this.globalConfig);
            if (null != this.injectionConfig) {
                this.injectionConfig.setConfig(this.config);
            }
        }

        if (null == this.templateEngine) {
            this.templateEngine = new VelocityTemplateEngine();
        }

        this.templateEngine.init(this.pretreatmentConfigBuilder(this.config)).mkdirs().batchOutput();
        logger.debug("==========================文件生成完成！！！==========================");
    }
}
