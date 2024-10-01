package com.hnu.webmanagementdemo.Controller;

import com.hnu.webmanagementdemo.Pojo.Emp;
import com.hnu.webmanagementdemo.Pojo.Result;
import com.hnu.webmanagementdemo.Service.EmpService;
import com.hnu.webmanagementdemo.Utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private EmpService empService;
    @PostMapping
    public Result JwtLogin(@RequestBody Emp emp){
        Emp loginEmp = empService.login(emp);
        if(loginEmp!=null){
            Map<String, Object> map = new HashMap<>();
            map.put("id",loginEmp.getId());
            map.put("username",loginEmp.getUsername());
            map.put("name",loginEmp.getName());

            String token = JwtUtils.generateJwt(map);
            return Result.success(token);

        }
        return Result.error("用户名或者密码错误");
    }
}
