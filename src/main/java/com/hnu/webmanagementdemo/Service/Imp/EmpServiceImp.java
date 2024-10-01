package com.hnu.webmanagementdemo.Service.Imp;

import com.hnu.webmanagementdemo.Mapper.EmpMapper;
import com.hnu.webmanagementdemo.Pojo.Emp;
import com.hnu.webmanagementdemo.Pojo.PageBean;
import com.hnu.webmanagementdemo.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImp implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public PageBean queryRows(Integer page, Integer pagesize, String name, Short gender,
                              LocalDate begin, LocalDate end) {
        Long total = empMapper.gettotal(name,gender,begin,end);
        int start = (page - 1) * pagesize;
        List<Emp> rows = empMapper.getRows(start,pagesize,name,gender,begin,end);
        return new PageBean(total,rows);
    }

    @Override
    public void deletebyarray(Integer[] ids) {
        empMapper.deletebyarray(ids);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp login(Emp emp) {
        Emp emp1 = empMapper.selectByIDandPassword(emp);

        return emp1;
    }
}
