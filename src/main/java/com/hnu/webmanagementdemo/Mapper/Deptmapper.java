package com.hnu.webmanagementdemo.Mapper;

import com.hnu.webmanagementdemo.MyAnnotation.MylogAnno;
import com.hnu.webmanagementdemo.Pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Deptmapper {
    @MylogAnno
    @Select("select * from dept")
    public List<Dept> list();
    @MylogAnno
    @Delete("delete from dept where id = #{id}")
    void delete(Integer id);

    @MylogAnno
    @Insert("insert into dept (name, create_time, update_time) VALUES (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    @MylogAnno
    @Update("update dept set name = #{name},update_time = #{updateTime} where id = #{id} ")
    void update(Dept dept);

    @MylogAnno
    Dept selectbyid(Integer id);

}
