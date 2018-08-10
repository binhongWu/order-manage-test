package com.wbh.manage.common.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Collections;

/**
 * @author Administrator
 */
public class GeneratorExecute {

    /**
     * 表名
     */
    private static final String TABLE_NAME = "brand";

    /**
     * 作者
     */
    private static final String AUTHOR = "wbh";

    /**
     * 文件根目录（项目路径）
     */
    private static final String PATH = "D://study/order/order-manage/src/main/java";


    /**
     * 自定义包路径
     */
    private static final String PARENTPATH = "com.wbh.manage";

    /**
     * XML文件自定义路径
     */
    private static final String XMLPATH = "D://study/order/order-manage/src/main/resources/mapper/";

    /**
     * 控制器包名
     */
    private static final String CONTROLLER = "controller";


    /**
     * 数据库配置信息
     */
    private static DbType DB_TYPE = DbType.MYSQL;
    private static final String DB_DRIVER_NAME = "com.mysql.jdbc.Driver";


    public static void main(String[] args) {
        generator();
    }

    /**
     * 代码生成器
     */
    private static void generator() {
        //父类引用子类实例  只能使用父类继承来的
        String dbUrl = "jdbc:mysql://47.106.193.185:3306/order?characterEncoding=utf8&autoReconnect=true&useSSL=false";
        String dbUserName = "root";
        String dbPassword = "123456";
        AutoGenerator autoGenerator = new AutoGeneratorChild().setGlobalConfig(
                //全局配置
                new GlobalConfig()
                        //输出目录
                        .setOutputDir(PATH)
                        // 是否覆盖文件
                        .setFileOverride(true)
                        // 开启 activeRecord 模式
                        .setActiveRecord(true)
                        // XML 二级缓存
                        .setEnableCache(false)
                        // XML ResultMap
                        .setBaseResultMap(true)
                        // XML columList
                        .setBaseColumnList(true)
                        .setAuthor(AUTHOR)
                        //去掉前缀I  没加会生成 例如ISysUserService.java
                        .setServiceName("%sService" )
        ).setDataSource(
                new DataSourceConfig()
                        .setDbType(DB_TYPE)
                        .setDriverName(DB_DRIVER_NAME)
                        .setUrl(dbUrl)
                        .setUsername(dbUserName)
                        .setPassword(dbPassword)
        ).setStrategy(
                new StrategyConfig()
                        // 表名生成策略
                        .setNaming(NamingStrategy.underline_to_camel)
                        // 需要生成的表
                        .setInclude(TABLE_NAME)
        ).setPackageInfo(
                new PackageConfig()
                        //自定义包路径
                        .setParent(PARENTPATH)
                        //控制器的报名 默认为web（在PackageConfig里设置的是web）
                        .setController(CONTROLLER)
        ).setCfg(
                new InjectionConfig() {
                    @Override
                    public void initMap() {
                    }
                }.setFileOutConfigList(Collections.<FileOutConfig>singletonList(new FileOutConfig("/templates/mapper.xml.vm" ) {
                    // 自定义XML输出文件目录
                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        return XMLPATH + tableInfo.getMapperName() + ".xml";
                    }
                }))
        ).setTemplate(
                //关闭XML默认生成路径
                new TemplateConfig().setXml(null)
        );
        autoGenerator.execute();
    }
}
