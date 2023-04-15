package com.example.mbs.dao;

import com.example.mbs.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartMentMapper {
    //获取部门总数
    Department getDeptCount(Department department);
    //根据部门id获取部门
    Department getDeptById(@Param("deptId") int deptId);
    //获取所有部门
    List<Department> getAllDept();
    //部门添加人数
    int addDeptCount(Department department);
    //部门减少人数
    int removeDeptCount(Department department);

}
