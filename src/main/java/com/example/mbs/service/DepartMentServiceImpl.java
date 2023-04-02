package com.example.mbs.service;

import com.example.mbs.dao.DepartMentMapper;
import com.example.mbs.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartMentServiceImpl implements DepartMentService{
    @Autowired
    private DepartMentMapper departMentMapper;

    @Override
    public Department getDeptCount(Department department) {
        return departMentMapper.getDeptCount(department);
    }

    @Override
    public List<Department> getAllDept() {
        return departMentMapper.getAllDept();
    }

    @Override
    public int addDeptCount(Department department) {
        return departMentMapper.addDeptCount(department);
    }

    @Override
    public int removeDeptCount(Department department) {
        return departMentMapper.removeDeptCount(department);
    }
}
