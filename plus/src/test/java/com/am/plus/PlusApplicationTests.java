package com.am.plus;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlusApplicationTests {
    private static GlobalConfig GlobalGenerate(){
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(false)// 不需要ActiveRecord特性的请改为false
                .setIdType(IdType.AUTO)
                .setEnableCache(false)// XML 二级缓存
            .setAuthor("long")
                .setBaseResultMap(true)// XML ResultMap
                .setBaseColumnList(false)// XML columList
            .setOutputDir("/Users/emmaliya/IdeaProjects/plus/src/main/java")
                .setFileOverride(true)
                .setControllerName("%sController")//自定义文件命名，注意 %s 会自动填充表实体属性！
                .setBaseResultMap(true)
                .setBaseColumnList(true);
        return config;
        }
    private static DataSourceConfig DaoSourceGenerate(){
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
//        DbType type=null;
//        if("oracle".equals(DB_TYPE)){
//            type=DbType.ORACLE;
//        }else if("sql_server".equals(DB_TYPE)){
//            type=DbType.SQL_SERVER;
//        }else if("mysql".equals(DB_TYPE)){
//            type=DbType.MYSQL;
//        }else if("postgre_sql".equals(DB_TYPE)){
//            type=DbType.POSTGRE_SQL;
//        }
        dataSourceConfig.setDbType(DbType.MYSQL)//数据库类型
                .setUrl("jdbc:mysql://localhost:3306/account?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false")//数据库地址
                .setUsername("root")//数据库用户名
                .setPassword("12345678")//数据库密码
                .setDriverName("com.mysql.cj.jdbc.Driver")//实例名
               ;
        return dataSourceConfig;
    }
    private static StrategyConfig StrategyGenerate() {
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setVersionFieldName("version")
                .setCapitalMode(true)// 全局大写命名 ORACLE 注意
                .setEntityLombokModel(false)
                .setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                // .entityTableFieldAnnotationEnable(ENABLE_TABLE_FIELD_ANNOTATION)
                // .fieldPrefix(FIELD_PREFIX)//test_id -> id, test_type -> type
                .setInclude("user");//修改替换成你需要的表名，多个表名传数组
        //.setExclude(new String[]{"test"}); // 排除生成的表
        //.setTablePrefix(new String[] { "tlog_", "tsys_" });// 此处可以修改为您的表前缀
        //.setSuperEntityClass("com.lin.demo.TestEntity");// 自定义实体父类
        //.setSuperEntityColumns(new String[] { "test_id","age" });// 自定义实体，公共字段
        //.setSuperMapperClass("com.lin.demo.TestMapper");// 自定义 mapper 父类
        // .setSuperServiceClass("com.lin.demo.TestService");// 自定义 service 父类
        //.setSuperServiceImplClass("com.lin.demo.TestServiceImpl");// 自定义 service 实现类父类
//             .setSuperControllerClass("com.lin.demo.TestController");// 自定义 controller 父类
//            .setEntityColumnConstant(true);// 【实体】是否生成字段常量（默认 false）public static final String ID = "test_id";
//            .setEntityBuilderModel(true);// 【实体】是否为构建者模型（默认 false）public User setName(String name) {this.name = name; return this;}
        return strategyConfig;
    }
//    private static TemplateConfig TemplateGenerate(){
//        TemplateConfig templateConfig = new TemplateConfig()
//                .setXml("/template/mapper2.xml")//注意：不要带上.vm
//                .setController("/template/action.java")
//                .setMapper("/template/mapper.java")
//                .setXml("/template/mapper.xml")
//                .setService("/template/service.java")
//                .setServiceImpl("/template/serviceImpl.java")
//                ;
//        return templateConfig;
//    }
public static PackageConfig PackageGenerate(){
    PackageConfig pc = new PackageConfig()
            .setParent("com.am.plus")
            .setController("controller")
            .setEntity("entity")
            .setMapper("mapper")
            .setXml("mapper");
    return pc;
}

    @Test
    public void contextLoads() {

            //全局配置
            GlobalConfig config =GlobalGenerate();
            //配置数据源
            DataSourceConfig dataSourceConfig=DaoSourceGenerate();
            //配置策略
            StrategyConfig strategyConfig = StrategyGenerate();
//            //配置模板
//            TemplateConfig templateConfig =TemplateGenerate();
//            //生成jsp文件
//            InjectionConfig injectionConfig = AutoGenerateUtil.FileGenerate();
            //配置包
            PackageConfig packageConfig=PackageGenerate();
            //生成代码
            new AutoGenerator()
                    .setGlobalConfig(config)
//                    .setTemplate(templateConfig)//自定义模板路径
//                    .setCfg(injectionConfig)
                    .setDataSource(dataSourceConfig)
                    .setStrategy(strategyConfig)
                    .setPackageInfo(packageConfig)
                    .execute();
        }

    }


