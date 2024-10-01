package com.hnu.webmanagementdemo.Mapper;

import com.hnu.webmanagementdemo.Pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EmpMapper {

//    @Select("select * from emp limit #{start},#{pagesize}")
     List<Emp> getRows(int start, Integer pagesize, String name, Short gender,
                       LocalDate begin, LocalDate end);

    Long gettotal(String name, Short gender,
                  LocalDate begin, LocalDate end);

    void deletebyarray(Integer[] ids);

    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            " values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    @Select("select * from emp " +
            "where username = #{username} and password = #{password}")
    Emp selectByIDandPassword(Emp emp);

    @Delete(("delete from emp where dept_id = #{id}"))
    void deletebaydepetID(Integer id);
}
