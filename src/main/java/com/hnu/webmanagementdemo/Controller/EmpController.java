package com.hnu.webmanagementdemo.Controller;

import com.hnu.webmanagementdemo.Pojo.Emp;
import com.hnu.webmanagementdemo.Pojo.PageBean;
import com.hnu.webmanagementdemo.Pojo.Result;
import com.hnu.webmanagementdemo.Service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping
    public Result queryRows(@RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "10") Integer pageSize,
                            String name, Short gender,
                            @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate begin,
                            @DateTimeFormat(pattern = "yyyy-mm-dd")LocalDate end){
        log.info("查询的页码和每页记录的记录数为：{},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
        PageBean pb = empService.queryRows(page,pageSize,name,gender,begin,end);
        return Result.success(pb);
    }
    @DeleteMapping("/{ids}")
    public Result delete (@PathVariable Integer[] ids){
        log.info("根据数组疲劳删除：{}", Arrays.toString(ids));
        empService.deletebyarray(ids);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Emp emp){
        log.info("添加员工:{}",emp);
        empService.save(emp);
        return Result.success();

    }

}
