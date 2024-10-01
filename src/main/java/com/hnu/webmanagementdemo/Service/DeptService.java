package com.hnu.webmanagementdemo.Service;

import com.hnu.webmanagementdemo.Pojo.Dept;

import java.util.List;

public interface DeptService {
    public List<Dept> list();
    public void delete(Integer id);

    void insert(Dept dept);

    void arlter(Dept dept);

    Dept selectbyid(Integer id);
}
