package com.hnu.webmanagementdemo;

import com.hnu.webmanagementdemo.Service.DeptService;
import com.hnu.webmanagementdemo.Service.Imp.DeptServiceImp;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class WebManagementdemoApplicationTests {
    @Autowired
    private ApplicationContext applicationContext;
    @Test
    void contextLoads() {
       /* DeptServiceImp deptServiceImp = (DeptServiceImp)applicationContext.getBean("deptServiceImp");
        System.out.println(deptServiceImp);

        DeptService bean = (DeptService)applicationContext.getBean(DeptService.class);
        System.out.println(bean);*/
        SAXReader bean = (SAXReader) applicationContext.getBean("saxReader");
        System.out.println(bean);
    }
    @Test
    public void JWTTest(){
//        Jwts.builder()
    }

}
