package com.example.mbs.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private int depId;
    private String deptName;
    private int deptSize;
    private String deptLeader;
    private String deptImagePath;
}
