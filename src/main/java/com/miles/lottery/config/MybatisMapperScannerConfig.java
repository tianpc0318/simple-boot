package com.miles.lottery.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

/**
 * 说明：Mybatis映射自动扫描
 * 创建时间：2018年05月14日 21:20
 * Copyright (C) 2017, tianpc0318@163.com All Rights Reserved.
 *
 * @author milesloner
 */
@Configuration
@AutoConfigureAfter(MybatisConfig.class)
@MapperScan("com.miles.springboot.mapper")
public class MybatisMapperScannerConfig {

    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.miles.springboot.mapper");
        return mapperScannerConfigurer;
    }

}
