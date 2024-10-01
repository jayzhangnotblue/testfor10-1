package com.hnu.webmanagementdemo.Service.Imp;

import com.hnu.webmanagementdemo.Mapper.Deptmapper;
import com.hnu.webmanagementdemo.Mapper.EmpMapper;
import com.hnu.webmanagementdemo.Pojo.Dept;
import com.hnu.webmanagementdemo.Service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Scope("prototype")
public class DeptServiceImp implements DeptService {
    @Autowired
    private Deptmapper deptmapper;
    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Dept> list() {
        return deptmapper.list();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        deptmapper.delete(id);
        empMapper.deletebaydepetID(id);
        return;
    }

    @Override
    public void insert(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptmapper.insert(dept);
    }

    @Override
    public void arlter(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptmapper.update(dept);
    }

    @Override
    public Dept selectbyid(Integer id) {
        Dept dept = deptmapper.selectbyid(id);
        return dept;

    }


}
