package com.hnu.webmanagementdemo.ConfigClass;

import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.rowset.spi.XmlReader;

@Configuration
public class CommonConfig {
    @Bean
    public SAXReader saxReader(){

        return new SAXReader();
    }
}
