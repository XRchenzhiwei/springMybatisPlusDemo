package org.mybatisplus;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenzw
 * @date 2020/8/24 0024  15:46
 * @description:
 */
public class CodeGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 当前程序所在目录
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("czw");
        gc.setFileOverride(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(true);
        // 是否覆盖同名文件，默认是false
        gc.setFileOverride(true);
        gc.setOpen(false);

        mpg.setGlobalConfig(gc);
        // 不需要ActiveRecord特性的请改为false
        gc.setActiveRecord(true);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/practicedb?useSSL=false&serverTimezone=CTT&nullNamePatternMatchesAll=true");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("mysql666");
        dsc.setTypeConvert(new MySqlTypeConvert() {
            @Override
            public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                //timestamp转换成String
                if (fieldType.toLowerCase().contains("timestamp")) {
                    return DbColumnType.STRING;
                }
                //timestamp转换成String
                if (fieldType.toLowerCase().contains("datetime")) {
                    return DbColumnType.STRING;
                }
                return (DbColumnType) super.processTypeConvert(globalConfig, fieldType);
            }
        });
        mpg.setDataSource(dsc);


        // 包配置
        PackageConfig pc = new PackageConfig();
        // 父包名
        pc.setParent("com.mybatisplus");
        // 实体类包名
        pc.setEntity("models.sys.user");
        // Service包名
        pc.setService("service.sys.user");
        // ServiceImpl包名
        pc.setServiceImpl("service.sys.user.impl");
        // Mapper包名
        pc.setMapper("mapper.sys.user");
        // controller包名
        pc.setController("controller.sys.user");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mybatis/mapper/sys/user/"
                        //+ pc.getModuleName()
                        //+ "/"
                        + tableInfo.getEntityName() + "Mapper.xml";
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude("sys_user");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
