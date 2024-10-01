package com.hnu.webmanagementdemo.Service;

import com.hnu.webmanagementdemo.Pojo.Emp;
import com.hnu.webmanagementdemo.Pojo.PageBean;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface EmpService {
    PageBean queryRows(Integer page, Integer pagesize, String name, Short gender, LocalDate begin, LocalDate end);

    void deletebyarray(Integer[] ids);

    void save(Emp emp);

    Emp login(Emp emp);
}
