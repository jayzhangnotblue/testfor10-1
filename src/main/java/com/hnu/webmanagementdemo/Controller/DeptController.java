package com.hnu.webmanagementdemo.Controller;

import com.hnu.webmanagementdemo.Pojo.Dept;
import com.hnu.webmanagementdemo.Pojo.Result;
import com.hnu.webmanagementdemo.Service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;
    @GetMapping
    public Result select (){
        log.info("查询全部部门数据");
        List<Dept> list = deptService.list();
        return Result.success(list);
    }

    //根据ID删除操作
    @DeleteMapping("/{id}")
    public Result delete (@PathVariable Integer id){
        log.info("根据{}删除部门",id);
        deptService.delete(id);
        return Result.success();
    }

    //添加数据
    @PostMapping
    public Result add(@RequestBody Dept dept){
    log.info("添加部门：{}",dept);
    deptService.insert(dept);
    return Result.success();
    }

    //修改部门
    @PutMapping
    public Result modify(@RequestBody Dept dept){
        log.info("修改部门：{}",dept);
        deptService.arlter(dept);
        return Result.success();
    }

    //查询数据
    @GetMapping("/{id}")
    public Result selectbyid (@PathVariable Integer id){
        log.info("根据id查询数据，id：{}",id);
        Dept dept = deptService.selectbyid(id);
        return Result.success(dept);
    }
}
