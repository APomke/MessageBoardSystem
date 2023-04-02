package com.example.mbs.service;

import com.example.mbs.pojo.Department;

import java.util.List;

public interface DepartMentService {
    //获取部门总数
    Department getDeptCount(Department department);
    //获取所有部门
    List<Department> getAllDept();
    //部门添加人数
    int addDeptCount(Department department);
    //部门减少人数
    int removeDeptCount(Department department);
}
