package com.hj.jdpt.repository;

import com.hj.jdpt.domain.Department;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("departmentMapper")
public interface DepartmentMapper {

    @Select("select * from department")
    List<Department> querryAll();

    @Select("select * from department where Department_Id=#{id}")
    Department FindById_lfm(Integer id);
}